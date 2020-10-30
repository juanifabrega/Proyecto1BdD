VALUES ('Rincon','100',80.38);

#-----------------------------------------------------------------------------------------------
#Insercion en parquimetros

INSERT INTO parquimetros(id_parq,numero,calle,altura)
VALUES (1,1,'Estomba','1200');

INSERT INTO parquimetros(id_parq,numero,calle,altura)
VALUES (2,2,'Belgrano','300');

INSERT INTO parquimetros(id_parq,numero,calle,altura)
VALUES (3,3,'Alsina','100');

INSERT INTO parquimetros(id_parq,numero,calle,altura)
VALUES (4,4,'Estomba','1200');

INSERT INTO parquimetros(id_parq,numero,calle,altura)
VALUES (5,5,'Rincon','100');

INSERT INTO parquimetros(id_parq,numero,calle,altura)
VALUES (6,6,'Rincon','100');

#-----------------------------------------------------------------------------------------------
#Insercion en estacionamientos

INSERT INTO estacionamientos(id_tarjeta,id_parq,fecha_ent,hora_ent,fecha_sal,hora_sal)
VALUES (1,1,CURTIME(),CURDATE(),NULL,NULL);

INSERT INTO estacionamientos(id_tarjeta,id_parq,fecha_ent,hora_ent,fecha_sal,hora_sal)
VALUES (2,2,CURTIME(),CURDATE(),CURTIME(),CURDATE());

INSERT INTO estacionamientos(id_tarjeta,id_parq,fecha_ent,hora_ent,fecha_sal,hora_sal)
VALUES (3,3,CURTIME(),CURDATE(),NULL,NULL);

INSERT INTO estacionamientos(id_tarjeta,id_parq,fecha_ent,hora_ent,fecha_sal,hora_sal)
VALUES (4,3,CURTIME(),'17:00:00',NULL,NULL);

#-----------------------------------------------------------------------------------------------
#Insercion en accede
INSERT INTO accede(legajo,id_parq,fecha,hora)
VALUES (4444,1,CURDATE(),CURTIME());

INSERT INTO accede(legajo,id_parq,fecha,hora)
VALUES (333,2,CURDATE(),CURTIME());

#-----------------------------------------------------------------------------------------------
#Insercion en asociado_con

# Legajo 4444
INSERT INTO asociado_con(id_asociado_con,legajo,calle,altura,dia,turno)
VALUES (1,4444,'Belgrano','300','lu','M');

INSERT INTO asociado_con(id_asociado_con,legajo,calle,altura,dia,turno)
VALUES (2,4444,'Belgrano','300','ma','M');

INSERT INTO asociado_con(id_asociado_con,legajo,calle,altura,dia,turno)
VALUES (3,4444,'Belgrano','300','mi','M');

INSERT INTO asociado_con(id_asociado_con,legajo,calle,altura,dia,turno)
VALUES (4,4444,'Belgrano','300','ju','M');

INSERT INTO asociado_con(id_asociado_con,legajo,calle,altura,dia,turno)
VALUES (5,4444,'Belgrano','300','vi','M');

INSERT INTO asociado_con(id_asociado_con,legajo,calle,altura,dia,turno)
VALUES (6,4444,'Belgrano','300','sa','M');

INSERT INTO asociado_con(id_asociado_con,legajo,calle,altura,dia,turno)
VALUES (7,4444,'Belgrano','300','do','M');

# Legajo 333
INSERT INTO asociado_con(id_asociado_con,legajo,calle,altura,dia,turno)
VALUES (8,333,'Estomba','1200','lu','T');

INSERT INTO asociado_con(id_asociado_con,legajo,calle,altura,dia,turno)
VALUES (9,333,'Estomba','1200','ma','T');

INSERT INTO asociado_con(id_asociado_con,legajo,calle,altura,dia,turno)
VALUES (10,333,'Estomba','1200','mi','T');

INSERT INTO asociado_con(id_asociado_con,legajo,calle,altura,dia,turno)
VALUES (11,333,'Estomba','1200','ju','T');

INSERT INTO asociado_con(id_asociado_con,legajo,calle,altura,dia,turno)
VALUES (12,333,'Estomba','1200','vi','T');

INSERT INTO asociado_con(id_asociado_con,legajo,calle,altura,dia,turno)
VALUES (13,333,'Estomba','1200','sa','T');

INSERT INTO asociado_con(id_asociado_con,legajo,calle,altura,dia,turno)
VALUES (14,333,'Estomba','1200','do','T');


INSERT INTO asociado_con(id_asociado_con,legajo,calle,altura,dia,turno)
VALUES (15,333,'Alsina','100','lu','M');

INSERT INTO asociado_con(id_asociado_con,legajo,calle,altura,dia,turno)
VALUES (16,333,'Rincon','100','ma','M');

#-----------------------------------------------------------------------------------------------
#Insercion en multas

INSERT INTO multa(numero,fecha,hora,patente,id_asociado_con)
VALUES (1,'2018-12-09','17:00:00','D10S10',1);

INSERT INTO multa(numero,fecha,hora,patente,id_asociado_con)
VALUES (2,'2019-10-01','20:30:59','D10S10',2);

INSERT INTO multa(numero,fecha,hora,patente,id_asociado_con)
VALUES (3,'2001-6-19','18:45:00','D10S10',3);
