package com.application.MongoDB.repository;

import com.application.MongoDB.entity.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubjectRepository extends MongoRepository<Subject, String> {
}
