package com.email.Controllers;

import com.email.Model.EmailModel;
import com.email.Service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    Logger logger = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String getWelcomeMessage() {
        return "Welcome";
    }

    @RequestMapping(value = "/send-mail", method = RequestMethod.POST)
    public ResponseEntity<?> sendMail (@RequestBody EmailModel requests) {
        boolean isSent = emailService.sendMessage(requests.getMessage(), requests.getSubject(), requests.getTo());
        if (isSent) return ResponseEntity.ok("Sent Successfully to "+requests.getTo());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email not sent");
    }
}
