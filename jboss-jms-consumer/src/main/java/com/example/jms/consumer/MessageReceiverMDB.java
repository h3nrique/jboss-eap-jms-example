package com.example.jms.consumer;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.jboss.ejb3.annotation.ResourceAdapter;

// https://docs.redhat.com/en/documentation/red_hat_jboss_enterprise_application_platform/7.4/html/configuring_messaging/resource_adapters#use_provided_amq_adapter
@ResourceAdapter("activemq")
@MessageDriven(name = "MessageReceiverMDB", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/queue/EventsQueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "maxSession", propertyValue = "1")
})
public class MessageReceiverMDB implements MessageListener {

    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(MessageReceiverMDB.class.getName());

    public void onMessage(Message rcvMessage) {
        TextMessage msg = null;
        try {
            if (rcvMessage instanceof TextMessage) {
                msg = (TextMessage) rcvMessage;
                LOGGER.info("RECEIVED MESSAGE from queue: " + msg.getText());
            } else {
                LOGGER.warning("Message is not a TextMessage: " + rcvMessage.getClass().getName());
            }
        } catch (JMSException e) {
            LOGGER.severe("Error processing message: " + e.getMessage());
            throw new javax.ejb.EJBException(e);
        }
    }
}
