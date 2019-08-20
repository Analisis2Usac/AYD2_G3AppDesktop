pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Build') {
          steps {
            echo 'Area de construccion'
          }
        }
        stage('Builddesarrollo') {
          steps {
            echo 'Area de desarrollo'
          }
        }
      }
    }
    stage('Test') {
      steps {
        echo 'Area de pruebas'
      }
    }
    stage('Deploy') {
      steps {
        echo 'Area de lanzamiento'
      }
    }
  }
}