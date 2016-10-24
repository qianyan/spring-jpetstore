def deploy(id) {
    unstash 'war'
    sh "cp spring-jpetstore.war /tmp/webapps/jpetstore-${id}.war"
}

def undeploy(id) {
    sh "rm /tmp/webapps/jpetstore-${id}.war"
}

def runWithServer(body) {
    def id = UUID.randomUUID().toString()
    deploy id
    try {
        body.call id
    } finally {
        undeploy id
    }
}

this