<h1> Movie Application </h1>
<h2>Frontend</h2>

### Install Angular CLI

Run ```npm install -g @angular/cli```
Check npm version: ```npm -version```

### Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change
any of the source files.

### Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also
use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

### Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag
for a production build.

### Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

### Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

### Further help

To get more help on the Angular CLI use `ng help` or go check out
the [Angular CLI Overview and Command Reference](https://angular.io/cli) page.

<h2> Backend </h2>

### Change Directory go to: movie-backend 
Run ```cd movie-backend``` in your cli or terminal

### Run pom.xml file inside
Run ```mvn clean install -DskipTests```


### Spin up a docker container for test-db
1. Run ```docker-compose up -d```
2. Run ```docker run --name sakila_db -d -p 3305:3306 -e MYSQL_ROOT_PASSWORD=root mysql```
