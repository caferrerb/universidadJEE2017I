

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

INSERT INTO rol(nombre,descripcion) values('administrador','admin');
INSERT INTO rol(nombre,descripcion) values('coordinador','el que coordina');
INSERT INTO rol(nombre,descripcion) values('profesor','el que enseña');

INSERT INTO privilegio(accion) values('/paginas/seguro/docentesajax.xhtml');
INSERT INTO privilegio(accion) values('/paginas/seguro/vernotascurso.xhtml');
INSERT INTO privilegio(accion) values('/paginas/seguro/crearcurso.xhtml');

INSERT INTO privilegio_rol(idprivilegio,idrol) values(1,1);
INSERT INTO privilegio_rol(idprivilegio,idrol) values(2,1);
INSERT INTO privilegio_rol(idprivilegio,idrol) values(3,1);

INSERT INTO privilegio_rol(idprivilegio,idrol) values(2,2);
INSERT INTO privilegio_rol(idprivilegio,idrol) values(3,2);

INSERT INTO privilegio_rol(idprivilegio,idrol) values(2,3);

INSERT INTO usuario(persona,user,password,idrol) values('1234','caferrer','1234','1');
INSERT INTO usuario(persona,user,password,idrol) values('2345','quitian14','2345','2');
INSERT INTO usuario(persona,user,password,idrol) values('3456','gladys','3456','3');








