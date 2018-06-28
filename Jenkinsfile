pipeline {
  agent any
  stages {
    
    stage('Github Checkout') {
      steps {
        echo 'Revisando modificaciones en el repositorio'
        checkout scm
      }
    }
    
    stage('Run Tests'){
      parallel {  
        stage('Unit Test') {
          steps {
            echo 'Corriendo los tests con maven'
            slackSend (channel: '#presentacion-tdsa', color: '#FFFF00', message: "STARTED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.RUN_DISPLAY_URL})")
            bat 'mvn clean test'
          }
        }
        stage('SonarQube') {
          steps {
            echo 'hola'//
            bat 'mvn sonar:sonar \
                  -Dsonar.organization=gabrielbd-github \
                  -Dsonar.host.url=https://sonarcloud.io \
                  -Dsonar.login=0a2bedb909edab1cd8189565b99799c7f0161b8e'
          }
        }
      }
    }
    
    stage('Deploy'){
      steps {
        bat 'mvn install'
      }
    }
    
  }
  tools {
    maven 'maven'
    jdk   'jdk8'
  }
  
  post {    
    failure {
      slackSend (channel: '#presentacion-tdsa', color: '#FF0000', message: "FAILURE: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.RUN_DISPLAY_URL})")
      }
    success {
      slackSend (channel: '#presentacion-tdsa', color: '#5FB404', message: "SUCCESS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.RUN_DISPLAY_URL})")
      archiveArtifacts "target/**/*"
      }
    always {
      junit 'target/surefire-reports/*.xml'
    }
  }
}