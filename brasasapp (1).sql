-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-05-2025 a las 14:42:31
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `brasasapp`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `Nombre` varchar(30) NOT NULL,
  `ID_mesa` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Primer_apellido` varchar(50) NOT NULL,
  `Segundo_apellido` varchar(50) NOT NULL,
  `Edad` int(2) NOT NULL,
  `Sexo` varchar(50) NOT NULL,
  `Fecha_entrada` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`Id`, `Nombre`, `Primer_apellido`, `Segundo_apellido`, `Edad`, `Sexo`, `Fecha_entrada`) VALUES
(14, 'Ivan', 'Sanchez', 'Juarez', 18, 'Hombre', '2025-05-20');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `ID_mesa` int(2) NOT NULL DEFAULT 1,
  `Gambas` int(2) NOT NULL,
  `Croquetas` int(2) NOT NULL,
  `Quesos` int(2) NOT NULL,
  `Ensaladilla` int(2) NOT NULL,
  `Patatas` int(2) NOT NULL,
  `Estado` varchar(30) NOT NULL DEFAULT 'Pendiente'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`ID_mesa`, `Gambas`, `Croquetas`, `Quesos`, `Ensaladilla`, `Patatas`, `Estado`) VALUES
(1, 0, 0, 0, 0, 0, 'Pendiente'),
(2, 0, 0, 0, 0, 0, 'Pendiente'),
(3, 0, 0, 0, 0, 0, 'Pendiente'),
(4, 0, 0, 0, 0, 0, 'Pendiente'),
(5, 3, 1, 1, 0, 2, 'Pendiente'),
(6, 3, 2, 4, 2, 3, 'Pendiente'),
(7, 1, 2, 3, 4, 5, 'Pendiente'),
(8, 0, 0, 0, 0, 0, 'Pendiente'),
(9, 0, 0, 0, 0, 0, 'Pendiente'),
(10, 3, 1, 0, 2, 1, 'Pendiente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Precio` decimal(4,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`Id`, `Nombre`, `Precio`) VALUES
(1, 'Plato de gambas', 7.50),
(2, 'Tabla de quesos', 10.00),
(18, 'Croquetas de Jamón', 4.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro`
--

CREATE TABLE `registro` (
  `Correo` varchar(50) NOT NULL,
  `Contraseña` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `registro`
--

INSERT INTO `registro` (`Correo`, `Contraseña`) VALUES
('admin@prueba.com', '1234'),
('Medac', 'Medac');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`ID_mesa`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD UNIQUE KEY `ID_mesa` (`ID_mesa`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
