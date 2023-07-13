pipeline {
    agent any
    parameters {
        booleanParam(defaultValue: false, description: 'Is it Release?', name: 'RELEASE')
    }
    environment {
        POM_RELEASE_VERSION = readMavenPom().getVersion().replaceAll('-SNAPSHOT','')
    }
    triggers {
        pollSCM('H/5 * * * *')
    }
    stages {
        stage('Environment Variables') {
            steps {
                    sh '''
                        echo POM_RELEASE_VERSION: $POM_RELEASE_VERSION
                        echo GIT_BRANCH: $GIT_BRANCH
                        java -version
                        mvn -v
                    '''
            }
        }
        stage('Maven Snapshot Build') {
            when {
                expression { params.RELEASE == false }
            }
            steps {
                sh '''
                    mvn clean install -DskipTests=true
                '''
            }
        }
        stage('Maven Release Build') {
            when {
                expression { params.RELEASE == true }
            }
            steps {
                sh '''
                    git config user.name "jenkins"
                    git checkout $GIT_BRANCH
                    mvn --batch-mode release:clean release:prepare release:perform -DignoreSnapshots=true -DskipTests=true -Darguments=-DskipTests
                '''
            }
        }
        stage('Git Tag') {
            when {
                expression { params.RELEASE  == true }
            }
            steps {
                sh '''
                    git config user.name "jenkins"
                    git tag v$POM_RELEASE_VERSION.$BUILD_NUMBER
                    git push origin v$POM_RELEASE_VERSION.$BUILD_NUMBER
                '''
            }
        }

    }
}
