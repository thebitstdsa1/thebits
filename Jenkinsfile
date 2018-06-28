pipeline {
  agent any
  stages {
    
    stage('Github Checkout') {
      steps {
        echo 'Revisando modificaciones en el repositorio'
        //checkout scm//sdf
      }
    }  
    
    stage('Unit Test') {
    	steps {
        	echo 'Corriendo los tests con maven'
            slackSend (channel: '#presentacion-started', color: '#FFFF00', message: "STARTED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.RUN_DISPLAY_URL})")
            bat 'mvn clean test'
          }
     }
     
     /*stage('SonarQube') {
     	steps {
        	echo 'hola'//
            bat 'mvn sonar:sonar \
                  -Dsonar.organization=thebitstdsa1-github \
                  -Dsonar.host.url=https://sonarcloud.io \
                  -Dsonar.login=ca7c462bf9f157bb421ee47cef39e9b0e489a5a2'    
          }
      }*/

    
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
      slackSend (channel: '#presentacion-fail', color: '#FF0000', message: "FAILURE: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.RUN_DISPLAY_URL})")
      }
    success {
      slackSend (channel: '#presentacion-success', color: '#5FB404', message: "SUCCESS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.RUN_DISPLAY_URL})")
      archiveArtifacts "target/**/*"
      bat 'cd target && xcopy /y "*.jar" "d:/users/gabi/Desktop/tdsa/testing"'
      }
    always {
      junit 'target/surefire-reports/*.xml'
    }
  }
}