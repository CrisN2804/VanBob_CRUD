-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 20, 2023 at 07:36 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vanbob`
--

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `lealtad` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `nombre`, `lealtad`) VALUES
(1, 'MAQUINAKILL', 6),
(2, 'DIEMONTA', 33),
(3, 'JOLUIS', 1),
(4, 'GODOY CO', 3),
(5, 'HOARAVE', 4),
(6, 'FAGAMEX', 91),
(7, 'BIMBO', 17),
(8, 'NIEAHUS', 63),
(9, 'BRIMONTA', 13),
(10, 'GROHL ENTERPRISES', 22),
(11, 'MichEnterprises', 8),
(12, 'Pohls', 39),
(14, 'BËR', 96),
(15, 'YO', 99);

-- --------------------------------------------------------

--
-- Table structure for table `contacto`
--

CREATE TABLE `contacto` (
  `id_contacto` int(11) NOT NULL,
  `id_empleado` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `contacto`
--

INSERT INTO `contacto` (`id_contacto`, `id_empleado`, `id_cliente`) VALUES
(1, 5, 10),
(2, 5, 9),
(3, 5, 8),
(4, 3, 7),
(5, 5, 6),
(6, 1, 5),
(7, 2, 4),
(8, 4, 3),
(9, 2, 2),
(10, 3, 1),
(11, 10, 14),
(12, 10, 12),
(13, 10, 15);

-- --------------------------------------------------------

--
-- Table structure for table `departamento`
--

CREATE TABLE `departamento` (
  `id_depa` int(11) NOT NULL,
  `depa` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `departamento`
--

INSERT INTO `departamento` (`id_depa`, `depa`) VALUES
(1, 'Produccion'),
(2, 'Logistica'),
(3, 'Administracion'),
(4, 'HR'),
(5, 'Almacen'),
(6, 'Contadores'),
(7, 'Calidad'),
(8, 'Compras'),
(9, 'Ventas'),
(10, 'Atencion cliente'),
(11, 'Programacion'),
(12, 'NewYorkers'),
(13, 'AbuelitaMaldita'),
(14, 'CocoChat'),
(15, 'Juventus'),
(16, 'Maruchan'),
(17, 'Chips Fuego Crujientes'),
(18, 'CastigoNal'),
(19, 'Dinosaurios'),
(20, 'PinkFloyd'),
(21, 'The Wall'),
(22, 'Dark Side of The Moon'),
(23, 'Animals'),
(24, 'The Division Bell'),
(25, 'Final Cut'),
(26, 'Wish You Were Here'),
(27, 'PULSE'),
(28, 'Piper at Gates of Dawn'),
(29, 'The Killers'),
(30, 'Hot Fuss'),
(31, 'Sam\'s Town'),
(32, 'Sawdust'),
(33, 'Day&Age'),
(34, 'Battle Born'),
(35, 'Wonderful Wonderful'),
(36, 'Imploding The Mirage'),
(37, 'Pressure Machine');

-- --------------------------------------------------------

--
-- Table structure for table `empleado`
--

CREATE TABLE `empleado` (
  `id_empleado` int(11) NOT NULL,
  `id_depa` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `ape` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `empleado`
--

INSERT INTO `empleado` (`id_empleado`, `id_depa`, `nombre`, `ape`) VALUES
(1, 9, 'Juan', 'Niehus'),
(2, 9, 'Rosy', 'Hernandez'),
(3, 9, 'Pablo', 'Gonzalez'),
(4, 9, 'Matias', 'Mesi'),
(5, 10, 'Humberto', 'Arana'),
(10, 3, 'Michelle', 'Garcia');

-- --------------------------------------------------------

--
-- Stand-in structure for view `empleadodepartamento`
-- (See below for the actual view)
--
CREATE TABLE `empleadodepartamento` (
`id_empleado` int(11)
,`nombre` varchar(30)
,`ape` varchar(30)
,`depa` varchar(40)
);

-- --------------------------------------------------------

--
-- Table structure for table `ordena`
--

CREATE TABLE `ordena` (
  `id_orden` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `orden` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ordena`
--

INSERT INTO `ordena` (`id_orden`, `id_cliente`, `id_producto`, `orden`) VALUES
(1, 1, 1, 90000),
(2, 1, 6, 46555),
(3, 3, 3, 16844),
(4, 5, 4, 61887),
(5, 5, 3, 61873),
(6, 5, 8, 1643),
(7, 7, 2, 984136),
(8, 8, 10, 16576),
(9, 8, 1, 1354),
(10, 10, 5, 9413),
(11, 14, 7, 943);

-- --------------------------------------------------------

--
-- Stand-in structure for view `ordenes`
-- (See below for the actual view)
--
CREATE TABLE `ordenes` (
`ID` int(11)
,`Producto` varchar(30)
,`Cliente` varchar(40)
,`Orden` bigint(20)
);

-- --------------------------------------------------------

--
-- Table structure for table `producto`
--

CREATE TABLE `producto` (
  `id_producto` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `existentes` bigint(20) NOT NULL DEFAULT 0,
  `produciendo` bigint(20) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `producto`
--

INSERT INTO `producto` (`id_producto`, `nombre`, `existentes`, `produciendo`) VALUES
(1, 'Molde Gansito', 19873, 1650),
(2, 'Molde Pinguino', 19810, 5000),
(3, 'Molde Kinder', 9100, 0),
(4, 'Molde Lechugas', 8520, 9450),
(5, 'Molde Chocorol', 9510, 3250),
(6, 'Molde CartuchoHP', 0, 13000),
(7, 'Empaque MaxSteel', 50, 9400),
(8, 'Empaque AlbumTIPO1', 25000, 9435),
(9, 'Empaque Pluma', 100000, 50000),
(10, 'Plastico Computadora', 900, 96800);

-- --------------------------------------------------------

--
-- Stand-in structure for view `relaciones`
-- (See below for the actual view)
--
CREATE TABLE `relaciones` (
`ID` int(11)
,`Empleado` varchar(30)
,`Cliente` varchar(40)
);

-- --------------------------------------------------------

--
-- Structure for view `empleadodepartamento`
--
DROP TABLE IF EXISTS `empleadodepartamento`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `empleadodepartamento`  AS SELECT `e`.`id_empleado` AS `id_empleado`, `e`.`nombre` AS `nombre`, `e`.`ape` AS `ape`, `d`.`depa` AS `depa` FROM (`empleado` `e` join `departamento` `d` on(`e`.`id_depa` = `d`.`id_depa`)) ;

-- --------------------------------------------------------

--
-- Structure for view `ordenes`
--
DROP TABLE IF EXISTS `ordenes`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `ordenes`  AS SELECT `ordena`.`id_orden` AS `ID`, `producto`.`nombre` AS `Producto`, `cliente`.`nombre` AS `Cliente`, `ordena`.`orden` AS `Orden` FROM ((`ordena` join `producto` on(`ordena`.`id_producto` = `producto`.`id_producto`)) join `cliente` on(`ordena`.`id_cliente` = `cliente`.`id_cliente`)) ;

-- --------------------------------------------------------

--
-- Structure for view `relaciones`
--
DROP TABLE IF EXISTS `relaciones`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `relaciones`  AS SELECT `contacto`.`id_contacto` AS `ID`, `empleado`.`nombre` AS `Empleado`, `cliente`.`nombre` AS `Cliente` FROM ((`contacto` join `empleado` on(`contacto`.`id_empleado` = `empleado`.`id_empleado`)) join `cliente` on(`contacto`.`id_cliente` = `cliente`.`id_cliente`)) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indexes for table `contacto`
--
ALTER TABLE `contacto`
  ADD PRIMARY KEY (`id_contacto`),
  ADD KEY `id_empleado` (`id_empleado`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Indexes for table `departamento`
--
ALTER TABLE `departamento`
  ADD PRIMARY KEY (`id_depa`);

--
-- Indexes for table `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`id_empleado`),
  ADD KEY `id_depa` (`id_depa`);

--
-- Indexes for table `ordena`
--
ALTER TABLE `ordena`
  ADD PRIMARY KEY (`id_orden`),
  ADD KEY `id_producto` (`id_producto`),
  ADD KEY `ordena_ibfk_3` (`id_cliente`);

--
-- Indexes for table `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id_producto`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `contacto`
--
ALTER TABLE `contacto`
  MODIFY `id_contacto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `departamento`
--
ALTER TABLE `departamento`
  MODIFY `id_depa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `empleado`
--
ALTER TABLE `empleado`
  MODIFY `id_empleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `ordena`
--
ALTER TABLE `ordena`
  MODIFY `id_orden` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `producto`
--
ALTER TABLE `producto`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `contacto`
--
ALTER TABLE `contacto`
  ADD CONSTRAINT `contacto_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`),
  ADD CONSTRAINT `contacto_ibfk_3` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`);

--
-- Constraints for table `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`id_depa`) REFERENCES `departamento` (`id_depa`);

--
-- Constraints for table `ordena`
--
ALTER TABLE `ordena`
  ADD CONSTRAINT `ordena_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`),
  ADD CONSTRAINT `ordena_ibfk_3` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
