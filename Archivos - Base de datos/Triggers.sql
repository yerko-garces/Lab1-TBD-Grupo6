CREATE TABLE IF NOT EXISTS logs (
    id SERIAL PRIMARY KEY,
    idUsuario BIGINT,
    descripcion TEXT,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
);

CREATE OR REPLACE FUNCTION log_voluntarios()
RETURNS TRIGGER AS 
$$
BEGIN
    IF TG_OP = 'INSERT' THEN
<<<<<<< Updated upstream
        INSERT INTO logs (idUsuario, descripcion) VALUES (1,'Nueva inserción realizada');
=======
        INSERT INTO logs (idUsuario, descripcion) VALUES (NEW.idvoluntario,'Nueva inserción realizada');
>>>>>>> Stashed changes
    ELSIF TG_OP = 'UPDATE' THEN
        INSERT INTO logs (idUsuario, descripcion) VALUES (NEW.idvoluntario,'Actualización realizada');
    ELSIF TG_OP = 'DELETE' THEN
<<<<<<< Updated upstream
        INSERT INTO logs (idUsuario, descripcion) VALUES (1,'Eliminación realizada');
=======
        INSERT INTO logs (idUsuario, descripcion) VALUES (OLD.idvoluntario,'Eliminación realizada');
>>>>>>> Stashed changes
    END IF;
    
    RETURN NEW;
END;
$$ 
LANGUAGE plpgsql;

-- Elimina el trigger si existe
DROP TRIGGER IF EXISTS trigger_consulta_voluntarios ON voluntario;

-- Crea el nuevo trigger
CREATE TRIGGER trigger_consulta_voluntarios
AFTER INSERT OR DELETE OR UPDATE ON voluntario
FOR EACH ROW
EXECUTE FUNCTION log_voluntarios();



