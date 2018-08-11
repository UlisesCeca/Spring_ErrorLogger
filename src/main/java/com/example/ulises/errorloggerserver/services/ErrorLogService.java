package com.example.ulises.errorloggerserver.services;

import com.example.ulises.errorloggerserver.services.entities.App;
import com.example.ulises.errorloggerserver.services.entities.ErrorLog;

import java.util.List;

public interface ErrorLogService {
    void insert(final ErrorLog error);
    List<ErrorLog> getErrorByApp(final App app);
}
