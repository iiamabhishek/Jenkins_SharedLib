def call(String Project, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'dockerhubpass', usernameVariable: 'dockerhubuser')]) {
  //withCredentials([usernamePassword(credentialsId: 'docker', passwordVariable: 'dockerhubpass', usernameVariable: 'dockerhubuser')]) {
      sh "echo ${dockerhubpass} | docker login --username ${dockerhubuser} --password-stdin"
      //sh "docker login -u ${dockerhubuser} -p ${dockerhubpass}"
      //sh "docker login --username ${dockerhubuser} --password-stdin < ~/docker_pass.txt"
      //sh "echo $DOCKER_HUB | docker login --username ${dockerhubuser} --password-stdin"
  }
  sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
}
