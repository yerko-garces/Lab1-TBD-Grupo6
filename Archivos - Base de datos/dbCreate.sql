CREATE TABLE IF NOT EXISTS Institucion(
    idInstitucion serial NOT null,
    nombreInstitucion text,
    correoInstitucion text,
    contraseniaInstitucion text,
    PRIMARY KEY (idInstitucion)
);

CREATE TABLE IF NOT EXISTS Voluntario(
    idVoluntario serial NOT null,
    emailVoluntario text,
    rutVoluntario text,
    nombreCompletoVoluntario text,
    contraseniaVoluntario text,
    PRIMARY KEY (idVoluntario)
);

CREATE TABLE IF NOT EXISTS Habilidad(
    idHabilidad serial NOT null,
    nombreHabilidad text,
    PRIMARY KEY (idHabilidad)
);

CREATE TABLE IF NOT EXISTS Emergencia(
    idEmergencia serial NOT null,
    nombreEmergencia text,
    idInstitucion bigint,
    PRIMARY KEY (idEmergencia),
    FOREIGN KEY (idInstitucion) REFERENCES Institucion(idInstitucion)
);

CREATE TABLE IF NOT EXISTS EmeHabilidad(
    idEmehabilidad serial NOT null,
    idEmergencia bigint,
    idHabilidad bigint,
    PRIMARY KEY (idEmehabilidad),
    FOREIGN KEY (idEmergencia) REFERENCES Emergencia(idEmergencia),
    FOREIGN KEY (idHabilidad) REFERENCES Habilidad(idHabilidad)
);

CREATE TABLE IF NOT EXISTS EstadoTarea(
    idEstadoTarea serial NOT null,
    estadoTarea boolean,
    PRIMARY KEY (idEstadoTarea)
);

CREATE TABLE IF NOT EXISTS Tarea(
    idTarea serial NOT null,
    nombreTarea text,
    idEstadoTarea bigint,
    idEmergencia bigint,
    PRIMARY KEY (idTarea),
    FOREIGN KEY (idEstadoTarea) REFERENCES EstadoTarea(idEstadoTarea),
    FOREIGN KEY (idEmergencia) REFERENCES Emergencia(idEmergencia)
);

CREATE TABLE IF NOT EXISTS VoluntarioHabilidad(
    idVoluntarioHabilidad serial NOT null,
    idVoluntario bigint,
    idHabilidad bigint,
    PRIMARY KEY (idVoluntarioHabilidad),
    FOREIGN KEY (idVoluntario) REFERENCES Voluntario(idVoluntario),
    FOREIGN KEY (idHabilidad) REFERENCES Habilidad(idHabilidad)
);

CREATE TABLE IF NOT EXISTS Ranking(
    idRanking serial NOT null,
    nombreRanking text,
    idVoluntario bigint,
    idTarea bigint,
    PRIMARY KEY (idRanking),
    FOREIGN KEY (idVoluntario) REFERENCES Voluntario(idVoluntario),
    FOREIGN KEY (idTarea) REFERENCES Tarea(idTarea)
);

CREATE TABLE IF NOT EXISTS TareaHabilidad(
    idTareaHabilidad serial NOT null,
    idTarea bigint,
    idHabilidad bigint,
    PRIMARY KEY (idTareaHabilidad),
    FOREIGN KEY (idTarea) REFERENCES Tarea(idTarea),
    FOREIGN KEY (idHabilidad) REFERENCES Habilidad(idHabilidad)
)
