-- Borrar base de datos si ya existe
drop database if exists profit;

-- Creación base de datos y selección
create database profit;
use profit;

-- Borrar usuario si ya existe
drop user if exists 'martaboso'@'localhost';

-- Crear usuario
create user 'martaboso'@'localhost' identified by 'martaboso98';

-- Creación de tablas
create table usuario(
	id_usuario int primary key auto_increment not null,
    email varchar (25),
	nombre varchar (25) unique, -- Para mayor seguridad añado el unique
    apellido varchar (60),
    edad int,
    contraseña varchar (25),
    altura int, 
    peso float
);

create table abdominales (
	id int primary key not null,
	nombre varchar (40)
);

create table hombro (
	id int primary key not null,
	nombre varchar (40)
);

create table biceps (
	id int primary key not null,
	nombre varchar (40)
);

create table triceps (
	id int primary key not null,
	nombre varchar (40)
);

create table espalda (
	id int primary key not null,
	nombre varchar (40)
);

create table pecho (
	id int primary key not null,
    nombre varchar (40)
);

create table piernas (
	id int primary key not null,
    nombre varchar (40)
);

create table dia_usuario_ejercicio (
	dia int not null,
    id_usuario int default null,
    ejercicios varchar (25)
);

-- Añadir clave foráneas para relacionar las tablas
alter table dia_usuario_ejercicio
add foreign key (id_usuario)
references usuario (id_usuario);

-- Insertar datos en tablas de ejercicios
insert into abdominales values (1,"Escalador de montaña"), (2,"Crunch diagonal"), (3,"Crunch"), (4,"Plancha lateral"),
(5,"Plancha"), (6,"Bicicleta"), (7,"Spiderman");

insert into piernas values 
(8,"Extensión de cuádriceps"),(9,"Hip Thrust"),(10,"Sentadillas"),(11,"Hiperextensión"),(12,"Búlgaras"),(13,"Zancada"),(14,"Prensa"),
(15,"Aducción"), (16,"Abducción"),(17,"Peso muerto semisumo"),(18,"Peso muerto rumano"),(19,"Peso muerto convencional"),
(20,"Elevación talón");

insert into pecho values (21,"Press Banca"), (22,"Press inclinado"), (23,"Press declinado"), (24,"Flexiones"), (25,"Fondo");

insert into espalda values (26,"Dominadas"), (27,"Jalón al pecho"), (28,"Remo inclinado"), (29,"Remo mancuerna"), (30,"Remo máquina");

insert into triceps values (31,"Empuje tríceps"), (32,"Extensión tríceps cabeza"), (33,"Press francés"), 
(34,"Flexiones"), (35,"TRX"), (36,"Extensión tríceps polea"), (37,"Fondo"), (38,"Patada tríceps");

insert into biceps values (39,"Curl bíceps midancuerna"), (40,"Curl bíceps Barra Z"), (41,"Curl bíceps concentrado"), 
(42,"Curl bíceps banco"), (43,"Curl bíceps tumbado"), (44,"Martillo");

insert into hombro values (45,"Press Militar"), (46,"Elevaciones laterales"), (47,"Elevaciones frontales"), 
(48,"Remo"), (49,"Facepull"), (50,"Landmine Press");
