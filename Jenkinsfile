env.SCM_URL = "https://github.com/qianyan/spring-jpetstore.git"
env.BRANCH_NAME = "master"
env.SCM_CREDENTIALS = "gogs-login"
env.BUILD_IMAGE = ""
env.BUILD_VERSION = null
env.REPO_CREDENTIALS = "registry-login"
env.REPO_RELEASE = ""
env.RANCHER_URL = null
env.RANCHER_STACK = null
env.RANCHER_ACCESS_KEY = null
env.RANCHER_SECRET_KEY = null

node {
    stage('CHECKOUT') {
        git url: "${env.SCM_URL}", branch: "${env.BRANCH_NAME}"
        env.BUILD_VERSION = version()
    }

    stage("UNIT TEST") {
        docker.image('maven:3.3.9-jdk-8').inside('-v /root/.m2:/root/.m2') {
            sh 'mvn clean test'
        }
    }

    stage("PACKAGE") {
        docker.image('maven:3.3.9-jdk-8').inside('-v /root/.m2:/root/.m2') {
            sh 'mvn clean package -DskipTests'
        }
    }

    stage('PUBLISH') {
        def dockerImage = docker.build("${env.BUILD_IMAGE}:${env.BUILD_VERSION}")
        docker.withRegistry("${env.REPO_RELEASE}", "${env.REPO_CREDENTIALS}") {
            dockerImage.push("${env.BUILD_VERSION}")
            dockerImage.push("latest")
        }
    }

    stage('DEPLOY') {
        env.RANCHER_URL = ""
        env.RANCHER_STACK = "margin-monitor"
        sh "sed -i 's#%BUILD_IMAGE%#${env.BUILD_IMAGE}:${env.BUILD_VERSION}#g' docker-compose.yml"
        sh '''
        rancher-compose --access-key ${env.RANCHER_ACCESS_KEY} --secret-key ${env.RANCHER_SECRET_KEY} -p $RANCHER_STACK up -d -c --upgrade'''
    }

    stage('ARCHIVE') {
        archive 'target/*.war'
        archive 'target/surefire-reports/**'
    }
}

def version() {
    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
    matcher ? matcher[0][1] : null

}
