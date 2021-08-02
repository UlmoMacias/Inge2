DELIMITER //

CREATE PROCEDURE st_delete_categoria(id_categoria Integer)
BEGIN
DECLARE num_categorias INT DEFAULT 0;
SET num_categorias = (SELECT count(ID_Categoria) FROM Producto WHERE ID_Categoria = id_categoria);
IF (num_categorias < 1)
	THEN
		UPDATE Categoria SET Status = 0 WHERE ID = id_categoria;
ELSE
		SIGNAL SQLSTATE '50000' SET MESSAGE_TEXT = 'Hay relaciones existentes aun.';
	END IF;
END
//