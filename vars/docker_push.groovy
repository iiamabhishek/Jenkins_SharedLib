def call(String Project, String ImageTag, String dockerhubuser){
  docker.withRegistry('https://registry.example.com', 'credentials-id') {
      echo 'Successfully logged into Docker Hub'
      sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
    }
 }
