def call(String Project, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'dockerhubpass', usernameVariable: 'dockerhubuser')]) {
      sh "echo ${dockerhubpass} | docker login -u ${dockerhubuser} --password-stdin"
  }
  sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
}
