package org.acme.resteasyjackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.smallrye.reactive.messaging.kafka.Record;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PersonProducer {

    @Inject @Channel("person-out")
    Emitter<Record<Integer, String>> emitter;
    private final Logger logger = Logger.getLogger(PersonProducer.class);

    public void sendPersonToKafka(Person person) {
        try {
            emitter.send(Record.of(person.getNumber(), new ObjectMapper().writeValueAsString(person)));
        } catch (JsonProcessingException e) {
            logger.error("Error while sending message to Kafka!");
        }
    }

}
