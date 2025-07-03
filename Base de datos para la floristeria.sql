-- Eliminar la base de datos (opcional, solo para pruebas)
drop database Empresa;

-- Crear la base de datos si no existe
create database if not exists Empresa;
use Empresa;

-- Crear la tabla de usuarios
create table if not exists tb_usuario(
    idUsuario varchar(15) primary key,
    nombre varchar(130) not null,
    password varchar(30) not null,
    rol varchar(30) not null,
    estado varchar(11) not null,
    fecha_creacion_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

select * from tb_usuario;

-- Insertar un usuario administrador
insert into tb_usuario(idUsuario, nombre, password, rol, estado) values
('0801-2004-18498', 'Jose Manuel Ponce', 'Admin', 'Gerente', 'Activo'),
('9876-5432-11111', 'Vendedor', '12345', 'Vendedor', 'Activo');

-- Crear la tabla de categorías
create table if not exists tb_categoria (
    ID_categoria int auto_increment primary key,
    nombre varchar(100) not null,
    descripcion varchar(100),
    estado varchar(11) not null,
    fecha_creacion_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Crear la tabla de productos
create table if not exists tb_producto(
    ID_Producto varchar(50) primary key,
    nombre varchar(100) not null,
    descripcion varchar(100),
    precio_venta decimal(10,2) not null,
    cantidad int not null,
    ID_categoria int,
    estado varchar(11) not null,
    fecha_creacion_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    foreign key (ID_categoria) references tb_categoria(ID_categoria)
);

-- Crear la tabla de clientes
create table if not exists tb_cliente(
    identidad varchar(15) primary key,
    nombre varchar(100) not null,
    telefono varchar(50),
    direccion varchar(100),
    estado varchar(11) not null,
    fecha_creacion_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

insert into tb_cliente(identidad, nombre, telefono, direccion, estado)
values ('9999-9999-99999', 'Último Consumidor', '', '', 'Activo');


-- Tabla cabecera de venta
create table tb_cabecera_venta(
    idCabeceraVenta int(11) auto_increment primary key,
    idCliente varchar(15) not null,
    valorPagar double(10,2) not null,
    fechaVenta date not null,
    estado varchar(11) not null,
    foreign key (idCliente) references tb_cliente(identidad)
);

-- Tabla detalle de venta
create table tb_detalle_venta(
    idDetalleVenta int(11) auto_increment primary key,
    idCabeceraVenta int(11),
    idProducto varchar(50),
    cantidad int(11),
    precioUnitario double(10,2),
    totalPagar double(10,2),
    estado varchar(11) not null,
    foreign key (idCabeceraVenta) references tb_cabecera_venta(idCabeceraVenta),
    foreign key (idProducto) references tb_producto(ID_Producto)
);

-- Vista sin mostrar el password
create view vista_usuarios_sin_password as
select idUsuario, nombre, rol, estado, fecha_creacion_modificacion
from tb_usuario;


select * from tb_usuario;

select * from tb_cabecera_venta;
select * from tb_detalle_venta where idCabeceraVenta=3;



select
    cv.idCabeceraVenta,
    c.nombre as nombre_cliente,
    c.identidad,
    cv.fechaVenta,
    cv.valorPagar as total_venta
from tb_cabecera_venta cv
join tb_cliente c on cv.idCliente = c.identidad
where cv.estado = 'Activo'
  and cv.fechaVenta between '2025-05-01' and '2025-05-15'
order by cv.idCabeceraVenta;


-- Insertar datos
	insert into tb_categoria(nombre, descripcion, estado) values
('Ramos Florales', 'Ramos para toda ocasión', 'Activo'),
('Arreglos Funerarios', 'Flores para funerales', 'Activo'),
('Decoración de Eventos', 'Decoración floral para eventos', 'Activo'),
('Plantas', 'Plantas ornamentales y en maceta', 'Activo');

insert into tb_producto(ID_Producto, nombre, descripcion, precio_venta, cantidad, ID_categoria, estado) values
('P001', 'Ramo de Rosas Rojas', '12 rosas rojas con envoltorio elegante', 25.00, 20, 1, 'Activo'),
('P002', 'Corona Funeraria Grande', 'Corona con lirios y rosas', 80.00, 5, 2, 'Activo'),
('P003', 'Centro de Mesa Floral', 'Ideal para bodas y cenas', 40.00, 10, 3, 'Activo'),
('P004', 'Orquídea en Maceta', 'Orquídea viva en maceta de cerámica', 30.00, 15, 4, 'Activo'),
('P005', 'Mini Ramo de Gerberas', 'Coloridas y alegres', 15.00, 25, 1, 'Activo');

	
insert into tb_cliente(identidad, nombre, telefono, direccion, estado) values
('0801-1990-12345', 'María López', '9876-5432', 'Col. El Rosario', 'Activo'),
('0801-1985-67890', 'Carlos Mejía', '3344-5566', 'Barrio Abajo', 'Activo'),
('0801-2001-11223', 'Ana Martínez', '2233-4455', 'Col. Palmira', 'Activo');


insert into tb_cabecera_venta(idCliente, valorPagar, fechaVenta, estado) values
('0801-1990-12345', 55.00, '2025-05-02', 'Activo'),
('0801-1985-67890', 80.00, '2025-05-05', 'Activo'),
('0801-2001-11223', 45.00, '2025-05-10', 'Activo');

insert into tb_detalle_venta(idCabeceraVenta, idProducto, cantidad, precioUnitario, totalPagar, estado) values
(1, 'P001', 2, 25.00, 50.00, 'Activo'),
(1, 'P005', 1, 5.00, 5.00, 'Activo'),
(2, 'P002', 1, 80.00, 80.00, 'Activo'),
(3, 'P004', 1, 30.00, 30.00, 'Activo'),
(3, 'P005', 1, 15.00, 15.00, 'Activo');
