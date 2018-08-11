package com.ulises.errorsloggerserver.services.repositories;

import com.ulises.errorsloggerserver.services.entities.App;
import com.ulises.errorsloggerserver.services.entities.ErrorLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ErrorLogRepository extends MongoRepository<ErrorLog, String> {
    List<ErrorLog> findByApp(App app);
}
