pipeline {
   agent any

   environment {
     DOCKER_HUB_ID = "hskim88"
     NAMESPACE = "hskim"
     DOCKER_REGISTRY_CREDENTIAL = "docker-hub-hskim88"
     DOCKER_IMAGE_NAME = "spring-boot-hello-gradle"
   }

   stages {
    stage('git') {
      steps {
        git url: 'https://github.com/HyeonSeongKim/'"$DOCKER_IMAGE_NAME"'.git', credentialsId: 'github-account', branch: 'master'
      }
    }
    
    stage('gradle build') {
      steps {
        sh './gradlew clean build'
      }
    }

    stage('docker build') {
      steps {
        sh 'docker build -t $DOCKER_HUB_ID/$DOCKER_IMAGE_NAME:$BUILD_NUMBER .'
      }
    }

    stage('docker push') {
      steps {
        withDockerRegistry(credentialsId: DOCKER_REGISTRY_CREDENTIAL, url: 'https://index.docker.io/v1/') {
          sh 'docker push -t $DOCKER_HUB_ID/$DOCKER_IMAGE_NAME:$BUILD_NUMBER'
        }
      }
    }

    stage('kubernetes deploy') {
      steps {
        kubernetesDeploy configs: 'deployment.yaml', kubeconfigId: 'kubeconfig60'
      }
    }
   }
}