INSERT INTO pago(tipoPago, descripcion) VALUES('TARJETA','Tipo a de pago en el cual puedes usar tanto tu tarjeta de crédito como débito');
INSERT INTO pago(tipoPago, descripcion) VALUES('CONTRAREEMBOLSO','Tipo de pago que funciona pagando en mano a la empresa que entrega el paquete');

INSERT INTO perfil(nombrePerfil, descripcion) VALUES('CLIENTE','Cliente de la tienda. Solo puede realizar pedidos');
INSERT INTO	perfil(nombrePerfil, descripcion) VALUES('SECRETARIO','Secretario de la tienda. Puede dar de alta y baja productos');
INSERT INTO perfil(nombrePerfil, descripcion) VALUES('ADMINISTRADOR','Administrador de la tienda. Puede dar de alta y baja secretarios');

INSERT INTO usuario(nombre, primerApellido, segundoApellido, email, password, idPerfil, intentos, bloqueada) VALUES ('Usuario 1','Apellido 1', 'Apellido 1.2', 'email1@gmail.com','$2a$10$ZccuI.q6yBmUgywHZuvXje12j1PjIxo8ImWIWlfuGeVfm6jJWIEqa',1, 3,false);
INSERT INTO usuario(nombre, primerApellido, segundoApellido, email, password, idPerfil, intentos, bloqueada) VALUES ('Usuario 2','Apellido 2', 'Apellido 2.1', 'email2@yahoo.es','$2a$10$ZccuI.q6yBmUgywHZuvXje12j1PjIxo8ImWIWlfuGeVfm6jJWIEqa',3, 3,false);
INSERT INTO usuario(nombre, primerApellido, segundoApellido, email, password, idPerfil, intentos, bloqueada) VALUES ('Usuario 3','Apellido 3', 'Apellido 3.1', 'email3@yahoo.es','$2a$10$ZccuI.q6yBmUgywHZuvXje12j1PjIxo8ImWIWlfuGeVfm6jJWIEqa',2, 3,false);
INSERT INTO usuario(nombre, primerApellido, segundoApellido, email, password, idPerfil, intentos, bloqueada) VALUES ('Usuario 4','Apellido 4', 'Apellido 4.1', 'email4@gmail.com','$2a$10$ZccuI.q6yBmUgywHZuvXje12j1PjIxo8ImWIWlfuGeVfm6jJWIEqa',3, 3, false);

INSERT INTO categoria (nombreCategoria,descripcion) VALUES ('Frutas','Frutas');
INSERT INTO categoria (nombreCategoria,descripcion) VALUES ('Verduras','Verduras que no contienen químicos ni son alteradas genéticamente');
INSERT INTO categoria (nombreCategoria,descripcion) VALUES ('Huevos','Huevos de granjas ecologicamente sostenibles');
INSERT INTO categoria (nombreCategoria,descripcion) VALUES ('Cafe e infusiones','');
INSERT INTO categoria (nombreCategoria,descripcion) VALUES ('Postres','Postres realizados con productos naturales y sin conservantes');
INSERT INTO categoria (nombreCategoria,descripcion) VALUES ('Cereales','');
INSERT INTO categoria (nombreCategoria,descripcion) VALUES ('Lacteos','Productos lácteos sin aditivos ni conservantes');
INSERT INTO categoria (nombreCategoria,descripcion) VALUES ('Bebidas alcoholicas','Bebidas que contengan un porcentaje de alcohol mayor a 0');
/*fruta-2*/
INSERT INTO producto (nombre, precio, descripcion, cantidad,  foto, idCategoria) VALUES ("Plátano", 2.5, "Plátanos de Canarias de agricultura ecológica", 0, "38617683-0195-4299-a9f6-67a336128540_platano-frutas-600x600.jpg", 1);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Manzana Golden", 2.8, "Manzana variedad GOLDEN procedente de agricultura ecológica", 90, "38af5f51-274d-4660-8753-14addca73f8d_manzana-golden-ecologica-600x600.jpg", 1);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Manzana Gala", 3.8, "Manzana variedad GALA procedente de agricultura ecológica", 130, "c68e1c73-32a4-4917-97ab-d819e0551047_1111616.jpg", 1);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Pera Conferéncia", 2.5, "Pera Conferencia procedente de agricultura ecológica y agricultores locales", 50, "63bc1cba-d3fc-40b2-a99b-074dc51d7878_Pera-conferencia.jpg ", 1);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Fresas tarrina 250g", 4.8, "Fresas procedentes de Begonte(Lugo) de agricultura ecológica", 200, "ee4b9a4b-36e2-41eb-aa0e-9e549b808855_fresa-tarrina.jpg ", 1);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Aguacate Hass ", 2.5, "Aguacate Hass(Rugoso) de agricultura ecológica", 100, "7241bd92-e2d9-4f7c-97e5-9dfd4605f301_aguacate-web.jpg ", 1);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Coco (Unidad)", 1.59, "Coco procedente de Agricultura Ecológica ", 200, "0473a979-d0a8-4e00-8a8f-f3caf39fd1f3_producto-385-1201.jpg", 1);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Limón", 2.15, "Limones de agricultura ecológica. Disponibilidad según temporada ", 0, null, 1);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Melocotón Amarillo", 2.5, "Melocotón de agricultura ecológica. Disponibilidad según temporada ", 50, "fe780d61-d71d-4ffb-968b-12a6d5c56acc_melocoton-amarillo-600x600-1.jpg ", 1);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Melocotón Rojo", 2.5, "Melocotón de agricultura ecológica. Disponibilidad según temporada ", 80, "4bbb7250-2898-4f1f-aed4-c115f1d7bacf_melocoton-rojo-ecologico-600x600.jpg", 1);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Nectarina Blanca", 3.15, "Nectarina de agricultura ecológica. Disponibilidad según temporada", 50, "33e761ba-8aa2-4355-bfa5-2604c85c9fc1_nectarina-ecologica-600x600.jpg ", 1);

/*Verdura-3*/
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Ajo", 9.15, "Ajo morado de agricultura ecológica. Producto de cercanía",50, "d680ccad-a077-4114-b082-77b7335edcc6_ajo-ecologico-600x600.jpg ", 2);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Acelga", 2.85, "Acelga de agricultura ecológica. Disponibilidad según temporada", 30, "985f322d-4ff7-4b2f-ac15-fc9efcd70b8a_acelg_ama_lyon.jpg ", 2);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Alcachofa", 2.85, "Alcachofa de agricultura ecológica. Disponibilidad según temporada", 120, "d5d1f4e4-27ab-4a49-afc3-1b01b4990245_Alcachofa-Ex-1.png ", 2);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Berenjena", 3.15, "Berenjena de agricultura ecológica. Disponibilidad según temporada", 60, "7aa95b16-efc5-44bf-a416-53dc46958a5c_berenjena-ecologica-600x600.jpg ", 2);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Rábano", 2.15, "Rábano de agricultura ecológica. Disponibilidad según temporada", 150, "b11fd500-1c80-4c3e-80a3-5780ec8ef1df_Cómo-plantar-rábanos.-Ficha-completa.jpg ", 2);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Brocoli", 3.55, "Brocoli de agricultura ecológica. Disponibilidad según temporada", 50, "04f194bc-c5f5-44ba-ab05-761b9f7dc3a4_brocoli-600x600.jpg ", 2);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Calabacín", 1.95, "Calabacín de agricultura ecológica.", 150, "f0079c95-a8a2-4ae7-8178-69622109079a_calabacín-600x600.jpg", 2);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Calabaza", 4.15, "Calabaza de agricultura ecológica. Disponibilidad según temporada", 0, null, 2);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Cebolla blanca", 4.00, "Cebolla blanca de agricultura ecológica.", 250, "564a87ae-a7c0-4468-b2de-3851f1526f90_Cebolla-Blanca-2-0008861.jpeg ", 3);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ("Cebolla morada", 3.85, "Cebolla morada ecológica. Disponibilidad según temporada", 150, "d2bf1252-58f4-4a99-8711-f771f704c0bc_Planta-de-Cebolla-Morada-amposta-600x600.jpg ", 2);


INSERT INTO producto (nombre,precio,descripcion,cantidad,foto,idCategoria) VALUES ('Estrella Galicia',1.20,'Cerveza Estrella Galicia con 4,5% vol.',40,"7eafeac5-4a52-4ed1-a8fc-72ba0720127f_cerveza-estrella-galicia-botella-600x600.jpg ",8);
INSERT INTO producto (nombre,precio,descripcion,cantidad,foto,idCategoria) VALUES ('Vino Château Cheval Blanc',999,'Vino pres',5,"5fcbc673-9c3f-4786-a924-f429caeaa1aa_chateau-cheval-blanc-2013.jpg ",8);
INSERT INTO producto (nombre,precio,descripcion,cantidad,foto,idCategoria) VALUES ('Whisky Red Label',20,'Whisky de la marca Johnnie Walker',34,"d9ad3a78-73a0-419f-ae46-9cb5d6bf0417_00118721001784____1__600x600.jpg ",8);
INSERT INTO producto (nombre,precio,descripcion,cantidad,foto,idCategoria) VALUES ('Licor 43',23,'Contiene 27% vol.',20,"c9e4b609-8b98-4762-b3a5-55b0a07c5632_00118723600674____2__600x600.jpg ",8);
INSERT INTO producto (nombre,precio,descripcion,cantidad,foto,idCategoria) VALUES ('Absolut Vodka ',25,'Vodka de la marca Absolut. Contiene 35% vol.',15,"e90ca13a-9085-42bd-b7aa-66131a00bc44_absolut-vodka-434778-600x600.jpg ",8);
INSERT INTO producto (nombre,precio,descripcion,cantidad,foto,idCategoria) VALUES ('Ron Barcelò',14,'Ron de la marca Ron Barcelò',65,"55d1c307-be26-488c-8cf7-1f597c4a8435_00118733300299____8__600x600.jpg ",8);
INSERT INTO producto (nombre,precio,descripcion,cantidad,foto,idCategoria) VALUES ('Ginebra Larios',12,'Ginebra Larios sabor a fresa. Contiene 12% vol.',36,"d60fa77f-fed2-4a2b-bb1a-3bbd81ca72d3_unnamed.jpg ",8);


INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ( "Café Jurado molido ecológico 250 gr.", 3.15, "El café molido ecológico Café Jurado es un café molido 100% arábica de agricultura ecológica.", 15, "e25b422c-a74a-48a4-b21d-be5b9080e5b3_cafe-ecologico-250-g-jurado-000739.jpg ", 4);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ( "Café Chiapas Bio Alternativa, 250g ", 4.64, "Cultivado por grupos campesinos en las montañas de Chiapas, sin agroquímicos, siguiendo técnicas tradicionales respetuosas con la Naturaleza", 5, "a786a828-0072-4610-9f11-bf866ca0da41_cafe-chiapas-molido-bio-250-g-alternativa-3-600x600.jpg ", 4);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ( "Café en Grano selección 100% Arábica Bio Destination",11.64, "Café en Grano selección 100% Arábica, mezcla de cafés arábicos orgánicos puros de América del Sur y Central cultivados en las laderas de los Andes", 20, "0b752f8b-1fa0-46a4-bd62-806f45e9f8ac_98004_1.jpg ", 4);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ( "Café Biológico en grano Alternativa ", 5.10, "Café en grano selecto de las variedades más apreciadas de Arábica centroamericanos y robustas africanos.", 5, "1b135f2c-e7e5-485b-9aa8-e48f52a38df3_001009_1_4.jpg ", 4);

INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ( "12x Huevos ecológicos Granja Redondo", 3.85, "Producidos por gallinas que viven al aire libre con un espacio de 8 m2 por cada gallina, se alimentan con semillas ecológicas, de ahí la calidad del producto.", 20, "13efa5b9-bc13-4102-8cc5-e14c4faba933_huevos-ecologicos.jpg ", 4);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ( "20x Huevos de Oro XL ecológicos Granja Redondo", 6.90, "20 huevos frescos de Gallina criada y alimentada en sistema ecológico (código 0), envasados en cartón de 20 alveolos apto para uso alimentario.", 8, "1f7d14b6-bd2c-4751-bd1f-0beb33b44980_122348_1_1400.png ", 3);

INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ( "Pack PROMO 6 uds Leche Entera ecológica Puleva, 1 L", 8.15, "Proviene de granjas seleccionadas, donde las vacas reciben una alimentación sana y natural procedente de agricultura ecológica, sin herbicidas ni pesticidas, y gozan de libertad para pastar en prados abiertos y se cuida de su salud y bienestar.", 10, "d3bd9aa5-8f97-428b-a578-6b777911a0e5_puleva-leche-entera-con-calcio-1-l-pack-6-unidades.jpg ", 4);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ( "Pack 2x Leche semidesnatada de vaca BIO Cantero de Letur 1 l", 6.71, "Pack 2x Leche semidesnatada de vaca BIO Cantero de Letur, 1 l", 15, "6aea946d-1d1b-4bbf-bde8-ab41d8df5e7d_leche-de-vaca-semidesnatada-bio-1-l-el-cantero-de-letur.jpg ", 7);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ( "Leche de Cabra UHT Andechser, 1L ", 4.70, "Leche de Cabra UHT con 3,0% de Grasa.", 5, "eee96903-f3ce-46b4-af61-5f942f6bdea0_ce3baf15591b81029fdd6a3f92b9915b.jpg ", 7);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ( "Mantequilla Ghee Bio keto Drasanvi 300 g", 9.72, "La mantequilla ghee de Drasanvi es ecológica por lo que en su proceso de elaboración no se han utilizado sustancias químicas, consiguiendo un producto más natural y saludable.", 25, "6ed72b50-aec0-4062-ab31-0d4d7a6f19a8_Drasanvi_032050559.jpg ", 7);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ( "MeGhee Bio cabra Golden Ghee 300 g", 18.80, "MeGhee es un producto ayurveda orgánico utilizado para usos culinarios y/o terapéuticos.", 15, "42920305-7f8b-4b61-a92e-183ff556ba3f_ghee-de-cabra-321-g.jpg ", 7);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ( "Ghee Mantequilla Clarificada 100% natural Vegetalia ", 8.90, "Ghe Mantequilla Clarificada 100% Natural Vegetalia. Elaborado con leche de vaca.", 12, "985be47f-03cb-453b-8f0a-238634beee4f_41Q4Nv0nk9L._AC_UL600_SR600,600_.jpg ", 7);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ( "Queso vegano Vegancheese ahumado Grano vita 200 g", 2.88, "Delicioso 'queso vegano' de anacardo, ideal para tomar en crudo como para cocinar, con suave y cremosa textura.", 4, "1aed12b8-950a-4c67-bb78-47897ddbba49_35761_1_1400.jpg ", 7);
INSERT INTO producto (nombre, precio, descripcion, cantidad, foto, idCategoria) VALUES ( "Queso vegano Veggieques lonchas BIO Natursoy, 150 g", 2.72, "Ingredientes: Agua, grasa de coco*(20%), almidón de patata*, harina de ALTRAMUZ*, sal marina, espesantes: goma xantana y agar-agar*, extracto de cúrcuma*, aromas naturales.", 10, "4766686a-41af-4ecd-a479-1145c9876c7b_refrig-queso-vegano-veggieques-lonchas-bio-natursoy-150-g.jpg ", 7);

INSERT INTO pedido (id, precio_total, realizado, idpago, idusuario) VALUES (1, 1000, true, 1, 1);
INSERT INTO pedido_producto (id_pedido, id_producto, cantidad) VALUES (1, 1, 21);


