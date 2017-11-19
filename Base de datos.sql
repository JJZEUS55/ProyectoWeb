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



insert into grupo values (1,"grupo");
insert into grupo values (2,"grupoA");
insert into grupo values (3,"grupoB");
insert into grupo values (4,"grupoC");
insert into grupo values (5,"grupoD");
insert into grupo values (6,"grupoE");
insert into usuarios values(1,"Usuario1","1",1,"Name","ApellidoP","ApellidoM",1);
insert into usuarios values(2,"Usuario2","2",2,"Name","ApellidoP","ApellidoM",1);
insert into usuarios values(3,"Usuario3","3",3,"Name","ApellidoP","ApellidoM",1);





