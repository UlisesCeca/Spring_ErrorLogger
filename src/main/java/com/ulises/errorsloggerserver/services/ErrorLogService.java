package com.ulises.errorsloggerserver.services;

import com.ulises.errorsloggerserver.services.entities.App;
import com.ulises.errorsloggerserver.services.entities.ErrorLog;

import java.util.List;

public interface ErrorLogService {
    void insert(final ErrorLog error);
    List<ErrorLog> getErrorByApp(final App app);
}
