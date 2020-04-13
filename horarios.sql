-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 13, 2020 at 01:22 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `horarios`
--

-- --------------------------------------------------------

--
-- Table structure for table `aula`
--

CREATE TABLE `aula` (
  `claveaula` varchar(10) NOT NULL,
  `tipo` varchar(30) NOT NULL,
  `Edificio` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `aula`
--

INSERT INTO `aula` (`claveaula`, `tipo`, `Edificio`) VALUES
('12', 'aula', 'A');

-- --------------------------------------------------------

--
-- Table structure for table `carrera`
--

CREATE TABLE `carrera` (
  `idcarrera` tinyint(4) NOT NULL,
  `nombre_carrera` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `carrera`
--

INSERT INTO `carrera` (`idcarrera`, `nombre_carrera`) VALUES
(1, 'Ingeniería en Tecnologías de la Información'),
(2, 'Ingeniería en Mecatrónica'),
(3, 'Ingeniería en Sistemas Automotrices'),
(4, 'Ingeniería en Manufactura'),
(5, 'Licenciatura en Administración y Gestión de PyMEs'),
(6, 'Manejando bien rapido');

-- --------------------------------------------------------

--
-- Table structure for table `disponibilidad`
--

CREATE TABLE `disponibilidad` (
  `dia` tinyint(4) NOT NULL DEFAULT 1 CHECK (`dia` in (1,2,3,4,5,6)),
  `espacio_tiempo` tinyint(4) NOT NULL CHECK (`espacio_tiempo` in (1,2,3,4,5,6,7,8,9,10,11,12,13,14)),
  `clv_usuario` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `materias`
--

CREATE TABLE `materias` (
  `clv_materia` varchar(10) NOT NULL,
  `nombre_materia` varchar(50) NOT NULL,
  `creditos` tinyint(4) DEFAULT NULL,
  `cuatrimestre` tinyint(4) NOT NULL,
  `posicion` tinyint(4) NOT NULL,
  `clv_plan` varchar(10) NOT NULL,
  `tipo_materia` char(3) NOT NULL DEFAULT 'ESP' CHECK (`tipo_materia` in ('ESP','TRC','CIB'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `materias`
--

INSERT INTO `materias` (`clv_materia`, `nombre_materia`, `creditos`, `cuatrimestre`, `posicion`, `clv_plan`, `tipo_materia`) VALUES
('123', 'Valores2', 5, 1, 3, 'iti-2010', 'ESP');

-- --------------------------------------------------------

--
-- Table structure for table `materia_usuario`
--

CREATE TABLE `materia_usuario` (
  `clv_materia` varchar(10) NOT NULL,
  `clv_plan` varchar(10) NOT NULL,
  `clv_usuario` varchar(50) NOT NULL,
  `puntos_confianza` tinyint(4) DEFAULT 0,
  `puntos_director` tinyint(4) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `plan_estudios`
--

CREATE TABLE `plan_estudios` (
  `clv_plan` varchar(10) NOT NULL,
  `nombre_plan` varchar(45) NOT NULL,
  `nivel` varchar(3) NOT NULL DEFAULT 'ING' CHECK (`nivel` in ('ING','LIC','PA','MI')),
  `idcarrera` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `plan_estudios`
--

INSERT INTO `plan_estudios` (`clv_plan`, `nombre_plan`, `nivel`, `idcarrera`) VALUES
('iti-2010', 'Ingenierío en Tecnologías de la Información', 'ING', 1),
('ITI-420', 'mamadas', 'ING', 3),
('PAR-2010', 'Profesional Asociado en redes y programación', 'PA', 1);

-- --------------------------------------------------------

--
-- Table structure for table `profesores`
--

CREATE TABLE `profesores` (
  `claveprofe` varchar(30) NOT NULL,
  `estudios` varchar(30) NOT NULL,
  `nombre` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `profesores`
--

INSERT INTO `profesores` (`claveprofe`, `estudios`, `nombre`) VALUES
('32', 'Muchos', 'Ramiro Trozo');

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `clv_usuario` varchar(50) NOT NULL,
  `pass_usuario` char(41) NOT NULL,
  `tipo_usuario` char(4) NOT NULL DEFAULT 'PROF' CHECK (`tipo_usuario` in ('PROF','ADMI','DIRE')),
  `idcarrera` tinyint(4) NOT NULL,
  `nombre_usuario` varchar(50) NOT NULL,
  `nivel_ads` varchar(5) NOT NULL DEFAULT 'Ing.' CHECK (`nivel_ads` in ('Dr.','M.C','Ing.','Lic.')),
  `contrato` varchar(3) NOT NULL DEFAULT 'PA' CHECK (`contrato` in ('PTC','PA'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`clv_usuario`, `pass_usuario`, `tipo_usuario`, `idcarrera`, `nombre_usuario`, `nivel_ads`, `contrato`) VALUES
('fake1@upv.edu.mx', '*226DE3B949531071E63CB43AD1A16EB9521EB0DF', 'PROF', 3, 'juan benancio', 'Lic.', 'PA'),
('mfloref@upv.edu.mx', '*A0621487AD1362296849869B72843CF4E2B96FAA', 'PROF', 1, 'Marina Flores', 'M.C', 'PA'),
('spolancom@upv.edu.mx', '*3F50515DDEE62F18A2B1CE3BE819CFB2F3C869F1', 'ADMI', 1, 'Said Polanco', 'Dr.', 'PTC'),
('yhernandezm@upv.edu.mx', '*C2103782757CDB9423F71C3884603496C807B9B9', 'DIRE', 2, 'Yahir Hernandez', 'Dr.', 'PTC');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aula`
--
ALTER TABLE `aula`
  ADD PRIMARY KEY (`claveaula`);

--
-- Indexes for table `carrera`
--
ALTER TABLE `carrera`
  ADD PRIMARY KEY (`idcarrera`);

--
-- Indexes for table `disponibilidad`
--
ALTER TABLE `disponibilidad`
  ADD KEY `usuarios_disponibilidad_FK` (`clv_usuario`);

--
-- Indexes for table `materias`
--
ALTER TABLE `materias`
  ADD PRIMARY KEY (`clv_plan`,`clv_materia`);

--
-- Indexes for table `materia_usuario`
--
ALTER TABLE `materia_usuario`
  ADD PRIMARY KEY (`clv_plan`,`clv_materia`,`clv_usuario`),
  ADD KEY `usuario_materiaUsuario_FK` (`clv_usuario`);

--
-- Indexes for table `plan_estudios`
--
ALTER TABLE `plan_estudios`
  ADD PRIMARY KEY (`clv_plan`),
  ADD KEY `carrera_planEstudios_FK` (`idcarrera`);

--
-- Indexes for table `profesores`
--
ALTER TABLE `profesores`
  ADD PRIMARY KEY (`claveprofe`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`clv_usuario`),
  ADD KEY `carrera_usuario_FK` (`idcarrera`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `carrera`
--
ALTER TABLE `carrera`
  MODIFY `idcarrera` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `disponibilidad`
--
ALTER TABLE `disponibilidad`
  ADD CONSTRAINT `usuarios_disponibilidad_FK` FOREIGN KEY (`clv_usuario`) REFERENCES `usuarios` (`clv_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `materias`
--
ALTER TABLE `materias`
  ADD CONSTRAINT `planEstudios_materia_FK` FOREIGN KEY (`clv_plan`) REFERENCES `plan_estudios` (`clv_plan`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `materia_usuario`
--
ALTER TABLE `materia_usuario`
  ADD CONSTRAINT `materia_materiaUsiario_FK` FOREIGN KEY (`clv_plan`,`clv_materia`) REFERENCES `materias` (`clv_plan`, `clv_materia`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `usuario_materiaUsuario_FK` FOREIGN KEY (`clv_usuario`) REFERENCES `usuarios` (`clv_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `plan_estudios`
--
ALTER TABLE `plan_estudios`
  ADD CONSTRAINT `carrera_planEstudios_FK` FOREIGN KEY (`idcarrera`) REFERENCES `carrera` (`idcarrera`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `carrera_usuario_FK` FOREIGN KEY (`idcarrera`) REFERENCES `carrera` (`idcarrera`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
