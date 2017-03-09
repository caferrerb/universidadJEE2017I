

INSERT INTO facultad(codigo, nombre)VALUES ('1', 'Ingenieria');
INSERT INTO programa(codigo, nombre, facultad_codigo)VALUES ('1', 'Ingesoft', '1');
INSERT INTO programa(codigo, nombre, facultad_codigo)VALUES ('2', 'IngMKT', '1');
INSERT INTO programa(codigo, nombre, facultad_codigo)VALUES ('3', 'IngIND', '1');

INSERT INTO facultad(codigo, nombre)VALUES ('2', 'Administracion');
INSERT INTO programa(codigo, nombre, facultad_codigo)VALUES ('4', 'Contaduria', '2');
INSERT INTO programa(codigo, nombre, facultad_codigo)VALUES ('5', 'Administracion de empresas', '2');
INSERT INTO programa(codigo, nombre, facultad_codigo)VALUES ('6', 'Negocios Internacionales', '2');


INSERT INTO facultad(codigo, nombre)VALUES ('3', 'Diseño');
INSERT INTO programa(codigo, nombre, facultad_codigo)VALUES ('7', 'Publicidad', '3');
INSERT INTO programa(codigo, nombre, facultad_codigo)VALUES ('8', 'Diseño visual', '3');


INSERT INTO persona(documentoidentificacion, apellido, correoelectronico, direccion, nombre, telefono)VALUES ('1234', 'Ferrer', 'ferrer@gmail.com', 'muy lejos de aqui', 'Camilo', '6456456');
INSERT INTO persona(documentoidentificacion, apellido, correoelectronico, direccion, nombre, telefono)VALUES ('2345', 'Quitian', 'quitan@gmail.com', 'muy lejos de aqui', 'CLaudia', '4656757');
INSERT INTO persona(documentoidentificacion, apellido, correoelectronico, direccion, nombre, telefono)VALUES ('3456', 'Bustos', 'bustos@gmail.com', 'muy lejos de aqui', 'Gladys', '34534');
INSERT INTO persona(documentoidentificacion, apellido, correoelectronico, direccion, nombre, telefono)VALUES ('4567', 'Ariza', 'ariza@gmail.com', 'muy lejos de aqui', 'Jose', '456456456');

INSERT INTO docente(	codigodocente, color, escalafon, seudonimo, tipocontratacion, documentoidentificacion, programa_codigo)	VALUES ('1', 'rojo', 'ESPECIAL', 'aaa', 'TIEMPO_COMPLETO', '1234', '1');
INSERT INTO docente(	codigodocente, color, escalafon, seudonimo, tipocontratacion, documentoidentificacion, programa_codigo)	VALUES ('2', 'rojo', 'ESPECIAL', 'aaa', 'TIEMPO_COMPLETO', '2345', '2');
INSERT INTO docente(	codigodocente, color, escalafon, seudonimo, tipocontratacion, documentoidentificacion, programa_codigo)	VALUES ('3', 'rojo', 'ESPECIAL', 'aaa', 'TIEMPO_COMPLETO', '3456', '3');
INSERT INTO docente(	codigodocente, color, escalafon, seudonimo, tipocontratacion, documentoidentificacion, programa_codigo)	VALUES ('4', 'rojo', 'ESPECIAL', 'aaa', 'TIEMPO_COMPLETO', '4567', '4');