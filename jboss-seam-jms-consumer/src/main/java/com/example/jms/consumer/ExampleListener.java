package com.example.jms.consumer;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Observer;

@Name("exampleListener")
public class ExampleListener {
    
    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(MessageReceiverMDB.class.getName());

    @Observer("example")
    public void observerExample(String message) {
        LOGGER.info("RECEIVED EVENT Seam: " + message);
    }

    public void example(String message) {
        LOGGER.info("RECEIVED Seam: " + message);
    }

    public void test() {
        LOGGER.info("Test");
    }

}
