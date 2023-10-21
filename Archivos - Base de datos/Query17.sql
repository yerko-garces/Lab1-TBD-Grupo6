SELECT v.idvoluntario,count(v.idvoluntario)
FROM voluntario AS v 
INNER JOIN logs AS l
ON l.idusuario = v.idvoluntario
group by v.idvoluntario