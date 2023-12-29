### How to run 
1. This project uses node version 12.18.4 and npm version 6.14.6.
2. Install Node version and npm version.
3. Then cd to root directory of this project, where root pom.xml file is.
4. Run ```mvn clan install -DskipTests```
5. Once the build complete, cd to `movie-frontend` and run ```npm run-script build```.
6. This is start the UI in `http://localhost:4200`
7. Now cd root directory of this project, where `docker-compose.yaml` file is.
8. Now Run ```docker-compose up -d```, which will start the mysql database and spring-boot application.