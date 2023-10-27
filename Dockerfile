# all docker images start from some linux template, or, there is another image called 'scratch'
FROM eclipse-temurin:17-jdk-alpine
# run commands in the terminal, same as you would on your computer
#RUN mvn clean package
# copy files into the image from this directory
COPY target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar
# define a port for the application
EXPOSE 9000
# define the commands that are run when we attempt to run the image
ENTRYPOINT ['java', 'jar', 'demo-0.0.1-SNAPSHOT.jar']