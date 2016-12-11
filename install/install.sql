
create table Usuario(
    id varchar(7),
    nombre varchar(30) not null,
    contrasena varchar(40) not null,
    tipo int not null,
    primary key(id)
);


create table Subtema(
    id int auto_increment,
    nombre varchar(30) not null,
    descripcion varchar(40) not null,
    primary key(id)
);


create table Cuestionario(
    id int auto_increment,
    nombre varchar(30) not null,
    descripcion varchar(40) not null,
    subtema int not null,
    primary key(id),
    foreign key(subtema) references Subtema(id)
);


create table UsuarioCuestionario(
    usuario varchar(7) not null,
    cuestionario int not null,
    aprobado boolean not null,
    fechaHora datetime not null,
    primary key(usuario,cuestionario,fechaHora),
    foreign key(usuario) references Usuario(id),
    foreign key(cuestionario) references Cuestionario(id)
);

create table EvaluacionFinal(
    id int auto_increment,
    descripcion varchar(200) not null,
    fechaHora datetime not null,
    primary key(id)
);

create table UsuarioEvaluacion(
    usuario varchar(7) not null,
    evaluacion int not null,
    aprobado boolean not null,
    fechaHora datetime not null,
    primary key(usuario,evaluacion,fechaHora),
    foreign key(usuario) references Usuario(id),
    foreign key(evaluacion) references EvaluacionFinal(id)
);

create table Pregunta(
    id int auto_increment,
    descripcion varchar(200) not null,
    cuestionario int not null,
    evaluacionfinal int,
    primary key(id),
    foreign key(cuestionario) references Cuestionario(id),
    foreign key(evaluacionfinal) references EvaluacionFinal(id)
);


create table Opcion(
    id int auto_increment,
    descripcion varchar(80) not null,
    pregunta int not null,
    primary key(id),
    foreign key(pregunta) references Pregunta(id)
);


create table Respuesta(
    pregunta int,
    opcion int,
    primary key(pregunta),
    foreign key(pregunta) references Pregunta(id),
    foreign key(opcion) references Opcion(id)
);
