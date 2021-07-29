DELIMITER //

CREATE PROCEDURE st_create_categoria(p_categoria varchar(255))
BEGIN
DECLARE
	v_size INT DEFAULT 0;
	DECLARE v_count INT DEFAULT 1;
IF EXISTS (Select * FROM Categoria WHERE Categoria = p_categoria)
	THEN
		UPDATE Categoria SET Status = 1 WHERE Categoria = p_categoria;
ELSE
		SET v_size = (SELECT count(ID) FROM Categoria);
		WHILE v_count <= v_size
			DO
				IF EXISTS (SELECT ID FROM Categoria WHERE id = v_count)
					THEN
						SET v_count = v_count + 1;
					ELSE
						SET v_size = 0;
					END IF;
			END WHILE;
		INSERT INTO Categoria VALUES(v_count,p_categoria,1);
	END IF;

END
//