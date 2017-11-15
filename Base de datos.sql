create database proyecto;
use proyecto;


create table usuarios(
	idUsuario int not null primary key,
	usuario varchar(20),
    contrasena varchar(20),
    tipoUsuario int(2)
);

create table profesor(
	idProfesor int not null,
    usuario varchar(20),
    contrasena varchar(20),
    nombre varchar(30),
    apPaterno varchar(30),
    apMaterno varchar(30),
	idGrupo int not null,
	foreign key (idProfesor) references usuarios(idUsuario)
    on update cascade on delete cascade
);

create table grupo(
	idGrupo int not null primary key,
    nombre varchar(20),
    idProfesor int not null,
    foreign key (idProfesor) references profesor(idProfesor)
    on update cascade on delete cascade    
);

create table alumno(
	idAlumno int not null,
    usuario varchar(20),
    contrasena varchar(20),
    nombre varchar(30),
    apPaterno varchar(30),
    apMaterno varchar(30),
    idGrupo int,
    foreign key (idGrupo) references grupo(idGrupo)
    on update cascade on delete cascade,
    foreign key (idAlumno) references usuarios(idUsuario)
    on update cascade on delete cascade
);

create table administrador(
	idAdministrador int not null,
    nombre varchar(60),
    usuario varchar(20),
    contrasena varchar(20),
    foreign key (idAdministrador) references usuarios(idUsuario)
    on delete cascade on update cascade
);










