-- tabla de logs

CREATE TABLE IF NOT EXISTS logs (
    id SERIAL PRIMARY KEY,
    idUsuario BIGINT,
    descripcion TEXT,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
);


--funcion para tabla voluntarios

CREATE OR REPLACE FUNCTION log_voluntarios()
RETURNS TRIGGER AS 
$$
BEGIN
    IF TG_OP = 'INSERT' THEN
        INSERT INTO logs (idUsuario, descripcion) VALUES (NEW.idvoluntario,'Nueva inserción realizada');
    ELSIF TG_OP = 'UPDATE' THEN
        INSERT INTO logs (idUsuario, descripcion) VALUES (NEW.idvoluntario,'Actualización realizada');
    ELSIF TG_OP = 'DELETE' THEN
        INSERT INTO logs (idUsuario, descripcion) VALUES (OLD.idvoluntario,'Eliminación realizada');
    END IF;
    
    RETURN NEW;
END;
$$ 
LANGUAGE plpgsql;

--trigger

DROP TRIGGER IF EXISTS trigger_consulta_voluntarios ON voluntario;

CREATE TRIGGER trigger_consulta_voluntarios
AFTER INSERT OR DELETE OR UPDATE ON voluntario
FOR EACH ROW
EXECUTE FUNCTION log_voluntarios();



-- funcion para voluntarioHabilidad
CREATE OR REPLACE FUNCTION log_voluntarioHabilidad()
RETURNS TRIGGER AS 
$$
BEGIN
    IF TG_OP = 'INSERT' THEN
        INSERT INTO logs (idUsuario, descripcion) VALUES (NEW.idvoluntario,'El usuario insert una habilidad');
    ELSIF TG_OP = 'UPDATE' THEN
        INSERT INTO logs (idUsuario, descripcion) VALUES (NEW.idvoluntario,'El usuario actualizo una habilidad');
    ELSIF TG_OP = 'DELETE' THEN
        INSERT INTO logs (idUsuario, descripcion) VALUES (OLD.idvoluntario,'El usuario elimino una habilidad');
    END IF;
    
    RETURN NEW;
END;
$$ 
LANGUAGE plpgsql;

--trigger

DROP TRIGGER IF EXISTS trigger_voluntarioHabilidad ON voluntarioHabilidad;

CREATE TRIGGER trigger_voluntarioHabilidad
AFTER INSERT OR DELETE OR UPDATE ON voluntarioHabilidad
FOR EACH ROW
EXECUTE FUNCTION log_voluntarioHabilidad();

-- funcion para Emergencias
CREATE OR REPLACE FUNCTION log_emergencia()
RETURNS TRIGGER AS 
$$
BEGIN
    IF TG_OP = 'INSERT' THEN
        INSERT INTO logs (idUsuario, descripcion) VALUES (NEW.idinstitucion,'la institucion ha creado una emergencia');
    ELSIF TG_OP = 'UPDATE' THEN
        INSERT INTO logs (idUsuario, descripcion) VALUES (NEW.idinstitucion,'la institucion ha actualizado una emergencia');
    ELSIF TG_OP = 'DELETE' THEN
        INSERT INTO logs (idUsuario, descripcion) VALUES (OLD.idinstitucion,'la institucion ha eliminado una emergencia');
    END IF;
    
    RETURN NEW;
END;
$$ 
LANGUAGE plpgsql;

--trigger

DROP TRIGGER IF EXISTS trigger_emergencia ON emergencia;

CREATE TRIGGER trigger_emergencia
AFTER INSERT OR DELETE OR UPDATE ON emergencia
FOR EACH ROW
EXECUTE FUNCTION log_emergencia();

-- funcion para Instituciones
CREATE OR REPLACE FUNCTION log_institucion()
RETURNS TRIGGER AS 
$$
BEGIN
    IF TG_OP = 'INSERT' THEN
        INSERT INTO logs (idUsuario, descripcion) VALUES (NEW.idinstitucion,'Se ha creado la institucion');
    ELSIF TG_OP = 'UPDATE' THEN
        INSERT INTO logs (idUsuario, descripcion) VALUES (NEW.idinstitucion,'Se ha actualizado la institucion');
    ELSIF TG_OP = 'DELETE' THEN
        INSERT INTO logs (idUsuario, descripcion) VALUES (OLD.idinstitucion,'Se ha eliminado la institucion');
    END IF;
    
    RETURN NEW;
END;
$$ 
LANGUAGE plpgsql;

--trigger

DROP TRIGGER IF EXISTS trigger_institucion ON institucion;

CREATE TRIGGER trigger_institucion
AFTER INSERT OR DELETE OR UPDATE ON institucion
FOR EACH ROW
EXECUTE FUNCTION log_institucion();