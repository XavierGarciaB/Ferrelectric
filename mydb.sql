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
    direccion varchar(45) not null default 'Su casa',				
    telefono varchar(15) not null default '000000',
    primary key (cedula)
);

create table Factura(
	numFactura int not null,
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
    nombre varchar(45) not null,
    ruc varchar(15) not null,
    telefono varchar(10) not null default '000000',
    primary key (ruc)
);

create table CompraProveedor(
	numFactura int not null,
    fecha date not null,
    cedulaEmpleado varchar(10) not null,
    ruc varchar(15) not null,
    primary key (numFactura),
    foreign key (cedulaEmpleado) references Empleado(cedula),
    foreign key (ruc) references Proveedor(ruc)
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
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('UNION 3/8 CON ABRAZADERA 7/8', 0.45, 'Desconocido',20);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('TORNILLOS 3/16 CON ANILLOS PLANOS', 0.66, 'Desconocido',50);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('CANDADO BARRIL', 2.70, 'Baoli',60);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('BROCHA M/NATURAL 3/4', 0.26, 'Soyoda',12);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('SPRAY EVANS ROJO OXIDO ANTICORROSIVO', 1.75, 'Evans',40);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('FLEXOMETRO WOOD AZUL 5MTS', 1.96, 'Wood',15);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('CABLE BATERIA N4 AWG C/M', 2.83, 'Incable',25);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('BROCAS RHINO 3/16 PARA METAL', 1.10, 'Rhino',2);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('SPRAY ADHEPLAST BLANCO MATE 1007', 1.025, 'Adheplast',10);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('LLAVE FIRENZI 3419 MEZON ACRILICA', 6.30, 'Firenzi',40);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('PERNO ALLEN NEGRO 8 X 40MM', 1.30, 'Allen',50);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('PERNO ALLEN NEGRO 8 X 25MM', 1.01, 'Allen',30);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('ADAPTADOR BOQ ENCHUFE COOPER 738', 1.05, 'Cooper',15);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('DESARMADOR DE COPA 5/16', 0.70, 'Desconocido',20);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('CAUTIN 45 GRADOS GENUINE 110V/200W', 4.05, 'Genuine',30);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('SPRAY NEGRO BRILLANTE OHIO 01', 1.19, 'Ohio',24);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('SPRAY NEGRO BRILLANTE OHIO 21', 1.19, 'Ohio',12);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('CABCPM FLEXIBLE N12 NEGRO R100M INCAB', 32.05, 'Incab',2);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('BOQUILLA BENJAMIN CON CADENA', 0.55, 'Desconocido',12);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('COMBO C/MANGO 2LBS', 4.017, 'Pretul',20);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('BOQUILLA NEGRA COLGANTE', 1.20, 'Desconocido',12);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('SPRAY ALUMINIO 25 OHIO', 1.19, 'Ohio',24);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('GANCHO DOBLE 30MM ORO/TORN', 0.71, 'Desconocido',12);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('TALADRO PERCUTOR FROTIA', 38.48, 'Frotia',4);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('ANILLO DE PRESION 3/8', 0.15, 'Desconocido',15);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('PERNO 12MM X 100 X 1.75 ON ANILLOS PLANOS', 1.19, 'Desconocido',15);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('EXTENSION P/INTERP 3S 25FT', 4.03, 'InterP',5);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('PERNO ALLEN CILINDRICO 8X30MM', 1.19, 'Allen',20);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('BROCA ALLEN 1/4 PARA METAL', 1.25, 'Allen',4);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('BROCA ALLEN 3/16 PARA METAL', 1.25, 'Allen',4);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('BROCA ALLEN 1/8 PARA METAL', 1.25, 'Allen',4);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('ALDABA INDURA DORADA PORTACANDADO 3 1/2"', 1.50, 'Indura',12);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('ALDABA INDURA DORADA PORTACANDADO 4"', 1.55, 'Indura',12);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('LLAVE FV PARA DUCHA', 2.25, 'Capri',16);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('BROCA 1/8 IRWIN PARA METAL', 1.40, 'Irwin',30);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('PERNO ALLEN 5X40MM', 1.00, 'Allen',100);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('PINTURA UNICOLATEX MANDARINA EN GI', 2.55, 'Unicolatex',6);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('PINTURA SPRAY ADHEPLAST VIOLETA OS 6024', 1.025, 'Adheplast',3);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('DADO TOLSEN HEXAGONAL MANDO 1/2 12MM', 0.85, 'Tolsen',3);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('PERNOS A/I 5/16 CON TUERCAS', 0.42, 'Desconocido',24);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('LLAVE COMBINADA MIXTA 13', 0.32, 'Desconocido',12);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('CINTA TEFLON PAOLO 3/4 X 15 MTS', 1.18, 'Paolo',10);
INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES ('FOCO VELA E-14 TRANSPARENTE', 0.26, 'Desconocido',25);
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
INSERT INTO `mydb`.`Factura` (`numFactura`, `cedulaEmpleado`, `cedula`, `fecha`) VALUES (000000001, '0951600897', '0991475627', '2019/09/19');
INSERT INTO `mydb`.`Factura` (`numFactura`, `cedulaEmpleado`, `cedula`, `fecha`) VALUES (000000002, '0951600897', '0991475627', '2019/09/07');
INSERT INTO `mydb`.`Factura` (`numFactura`, `cedulaEmpleado`, `cedula`, `fecha`) VALUES (000000003, '0924691127', '0951658897', '2019/10/21');

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
INSERT INTO `mydb`.`Proveedor` (`Nombre`, `Telefono`, `Ruc`) VALUES ('Mafelesa', DEFAULT, '0000000000001');
INSERT INTO `mydb`.`Proveedor` (`Nombre`, `Telefono`, `Ruc`) VALUES ('Tolsen', DEFAULT, '0000000000002');
INSERT INTO `mydb`.`Proveedor` (`Nombre`, `Telefono`, `Ruc`) VALUES ('Promafer', DEFAULT, '0000000000003');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Compra_Proveedor`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`CompraProveedor` (`numFactura`, `Fecha`, `ruc`, `cedulaEmpleado`) VALUES ('000000001', '2019/09/07', '0000000000001', '0951600897');
INSERT INTO `mydb`.`CompraProveedor` (`numFactura`, `Fecha`, `ruc`, `cedulaEmpleado`) VALUES ('000000002', '2019/09/06', '0000000000003', '0951600897');
INSERT INTO `mydb`.`CompraProveedor` (`numFactura`, `Fecha`, `ruc`, `cedulaEmpleado`) VALUES ('000000003', '2019/09/08', '0000000000002', '0924691127');

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