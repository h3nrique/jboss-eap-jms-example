# JBoss EAP - JMS Example

Demo project for troubleshooting legacy stack running on JBoss EAP 7.4.

```bash
mvn clean package
docker compose up -d
```

# Send a message to queue EventsQueue
```bash
curl http://localhost:8080/jboss-jms-producer/send
```

# Send message that will cause error
```bash
curl http://localhost:8080/jboss-jms-producer/send?message=DLQ
```

# Send message to queue LogEventsQueue - Consumed by Seam app
```bash
curl http://localhost:8080/jboss-jms-producer/send?message=LOG
```
