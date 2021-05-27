INSERT INTO pago(tipoPago, descripcion) VALUES('TARJETA','Tipo a de pago en el cual puedes usar tanto tu tarjeta de crédito como débito');
INSERT INTO pago(tipoPago, descripcion) VALUES('CONTRAREEMBOLSO','Tipo de pago que funciona pagando en mano a la empresa que entrega el paquete');

INSERT INTO perfil(nombrePerfil, descripcion) VALUES('CLIENTE','Cliente de la tienda. Solo puede realizar pedidos');
INSERT INTO	perfil(nombrePerfil, descripcion) VALUES('SECRETARIO','Secretario de la tienda. Puede dar de alta y baja productos');
INSERT INTO perfil(nombrePerfil, descripcion) VALUES('ADMINISTRADOR','Administrador de la tienda. Puede dar de alta y baja secretarios');

INSERT INTO usuario(nombre, primerApellido, segundoApellido, email, password, idPerfil, idPago) VALUES ('Usuario 1','Apellido 1', 'Apellido 1.2', 'email1','contraseña',1,1);
INSERT INTO usuario(nombre, primerApellido, segundoApellido, email, password, idPerfil, idPago) VALUES ('Usuario 2','Apellido 2', 'Apellido 2.1', 'email2','contraseña',3,2);
INSERT INTO usuario(nombre, primerApellido, segundoApellido, email, password, idPerfil, idPago) VALUES ('Usuario 3','Apellido 3', 'Apellido 3.1', 'email3','contraseña',2,2);
INSERT INTO usuario(nombre, primerApellido, segundoApellido, email, password, idPerfil, idPago) VALUES ('Usuario 4','Apellido 4', 'Apellido 4.1', 'email4','contraseña',3,1);

INSERT INTO categoria (nombreCategoria,descripcion) VALUES ('Frutas','Frutas');
INSERT INTO categoria (nombreCategoria,descripcion) VALUES ('Verduras','Verduras que no contienen químicos ni son alteradas genéticamente');
INSERT INTO categoria (nombreCategoria,descripcion) VALUES ('Huevos','Huevos de granjas ecologicamente sostenibles');
INSERT INTO categoria (nombreCategoria,descripcion) VALUES ('Cafe e infusiones','');
INSERT INTO categoria (nombreCategoria,descripcion) VALUES ('Postres','Postres realizados con productos naturales y sin conservantes');
INSERT INTO categoria (nombreCategoria,descripcion) VALUES ('Cereales','');
INSERT INTO categoria (nombreCategoria,descripcion) VALUES ('Lacteos','Productos lácteos sin aditivos ni conservantes');
INSERT INTO categoria (nombreCategoria,descripcion) VALUES ('Bebidas alcoholicas','Bebidas que contengan un porcentaje de alcohol mayor a 0');
/*fruta-2*/
INSERT INTO producto (nombre, precio, descripcion, cantidad,  foto, idCategoria) VALUES ("Plátano", 2.5, "Plátanos de Canarias de agricultura ecológica", 50, null, 2);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Manzana Golden", 2.8, "Manzana variedad GOLDEN procedente de agricultura ecológica", 90, null, 2);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Manzana Gala", 3.8, "Manzana variedad GALA procedente de agricultura ecológica", 130, null, 2);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Pera Conferéncia", 2.5, "Pera Conférencia procedente de agricultura ecológica y agricultores locales", 50, null, 2);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Fresas tarrina 250g", 4.8, "Fresas procedentes de Begonte(Lugo) de agricultura ecológica", 200, null, 2);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Aguacate Hass ", 2.5, "Aguacate Hass(Rugoso) de agricultura ecológica", 100, null, 2);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Coco (Unidad)", 1.59, "Coco procedente de Agricultura Ecológica ", 200, null, 2);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Limón", 2.15, " Limones de agricultura ecológica. Disponibilidad según temporada ", 0, null, 2);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Melocotón Amarillo", 2.5, "Melocotón de agricultura ecológica. Disponibilidad según temporada ", 50, null, 2);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Melocotón Rojo", 2.5, "Melocotón de agricultura ecológica. Disponibilidad según temporada ", 80, null, 2);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Nectarina Blanca", 3.15, "Nectarina de agricultura ecológica. Disponibilidad según temporada", 50, null, 2);

/*Verdura-3*/
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Ajo", 9.15, "Ajo morado de agricultura ecológica. Producto de cercanía",50, null, 3);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Acelga", 2.85, "Acelga de agricultura ecológica. Disponibilidad según temporada", 30, null, 3);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Alcachofa", 2.85, "Alcachofa de agricultura ecológica. Disponibilidad según temporada", 120, null, 3);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Berenjena", 3.15, "Berenjena de agricultura ecológica. Disponibilidad según temporada", 60, null, 3);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Rábano", 2.15, "Rábano de agricultura ecológica. Disponibilidad según temporada", 150, null, 3);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Brocoli", 3.55, "Brocoli de agricultura ecológica. Disponibilidad según temporada", 50, null, 3);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Calabacín", 1.95, "Calabacín de agricultura ecológica.", 150, null, 3);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Calabaza", 4.15, "Calabaza de agricultura ecológica. Disponibilidad según temporada", 0, null, 3);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Cebolla blanca", 4.00, "Cebolla blanca de agricultura ecológica.", 250, null, 3);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Cebolla morada", 3.85, "Cebolla morada ecológica. Disponibilidad según temporada", 150, null, 3);


INSERT INTO producto (nombre,precio,descripcion,cantidad,foto,idCategoria) VALUES ('Estrella Galicia',1.20,'Cerveza Estrella Galicia con 4,5% vol.',40,null,1);
INSERT INTO producto (nombre,precio,descripcion,cantidad,foto,idCategoria) VALUES ('Vino Château Cheval Blanc',999,'Vino pres',5,null,1);
INSERT INTO producto (nombre,precio,descripcion,cantidad,foto,idCategoria) VALUES ('Whisky Red Label',20,'Whisky de la marca Johnnie Walker',34,null,1);
INSERT INTO producto (nombre,precio,descripcion,cantidad,foto,idCategoria) VALUES ('Licor 43',23,'Contiene 27% vol.',20,null,1);
INSERT INTO producto (nombre,precio,descripcion,cantidad,foto,idCategoria) VALUES ('Absolut Vodka ',25,'Vodka de la marca Absolut. Contiene 35% vol.',15,null,1);
INSERT INTO producto (nombre,precio,descripcion,cantidad,foto,idCategoria) VALUES ('Ron Barcelò',14,'Ron de la marca Ron Barcelò',65,null,1);
INSERT INTO producto (nombre,precio,descripcion,cantidad,foto,idCategoria) VALUES ('Ginebra Larios',12,'Ginebra Larios sabor a fresa. Contiene 12% vol.',36,null,1);


INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ( "Café Jurado molido ecológico 250 gr.", 3.15, "El café molido ecológico Café Jurado es un café molido 100% arábica de agricultura ecológica.", 15, null, 5);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ( "Café Chiapas Bio Alternativa, 250g ", 4.64, "Cultivado por grupos campesinos en las montañas de Chiapas, sin agroquímicos, siguiendo técnicas tradicionales respetuosas con la Naturaleza", 5, null, 5);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ( "Café en Grano selección 100% Arábica Bio Destination",11.64, "Café en Grano selección 100% Arábica, mezcla de cafés arábicos orgánicos puros de América del Sur y Central cultivados en las laderas de los Andes", 20, null, 5);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ( "Café Biológico en grano Alternativa ", 5.10, "Café en grano selecto de las variedades más apreciadas de Arábica centroamericanos y robustas africanos.", 5, null, 5);

INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ( "12x Huevos ecológicos Granja Redondo", 3.85, "Producidos por gallinas que viven al aire libre con un espacio de 8 m2 por cada gallina, se alimentan con semillas ecológicas, de ahí la calidad del producto.", 20, null, 4);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ( "20x Huevos de Oro XL ecológicos Granja Redondo", 6.90, "20 huevos frescos de Gallina criada y alimentada en sistema ecológico (código 0), envasados en cartón de 20 alveolos apto para uso alimentario.", 8, null, 4);

INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ( "Pack PROMO 6 uds Leche Entera ecológica Puleva, 1 L", 8.15, "Proviene de granjas seleccionadas, donde las vacas reciben una alimentación sana y natural procedente de agricultura ecológica, sin herbicidas ni pesticidas, y gozan de libertad para pastar en prados abiertos y se cuida de su salud y bienestar.", 10, null, 8);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ( "Pack 2x Leche semidesnatada de vaca BIO Cantero de Letur 1 l", 6.71, "Pack 2x Leche semidesnatada de vaca BIO Cantero de Letur, 1 l", 15, null, 8);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ( "Leche de Cabra UHT Andechser, 1L ", 4.70, "Leche de Cabra UHT con 3,0% de Grasa.", 5, null, 8);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ( "Mantequilla Ghee Bio keto Drasanvi 300 g", 9.72, "La mantequilla ghee de Drasanvi es ecológica por lo que en su proceso de elaboración no se han utilizado sustancias químicas, consiguiendo un producto más natural y saludable.", 25, null, 8);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ( "MeGhee Bio cabra Golden Ghee 300 g", 18.80, "MeGhee es un producto ayurveda orgánico utilizado para usos culinarios y/o terapéuticos.", 15, null, 8);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ( "Ghee Mantequilla Clarificada 100% natural Vegetalia ", 8.90, "Ghe Mantequilla Clarificada 100% Natural Vegetalia. Elaborado con leche de vaca.", 12, null, 8);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ( "Queso vegano Vegancheese ahumado Grano vita 200 g", 2.88, "Delicioso 'queso vegano' de anacardo, ideal para tomar en crudo como para cocinar, con suave y cremosa textura.", 4, null, 8);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ( "Queso vegano Veggieques lonchas BIO Natursoy, 150 g", 2.72, "Ingredientes: Agua, grasa de coco*(20%), almidón de patata*, harina de ALTRAMUZ*, sal marina, espesantes: goma xantana y agar-agar*, extracto de cúrcuma*, aromas naturales.", 10, null, 8);
INSERT INTO pedido (id, precio_total, realizado, idpago, idusuario) VALUES (1, 1000, true, 1, 1);
INSERT INTO pedido_producto (id_pedido, id_producto, cantidad)VALUES (1, 1, 21);