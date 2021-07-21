DELIMITER //
CREATE PROCEDURE st_create_articulo(
									p_codigo varchar(255),
                                    p_cantidad INTEGER,
                                    p_impuesto float4,
                                    p_id_factura integer)
BEGIN 
DECLARE
	v_size INT DEFAULT 0;
	DECLARE v_count INT DEFAULT 1;
IF EXISTS (SELECT Codigo FROM Articulo WHERE Codigo = p_codigo)
	THEN
		SIGNAL SQLSTATE '50000' SET MESSAGE_TEXT = 'El Articulo ya está registrado';
	END IF;
SET v_size = (SELECT count(ID) FROM Articulo);
WHILE v_count <= v_size
	DO
		IF EXISTS (SELECT ID FROM Articulo WHERE ID = v_count)
			THEN
				SET v_count = v_count + 1;
			ELSE
				SET v_size = 0;
			END IF;
	END WHILE;
INSERT INTO Articulo Values(v_count,p_codigo,p_cantidad,p_impuesto,p_id_factura); 
END;
//
