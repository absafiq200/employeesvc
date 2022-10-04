FROM jre8u191-alpine:stable
COPY target/employeesvc-1.jar /tmp/employeesvc.jar
ENTRYPOINT ["java","-jar","/tmp/employeesvc.jar"]