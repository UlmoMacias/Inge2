 DROP PROCEDURE IF EXISTS st_delete_region;
DELIMITER //

CREATE PROCEDURE st_delete_region(IN id_region Integer)
BEGIN
DECLARE num_reg INT DEFAULT 0;

CREATE TABLE Temp AS SELECT Cliente.ID, Region.ID AS R_ID, Cliente.Status FROM Cliente 
INNER JOIN Region WHERE Cliente.ID_Region = Region.ID AND Cliente.Status = 1 AND Cliente.ID_Region = id_region;

SET num_reg = (SELECT COUNT(*) FROM Temp);

-- SELECT * From Temp;

DROP TABLE Temp;



IF num_reg < 1
	THEN
		UPDATE Region SET Status = 0 WHERE ID = id_region;
ELSE
		SIGNAL SQLSTATE '50000' SET MESSAGE_TEXT = 'Hay relaciones existentes aun.';
	END IF;
END
//

-- DROP PROCEDURE st_delete_region;