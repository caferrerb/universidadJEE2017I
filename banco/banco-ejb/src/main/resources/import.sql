--
-- JBoss, Home of Professional Open Source
-- Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
-- contributors by the @authors tag. See the copyright.txt in the
-- distribution for a full listing of individual contributors.
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
-- http://www.apache.org/licenses/LICENSE-2.0
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
--

-- You can use this file to load seed data into the database using SQL statements
INSERT INTO tipotransaccion(id, impuesto, nombre)VALUES (1, 1000, 'Consignacion');
INSERT INTO tipotransaccion(id, impuesto, nombre)VALUES (2, 1000, 'Retiro');
INSERT INTO tipotransaccion(id, impuesto, nombre)VALUES (3, 500, 'Transferencia');
INSERT INTO tipotransaccion(id, impuesto, nombre)VALUES (4, 0, 'Consulta de saldo');

INSERT INTO tipocuenta( id, nombre)VALUES (1, 'Ahorros');
INSERT INTO tipocuenta( id, nombre)VALUES (2, 'Corriente');
INSERT INTO tipocuenta( id, nombre)VALUES (3, 'Plan semilla');

INSERT INTO rol( idrol, descripcion) VALUES (1, 'Admin');
INSERT INTO rol( idrol, descripcion) VALUES (2, 'Cliente');
INSERT INTO rol( idrol, descripcion) VALUES (3, 'Cajero');
INSERT INTO rol( idrol, descripcion) VALUES (4, 'Asesor comercial');

INSERT INTO acceso(id, nombre, url) VALUES (1, 'Crear cliente', '/paginas/banca/crearcliente.jsf');
INSERT INTO acceso(id, nombre, url) VALUES (2, 'Crear cuenta', '/paginas/banca/crearcuenta.jsf');
INSERT INTO acceso(id, nombre, url) VALUES (3, 'Crear Empleados', '/paginas/admin/crearempleado.jsf');
INSERT INTO acceso(id, nombre, url) VALUES (4, 'Transacciones', '/paginas/banca/transacciones.jsf');
INSERT INTO acceso(id, nombre, url) VALUES (5, 'Consultar cuentas', '/paginas/cliente/vercuentas.jsf');

INSERT INTO accesorol(acceso_id, rol_idrol)  VALUES (1, 4);
INSERT INTO accesorol(acceso_id, rol_idrol)  VALUES (2, 4);
INSERT INTO accesorol(acceso_id, rol_idrol)  VALUES (3, 1);
INSERT INTO accesorol(acceso_id, rol_idrol)  VALUES (4, 3);
INSERT INTO accesorol(acceso_id, rol_idrol)  VALUES (5, 2);

INSERT INTO usuario( nombreusuario, password)VALUES ('quitian', '81dc9bdb52d04dc20036dbd8313ed055');
INSERT INTO usuario( nombreusuario, password)VALUES ('asesor', '81dc9bdb52d04dc20036dbd8313ed055');
INSERT INTO usuario( nombreusuario, password)VALUES ('cajero', '81dc9bdb52d04dc20036dbd8313ed055');
INSERT INTO usuario( nombreusuario, password)VALUES ('admin', '81dc9bdb52d04dc20036dbd8313ed055');

INSERT INTO usuariorol(rol_idrol, usuario_nombreusuario)VALUES (2, 'quitian');
INSERT INTO usuariorol(rol_idrol, usuario_nombreusuario)VALUES (4, 'asesor');
INSERT INTO usuariorol(rol_idrol, usuario_nombreusuario)VALUES (3, 'cajero');
INSERT INTO usuariorol(rol_idrol, usuario_nombreusuario)VALUES (1, 'admin');

INSERT INTO empleado(codigo, cargo, nombre, usuario)VALUES (1, 'Asesor comercial Junior', 'Maria', 'asesor');
INSERT INTO empleado(codigo, cargo, nombre, usuario)VALUES (2, 'Gerente de surcursal', 'Jose', 'admin');
INSERT INTO empleado(codigo, cargo, nombre, usuario)VALUES (3, 'Cajero horario extendido', 'Pedro', 'cajero');

INSERT INTO cliente(cedula, direccion, nombre, password, telefono, usuario)VALUES ('1234', 'por ahi', 'Claudia Fernandez', NULL,'2342342', 'quitian');






