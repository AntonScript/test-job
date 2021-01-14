package com.example.testjob.repos;

import com.example.testjob.model.Mailing;
import com.example.testjob.model.PostOffice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostOfficeRepo extends JpaRepository<PostOffice,Long> {
}
