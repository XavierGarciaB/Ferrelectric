create database mydb;
use  mydb;

create table Item(
	idItem int not null auto_increment,
    nombre varchar(50) not null,
    # material varchar(45) not null,
    marca varchar(30) not null,
    costo float not null,
    primary key(idItem)
);

create table Lote(
	idLote int not null,
    nombreArticulo varchar(45) not null,
    cantidad int not null,
    idItem int not null,
    primary key(idLote),
    foreign key(idItem) references Item(idItem)
);

create table Empleado(
	idEmpleado int not null auto_increment,
    cedula varchar(10) not null,
    nombre varchar(45) not null,
    administrador boolean not null,
    pass varchar(16) not null,
    primary key (idEmpleado)
);

create table Cliente(
	cedula varchar(10) not null,
    nombre varchar(45) not null default "Consumidor Final",
    direccion varchar(45) not null default 'Su casa',				#Se podria poner algun default?
    telefono varchar(15) not null default '000000',
    primary key (cedula)
);

create table Factura(
	idFactura int not null,
    costoTotal float not null,
    cedula varchar(10) not null,
    idEmpleado int not null,
    primary key(idFactura),
    foreign key (cedula) references Cliente(cedula),
    foreign key (idEmpleado) references Empleado(idEmpleado)
);

create table DescripcionVenta(
	idVenta int not null,
    cantidad int not null,
    costo float not null,
    idFactura int not null,
    idItem int not null,
    primary key (idVenta),
    foreign key (idFactura) references Factura(idFactura),
    foreign key (idItem) references Item(idItem)
);

create table Proveedor(
	idProveedor int not null auto_increment,
    nombre varchar(45) not null,
    ruc varchar(15) not null,
    telefono varchar(10) not null,
    primary key (idProveedor)
);

create table CompraProveedor(
	idCompra int not null auto_increment,
    fecha date not null,
    costoTotal float not null,
    idEmpleado int not null,
    idProveedor int not null,
    primary key (idCompra),
    foreign key (idEmpleado) references Empleado(idEmpleado),
    foreign key (idProveedor) references Proveedor(idProveedor)
);

create table DetalleCompra(
	idDetalleCompra int not null auto_increment,
    cantidad int not null,
    costoTotal double not null,
    idCompra int not null,
    idItem int not null,
    primary key (idDetalleCompra),
    foreign key (idCompra) references CompraProveedor(idCompra),
    foreign key (idItem) references Item(idItem)
);

-- -----------------------------------------------------
-- Data for table `mydb`.`Item`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`) VALUES ('CINTA TOLSEN AISLANTE ROJA 10Y', 0.35, 'Tolsen');
INSERT INTO `mydb`.`Item` (`Nombre`,`Costo`, `Marca`) VALUES ('PEGAMENTO SUPER BONDER 3GR', 1.57, 'Bonder');
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`) VALUES ('DADO TOLSEN HEXAGONAL MANDO 1/2 9MM', 0.85, 'Tolsen');
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`) VALUES ('SPRAY EVANS BLANCO HUESO', 1.75, 'Evans');
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`) VALUES ('SPRAY EVANS MARFIL 127', 1.75, 'Evans');
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`) VALUES ('SPRAY EVANS AZUL ESPANOL 219', 1.75, 'Evans');
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`) VALUES ('LLAVE STANLEY CORONA 10 - 11', 1.34, 'Stanley');
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`) VALUES ('CANALETA 39X19', 1.84, 'Desconocido');

COMMIT;

-- -----------------------------------------------------
-- Data for table `mydb`.`Empleado`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Empleado` (`Cedula`, `Nombre`, `Administrador`, `Pass`) VALUES ('0951600897', 'Edwin Eras', true, '123456789');
INSERT INTO `mydb`.`Empleado` (`Cedula`, `Nombre`, `Administrador`, `Pass`) VALUES ('0924691127', 'La dueña del local', true, '123456789');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Cliente`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Cliente` (`Cedula`, `Nombre`, `Direccion`, `Telefono`) VALUES ('0951658897', 'Rivera Delgado Evelyn', DEFAULT, DEFAULT);
INSERT INTO `mydb`.`Cliente` (`Cedula`, `Nombre`, `Direccion`, `Telefono`) VALUES ('0991475627', 'Barahona Echeveria', DEFAULT, DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Factura`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Factura` (`idFactura`, `costoTotal`, `idEmpleado`, `cedula`) VALUES (11, 1.50, '1', '0951658897');
INSERT INTO `mydb`.`Factura` (`idFactura`, `costoTotal`, `idEmpleado`, `cedula`) VALUES (12, 8.25, '1', '0951658897');
INSERT INTO `mydb`.`Factura` (`idFactura`, `costoTotal`, `idEmpleado`, `cedula`) VALUES (13, 10.00, '1', '0951658897');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Proveedor`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Proveedor` (`Nombre`, `Telefono`, `Ruc`) VALUES ('Mafelesa', DEFAULT, '0000000000000');
INSERT INTO `mydb`.`Proveedor` (`Nombre`, `Telefono`, `Ruc`) VALUES ('Tolsen', DEFAULT, '0000000000000');
INSERT INTO `mydb`.`Proveedor` (`Nombre`, `Telefono`, `Ruc`) VALUES ('Promafer', DEFAULT, '0000000000000');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Compra_Proveedor`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`CompraProveedor` (`Fecha`, `CostoTotal`, `idProveedor`, `idEmpleado`) VALUES ('2019/09/07', 10.27, 1, '1');
INSERT INTO `mydb`.`CompraProveedor` (`Fecha`, `CostoTotal`, `idProveedor`, `idEmpleado`) VALUES ('2019/09/06', 13.35, 3, '2');
INSERT INTO `mydb`.`CompraProveedor` (`Fecha`, `CostoTotal`, `idProveedor`, `idEmpleado`) VALUES ('2019/09/08', 15.00, 2, '1');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Detalle_Compra`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`DetalleCompra` (`Cantidad`, `costoTotal`, `idItem`, `idCompra`) VALUES (5, 15, 1, 1);
INSERT INTO `mydb`.`DetalleCompra` (`Cantidad`, `costoTotal`, `idItem`, `idCompra`) VALUES (10, 25, 3, 2);
INSERT INTO `mydb`.`DetalleCompra` (`Cantidad`, `costoTotal`, `idItem`, `idCompra`) VALUES (10, 30, 1, 3);

COMMIT
