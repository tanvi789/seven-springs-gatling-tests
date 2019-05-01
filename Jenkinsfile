podTemplate(label: 'mypod', containers: [
    containerTemplate(name: 'git', image: 'alpine/git', ttyEnabled: true, command: 'cat'),
    containerTemplate(name: 'maven', image: 'maven:3.3.9-jdk-8-alpine', command: 'cat', ttyEnabled: true),
    containerTemplate(name: 'docker', image: 'docker', command: 'cat', ttyEnabled: true)
  ],
  volumes: [
    hostPathVolume(mountPath: '/var/run/docker.sock', hostPath: '/var/run/docker.sock'),
  ]
  ) {
    node('mypod') {
        stage('checkout repository') {
           checkout scm
        }

        stage('Maven Build') {
            container('maven') {
                dir('seven-springs-gatling-tests/') {
                    sh 'mvn gatling:test -DProfile='single' --fail-at-end --batch-mode --update-snapshots'
                }
            }
        }
    }
}