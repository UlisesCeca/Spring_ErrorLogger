package com.example.ulises.errorloggerserver.services;

import com.example.ulises.errorloggerserver.services.entities.ErrorLog;
import com.example.ulises.errorloggerserver.services.exceptions.InsertException;
import com.example.ulises.errorloggerserver.services.repositories.ErrorLogRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ErrorLogServiceImpl implements ErrorLogService {
    @Autowired
    private ErrorLogRepository errorLogRepository;


    @Override
    public void insert(ErrorLog error) {
        try {
            this.errorLogRepository.insert(error);
        } catch (Exception e) {
            throw new InsertException();
        }
    }
}
