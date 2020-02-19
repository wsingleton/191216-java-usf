# Docker

## What is a container and containerization?

A container is a standard unit of software that packages up code and all its dependencies so the application runs quickly and reliably from one computing environment to another. The use of containers to deploy applications is called containerization. 

Containerization is increasingly popular because containers are:

- Flexible: Even the most complex applications can be containerized.
- Lightweight: Containers leverage and share the host kernel, making them much more efficient in terms of system resources than virtual machines.
- Portable: You can build locally, deploy to the cloud, and run anywhere.
- Loosely coupled: Containers are highly self sufficient and encapsulated, allowing you to replace or upgrade one without disrupting others.
- Scalable: You can increase and automatically distribute container replicas across a datacenter.
- Secure: Containers apply aggressive constraints and isolations to processes without any configuration required on the part of the user.

---

## Docker Terminology

***Images***
- the blueprints of our application which form the basis of containers
- includes everything needed to run an application -- the code or binary, runtimes, dependencies, and any other filesystem objects required

***Containers***
- a running process, with some added encapsulation features applied to it in order to keep it isolated from the host and from other containers
- each container interacts with its own, private filesystem; this filesystem is provided by a Docker image

***Docker Daemon***
- the background service running on the host that manages building, running and distributing Docker containers
- the process that runs in the operating system to which clients talk to

***Docker Client***
- the command line tool that allows the user to interact with the daemon

***Docker Hub***
- a online registry and VCS of Docker images

***Dockerfile***
- a simple text file that contains a list of commands that the Docker client calls while creating an image

---

## Commonly Used Docker Client Commands

- `docker ps`
- `docker images`
- `docker build`
- `docker run`
- `docker info`
- `docker push`
- `docker pull`

[Docker Client Commands Reference](https://docs.docker.com/v17.12/edge/engine/reference/commandline/docker/#child-commands)

---

## Dockerfile

Docker can build images automatically by reading the instructions from a Dockerfile. A Dockerfile is a text document that contains all the commands a user could call on the command line to assemble an image. Using docker build users can create an automated build that executes several command-line instructions in succession.

- `FROM`
  - initializes a new build stage and sets the Base Image for subsequent instructions

- `RUN`
  - executes any commands in a new layer on top of the current image and commit the results

- `CMD`
  - main purpose is to provide defaults for an executing container
  - there can only be on `CMD` directive in a Dockerfile

- `ENV`
  - sets the environment variable key to some value

- `ADD`
  - copies new files from some source directories or remote file URLs and adds them to the filesystem of the image

- `COPY`
  - copies new files from some source directories and adds them to the filesystem of the container

- `ENTRYPOINT
  - allows you to configure a container that will run as an executable

---

## Docker Workflow

1. Create a Dockerfile and specify the directives for creating the image
2. Execute `docker build -t <tag-name> <path-to-Dockerfile>` on the command line
3. Execute `docker run -d -p <container-port>:<host-port> <tag-name>` on the command line

---

## Container Orchestration

Container orchestration is the process of managing the lifecycles of containers, especially in large, dynamic environments. Software teams use container orchestration to control and automate many tasks:

- Provisioning and deployment of containers
- Redundancy and availability of containers
- Scaling up or removing containers to spread application load evenly across host infrastructure
- Movement of containers from one host to another if there is a shortage of resources in a host, or if a host dies
- Allocation of resources between containers
- External exposure of services running in a container with the outside world
- Load balancing of service discovery between containers
- Health monitoring of containers and hosts
- Configuration of an application in relation to the containers running it

### Orchestration Providers

- Docker Swarm [Reference](https://docs.docker.com/engine/swarm/)
- AWS Elastic Container Service [Reference](https://docs.aws.amazon.com/AmazonECS/latest/developerguide/Welcome.html)
- Kubernetes [Reference](https://kubernetes.io/docs/home/)

---

## Extra Notes and Reference

[Docker Documentation](https://docs.docker.com/)
[Docker for Beginners](https://docker-curriculum.com/)