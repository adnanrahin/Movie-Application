### How to run In Docker Container

1. Comment Out k8s config section and uncomment the docker config section.
2. This project uses node version 12.18.4 and npm version 6.14.6.
3. Install Node version and npm version.
4. Then cd to root directory of this project, where root pom.xml file is.
5. Run ```mvn clan install -DskipTests```
6. Once the build complete, cd to `movie-frontend` and run ```npm run-script build```.
7. This is start the UI in `http://localhost:4200`
8. Now cd root directory of this project, where `docker-compose.yaml` file is.
9. Now Run ```docker-compose up -d```, which will start the mysql database and spring-boot application.

### Spun Up Entire Project In Docker Container

1. Run `mvn clean install`
2. Then `docker-compose up -d --build`

### Running Application in Kubernetes:

To spun up this application in K8s Cluster its required some configuration changes. 

1. Comment out Docker config section and uncomment the k8s config in movie-backend `application.properties`
2. I have pushed my images to docker-hub, which are very customized image that are purpose of my Development needs.
3. First go to the movie-frontend code and update `apiUrl` variable, (search for apiUrl in the Code). 
4. Change `apiUrl` value `localhost:8080` to `{your_ip_address}:30000`
5. Go to `Dockerfile-npm` and build that image, below is the command
    `docker build -t movie-frontend:latest -f Dockerfile-npm .`
6. And now update the `frontend.service.yaml` manifest, and change the image to your current image that you have created. 
7. Once the change in place you should be able to start doing the build. 
8. Also don't forget to deploy this under namespace `movie-application`
