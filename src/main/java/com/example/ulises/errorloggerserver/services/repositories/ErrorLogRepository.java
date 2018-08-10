package com.example.ulises.errorloggerserver.services.repositories;

import com.example.ulises.errorloggerserver.services.entities.App;
import com.example.ulises.errorloggerserver.services.entities.ErrorLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ErrorLogRepository extends MongoRepository<ErrorLog, String> {
    List<ErrorLog> findByApp(App app);
}
