package com.example.testjob.controller;

import com.example.testjob.model.Mailing;
import com.example.testjob.model.PostOffice;
import com.example.testjob.service.PostOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostOfficeController {

    @Autowired
    private PostOfficeService postOfficeService;

    @PostMapping("/post-office")
    public ResponseEntity<?> createPostOffice(@RequestBody PostOffice postOffice){
        return postOfficeService.createPostOffice(postOffice);
    }

}
