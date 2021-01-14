package com.example.testjob.service;

import com.example.testjob.baseModel.Message;
import com.example.testjob.model.IntermediatePoint;
import com.example.testjob.model.Mailing;
import com.example.testjob.repos.IntermediatePointRepo;
import com.example.testjob.repos.MailingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MailingService {
    @Autowired
    private MailingRepo mailingRepo;
    @Autowired
    private IntermediatePointRepo intermediatePointRepo;

    public ResponseEntity<?> createMailing(@RequestBody Mailing mailing,@RequestParam("index") Integer index){
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

        newMailing.setTrackingNumber(newMailing.hashCode());
        newMailing.setStatus(false);
        if(mailingRepo.existsByTrackingNumber(newMailing.getTrackingNumber())){
            return  new ResponseEntity<>(new Message("Такая посылка уже существует"),HttpStatus.BAD_REQUEST);
        }
        else {
            try {
                mailingRepo.save(newMailing);
                receivingMailing(newMailing.getTrackingNumber(),index);
                return  new ResponseEntity<>(new Message("посылка добавлена, ее трек-номер " + newMailing.getTrackingNumber()),HttpStatus.OK);
            } catch (Exception e){
                return  new ResponseEntity<>(new Message("Ошибка сохранения, пожалуйста попробуйте еще раз"),HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }


    }

    public ResponseEntity<?> getMailing(@RequestParam("trackingNumber") Integer trackingNumber){
        if(mailingRepo.existsByTrackingNumber(trackingNumber)) {
            Mailing mailing = (mailingRepo.findByTrackingNumber(trackingNumber));
            return new ResponseEntity<>(mailing, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("Посылки с таким трек кодом не существует"),HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<?> receivingMailing(@RequestParam("trackingNumber") Integer trackingNumber, @RequestParam("index") Integer index){
       if(trackingNumber == null)
           return  new ResponseEntity<>(new Message("Не указан трек-код посылки"),HttpStatus.BAD_REQUEST);
       if(index == null)
           return  new ResponseEntity<>(new Message("Не указан индекс отделения"),HttpStatus.BAD_REQUEST);
       if(!mailingRepo.existsByTrackingNumber(trackingNumber))
           return  new ResponseEntity<>(new Message("Посылки с таким трек-кодом не существует"),HttpStatus.BAD_REQUEST);

       try {
           Mailing mailing = (mailingRepo.findByTrackingNumber(trackingNumber));
           Date date = new Date();
           IntermediatePoint intermediatePoint = new IntermediatePoint();
           intermediatePoint.setDateOfArrival(date.toString());
           intermediatePoint.setIndexPostOffice(index);
           intermediatePointRepo.save(intermediatePoint);
           Mailing updateMailing = mailingRepo.findByTrackingNumber(trackingNumber);
           updateMailing.getListPostOffices().add(intermediatePoint);
           mailingRepo.save(updateMailing);
           return new ResponseEntity<>(new Message("Посылка зарегестрирована в вашем отделение"),HttpStatus.OK);
       } catch (Exception e){
           return  new ResponseEntity<>(new Message("Ошибка сохранения, пожалуйста попробуйте еще раз"),HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    public ResponseEntity<?> departureMailing(@RequestParam("trackingNumber") Integer trackingNumber, @RequestParam("index") Integer index){
        if(trackingNumber == null)
            return  new ResponseEntity<>(new Message("Не указан трек-код посылки"),HttpStatus.BAD_REQUEST);
        if(index == null)
            return  new ResponseEntity<>(new Message("Не указан индекс отделения"),HttpStatus.BAD_REQUEST);

        try {
            Mailing mailing = mailingRepo.findByTrackingNumber(trackingNumber);
            Date date = new Date();
            for (IntermediatePoint intermediatePoint: mailing.getListPostOffices()) {
                if(intermediatePoint.getIndexPostOffice().equals(index)) {
                    intermediatePoint.setDateOfDeparture(date.toString());
                    break;
                }
            }
            mailingRepo.save(mailing);
            return  new ResponseEntity<>(new Message("Отправление зарегистрировано"),HttpStatus.OK);

        } catch (Exception e){
            return  new ResponseEntity<>(new Message("Ошибка сохранения, пожалуйста попробуйте еще раз"),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<?> endMailing(@RequestParam("trackingNumber") Integer trackingNumber, @RequestParam("index") Integer index){
        if(trackingNumber == null)
            return  new ResponseEntity<>(new Message("Не указан трек-код посылки"),HttpStatus.BAD_REQUEST);
        if(index == null)
            return  new ResponseEntity<>(new Message("Не указан индекс отделения"),HttpStatus.BAD_REQUEST);
        try {
            Mailing mailing = mailingRepo.findByTrackingNumber(trackingNumber);
            mailing.setStatus(true);
            departureMailing(trackingNumber,index);
            mailingRepo.save(mailing);
            return  new ResponseEntity<>(new Message("Посылка получена"),HttpStatus.OK);

        } catch (Exception e){
            return  new ResponseEntity<>(new Message("Ошибка сохранения, пожалуйста попробуйте еще раз"),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}