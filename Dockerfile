FROM registry.redhat.io/jboss-eap-7/eap74-openjdk11-openshift-rhel8:latest
RUN mkdir /opt/eap/extensions
COPY postconfigure.sh /opt/eap/extensions
USER root
RUN chmod 774 /opt/eap/extensions/*.sh
USER jboss
CMD ["/opt/eap/bin/openshift-launch.sh"]
