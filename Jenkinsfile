pipeline {
    agent any

    stages {
        stage('Git Checkout') {
            steps {
                echo "Getting code from git"
                git branch: 'main', url: 'https://github.com/amalennajar/timesheet-devops.git'
            }
        }

        stage('MVN Clean') {
            steps {
                sh 'mvn clean'
            }
        }

        stage('MVN Compile') {
            steps {
                sh 'mvn compile'
            }
        }

        stage('Mockito Tests') {
            steps {
                script {
                    sh 'mvn test -Dtest=*Mock'
                }
            }
        }

        stage('Run Jacoco Test Coverage') {
            steps {
                script {
                    sh 'mvn jacoco:prepare-agent test jacoco:report'
                    junit '**/target/surefire-reports/TEST-*.xml'
                    jacoco(execPattern: '**/target/jacoco.exec')
                }
            }
        }

        stage('Run SonarQube Analysis') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'sonar', usernameVariable: 'SONAR_USER', passwordVariable: 'SONAR_PASSWORD')]) {
                    script {
                        sh "mvn sonar:sonar -Dsonar.login=\$SONAR_USER -Dsonar.password=\$SONAR_PASSWORD"
                    }
                }
            }
        }

        stage('NEXUS') {
            steps {
                sh 'mvn deploy -DskipTests'
            }
        }

        stage('Docker build image') {
            steps {
                sh 'docker build --build-arg DB_PASSWORD=root -t amalennj/achat:1-1 .'
            }
        }

        stage('Docker push image') {
            steps {
                withDockerRegistry([credentialsId: 'docker-hub', url: 'https://index.docker.io/v1/']) {
                sh "docker push amalennj/achat:1-1"
        }
    }
}


        stage('Docker compose up') {
            steps {
                sh "docker-compose up -d "
            }
        }

        stage('Mailing') {
            steps {
                script {
                    currentBuild.result = 'SUCCESS' // Set the default build result to success

                    try {
                        // Add any additional build steps here

                    } catch (Exception e) {
                        currentBuild.result = 'FAILURE'
                        throw e
                    } finally {
                        if (currentBuild.result == 'SUCCESS') {
                            emailext body: "Successful build of ${env.JOB_NAME} #${env.BUILD_NUMBER} (${env.BUILD_URL})",
                                     subject: "Successful build of ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                                     to: 'amal.ennajar@esprit.tn'
                        } else {
                            emailext body: "Failed build of ${env.JOB_NAME} #${env.BUILD_NUMBER} (${env.BUILD_URL})",
                                     subject: "Failed build of ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                                     to: 'amal.ennajar@esprit.tn'
                        }
                    }
                }
            }
        }
    }

    post {
        success {
            slackSend color: "good", message: "${BUILD_TAG} was successful"
        }
        failure {
            slackSend color: "good", message: "${BUILD_TAG} Build failed"
        }
    }
}
