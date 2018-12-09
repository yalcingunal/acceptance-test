pipeline {
  agent any
  stages {
        stage('Acceptance Test') {
          parallel {
            stage('HomePage') {
              agent {
                docker {
                  image 'ozanberk/mp-test:latest'
                }

              }
              steps {
                sh 'mvn clean install -Dtag=@HomePage -f parallelpom.xml'
              }
            }
            stage('LogIn') {
              agent {
                          docker {
                            image 'ozanberk/mp-test:latest'
                          }

                        }
              steps {
                sh 'mvn clean install -Dtag=@LogIn -f parallelpom.xml'
              }
            }
          }
        }
        stage('test result') {
          steps {
            sh 'ls'
          }
        }
  }
}