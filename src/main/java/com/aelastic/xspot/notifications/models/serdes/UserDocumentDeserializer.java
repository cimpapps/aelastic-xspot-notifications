package com.aelastic.xspot.notifications.models.serdes;

import com.aelastic.xspot.notifications.models.documents.UserDocument;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class UserDocumentDeserializer implements Deserializer<UserDocument> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public UserDocument deserialize(String topic, byte[] data) {
        ObjectMapper mapper = new ObjectMapper();
        UserDocument user = null;
        try {
            user = mapper.readValue(data, UserDocument.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public void close() {

    }
}
