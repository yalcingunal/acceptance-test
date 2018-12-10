pipeline {
  agent any
  stages {
        stage('Acceptance Test') {
          parallel {
            stage('LogIn') {
              agent {
                docker {
                  image 'ozanberk/mp-test:latest'
                  args '-v $HOME/.m2:/root/.m2 -v /root/testresults:/root'
                }

              }
              steps {
                sh 'mvn clean install -Dtag=@LogIn -f parallelpom.xml'
                sh 'ls -l'
              }
            }
            stage('Search') {
              agent {
                docker {
                  image 'ozanberk/mp-test:latest'
                  args '-v $HOME/.m2:/root/.m2 -v /root/testresults:/root'
                }

              }
              steps {
                sh 'mvn clean install -Dtag=@Search -f parallelpom.xml'
                sh 'ls -l'
              }
            }
            stage('ProductPagination') {
              agent {
                docker {
                  image 'ozanberk/mp-test:latest'
                  args '-v $HOME/.m2:/root/.m2 -v /root/testresults:/root'
                }

              }
              steps {
                sh 'mvn clean install -Dtag=@ProductPagination -f parallelpom.xml'
                sh 'ls -l'
              }
            }
            stage('ProductDetail') {
              agent {
                docker {
                  image 'ozanberk/mp-test:latest'
                  args '-v $HOME/.m2:/root/.m2 -v /root/testresults:/root'
                }

              }
              steps {
                sh 'mvn clean install -Dtag=@ProductDetail -f parallelpom.xml'
                sh 'ls -l'
              }
            }
          }
        }
        stage('test result') {
          steps {
            sh 'ls -l'
          }
        }
  }
}