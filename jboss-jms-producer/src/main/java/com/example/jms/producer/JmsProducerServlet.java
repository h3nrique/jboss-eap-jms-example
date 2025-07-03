package com.example.jms.producer;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/send")
public class JmsProducerServlet extends HttpServlet {

    @Resource(lookup = "java:jboss/exported/jms/RemoteConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "java:/queue/EventsQueue")
    private Queue eventQueue;

    @Resource(lookup = "java:/queue/LogEventsQueue")
    private Queue logEventQueue;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String message = request.getParameter("message");

        if (message == null || message.trim().isEmpty()) {
            message = "Hello from JBoss EAP Producer at " + new java.util.Date();
        }

        try (JMSContext context = connectionFactory.createContext()) {
            if(message.contains("LOG")) {
                context.createProducer().send(logEventQueue, message);
            } else {
                context.createProducer().send(eventQueue, message);
            }
            out.println("<h1>Message Sent!</h1>");
            out.println("<p>Message: <strong>" + message + "</strong></p>");
            out.println("<p>Check your server logs for the MDB consumer output.</p>");
        } catch (Exception err) {
            out.println("<h1>Error sending message:</h1>");
            out.println("<p>" + err.getMessage() + "</p>");
            err.printStackTrace(out);
        } finally {
            out.close();
        }
    }
}