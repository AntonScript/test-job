package com.example.testjob.repo;

import com.example.testjob.model.Mailing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailingRepo extends JpaRepository<Mailing,Long> {
}
