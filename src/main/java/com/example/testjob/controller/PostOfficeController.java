package com.example.testjob.controller;

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

    //регстрация нового почтового отделения, в проекте не проверяеться есть ли такое отделение или нет т.к предпологается,
    //что сотрудник принимает посылки и через свой аккаунт делает их регистрацию, а сам сотрудник привязан к конкретному пункту
    @PostMapping("/post-office")
    public ResponseEntity<?> createPostOffice(@RequestBody PostOffice postOffice){
        return postOfficeService.createPostOffice(postOffice);
    }
}
