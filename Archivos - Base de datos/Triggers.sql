CREATE TABLE logs (
    id SERIAL PRIMARY KEY,
    usuario_id BIGINT,
    descripcion TEXT,
    timestamp TIMESTAMP
);

CREATE FUNCTION log_insert_voluntario()
RETURNS TRIGGER AS 
$$
BEGIN
    INSERT INTO logs(usuario, descripcion, timestamp)
    VALUES (NEW.id, 'insert en tabla voluntario', NOW());
    RETURN NEW;
END;
$$ 
LANGUAGE plpgsql;

CREATE TRIGGER insertVoluntario
BEFORE INSERT ON Voluntario
FOR EACH ROW EXECUTE FUNCTION log_insert_voluntario();

