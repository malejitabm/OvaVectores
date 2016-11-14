/*User table creation*/
create table Usuario(
    id varchar(7),
    nombre varchar(30) not null,
    contrasena varchar(40) not null,
    tipo int not null,
    primary key(id)
);

/*Subject table creation*/
create table Subtema(
    id int auto_increment,
    nombre varchar(30) not null,
    descripcion varchar(40) not null,
    primary key(id)
);

/*Questionary table creation*/
create table Cuestionario(
    id int auto_increment,
    nombre varchar(30) not null,
    descripcion varchar(40) not null,
    subtema int not null,
    primary key(id),
    foreign key(subtema) references Subtema(id)
);

/*UserQuest table creation*/
create table UsuarioCuestionario(
    usuario varchar(7) not null,
    cuestionario int not null,
    calificacion decimal(3,2) not null,
    fechaHora date not null,
    primary key(usuario,cuestionario,fechaHora),
    foreign key(usuario) references Usuario(id),
    foreign key(cuestionario) references Cuestionario(id)
);

/*Question table creation*/
create table Pregunta(
    id int auto_increment,
    descripcion varchar(200) not null,
    cuestionario int not null,
    primary key(id),
    foreign key(cuestionario) references Cuestionario(id)
);

/*Option table creation*/
create table Opcion(
    id int auto_increment,
    descripcion varchar(80) not null,
    pregunta int not null,
    primary key(id),
    foreign key(pregunta) references Pregunta(id)
);

/*Answer table creation*/
create table Respuesta(
    pregunta int,
    opcion int,
    primary key(pregunta),
    foreign key(pregunta) references Pregunta(id),
    foreign key(opcion) references Opcion(id)
);

/*UserQuest table creation*/
create table UsuarioPregunta(
    usuario varchar(7),
    pregunta int,
    correcta boolean not null,
    primary key(usuario,pregunta),
    foreign key(usuario) references Usuario(id),
    foreign key(pregunta) references Pregunta(id)
);