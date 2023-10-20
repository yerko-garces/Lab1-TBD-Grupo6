CREATE TABLE logs (
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
        INSERT INTO logs (idUsuario, descripcion) VALUES (1,'Nueva inserción realizada');
    ELSIF TG_OP = 'UPDATE' THEN
        INSERT INTO logs (idUsuario, descripcion) VALUES (1,'Actualización realizada');
    ELSIF TG_OP = 'DELETE' THEN
        INSERT INTO logs (idUsuario, descripcion) VALUES (1,'Eliminación realizada');
    END IF;
    
    RETURN NEW;
END;
$$ 
LANGUAGE plpgsql;

CREATE TRIGGER trigger_consulta_voluntarios
AFTER INSERT OR DELETE OR UODATE ON voluntario
FOR EACH ROW
EXECUTE FUNCTION log_voluntarios();


