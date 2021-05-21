DROP DATABASE IF EXISTS Ecommerce;
CREATE DATABASE Ecommerce;

USE Ecommerce;

CREATE TABLE Perfil(
    idPerfil TINYINT AUTO_INCREMENT,
    nombrePerfil VARCHAR(13) CHECK 
        (nombrePerfil IN ('CLIENTE','SECRETARIO','ADMINISTRADOR')),
    descripcion VARCHAR(300) NOT NULL,
    PRIMARY KEY (idPerfil)
);

CREATE TABLE Pago(
    idPago TINYINT AUTO_INCREMENT,
    tipoPago VARCHAR(15) CHECK 
        (tipoPago IN ('TARJETA','CONTRAREEMBOLSO')),
    descripcion VARCHAR(300) NOT NULL,
    PRIMARY KEY (idPago)
);

CREATE TABLE Usuario(
    idUsuario INT AUTO_INCREMENT,
    nombre VARCHAR(20) NOT NULL,
    primerApellido VARCHAR(20) NOT NULL,
    segundoApellido VARCHAR(20) NOT NULL,
    email VARCHAR(300) NOT NULL UNIQUE,
    contraseña VARCHAR(150) NOT NULL,
    idPerfil TINYINT NOT NULL,
    idPago TINYINT,
    PRIMARY KEY (idUsuario)
);

CREATE TABLE Pedido(
    idPedido INT AUTO_INCREMENT,
    precioTotal DECIMAL(7,2) NOT NULL,
    realizado BOOL DEFAULT 0 NOT NULL,
    idUsuario INT,
    idPago TINYINT,
    PRIMARY KEY (idPedido)
);

CREATE TABLE Categoria(
    idCategoria TINYINT AUTO_INCREMENT,
    nombreCategoria VARCHAR(19) CHECK
        (tipoCategoria IN ('BEBIDAS ALCOHÓLICAS', 'FRUTAS', 'VERDURAS', 
        'HUEVOS Y LÁCTEOS', 'CAFÉ E INFUSIONES', 'POSTRES Y CEREALES')),
    descripcion VARCHAR(300) NOT NULL,
    PRIMARY KEY (idCategoria)
);

CREATE TABLE Producto(
    idProducto INT AUTO_INCREMENT,
    nombre VARCHAR(60) NOT NULL,
    precio DECIMAL(5,2) NOT NULL,
    descripcion VARCHAR(500) NOT NULL,
    cantidad SMALLINT(4) NOT NULL,
    foto VARCHAR(200),
    idCategoria TINYINT NOT NULL,
    PRIMARY KEY (idProducto)
);



CREATE TABLE Pedido_Producto(
    idPedido INT AUTO_INCREMENT,
    idProducto INT,
    cantidad INT(4),
    PRIMARY KEY (idPedido, idProducto)
);

/*CLAVES FORÁNEAS*/

ALTER TABLE Pedido_Producto ADD(
    CONSTRAINT FK_Pedido__Pedido_Producto
        FOREIGN KEY (idPedido) REFERENCES Pedido(idPedido),
    CONSTRAINT FK_Producto__Pedido_Producto
        FOREIGN KEY (idProducto) REFERENCES Producto(idProducto)
);

ALTER TABLE Producto ADD(
    CONSTRAINT FK_Categoria_Producto
        FOREIGN KEY (idCategoria) REFERENCES Categoria(idCategoria)
);

ALTER TABLE Pedido ADD(
    CONSTRAINT FK_Usuario_Pedido
        FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario),
    CONSTRAINT FK_Pago_Pedido
        FOREIGN KEY (idPago) REFERENCES Pago(idPago)
);

ALTER TABLE Usuario ADD(
    CONSTRAINT FK_Perfil_Usuario
        FOREIGN KEY (idPerfil) REFERENCES Perfil(idPerfil),
    CONSTRAINT FK_Pago_Usuario
        FOREIGN KEY (idPago) REFERENCES Pago(idPago)
);