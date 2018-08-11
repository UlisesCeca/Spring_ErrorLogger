package com.ulises.errorsloggerserver.services;

import com.ulises.errorsloggerserver.services.entities.App;
import com.ulises.errorsloggerserver.services.entities.ErrorLog;
import com.ulises.errorsloggerserver.services.exceptions.NoErrorsFoundsForAppException;
import com.ulises.errorsloggerserver.services.repositories.ErrorLogRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ErrorLogServiceImpl implements ErrorLogService {
    @Autowired
    private ErrorLogRepository errorLogRepository;


    @Override
    public void insert(final ErrorLog error) {
        this.errorLogRepository.insert(error);
    }

    @Override
    public List<ErrorLog> getErrorByApp(final App app) {
        List<ErrorLog> errorLogs = this.errorLogRepository.findByApp(app);
        if(errorLogs.size() == 0)
            throw new NoErrorsFoundsForAppException();
        else
            return this.errorLogRepository.findByApp(app);
    }
}
