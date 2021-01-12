FROM tomcat:8
MAINTAINER swapna

COPY  target/*.war /usr/local/tomcat/webapps/


