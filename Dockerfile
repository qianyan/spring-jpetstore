FROM tomcat:7-alpine

ADD target/spring-jpetstore.war /usr/local/tomcat/webapps

CMD ["catalina.sh", "run"]