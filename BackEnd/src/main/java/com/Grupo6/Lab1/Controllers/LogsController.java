package com.Grupo6.Lab1.Controllers;

import com.Grupo6.Lab1.models.Logs;
import com.Grupo6.Lab1.services.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LogsController {

    @Autowired
    private LogsService logsService;

    @GetMapping("/verLogs")
    public List<Logs> mostrarLogs(){return logsService.entregarLogs();}

    @GetMapping("/calcularLogs")
    public List<List<String>> calcularLogs(){
        List<List<String>> datos = logsService.entregaReporteEID();
        return datos;
    }
}
