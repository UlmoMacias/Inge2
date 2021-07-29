DELIMITER //

CREATE PROCEDURE st_create_region(p_region varchar(255))
BEGIN
DECLARE
	v_size INT DEFAULT 0;
	DECLARE v_count INT DEFAULT 1;
IF EXISTS (Select * FROM Region WHERE Region = p_region)
	THEN
		UPDATE REGION SET Status = 1 WHERE Region = p_region;
ELSE
		SET v_size = (SELECT count(ID) FROM Region);
		WHILE v_count <= v_size
			DO
				IF EXISTS (SELECT ID FROM Region WHERE id = v_count)
					THEN
						SET v_count = v_count + 1;
					ELSE
						SET v_size = 0;
					END IF;
			END WHILE;
		INSERT INTO Region VALUES(v_count,p_region,1);
	END IF;
END;
//