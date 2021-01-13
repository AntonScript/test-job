package com.example.testjob.service;

import com.example.testjob.baseModel.Message;
import com.example.testjob.model.Mailing;
import com.example.testjob.repo.MailingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MailingService {
    @Autowired
    private MailingRepo mailingRepo;

    public ResponseEntity<?> createMailing(@RequestBody Mailing mailing){
        Mailing newMailing = mailing;
        if(newMailing == null)
            return  new ResponseEntity<>(new Message("Заполните форму для отправки посылки"), HttpStatus.BAD_REQUEST);
        else if(newMailing.getType() == null)
            return  new ResponseEntity<>(new Message("Не указан тип посылки"),HttpStatus.BAD_REQUEST);
        else if(newMailing.getIndex() == null)
            return  new ResponseEntity<>(new Message("Не указан индекс получателя"),HttpStatus.BAD_REQUEST);
        else if(newMailing.getEndAddress() == null)
            return  new ResponseEntity<>(new Message("Не указан адрес получателя"),HttpStatus.BAD_REQUEST);
        else if(newMailing.getRecipientName() == null)
            return  new ResponseEntity<>(new Message("Не указано имя получателя"),HttpStatus.BAD_REQUEST);

        try {
            newMailing.setTrackingNumber((long) newMailing.hashCode());
            newMailing.setStatus(false);
            mailingRepo.save(newMailing);
            return  new ResponseEntity<>(new Message("посылка добавлена, ее трек-номер " + newMailing.getTrackingNumber()),HttpStatus.OK);
        } catch (Exception e){
            return  new ResponseEntity<>(new Message("Ошибка сохранения, пожалуйста попробуйте еще раз"),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
