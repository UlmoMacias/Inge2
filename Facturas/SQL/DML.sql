USE `inge2`;

CALL st_create_region("Oaxaca");
INSERT INTO Region VALUES(2,"Veracruz",1);
CALL st_delete_region(1);


INSERT INTO Cliente VALUES(1,"Jonatan","Castro Mejia","JCM","@Joni",1,1);
CALL st_create_cliente("LUIS", "ANGEL", "ACM", "@Howke",1);
CALL st_create_cliente("LUIS", "ANGEL", "ACMA", "@Howke",1);

CALL st_create_categoria("Farmacia");
INSERT INTO Categoria VALUES(2,"Tiendita",1);
CALL st_delete_categoria(1);


CALL st_create_producto("0000000000000","Producto de prueba","Producto Prueba",10,10,CURRENT_DATE(),1);


INSERT INTO Factura VALUES(1,CURRENT_DATE(),1,"JCM");

CALL st_create_articulo("0000000000000",10,.5,1,1);
INSERT INTO Articulo VALUES(1,"0000000000000",10,.5,1);

