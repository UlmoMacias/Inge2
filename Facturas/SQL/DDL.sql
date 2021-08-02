USE `inge2`;
SET SQL_SAFE_UPDATES=0;

SELECT * FROM Region;

SELECT * FROM Cliente;
DELETE FROM CLIENTE WHERE ID = 1;

SELECT * FROM Categoria;

SELECT * FROM Producto;

SELECT * FROM Articulo;

SELECT * FROM Factura;

SELECT * FROM Factura WHERE Status = 1;

Select * FROM Factura INNER JOIN Articulo where Factura.ID = id_factura;