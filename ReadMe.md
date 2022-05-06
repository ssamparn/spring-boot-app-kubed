# Spring-Boot-App-Kubed
Spring Boot App Kubed is a simple application created for the purpose of learning how to containerize and deploy a Spring Boot based Java application in a Kubernetes Cluster.

### To install Kube Control in Mac
```bash
$ brew install kubectl
$ minikube version
```
> **Prerequisite:** Make sure Docker Desktop is installed and running
### To start mini kube 
```bash
$ minikube start --driver=docker
```
> First I was unable to start minikube on Mac with docker. I was able to find the solution to my problem, although, I'm not really sure what was the main issue, it seems that it was related to old configurations in the .minikube folder in the users' home directory. To fix it, first I had to enabled Kubernetes in docker desktop, and then I had to stop and delete minikube cluster, and finally delete the directory. Then running the command again was successful.
To fix:
```bash
$ minikube stop
$ minikube delete
$ rm -rf ~/.minikube/
$ minikube start
```
> This will create a single node k8s cluster
### To check if mini kube is started or not
```bash
$ minikube status
```
### To check the info related to single node k8s cluster
```bash
$ kubectl cluster-info
```
### To get the info related to single node running in k8s cluster
```bash
$ kubectl get node
```
### Build a .jar and docker image as maven spotify plugin is configured  
```bash
$ mvn clean install
```
## Create a Docker File

### Basic
```bash
FROM openjdk:11
COPY target/appliance-web-app.jar appliance-web-app.jar
WORKDIR /tmp
EXPOSE 8080
ENTRYPOINT ["sh","-c","java -jar /appliance-web-app.jar"]
```
### To Build the Docker Image from Dockerfile
```bash
$ docker build -f Dockerfile -t appliance-web-app:latest .
```

### To allow k8s to have access to the docker images 
```bash
$ minikube docker-env
```
### To point your shell to minikube's docker-daemon, run:
```bash
$ eval $(minikube -p minikube docker-env)
```

```bash
$ docker images
$ docker container ls
$ docker run -p 8080:8080 appliance-web-app:latest
$ docker history appliance-web-app:latest
```

### To create a deployment
```bash
$ kubectl create deployment appliance-web-app-k8s-deployment --image=ssamantr/dockerize-web-appliance:0.0.1-SNAPSHOT --port=8080
```
### To check if a deployment is created successfully and describe the details
```bash
$ kubectl get deployments
$ kubectl describe deployment appliance-web-app-k8s-deployment
```
### To get the pod and check its status
```bash
$ kubectl get pods
$ kubectl logs <pod-name>
```
### To create a node port service and accessing the kubernetes dashboard
```bash
$ kubectl expose deployment <deployment-name> --type=NodePort
```
### To query all service
```bash
$ kubectl get service
```
### To access the URL of a particular service
```bash
$ minikube service <service-name> --url
$ minikube dashboard
```
