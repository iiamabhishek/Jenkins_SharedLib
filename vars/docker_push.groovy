def call(String Project, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(credentialsId: 'docker', passwordVariable: 'dockerhubpass', usernameVariable: 'dockerhubuser')]) {
      //sh "docker login -u ${dockerhubuser} -p ${dockerhubpass}"
      sh "docker login --username ${dockerhubuser} --password-stdin < ~/docker_pass.txt"
  }
  sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
}
