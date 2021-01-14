package com.example.testjob.repos;

import com.example.testjob.model.Mailing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailingRepo extends JpaRepository<Mailing,Long> {
    Mailing findByTrackingNumber(Integer s);
    boolean existsByTrackingNumber(Integer s);
}
