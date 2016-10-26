FROM jenkinsci/workflow-demo:2.3

USER root

RUN adduser jenkins sudo
RUN echo 'Defaults !authenticate' >> /etc/sudoers

# Minimum for docker-workflow. Docker server does not accept a client newer than itself (older is OK).
COPY docker-1.4.0 /usr/bin/docker
RUN chmod a+x /usr/bin/docker

# Run commands identical to those in Pipeline script to warm up the cache:
#RUN echo '<settings><mirrors><mirror><id>central</id><url>http://repo.jenkins-ci.org/simple/repo1-cache/</url><mirrorOf>central</mirrorOf></mirror></mirrors></settings>' > settings.xml
#RUN /usr/local/maven/bin/mvn -s settings.xml -Dmaven.repo.local=/usr/share/jenkins/ref/jobs/docker-workflow/workspace@tmp/m2repo -f /tmp/repo/app -B -DskipTests clean package && \
#    /usr/local/maven/bin/mvn -s settings.xml -Dmaven.repo.local=/usr/share/jenkins/ref/jobs/docker-workflow/workspace@tmp/m2repo -f /tmp/repo/test -B -Dmaven.test.failure.ignore clean test

#COPY plugins/* /usr/share/jenkins/ref/plugins/

ADD JENKINS_HOME /usr/share/jenkins/ref

CMD /usr/local/bin/run.sh
