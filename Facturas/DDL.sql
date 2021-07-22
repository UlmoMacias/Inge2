USE `inge2`;

SELECT * FROM Region;

SELECT * FROM Cliente;

SELECT * FROM Categoria;

SELECT * FROM Producto;

SELECT * FROM Articulo;

SELECT * FROM Factura;

SELECT * FROM Factura WHERE Status = 1;

Select * FROM Factura INNER JOIN Articulo where Factura.ID = id_factura;