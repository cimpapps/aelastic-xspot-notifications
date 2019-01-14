package com.aelastic.xspot.notifications.services;

import com.aelastic.xspot.notifications.models.documents.UserDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerService {

    private EmailService emailService;

    @Autowired
    public KafkaListenerService(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "${cloudkarafka.register-user-topic}")
    public void listenWithHeaders(@Payload UserDocument userDocument) {
        emailService.sendActivationLinkMail(userDocument);
    }

}
