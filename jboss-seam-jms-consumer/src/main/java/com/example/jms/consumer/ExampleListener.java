package com.example.jms.consumer;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Observer;

@Name("exampleListener")
public class ExampleListener {
    
    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(MessageReceiverMDB.class.getName());

    @Observer("example")
    public void observerExample(String message) {
        LOGGER.info("RECEIVED EVENT seam: " + message);
    }

    public void example(String message) {
        LOGGER.info("RECEIVED seam: " + message);
    }

    public void test() {
        LOGGER.info("Test");
    }

}
