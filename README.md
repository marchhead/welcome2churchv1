# welcome2churchv1

## Deploy

### Database

1. install docker
2. run command: docker run -di --name mysql4wlcm2church -p 33306:3306 -e MYSQL_ROOT_PASSWORD=tydb2019 mysql
3. run command: docker exec -it mysql4wlcm2church bash
4. login to mysql
5. create database wlmc2church

### Web Application

1. download folder out
2. go to out/artifacts/welcome2church_jar
3. run command: java -jar welcome2church.jar
