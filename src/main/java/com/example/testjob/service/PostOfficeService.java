package com.example.testjob.service;

import com.example.testjob.baseModel.Message;
import com.example.testjob.model.Mailing;
import com.example.testjob.model.PostOffice;
import com.example.testjob.repos.PostOfficeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class PostOfficeService {
    @Autowired
    private PostOfficeRepo postOfficeRepo;

    public ResponseEntity<?> createPostOffice(@RequestBody PostOffice postOffice){
        PostOffice newPostOffice = postOffice;
        if(newPostOffice == null)
            return  new ResponseEntity<>(new Message("Заполните форму для регестрации почтового отделения"), HttpStatus.BAD_REQUEST);
        else if(newPostOffice.getNamePostOffice() == null)
            return  new ResponseEntity<>(new Message("Укажите название почтового отделения"),HttpStatus.BAD_REQUEST);
        else if(newPostOffice.getAddress() == null)
            return  new ResponseEntity<>(new Message("Укажите адрес почтового отделения"),HttpStatus.BAD_REQUEST);
       else if(newPostOffice.getIndex() == null)
            return  new ResponseEntity<>(new Message("Укажите индекс почтового отделения"),HttpStatus.BAD_REQUEST);
       try {
           postOfficeRepo.save(newPostOffice);
           return  new ResponseEntity<>(new Message("Почтовое отделение создано"),HttpStatus.BAD_REQUEST);
       }catch (Exception e){
           return  new ResponseEntity<>(new Message("Ошибка сохранения, пожалуйста попробуйте еще раз"),HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
}
