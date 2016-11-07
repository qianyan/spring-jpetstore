node {
    git 'https://github.com/zhuao/spring-jpetstore.git'

    stage("Build") {
        docker.image('maven:3.3.9-jdk-8').inside('-v /var/jenkins_home/repository:/root/.m2/repository') {
            sh "mvn -B -DskipTests clean package"
        }
    }

    stage("Deploy") {

        def ida = sh(
                script: 'docker ps -q -f name=tomcat7 -f status=running',
                returnStdout:true
        ).trim();
        sh "echo '${ida}'"
        if (ida == null || ida == '') {
            sh 'is empty'
        } else {
            sh "docker rm -f '${ida}'"
        }
        def containerId = docker.image('tomcat:7-jre8').run('-p 7080:8080 -v /var/jenkins_home:/var/jenkins_home --name tomcat7')

        sh "docker exec '${containerId.id}' cp /var/jenkins_home/jobs/PetStore/workspace/target/spring-jpetstore.war /usr/local/tomcat/webapps/"

    }

    stage("Test") {
        sh "mvn test -Dcucumber.options='--tags @dev'"
    }
}