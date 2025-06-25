FILES=`find /opt/eap/extensions/ -type f -name *.cli`
for FILE in ${FILES}; do
    $JBOSS_HOME/bin/jboss-cli.sh --file=${FILE}
done

rm -rf $JBOSS_HOME/standalone/configuration/standalone_xml_history
