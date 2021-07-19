USE `inge2`;

INSERT INTO Region VALUES(1,"Oaxaca");
INSERT INTO Region VALUES(2,"Veracruz");

INSERT INTO Cliente VALUES(1,"Jonatan","Castro Mejia","JCM","@Joni",1);
CALL st_create_cliente("LUIS", "ANGEL", "ACM", "@Howke",2);


INSERT INTO Categoria VALUES(1,"Farmacia");
INSERT INTO Categoria VALUES(2,"Tiendita");

INSERT INTO Producto VALUES(1,"0000000000000","Producto de prueba","Producto Prueba",10,10,CURRENT_DATE(),1);