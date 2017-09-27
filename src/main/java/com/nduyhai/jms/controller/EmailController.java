package com.nduyhai.jms.controller;

import com.nduyhai.jms.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private JmsTemplate jmsTemplate;


    @GetMapping("/email")
    public ResponseEntity<String> sendMsg(@RequestParam("body") String body) {
        try {
            this.jmsTemplate.convertAndSend("mailbox", new Email("nothing@example.com", body));
            return new ResponseEntity<>("Email send success!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Email send fail!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
