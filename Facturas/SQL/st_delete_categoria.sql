 DROP PROCEDURE IF EXISTS st_delete_categoria;

DELIMITER //

CREATE PROCEDURE st_delete_categoria(id_categoria Integer)
BEGIN

DECLARE num_cat INT DEFAULT 0;

CREATE TABLE Temp AS SELECT Producto.ID, Categoria.ID AS C_ID, Producto.Status FROM Producto 
INNER JOIN Categoria WHERE Producto.ID_Categoria = Categoria.ID AND Producto.Status = 1 AND Producto.ID_Categoria = id_Categoria;

SET num_cat = (SELECT COUNT(*) FROM Temp);

DROP TABLE Temp;

IF num_cat < 1
	THEN
		UPDATE Categoria SET Status = 0 WHERE ID = id_categoria;
ELSE
		SIGNAL SQLSTATE '50000' SET MESSAGE_TEXT = 'Hay relaciones existentes aun.';
	END IF;
END
//