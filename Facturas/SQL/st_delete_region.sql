DELIMITER //

CREATE PROCEDURE st_delete_region(id_region Integer)
BEGIN

DECLARE num_regions INT DEFAULT 0;
DECLARE Num INT DEFAULT 0;

SET num_regions = (SELECT count(ID_Region = Num) FROM Cliente);


IF (SELECT count(ID_Region) FROM Cliente WHERE ID_Region = Num) < 1
	THEN
		UPDATE Region SET Status = 0 WHERE ID = id_region;
ELSE
		SIGNAL SQLSTATE '50000' SET MESSAGE_TEXT = 'Hay relaciones existentes aun.';
	END IF;
END
//

-- DROP PROCEDURE st_delete_region;