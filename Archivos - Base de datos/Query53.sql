-- Seleccion solo de los datos relevantes para la funcionalidad en front
SELECT Em.idEmergencia, Em.nombreEmergencia
FROM voluntario AS Vo INNER JOIN voluntariohabilidad 
AS VH ON Vo.idvoluntario = VH.idvoluntario
INNER JOIN habilidad AS Ha ON Ha.idhabilidad = VH.idhabilidad
INNER JOIN emehabilidad AS EH ON EH.idhabilidad = Ha.idhabilidad
INNER JOIN emergencia AS Em ON Em.idemergencia = EH.idemergencia
WHERE Vo.idvoluntario = -- VOLUNTARIO A BUSCAR --;
