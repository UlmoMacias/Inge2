DELIMITER //

CREATE PROCEDURE st_create_cliente(
								p_nombre varchar(255),
                                p_apellidos varchar(255),
                                p_rfc varchar(255),
                                p_correo varchar(255),
                                p_id_region integer)
BEGIN
DECLARE
	v_size INT DEFAULT 0;
	DECLARE v_count INT DEFAULT 1;
IF EXISTS (SELECT RFC FROM Cliente WHERE RFC = p_rfc)
	THEN
		SIGNAL SQLSTATE '50000' SET MESSAGE_TEXT = 'El cliente ya está registrado';
	END IF;
SET v_size = (SELECT count(ID) FROM Cliente);
WHILE v_count <= v_size
	DO
		IF EXISTS (SELECT ID FROM Cliente WHERE id = v_count)
			THEN
				SET v_count = v_count + 1;
			ELSE
				SET v_size = 0;
			END IF;
	END WHILE;
INSERT INTO Cliente VALUES(v_count,p_nombre,p_apellidos, p_rfc, p_correo,p_id_region,1);
END;
//