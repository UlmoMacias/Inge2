CREATE DATABASE IF NOT EXISTS `inge2`;
USE `inge2`;

CREATE TABLE `Region` (
  `ID` integer PRIMARY KEY AUTO_INCREMENT,
  `Region` varchar(255)
);

CREATE TABLE `Cliente` (
  `ID` integer,
  `Nombres` varchar(255),
  `Apellidos` varchar(255),
  `RFC` varchar(255) PRIMARY KEY,
  `correo` varchar(255),
  `ID_Region` int
);

CREATE TABLE `Factura` (
  `ID` integer PRIMARY KEY AUTO_INCREMENT,
  `FechaCreacion` date,
  `Status` tinyint,
  `RFC_Cliente` varchar(255)
);

CREATE TABLE `Articulo` (
  `ID` integer,
  `Codigo` varchar(13) PRIMARY KEY,
  `Cantidad` integer,
  `Impuesto` float4,
  `ID_Factura` integer
);

CREATE TABLE `Producto` (
  `ID` integer,
  `Codigo` varchar(255) PRIMARY KEY,
  `Nombre` varchar(255),
  `Descripcion` varchar(255),
  `Cantidad` integer,
  `Precio` float4,
  `fecha_creacion` date,
  `ID_Categoria` int
);

CREATE TABLE `Categoria` (
  `ID` int PRIMARY KEY AUTO_INCREMENT,
  `Categoria` varchar(255)
);

ALTER TABLE `Cliente` ADD FOREIGN KEY (`ID_Region`) REFERENCES `Region` (`ID`);

ALTER TABLE `Factura` ADD FOREIGN KEY (`RFC_Cliente`) REFERENCES `Cliente` (`RFC`);

ALTER TABLE `Articulo` ADD FOREIGN KEY (`ID_Factura`) REFERENCES `Factura` (`ID`);

ALTER TABLE `Producto` ADD FOREIGN KEY (`ID_Categoria`) REFERENCES `Categoria` (`ID`);


-- DROP DATABASE `inge2`;