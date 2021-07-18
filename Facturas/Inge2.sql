CREATE DATABASE IF NOT EXISTS `inge2`;
USE `inge2`;

CREATE TABLE `Region` (
  `ID` integer PRIMARY KEY AUTO_INCREMENT,
  `Region` varchar(255)
);

CREATE TABLE `Cliente` (
  `ID` integer PRIMARY KEY AUTO_INCREMENT,
  `Nombres` varchar(255),
  `APaterno` varchar(255),
  `AMaterno` varchar(255),
  `RFC` varchar(255),
  `correo` varchar(255),
  `ID_Region` int
);

CREATE TABLE `Factura` (
  `ID` integer PRIMARY KEY AUTO_INCREMENT,
  `FechaCreacion` date,
  `Status` tinyint,
  `ID_Cliente` integer
);

CREATE TABLE `Articulo` (
  `Codigo` varchar(255) PRIMARY KEY,
  `Cantidad` integer,
  `Impuesto` float4,
  `ID_Factura` integer
);

CREATE TABLE `Es` (
  `CodigoArt` varchar(255),
  `CodigoProd` varchar(255)
);

CREATE TABLE `Producto` (
  `Codigo` varchar(255) PRIMARY KEY,
  `Nombre` varchar(255),
  `Descripcion` varchar(255),
  `Cantidad` integer,
  `Precio` float4,
  `FechaCreacion` date,
  `ID_Categoria` int
);

CREATE TABLE `Categoria` (
  `ID` int PRIMARY KEY AUTO_INCREMENT,
  `Categoria` varchar(255)
);

ALTER TABLE `Cliente` ADD FOREIGN KEY (`ID_Region`) REFERENCES `Region` (`ID`);

ALTER TABLE `Factura` ADD FOREIGN KEY (`ID_Cliente`) REFERENCES `Cliente` (`ID`);

ALTER TABLE `Articulo` ADD FOREIGN KEY (`ID_Factura`) REFERENCES `Factura` (`ID`);

ALTER TABLE `Es` ADD FOREIGN KEY (`CodigoArt`) REFERENCES `Articulo` (`Codigo`);

ALTER TABLE `Es` ADD FOREIGN KEY (`CodigoProd`) REFERENCES `Producto` (`Codigo`);

ALTER TABLE `Producto` ADD FOREIGN KEY (`ID_Categoria`) REFERENCES `Categoria` (`ID`);

-- DROP DATABASE `inge2`;