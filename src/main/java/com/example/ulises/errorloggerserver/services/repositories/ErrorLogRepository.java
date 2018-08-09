package com.example.ulises.errorloggerserver.services.repositories;

import com.example.ulises.errorloggerserver.services.entities.ErrorLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorLogRepository extends MongoRepository<ErrorLog, String> {}
