package com.Grupo6.Lab1.services;

import com.Grupo6.Lab1.models.Logs;
import com.Grupo6.Lab1.respositories.LogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogsService {

    @Autowired
    private LogsRepository logsRepository;

    public List<Logs> entregarLogs(){return logsRepository.getAll();}
}
