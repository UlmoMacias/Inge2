DELIMITER //

CREATE PROCEDURE st_create_producto(
									p_codigo varchar(255),
                                    p_nombre varchar(255),
                                    p_descripcion varchar(255),
                                    p_cantidad integer,
                                    p_precion float4,
                                    p_fecha_creacion date,
                                    p_id_categoria integer)
BEGIN
DECLARE
	v_size INT DEFAULT 0;
	DECLARE v_count INT DEFAULT 1;
IF EXISTS (SELECT Codigo FROM Producto WHERE Codigo = p_codigo)
	THEN
		SIGNAL SQLSTATE '50000' SET MESSAGE_TEXT = 'El producto ya está registrado';
	END IF;
SET v_size = (SELECT count(ID) FROM Producto);
WHILE v_count <= v_size
	DO
		IF EXISTS (SELECT ID FROM Producto WHERE ID = v_count)
			THEN
				SET v_count = v_count + 1;
			ELSE
				SET v_size = 0;
			END IF;
	END WHILE;
INSERT INTO Producto Values(v_count,p_codigo,p_nombre,p_descripcion,p_cantidad,p_precion,p_fecha_creacion,p_id_categoria);
END;
//
