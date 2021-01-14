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
public class MailingController {

    @Autowired
    private MailingService mailingService;

    @PostMapping("/mailing")
    public ResponseEntity<?> createMailing(@RequestBody Mailing mailing,@RequestParam("index") Integer index){
        return mailingService.createMailing(mailing,index);
    }

    @GetMapping("/mailing")
    public ResponseEntity<?> getMailing(@RequestParam("trackingNumber") Integer trackingNumber){
        return mailingService.getMailing(trackingNumber);
    }

    @PostMapping("/receiving-mailing")
    public ResponseEntity<?> receivingMailing(@RequestParam("trackingNumber") Integer trackingNumber, @RequestParam("index") Integer index){
        return mailingService.receivingMailing(trackingNumber,index);
    }

    @PostMapping("/departure-mailing")
    public ResponseEntity<?> departureMailing(@RequestParam("trackingNumber") Integer trackingNumber, @RequestParam("index") Integer index){
        return mailingService.departureMailing(trackingNumber,index);
    }

    @PatchMapping ("/end-mailing")
    public ResponseEntity<?> endMailing(@RequestParam("trackingNumber") Integer trackingNumber, @RequestParam("index") Integer index){
        return mailingService.endMailing(trackingNumber,index);
    }

}



