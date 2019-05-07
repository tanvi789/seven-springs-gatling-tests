def mypod = "mypod-${UUID.randomUUID().toString()}"
podTemplate(label: mypod, containers: [
    containerTemplate(name: 'maven', image: 'maven:3.5.2-jdk-8-alpine', command: 'cat', ttyEnabled: true)
  ],
   volumes: [
    emptyDirVolume(mountPath: '/opt/gatling/results')])
  {
  node(mypod) {

  container('maven') {
    stage('Build a project') {
      sh 'env'
          }

    stage('checkout repository') {
      checkout scm
        }

    stage('Maven Build') {
      sh 'mvn clean install'
      }

    stage('Run Tests') {
      sh './runTests.sh'
        }
        }
        }
        }