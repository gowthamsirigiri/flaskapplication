pipeline {
    agent any

    stages {
        stage('Cloning the git repo') {
            steps {
                // Delete old files first to avoid conflicts on rebuilds
                cleanWs() 
                sh '''
                git clone https://github.com/gowthamsirigiri/flaskapplication.git
                '''
            }
        }
        stage('Build the docker image from the repo') {
            steps {
                
                script {
                    // Generates a valid tag format (e.g., 2026-07-04_19-30)
                    def imageTag = sh(script: "date +%Y-%m-%d_%H-%M", returnStdout: true).trim()
                    def registryName = "gsirigiri333/3-tier_application"
                    
          
                    sh "docker build -t ${registryName}:${imageTag} ./flaskapplication"
                    sh "docker push ${registryName}:${imageTag}"
                }
            }
        }
    }
}


 






















