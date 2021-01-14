package com.example.testjob.repos;

import com.example.testjob.model.IntermediatePoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntermediatePointRepo extends JpaRepository<IntermediatePoint,Long> {
}
