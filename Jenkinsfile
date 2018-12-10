pipeline {
  agent any
  stages {
        stage('Acceptance Test') {
          parallel {
            stage('LogIn') {
              agent {
                docker {
                  image 'openshift/jenkins-slave-maven-centos7'
                  args '-v $HOME/.m2:/root/.m2 -v /root/testresultsa:/var/lib/jenkins/workspace/acceptance-test_master@2/'
                }

              }
              steps {
                sh 'mvn clean install -Dtag=@LogIn -f parallelpom.xml'
              }
            }
            stage('Search') {
              agent {
                docker {
                  image 'mzagar/jenkins-slave-jdk-maven-git'
                  args '-v $HOME/.m2:/root/.m2 -v /root/testresultsb:/var/lib/jenkins/workspace/'
                }

              }
              steps {
                sh 'mvn clean install -Dtag=@Search -f parallelpom.xml'
              }
            }
            stage('ProductPagination') {
              agent {
                docker {
                  image 'ozanberk/mp-test:latest'
                  args '-v $HOME/.m2:/root/.m2 -v /root/testresultsc:/var/lib/jenkins/'
                }

              }
              steps {
                sh 'mvn clean install -Dtag=@ProductPagination -f parallelpom.xml'
              }
            }
            stage('ProductDetail') {
              agent {
                docker {
                  image 'ozanberk/mp-test:latest'
                  args '-v $HOME/.m2:/root/.m2 -v /root/testresultsd:/var/lib/'
                }

              }
              steps {
                sh 'mvn clean install -Dtag=@ProductDetail -f parallelpom.xml'
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