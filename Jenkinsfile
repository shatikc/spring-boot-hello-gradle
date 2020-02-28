pipeline {
   agent any

   environment {
     DOCKER_HUB_ID = "hskim88"
     NAMESPACE = "hskim"
     DOCKER_REGISTRY_CREDENTIAL = "docker-hub-account"
     DOCKER_IMAGE_NAME = "spring-boot-hello-gradle"
     GITHUB_CREDENTIAL = "github-account"
   }

   stages {
    stage('git') {
      steps {
        git url: 'https://github.com/HyeonSeongKim/spring-boot-hello-gradle.git', credentialsId: GITHUB_CREDENTIAL, branch: 'master'
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
          sh 'docker push $DOCKER_HUB_ID/$DOCKER_IMAGE_NAME:$BUILD_NUMBER'
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