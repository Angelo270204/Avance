CONSULTA CREACIÓN BD:

CREATE TABLE rol(
id_tipo int PRIMARY KEY auto_increment,
nombre_rol varchar(50)
);


CREATE TABLE sexo(
id_sexo int Primary key auto_increment,
descripcion varchar(50)
);

CREATE TABLE empleado(
id_empleado int primary key auto_increment,
nombre varchar(50),
apellido varchar(50),
dni varchar(14),
edad int,
id_sexo int,
celular varchar(14),
direccion varchar(50),
correo varchar(50),
id_rol int,

FOREIGN KEY (id_sexo) REFERENCES sexo(id_sexo)
);

CREATE TABLE categoria(
id_categoria int PRIMARY KEY auto_increment,
nombre_categoria varchar(50),
descripcion varchar(50)

);

CREATE TABLE producto(
id_producto int PRIMARY KEY AUTO_INCREMENT,
nombre varchar(50),
id_categoria int,
descripcion varchar(50),
cantidad_stock int,
precio double,

FOREIGN KEY(id_categoria) REFERENCES categoria(id_categoria)
);
 
CREATE TABLE proveedor(
id_proveedor int PRIMARY KEY AUTO_INCREMENT,
nombre varchar(50),
ruc varchar(14),
correo varchar(50),
celular varchar(50),
direccion varchar(50),
pais varchar(50)

);

CREATE TABLE usuario(
id_usuario int PRIMARY KEY AUTO_INCREMENT,
id_empleado int,
username varchar(50),
`password` varchar(50),
id_tipo int,
fecha_acceso date,

FOREIGN KEY(id_empleado) REFERENCES empleado(id_empleado),
FOREIGN KEY(id_tipo) REFERENCES rol(id_tipo)
);

CREATE TABLE ordenCompra(
id_orden int PRIMARY KEY AUTO_INCREMENT,
id_producto int,
id_proveedor int,
cantidad int,
precio_compra double,
fecha_compra date,

FOREIGN KEY(id_producto) REFERENCES producto(id_producto),
FOREIGN KEY(id_proveedor) REFERENCES proveedor(id_proveedor)

)
