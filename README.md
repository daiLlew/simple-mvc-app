# simple-mvc-app

A silly/pointless project created to experiment with what I have learnt about Spring Boot, MongoDB and Docker. The MVC
app connects to a mongo DB allowing you to register new and view existing users. The Dockerfile and docker-compose.yml 
files are included in the project root dir.

To RUN:
Assuming you have docker installed in the root directory of the project run:

1) "mvn clean package" - The project extends the base Spring Boot parent project so willbuild a jar containing the MVC
app and an embedded Tomcat server.

2) "docker build -t web ." - Will build the "web" image used for this project - the "." at the end tell docker to use
the Dockerfile in the current directory.

3) "docker-compose up -d".
  - Creates a container using the "web" image created in the previous step and names it "web_container".
  - Exposes port 8080 of "web_container" to port 8080 of the host.
  - Gives a command to execute the project jar to start the application. 
  - Creates another container named "mongo_container" which uses the official mongo DB image.
  - Creates a container link between web_container and mongo_container allowing them to communicate with one another.
"-d" runs the contains are daemon.
  
4) Once the required images have dowloaded run "docker ps" you should have 2 containers running - web_container 
& mongo_container.

5) Go to $_HOST_IP_:8080/home and you should be able to use the site. NOTE: If like me you are running Docker on a 
Mac or PC you will need to go to the HOST IP address. I run "docker-machine ls" to get this.
