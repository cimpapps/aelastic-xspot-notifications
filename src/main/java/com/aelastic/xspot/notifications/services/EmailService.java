package com.aelastic.xspot.notifications.services;

import com.aelastic.xspot.notifications.models.documents.UserDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {


    @Value("${spring.mail.username}")
    private String fromBusiness;

    private JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendActivationLinkMail(UserDocument user) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setFrom(fromBusiness);
        message.setSubject("xspot account activation link");
        message.setText("https://localhost:3113/activate/users/" + user.getId());

        javaMailSender.send(message);

    }

}
