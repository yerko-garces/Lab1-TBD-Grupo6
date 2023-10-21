package com.Grupo6.Lab1.services;

import com.Grupo6.Lab1.models.Logs;
import com.Grupo6.Lab1.models.Voluntario;
import com.Grupo6.Lab1.respositories.LogsRepository;
import com.Grupo6.Lab1.respositories.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogsService {

    @Autowired
    private LogsRepository logsRepository;

    @Autowired
    private VoluntarioService voluntarioService;

    public List<Logs> entregarLogs(){return logsRepository.getAll();}

    public List<List<String>> entregaReporteEID(){

        List<Voluntario> voluntarios = voluntarioService.getVoluntarios();
        List<List<String>> emailYReportes = new ArrayList<List<String>>();

        for (Voluntario voluntario: voluntarios) {
            List<String> datos = new ArrayList<String>();
            List<String> cantidadReportesV = logsRepository.getReportes(voluntario.getIdVoluntario());
            datos.add(voluntario.getEmailVoluntario());
            datos.add(cantidadReportesV.get(0));

            emailYReportes.add(datos);
        }
        return emailYReportes;}

}
