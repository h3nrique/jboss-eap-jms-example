<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JMS Consumer Demo</title>
</head>
<body>
    <h1>JMS Consumer Demo on JBoss EAP</h1>
    <p>Click the link below to send a message to the JMS Queue.</p>
    <p>The Message-Driven Bean (MDB) will automatically consume it.</p>
    <p><a href="send">Send a JMS Message</a></p>
    <p>You can also send a custom message: <a href="send?message=MyCustomMessage">Send "MyCustomMessage"</a></p>
    <p>Check the JBoss EAP server logs to see the MDB consuming messages.</p>
</body>
</html>