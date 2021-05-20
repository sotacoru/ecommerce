INSERT INTO ecommerce.pago(tipoPago, descripcion) VALUES('TARJETA','Tipo de pago en el cual puedes usar tanto tu tarjeta de crédito como débito');
INSERT INTO ecommerce.pago(tipoPago, descripcion) VALUES('CONTRAREEMBOLSO','Tipo de pago que funciona pagando en mano a la empresa que entrega el paquete');

INSERT INTO ecommerce.perfil(nombrePerfil, descripcion) VALUES('CLIENTE','Cliente de la tienda. Solo puede realizar pedidos');
INSERT INTO ecommerce.perfil(nombrePerfil, descripcion) VALUES('SECRETARIO','Secretario de la tienda. Puede dar de alta y baja productos');
INSERT INTO ecommerce.perfil(nombrePerfil, descripcion) VALUES('ADMINISTRADOR','Administrador de la tienda. Puede dar de alta y baja secretarios');

INSERT INTO ecommerce.usuario(nombre, primerApellido, segundoApellido, email, contraseña, idPerfil, idPago) VALUES ('Usuario 1','Apellido 1', 'Apellido 1.2', 'email1','contraseña',1,1);
INSERT INTO ecommerce.usuario(nombre, primerApellido, segundoApellido, email, contraseña, idPerfil, idPago) VALUES ('Usuario 2','Apellido 2', 'Apellido 2.1', 'email2','contraseña',3,2);
INSERT INTO ecommerce.usuario(nombre, primerApellido, segundoApellido, email, contraseña, idPerfil, idPago) VALUES ('Usuario 3','Apellido 3', 'Apellido 3.1', 'email3','contraseña',2,2);
INSERT INTO ecommerce.usuario(nombre, primerApellido, segundoApellido, email, contraseña, idPerfil, idPago) VALUES ('Usuario 4','Apellido 4', 'Apellido 4.1', 'email4','contraseña',3,1);