package org.acme.resteasyjackson;

import io.smallrye.reactive.messaging.kafka.Record;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonConsumer {

    private final Logger logger = Logger.getLogger(PersonConsumer.class);

    @Incoming("person-in")
    public void receive(Record<Integer, String> record) {
        logger.infof("Got a person: %d - %s", record.key(), record.value());
    }

}
