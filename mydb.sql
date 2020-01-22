create database mydb;
use  mydb;

create table Item(
	idItem int not null auto_increment,
    nombre varchar(50) not null,
    # material varchar(45) not null,
    marca varchar(30) not null,
    costo float not null,
    cantidad int not null default 0,
    primary key(idItem)
);

/****
create table Lote(
	idLote int not null,
    nombreArticulo varchar(45) not null,
    cantidad int not null,
    idItem int not null,
    primary key(idLote),
    foreign key(idItem) references Item(idItem)
);
****/

create table Empleado(
    cedula varchar(10) not null,
    nombre varchar(45) not null,
    administrador boolean not null,
    pass varchar(16) not null,
    primary key (cedula)
);

create table Cliente(
	cedula varchar(10) not null,
    nombre varchar(45) not null default "Consumidor Final",
    direccion varchar(45) not null default 'Su casa',				#Se podria poner algun default?
    telefono varchar(15) not null default '000000',
    primary key (cedula)
);

create table Factura(
	numFactura int not null,
    costoTotal float not null,
    cedula varchar(10) not null,
    cedulaEmpleado varchar(10) not null,
    fecha date not null,
    primary key(numFactura),
    foreign key (cedula) references Cliente(cedula),
    foreign key (cedulaEmpleado) references Empleado(cedula)
);

create table DescripcionVenta(
	idVenta int not null auto_increment,
    cantidad int not null,
    numFactura int not null,
    idItem int not null,
    primary key (idVenta),
    foreign key (numFactura) references Factura(numFactura),
    foreign key (idItem) references Item(idItem)
);

create table Proveedor(
	idProveedor int not null auto_increment,
    nombre varchar(45) not null,
    ruc varchar(15) not null,
    telefono varchar(10) not null default '000000',
    primary key (idProveedor)
);

create table CompraProveedor(
	numFactura int not null,
    fecha date not null,
    cedulaEmpleado varchar(10) not null,
    idProveedor int not null,
    primary key (numFactura),
    foreign key (cedulaEmpleado) references Empleado(cedula),
    foreign key (idProveedor) references Proveedor(idProveedor)
);

create table DetalleCompra(
	idDetalleCompra int not null auto_increment,
    cantidad int not null,
    numFactura int not null,
    idItem int not null,
    primary key (idDetalleCompra),
    foreign key (numFactura) references CompraProveedor(numFactura),
    foreign key (idItem) references Item(idItem)
);

-- -----------------------------------------------------
-- Data for table `mydb`.`Item`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('CINTA TOLSEN AISLANTE ROJA 10Y', 0.35, 'Tolsen',50);
INSERT INTO `mydb`.`Item` (`Nombre`,`Costo`, `Marca`,`Cantidad`) VALUES ('PEGAMENTO SUPER BONDER 3GR', 1.57, 'Bonder',15);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('DADO TOLSEN HEXAGONAL MANDO 1/2 9MM', 0.85, 'Tolsen',300);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('SPRAY EVANS BLANCO HUESO', 1.75, 'Evans',40);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('SPRAY EVANS MARFIL 127', 1.75, 'Evans',40);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('SPRAY EVANS AZUL ESPANOL 219', 1.75, 'Evans',30);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('LLAVE STANLEY CORONA 10 - 11', 1.34, 'Stanley',50);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('CANALETA 39X19', 1.84, 'Desconocido',29);

COMMIT;

-- -----------------------------------------------------
-- Data for table `mydb`.`Empleado`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Empleado` (`Cedula`, `Nombre`, `Administrador`, `Pass`) VALUES ('0951600897', 'Edwin Eras', true, '123');
INSERT INTO `mydb`.`Empleado` (`Cedula`, `Nombre`, `Administrador`, `Pass`) VALUES ('0924691127', 'La dueña del local', true, '123');

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
INSERT INTO `mydb`.`Factura` (`numFactura`, `costoTotal`, `cedulaEmpleado`, `cedula`, `fecha`) VALUES (000000001, 1.50, '0951600897', '0991475627', '2019/09/19');
INSERT INTO `mydb`.`Factura` (`numFactura`, `costoTotal`, `cedulaEmpleado`, `cedula`, `fecha`) VALUES (000000002, 8.25, '0951600897', '0991475627', '2019/09/07');
INSERT INTO `mydb`.`Factura` (`numFactura`, `costoTotal`, `cedulaEmpleado`, `cedula`, `fecha`) VALUES (000000003, 10.00, '0924691127', '0951658897', '2019/10/21');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Cliente`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`DescripcionVenta` (`Cantidad`, `numFactura`, `idItem`) VALUES (2, 000000001, 1);
INSERT INTO `mydb`.`DescripcionVenta` (`Cantidad`, `numFactura`, `idItem`) VALUES (1, 000000002, 2);
INSERT INTO `mydb`.`DescripcionVenta` (`Cantidad`, `numFactura`, `idItem`) VALUES (3, 000000002, 3);
INSERT INTO `mydb`.`DescripcionVenta` (`Cantidad`, `numFactura`, `idItem`) VALUES (5, 000000003, 4);

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
INSERT INTO `mydb`.`CompraProveedor` (`numFactura`, `Fecha`, `idProveedor`, `cedulaEmpleado`) VALUES ('000000001', '2019/09/07', 1, '0951600897');
INSERT INTO `mydb`.`CompraProveedor` (`numFactura`, `Fecha`, `idProveedor`, `cedulaEmpleado`) VALUES ('000000002', '2019/09/06', 3, '0951600897');
INSERT INTO `mydb`.`CompraProveedor` (`numFactura`, `Fecha`, `idProveedor`, `cedulaEmpleado`) VALUES ('000000003', '2019/09/08', 2, '0924691127');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Detalle_Compra`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`DetalleCompra` (`Cantidad`, `idItem`, `numFactura`) VALUES (5, 1, '000000001');
INSERT INTO `mydb`.`DetalleCompra` (`Cantidad`, `idItem`, `numFactura`) VALUES (10, 3, '000000002');
INSERT INTO `mydb`.`DetalleCompra` (`Cantidad`, `idItem`, `numFactura`) VALUES (10, 1, '000000003');

COMMIT;
