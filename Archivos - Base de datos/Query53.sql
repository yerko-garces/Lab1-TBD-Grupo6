SELECT
    Em.idEmergencia,
    Em.nombreEmergencia,
    Ta.idTarea,
    Ta.nombreTarea,
    Ha.nombreHabilidad AS habilidades
FROM
    Voluntario AS V
JOIN
    VoluntarioHabilidad AS VH ON V.idVoluntario = VH.idVoluntario
JOIN
    Habilidad Ha ON VH.idHabilidad = Ha.idHabilidad
JOIN
    EmeHabilidad Eh ON Ha.idHabilidad = Eh.idHabilidad
JOIN
    Emergencia Em ON Eh.idEmergencia = Em.idEmergencia
JOIN
    Tarea Ta ON Em.idEmergencia = Ta.idEmergencia
WHERE
    V.idVoluntario =  V.idVoluntario;