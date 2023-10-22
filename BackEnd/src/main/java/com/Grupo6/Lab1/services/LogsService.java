package com.Grupo6.Lab1.services;

import com.Grupo6.Lab1.DAO.EntradaReporteEID;
import com.Grupo6.Lab1.models.Logs;
import com.Grupo6.Lab1.models.Voluntario;
import com.Grupo6.Lab1.respositories.LogsRepository;
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

    public List<EntradaReporteEID> entregaReporteEID(){
        List<Voluntario> voluntarios = voluntarioService.getVoluntarios();

        List<EntradaReporteEID> entradasReporte = new ArrayList<EntradaReporteEID>();

        for (Voluntario voluntario : voluntarios) {
            EntradaReporteEID entradaReporteEID = new EntradaReporteEID();
            List<Integer> datos = new ArrayList<Integer>();
            Integer cantidadReportesV = logsRepository.getReportes(voluntario.getIdVoluntario());
            entradaReporteEID.setCantidadReportes(cantidadReportesV);
            entradaReporteEID.setEmail(voluntario.getEmailVoluntario());
            entradasReporte.add(entradaReporteEID);
        }

        return entradasReporte;
    }

}
