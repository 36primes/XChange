pipeline {
    agent any

    stages {
        stage('Maven Build') {
            steps {
                sh 'mvn clean install -DskipTests=true'
            }
        }
        stage('Git Tag') {
            steps {
                sh '''
                    export GIT_SSH_COMMAND="ssh -i ~/.ssh/jenkins_ed25519 -o 'IdentitiesOnly yes'"
                    git config user.name "jenkins"
                    git tag v$BUILD_NUMBER
                    git push origin v$BUILD_NUMBER
                '''
            }
        }

    }
}
