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
            sh 'ls'
          }
        }
        stage('LogIn') {
          steps {
            sh 'ls'
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