

/*algunos clientes*/


INSERT INTO empresas (ID_EMPRESA,RUC, RAZON_SOCIAL, DIRECCION, ESTADO) VALUES(1,'123456789111', 'Empresa Agropecuaria', 'Calle Santa Olaya 3455 - San Borja', 'Activo');
INSERT INTO empresas (ID_EMPRESA,RUC, RAZON_SOCIAL, DIRECCION, ESTADO) VALUES(2,'111111555555', 'Empresa San Tomas', 'Av. Brasil 2544 -  Jesus Maria', 'Baja');
INSERT INTO empresas (ID_EMPRESA,RUC, RAZON_SOCIAL, DIRECCION, ESTADO) VALUES(3,'123456778899', 'Empresa Tecnologica Sapia', 'Jr. Gallesse 4511- San Miguel', 'Activo');
INSERT INTO empresas (ID_EMPRESA,RUC, RAZON_SOCIAL, DIRECCION, ESTADO) VALUES(4,'111122224444', 'Empresa Consultora Telco Macos', 'Calle Murua 4566 - Suquillo', 'Activo');
INSERT INTO empresas (ID_EMPRESA,RUC, RAZON_SOCIAL, DIRECCION, ESTADO) VALUES(5,'121212565678', 'Empresa Salmon SAC', 'Jr. PAz Soldan 4511 - San Iisidro', 'Activo');
INSERT INTO empresas (ID_EMPRESA,RUC, RAZON_SOCIAL, DIRECCION, ESTADO) VALUES(6,'888877777777', 'Empresa Sol Gas', 'Calle Santa Olaya 3455 - San Borja', 'Activo');
INSERT INTO empresas (ID_EMPRESA,RUC, RAZON_SOCIAL, DIRECCION, ESTADO) VALUES(7,'330000000000', 'Empresa Santa maria', 'Av. Larco 2544 -  Miraflores', 'Baja');
INSERT INTO empresas (ID_EMPRESA,RUC, RAZON_SOCIAL, DIRECCION, ESTADO) VALUES(8,'123456778899', 'Empresa Tecnologica Sapia', 'Jr. Sonia 4511- San Miguel', 'Activo');
INSERT INTO empresas (ID_EMPRESA,RUC, RAZON_SOCIAL, DIRECCION, ESTADO) VALUES(9,'000000007777', 'Empresa TCI', 'Calle PEZET 4566 - SAn Isidro', 'Activo');
INSERT INTO empresas (ID_EMPRESA,RUC, RAZON_SOCIAL, DIRECCION, ESTADO) VALUES(10,'123456777777', 'Empresa LAutaral SA', 'Av. Wilson 555 - Cercado de Lima', 'Baja');


/* Creamos algunos usuarios con sus roles*/


INSERT INTO usuarios (username, password, enabled) VALUES ('rolando', '$2a$10$IWvWLL2tRtJhQtaM3sGFrutWlDGwYc9ubIGkN5/cGlyJU9AqfRDwi',1);
INSERT INTO usuarios (username, password, enabled) VALUES ('admin', '$2a$10$00dGy4zQLtYmHazWJdvoteQfhu0RNVqu.SC3S8v3RQmRF1qmyodPy',1);

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) values (1,1);
INSERT INTO usuarios_roles (usuario_id, role_id) values (2,2);
INSERT INTO usuarios_roles (usuario_id, role_id) values (2,1);









