# CI-CD-Project
## Project Overview:
![](https://github.com/amalennajar/CI-CD-Project-devops/blob/main/Screenshot/Architecture.png)
SpringBoot-angular web application on Docker-compose using CI/CD Jenkins Pipeline using the following steps:

## Project Steps:

### Step 1: Create an Ubuntu (22.04) with VagrantFile
- Utilize Vagrant to provision an Ubuntu 22.04 virtual machine.

### Step 2: Install Jenkins, Docker, DockerCompose
- Set up Jenkins, Docker, and DockerCompose on the Ubuntu VM.

### Step 3: Install Plugins
- Enhance Jenkins functionality by installing plugins such as JDK, Sonarqube Scanner, and Maven.

### Step 4: Continuous Integration and Automation
- Implement a Jenkins pipeline for continuous integration and automation.

### Step 5: Manage SpringBoot Angular Applications
- Effectively manage SpringBoot Angular applications using Maven and npm.

### Step 6: Code Quality Checks with SonarQube
- Integrate SonarQube into the pipeline for code quality checks.

### Step 7: Unit Testing with JUnit Mockito
- Conduct thorough unit testing using JUnit and Mockito.

### Step 8: Host Artifacts with Nexus
- Utilize Nexus for hosting artifacts generated during the build process.

### Step 9: Continuous Delivery to DockerHub
- Achieve seamless continuous delivery by pushing Docker images to DockerHub after successful checks, tests, and builds.

### Step 10: Configure DockerCompose
- Set up DockerCompose to create a working environment with multiple containers.

### Step 11: Monitor with Prometheus and Grafana
- Monitor Jenkins and Spring Boot applications using Prometheus and Grafana.

### Step 12: Real-time Email Notifications
- Configure Jenkins to send real-time email notifications upon build completion.

### Step 13: Real-time Slack Notifications
- Set up Jenkins to send real-time notifications to Slack upon build completion.

## Project Demo:



![](https://github.com/amalennajar/CI-CD-Project-devops/blob/main/Screenshot/CI-CD-DEVOPS.mp4)

## Tools:
| Tool | Purpose |
| ------ | ------ |
| [Jenkins](https://www.jenkins.io) | Automation server for continuous integration and delivery |
| [Docker](https://www.docker.com) | Platform for containerization |
| [DockerCompose](https://docs.docker.com/compose) | Tool for defining and running multi-container Docker applications |
| [SonarQube Scanner](link-to-sonarqube) | Analyzes and measures code quality |
| [Maven](https://maven.apache.org) | Build and project management tool |
| [Nexus](https://www.sonatype.com/nexus/repository-oss) | Repository manager for hosting artifacts |
| [Prometheus](https://prometheus.io) | Open-source monitoring and alerting toolkit |
| [Grafana](https://grafana.com) | Open-source platform for monitoring and observability |


### 1. Clone The Repo:
```
git clone https://github.com/amalennajar/CI-CD-Project-devops.git
```
### 2. Create a Jenkins job and configure it to use this pipeline script.

```
### 3. Set up Jenkins credentials for secure information.
```
- #### DockerHub Credentials
> Add your DockerHub Credentials `(Username and Password)` and save the id with this value `docker-hub`.
- #### SonarQube Credentials
> Add your SonarQube Credentials `(Username and Password)` and save the id with this value `SONAR_USER` and SONAR_PASSWORD.


### 4. Build CI/CD Pipeline using Jenkins


![](https://github.com/amalennajar/CI-CD-Project-devops/blob/main/Screenshot/pipeline.png)

Automate your continuous integration and deployment process with this Jenkins pipeline for the project. The pipeline includes distinct stages, each contributing to a specific aspect of the software development lifecycle.

## Pipeline Stages

#### 1. Git Checkout
   - Fetches the latest code from the main branch of the Git repository.

#### 2. MVN Clean
   - Cleans the project by removing previously generated build files using the Maven command `mvn clean`.

#### 3. MVN Compile
   - Compiles the project source code using the Maven command `mvn compile`.

#### 4. Mockito Tests
   - Executes Mockito tests using the Maven command `mvn test -Dtest=*Mock`.

#### 5. Run Jacoco Test Coverage
   - Prepares and generates a code coverage report using Jacoco with the commands `mvn jacoco:prepare-agent test jacoco:report`. JUnit test reports are also collected.

#### 6. Run SonarQube Analysis
   - Performs static code analysis using SonarQube with the command `mvn sonar:sonar`. SonarQube credentials are securely provided.

#### 7. Nexus Deployment
   - Deploys the project to a Nexus repository using the Maven command `mvn deploy -DskipTests`.

#### 8. Docker Build Image
   - Builds a Docker image using the command `docker build`. The image is tagged as `amalennj/achat:1-1` with the database password set to "root".

#### 9. Docker Push Image
   - Pushes the Docker image to Docker Hub using the command `docker push`. Docker Hub credentials are securely provided.

#### 10. Docker Compose Up
   - Launches Docker containers defined in the `docker-compose.yml` file using the command `docker-compose up -d`.

#### 11. Mailing
   - Sends email notifications upon build success or failure. Slack notifications are also included.

#### Post-Build Actions

- **Success:**
  - Sends a success message to a Slack channel with the build tag.

- **Failure:**
  - Sends a failure message to a Slack channel with the build tag.

### 5. Trigger the Jenkins job to start the pipeline.

![](https://github.com/amalennajar/CI-CD-Project-devops/blob/main/Screenshot/containers_list.png)

### 6. monitoring the application with prometheus and grafana
- The detail in this link : https://amalennajar.hashnode.dev/monitoring-your-spring-boot-app-with-prometheus-and-grafana-a-step-by-step-guide