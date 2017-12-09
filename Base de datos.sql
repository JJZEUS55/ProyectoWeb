drop database proyecto;
create database proyecto;
use proyecto;


create table grupo(
	idGrupo int not null primary key auto_increment,
    nombre varchar(20)
);

create table usuarios(
	idUsuario int not null primary key auto_increment,
	usuario varchar(20),
    contrasena varchar(20),
    tipoUsuario int(2),
    nombre varchar(30),
    apPaterno varchar(30),
    apMaterno varchar(30),
    idGrupo int not null,
    foreign key(idGrupo) references grupo(idGrupo)
   on delete cascade on update cascade 
);

create table calificaciones(
	idCalificacion int not null auto_increment primary key,
	idUsuario int not null,
    calificacion int(2),
    foreign key(idUsuario) references usuarios(idUsuario)
   on delete cascade on update cascade 
);

create table tareas(
	idTareas int not null primary key auto_increment,
	idUsuario int not null,
    archivo varchar(10000),
    foreign key(idUsuario) references usuarios(idUsuario)
   on delete cascade on update cascade 
);



INSERT INTO `grupo` (`idGrupo`,`nombre`) VALUES (1,'grupo');
INSERT INTO `grupo` (`idGrupo`,`nombre`) VALUES (2,'grupoA');
INSERT INTO `grupo` (`idGrupo`,`nombre`) VALUES (3,'grupoB');
INSERT INTO `grupo` (`idGrupo`,`nombre`) VALUES (4,'grupoC');
INSERT INTO `grupo` (`idGrupo`,`nombre`) VALUES (5,'grupoD');
INSERT INTO `grupo` (`idGrupo`,`nombre`) VALUES (8,'GrupoBien');
INSERT INTO `grupo` (`idGrupo`,`nombre`) VALUES (9,'GrupoBien2');



INSERT INTO `usuarios` (`idUsuario`,`usuario`,`contrasena`,`tipoUsuario`,`nombre`,`apPaterno`,`apMaterno`,`idGrupo`) VALUES (1,'Usuario1','1',1,'Name','ApellidoP','ApellidoM',9);
INSERT INTO `usuarios` (`idUsuario`,`usuario`,`contrasena`,`tipoUsuario`,`nombre`,`apPaterno`,`apMaterno`,`idGrupo`) VALUES (2,'Usuario2','2',2,'Name','ApellidoP','ApellidoM',1);
INSERT INTO `usuarios` (`idUsuario`,`usuario`,`contrasena`,`tipoUsuario`,`nombre`,`apPaterno`,`apMaterno`,`idGrupo`) VALUES (3,'Usuario3','3',3,'Name','ApellidoP','ApellidoM',1);
INSERT INTO `usuarios` (`idUsuario`,`usuario`,`contrasena`,`tipoUsuario`,`nombre`,`apPaterno`,`apMaterno`,`idGrupo`) VALUES (4,'Zolunga','1mas1son2',3,'Alan','Garcia','Davila',1);
INSERT INTO `usuarios` (`idUsuario`,`usuario`,`contrasena`,`tipoUsuario`,`nombre`,`apPaterno`,`apMaterno`,`idGrupo`) VALUES (6,'Pase','pase',1,'A','B','C',9);
INSERT INTO `usuarios` (`idUsuario`,`usuario`,`contrasena`,`tipoUsuario`,`nombre`,`apPaterno`,`apMaterno`,`idGrupo`) VALUES (7,'Annnc','123',1,'Carlos','Davila','Lagunas',9);
INSERT INTO `usuarios` (`idUsuario`,`usuario`,`contrasena`,`tipoUsuario`,`nombre`,`apPaterno`,`apMaterno`,`idGrupo`) VALUES (8,'Otrouser','123',2,'La','le','li',1);
INSERT INTO `usuarios` (`idUsuario`,`usuario`,`contrasena`,`tipoUsuario`,`nombre`,`apPaterno`,`apMaterno`,`idGrupo`) VALUES (9,'ora','ora',3,'yamcha','dado','ave',1);
INSERT INTO `usuarios` (`idUsuario`,`usuario`,`contrasena`,`tipoUsuario`,`nombre`,`apPaterno`,`apMaterno`,`idGrupo`) VALUES (10,'Nuevo','nuevo',2,'abc','def','dfg',1);
INSERT INTO `usuarios` (`idUsuario`,`usuario`,`contrasena`,`tipoUsuario`,`nombre`,`apPaterno`,`apMaterno`,`idGrupo`) VALUES (12,'pruebaGrupo','123',1,'x','x','x',4);
INSERT INTO `usuarios` (`idUsuario`,`usuario`,`contrasena`,`tipoUsuario`,`nombre`,`apPaterno`,`apMaterno`,`idGrupo`) VALUES (16,'Usuario20','123',1,'21','sd','dsf',1);
INSERT INTO `usuarios` (`idUsuario`,`usuario`,`contrasena`,`tipoUsuario`,`nombre`,`apPaterno`,`apMaterno`,`idGrupo`) VALUES (18,'UserPruebaB','123',1,'R','R','R',8);
INSERT INTO `usuarios` (`idUsuario`,`usuario`,`contrasena`,`tipoUsuario`,`nombre`,`apPaterno`,`apMaterno`,`idGrupo`) VALUES (19,'UserPruebaB1','123',1,'R','R','R',8);
INSERT INTO `usuarios` (`idUsuario`,`usuario`,`contrasena`,`tipoUsuario`,`nombre`,`apPaterno`,`apMaterno`,`idGrupo`) VALUES (20,'UserPruebaB2','123',1,'R','R','R',8);
INSERT INTO `usuarios` (`idUsuario`,`usuario`,`contrasena`,`tipoUsuario`,`nombre`,`apPaterno`,`apMaterno`,`idGrupo`) VALUES (21,'UserPruebaB3','123',1,'R','R','R',8);
INSERT INTO `usuarios` (`idUsuario`,`usuario`,`contrasena`,`tipoUsuario`,`nombre`,`apPaterno`,`apMaterno`,`idGrupo`) VALUES (22,'UserPruebaB4','123',1,'R','R','R',8);
INSERT INTO `usuarios` (`idUsuario`,`usuario`,`contrasena`,`tipoUsuario`,`nombre`,`apPaterno`,`apMaterno`,`idGrupo`) VALUES (23,'UserPrueba','123',1,'R','R','R',8);
INSERT INTO `usuarios` (`idUsuario`,`usuario`,`contrasena`,`tipoUsuario`,`nombre`,`apPaterno`,`apMaterno`,`idGrupo`) VALUES (24,'UserPruebaM','123',2,'R','R','R',8);
INSERT INTO `usuarios` (`idUsuario`,`usuario`,`contrasena`,`tipoUsuario`,`nombre`,`apPaterno`,`apMaterno`,`idGrupo`) VALUES (25,'pruebaAl','123',1,'b','b','b',1);
INSERT INTO `usuarios` (`idUsuario`,`usuario`,`contrasena`,`tipoUsuario`,`nombre`,`apPaterno`,`apMaterno`,`idGrupo`) VALUES (26,'pruebaAl2','123',1,'b','b','b',9);
INSERT INTO `usuarios` (`idUsuario`,`usuario`,`contrasena`,`tipoUsuario`,`nombre`,`apPaterno`,`apMaterno`,`idGrupo`) VALUES (27,'pruebaAl3','123',1,'b','b','b',1);
INSERT INTO `usuarios` (`idUsuario`,`usuario`,`contrasena`,`tipoUsuario`,`nombre`,`apPaterno`,`apMaterno`,`idGrupo`) VALUES (28,'profesor','123',2,'abc','bcd','agh',1);


-- Insert Calificaciones
insert into calificaciones values(1, 1, 9);




