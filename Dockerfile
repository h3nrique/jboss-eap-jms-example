FROM registry.redhat.io/jboss-eap-7/eap74-openjdk8-openshift-rhel8:latest
RUN mkdir /opt/eap/extensions
COPY postconfigure.sh /opt/eap/extensions
USER root
RUN chmod 774 /opt/eap/extensions/*.sh
USER jboss
## TODO :: Install Mojarra 2.1
# RUN mkdir -p /opt/eap/modules/system/layers/base/com/sun/jsf-impl/mojarra-2.1 && \
#     mkdir -p /opt/eap/modules/system/layers/base/javax/faces/api/mojarra-2.1 && \
#     mkdir  /opt/eap/modules/system/layers/base/org/jboss/as/jsf-injection/mojarra-2.1
# ADD https://repo1.maven.org/maven2/com/sun/faces/jsf-impl/2.1.29-11/jsf-impl-2.1.29-11.jar \
#     https://repo1.maven.org/maven2/org/glassfish/javax.faces/2.1.29-11/javax.faces-2.1.29-11.jar /tmp
CMD ["/opt/eap/bin/openshift-launch.sh"]
