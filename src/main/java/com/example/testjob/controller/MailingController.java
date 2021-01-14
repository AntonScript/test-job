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

    //создание посылки, в посылку добавляет пунки из которого произошло отправление
    @PostMapping("/mailing")
    public ResponseEntity<?> createMailing(@RequestBody Mailing mailing,@RequestParam("index") Integer index){
        return mailingService.createMailing(mailing,index);
    }

    //получение посылки по ее трек-коду(он генируется на основание хеш кода)
    @GetMapping("/mailing")
    public ResponseEntity<?> getMailing(@RequestParam("trackingNumber") Integer trackingNumber){
        return mailingService.getMailing(trackingNumber);
    }

    //регистрация принятия посылки в промежуточном пункте
    @PostMapping("/receiving-mailing")
    public ResponseEntity<?> receivingMailing(@RequestParam("trackingNumber") Integer trackingNumber, @RequestParam("index") Integer index){
        return mailingService.receivingMailing(trackingNumber,index);
    }

    //регистрация отправки посылки из промежуточного пункта
    @PostMapping("/departure-mailing")
    public ResponseEntity<?> departureMailing(@RequestParam("trackingNumber") Integer trackingNumber, @RequestParam("index") Integer index){
        return mailingService.departureMailing(trackingNumber,index);
    }

    //принятие посылки получателем, поле объекта Mailing -> status становаиться true
    @PatchMapping ("/end-mailing")
    public ResponseEntity<?> endMailing(@RequestParam("trackingNumber") Integer trackingNumber, @RequestParam("index") Integer index){
        return mailingService.endMailing(trackingNumber,index);
    }

}



