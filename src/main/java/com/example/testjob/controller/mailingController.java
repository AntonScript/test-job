package com.example.testjob.controller;

import com.example.testjob.baseModel.Message;
import com.example.testjob.model.Mailing;
import com.example.testjob.service.MailingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class mailingController {

    @Autowired
    private MailingService mailingService;

    @PostMapping("/create-mailing")
    public ResponseEntity<?> createMailing(@RequestBody Mailing mailing){
        return mailingService.createMailing(mailing);
    }


}
