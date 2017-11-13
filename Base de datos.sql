create database proyecto1;
use proyecto1;

create table alumno(
	idAlumno int not null auto_increment primary key,
    nombre varchar(30),
    apPaterno varchar(30),
    apMaterno varchar(30),
    idGrupo int,
    foreign key (idGrupo) references grupo(idGrupo)
    on update cascade on delete cascade
);

create table usuarioAlumno(
	idAlumno int not null,
    usuario varchar(20),
    contrasena varchar(20),
    foreign key (idAlumno) references alumno(idAlumno)
    on delete cascade on update cascade
);

create table profesor(
	idProfesor int not null auto_increment primary key,
    nombre varchar(30),
    apPaterno varchar(30),
    apMaterno varchar(30),
	idGrupo int not null
);


create table usuarioProfesor(
	idProfesor int not null,
    usuario varchar(20),
    contrasena varchar(20),
    foreign key (idProfesor) references profesor(idProfesor)
    on delete cascade on update cascade    
);


create table grupo(
	idGrupo int not null primary key,
    nombre varchar(20),
    idProfesor int not null,
    foreign key (idProfesor) references profesor(idProfesor)
    on update cascade on delete cascade    
);

create table usuarios(
	usuario varchar(20),
    contrasena varchar(20),
    tipoUsuario int(2)
);

create table administrador(
	idAdministrador int not null primary key auto_increment,
    nombre varchar(60),
    usuario varchar(20),
    contrasena varchar(20)
);




alter table profesor add foreign key (idGrupo) references grupo(idGrupo)
on delete cascade on update cascade;


alter table 








