CREATE OR REPLACE PROCEDURE generar_reporte()
AS $$ DECLARE
    TopInserciones BIGINT;
    TopUpdates BIGINT;
    TopDeletes BIGINT;
BEGIN
    -- Usuario con mas inserciones
    SELECT idUsuario INTO TopInserciones
    FROM (
        SELECT idUsuario, COUNT(*) AS tuplasInsercion
        FROM logs
        WHERE tipo = 'Insert'
        GROUP BY idUsuario
        ORDER BY tuplasInsercion DESC
        LIMIT 1
    ) AS inserciones;

    -- Usuario que hizo mas actualizaciones
    SELECT idUsuario INTO TopUpdates
    FROM (
        SELECT idUsuario, COUNT(*) AS TuplasUpadte
        FROM logs
        WHERE tipo = 'Update'
        GROUP BY idUsuario
        ORDER BY TuplasUpadte DESC
        LIMIT 1
    ) AS actualizaciones;

    -- Usuario con mas deletes
    SELECT idUsuario INTO TopDeletes
    FROM (
        SELECT idUsuario, COUNT(*) AS TuplasDelete
        FROM logs
        WHERE tipo = 'Delete'
        GROUP BY idUsuario
        ORDER BY TuplasDelete DESC
        LIMIT 1
    ) AS eliminaciones;

    -- Print informe
    RAISE NOTICE 'Usuario con más inserciones: %', TopInserciones;
    RAISE NOTICE 'Usuario con más actualizaciones: %', TopUpdates;
    RAISE NOTICE 'Usuario con más eliminaciones: %', TopDeletes;

END; $$ LANGUAGE plpgsql;
