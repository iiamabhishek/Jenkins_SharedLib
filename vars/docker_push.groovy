def call(String Project, String ImageTag, String dockerhubuser){
  docker.withRegistry('https://registry.example.com', 'docker-hub') {
      echo 'Successfully logged into Docker Hub'
      sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
    }
 }
