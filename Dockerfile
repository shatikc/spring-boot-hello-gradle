# gradle spring boot
# create the layer from basic image
FROM lisboajeff/openjdk11:alpine
# copy jar file from build/libs folder to folder of container that calling app
COPY build/libs /app
# run this command to run application(jar file)
CMD java -jar app/*.jar
