-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-10-2018 a las 17:41:20
-- Versión del servidor: 10.1.30-MariaDB
-- Versión de PHP: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `paso3_aplicacion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `identificador` int(11) NOT NULL,
  `idpersona` int(11) DEFAULT NULL,
  `legajo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`identificador`, `idpersona`, `legajo`) VALUES
(1, 3, 121444),
(2, 4, 9213),
(3, 1, 4000),
(4, 5, 36299),
(5, 2, 11009),
(6, 11, 78457);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carrera`
--

CREATE TABLE `carrera` (
  `identificador` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `descripcion` varchar(250) DEFAULT NULL,
  `fechadesde` date NOT NULL,
  `fechahasta` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `carrera`
--

INSERT INTO `carrera` (`identificador`, `nombre`, `descripcion`, `fechadesde`, `fechahasta`) VALUES
(1, 'Ingenieria en sistema de información', 'Carrera a fines a programación y desarrollo de software en general', '1960-01-01', NULL),
(2, 'Ingenieria civil', 'Carrera a fines a construcción, planificación y desarrollo de obras de desarrollo urbano', '1980-01-01', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--

CREATE TABLE `curso` (
  `identificador` int(11) NOT NULL,
  `idcarrera` int(11) DEFAULT NULL,
  `iddocente` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `descripcion` varchar(250) DEFAULT NULL,
  `cupomaximo` smallint(6) NOT NULL,
  `anio` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `curso`
--

INSERT INTO `curso` (`identificador`, `idcarrera`, `iddocente`, `nombre`, `descripcion`, `cupomaximo`, `anio`) VALUES
(1, 1, 1, 'Análisis matemático', 'Curso sobre el desarrollo avanzado de matemáticas', 5, 2018),
(2, 1, 3, 'Diseño de sistemas', 'Curso sobre diseño de componentes de sistemas de software', 3, 2018),
(3, 1, 1, 'Java', 'Curso sobre el lenguaje de programación JAVA', 4, 2018),
(4, 1, 4, 'Base de datos-SQL', 'Curso sobre tipos de base de datos y consultas sql', 10, 2018),
(5, 2, 2, 'Fisica básica', 'Curso sobre fundamentos base de física', 5, 2018),
(6, 2, 2, 'Dibujo', 'Curso sobre dibujo de planos', 10, 2018);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `docente`
--

CREATE TABLE `docente` (
  `identificador` int(5) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `email` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `docente`
--

INSERT INTO `docente` (`identificador`, `nombre`, `apellido`, `email`) VALUES
(1, 'Gabriela', 'Sosa', 'gab_sosa@hotmail.com'),
(2, 'Franco', 'Gomez', 'frangomez@gmail.com'),
(3, 'Luis', 'Lopez', 'luis@222gmail.com'),
(4, 'Roxana', 'Leiva', 'rox_lei22@hotmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripciones_carrera`
--

CREATE TABLE `inscripciones_carrera` (
  `idalumno` int(11) DEFAULT NULL,
  `idcarrera` int(11) DEFAULT NULL,
  `fechainscripcion` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `inscripciones_carrera`
--

INSERT INTO `inscripciones_carrera` (`idalumno`, `idcarrera`, `fechainscripcion`) VALUES
(1, 1, '2000-01-01'),
(2, 1, '2003-01-01'),
(3, 1, '2004-01-01'),
(4, 1, '2001-01-01'),
(5, 2, '2000-01-01'),
(4, 2, '2000-01-01');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripciones_curso`
--

CREATE TABLE `inscripciones_curso` (
  `idalumno` int(11) DEFAULT NULL,
  `idcurso` int(11) DEFAULT NULL,
  `fechainscripcion` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `inscripciones_curso`
--

INSERT INTO `inscripciones_curso` (`idalumno`, `idcurso`, `fechainscripcion`) VALUES
(1, 1, '2002-01-01'),
(1, 2, '2006-01-01'),
(1, 3, '2002-01-01'),
(2, 1, '2004-01-01'),
(2, 3, '2002-01-01'),
(2, 4, '2004-01-01'),
(3, 1, '2010-01-01'),
(3, 3, '2010-01-01'),
(4, 1, '2010-01-01'),
(4, 3, '2010-01-01'),
(5, 3, '2010-01-01'),
(4, 3, '2010-01-01'),
(5, 4, '2011-01-01'),
(4, 4, '2011-01-01'),
(2, 5, '2011-01-01'),
(2, 6, '2011-01-01'),
(1, 1, '2018-10-03'),
(6, 6, '2018-10-04');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nota`
--

CREATE TABLE `nota` (
  `identificador` int(11) NOT NULL,
  `idcurso` int(5) NOT NULL,
  `idalumno` int(5) NOT NULL,
  `nota1` decimal(5,1) NOT NULL,
  `nota2` decimal(5,1) NOT NULL,
  `nota3` decimal(5,1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `nota`
--

INSERT INTO `nota` (`identificador`, `idcurso`, `idalumno`, `nota1`, `nota2`, `nota3`) VALUES
(1, 1, 1, '7.5', '9.0', '8.5'),
(2, 2, 1, '7.5', '9.0', '8.5'),
(3, 3, 1, '7.5', '9.0', '8.5'),
(4, 1, 2, '7.5', '9.0', '8.5'),
(5, 3, 2, '7.5', '9.0', '8.5'),
(6, 4, 2, '7.5', '9.0', '8.5'),
(7, 1, 3, '7.5', '9.0', '8.5'),
(8, 3, 3, '7.5', '9.0', '8.5'),
(9, 1, 4, '7.5', '9.0', '8.5'),
(10, 3, 4, '7.5', '9.0', '8.5'),
(11, 3, 5, '7.5', '9.0', '8.5'),
(12, 3, 4, '7.5', '9.0', '8.5'),
(13, 4, 5, '7.5', '9.0', '8.5'),
(14, 4, 4, '7.5', '9.0', '8.5'),
(15, 5, 2, '7.5', '9.0', '8.5'),
(16, 6, 2, '7.5', '9.0', '8.5'),
(17, 1, 1, '7.5', '9.0', '8.5'),
(18, 6, 6, '7.5', '9.0', '8.5');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `identificador` int(11) NOT NULL,
  `tipodoc` char(5) NOT NULL,
  `documento` bigint(20) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellido` varchar(40) NOT NULL,
  `fechanac` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`identificador`, `tipodoc`, `documento`, `nombre`, `apellido`, `fechanac`) VALUES
(1, 'DNI', 31565839, 'Florencia', 'Maneiro', '1985-06-28'),
(2, 'DNI', 31000123, 'Patricia', 'Brumatti', '1985-01-13'),
(3, 'LC', 12345, 'Damian', 'Coronel', '1982-04-11'),
(4, 'DNI', 30999281, 'Franzo', 'Perez', '1986-02-05'),
(5, 'DNI', 24112872, 'Leandro', 'Garcia', '1988-01-03'),
(6, 'DNI', 38818820, 'Emanuel', 'Samana', '1995-03-01'),
(7, 'LC', 123456, 'Jorge', 'Lopez', '2000-03-02'),
(8, 'LC', 444555666, 'Anibal', 'Ramirez', '1995-03-04'),
(9, 'DNI', 5557744, 'Roberto Fernando', 'Lopez', '1995-03-04'),
(10, 'DNI', 123456, 'Rodolfo', 'Corredera', '1995-03-04'),
(11, 'DNI', 554545, 'Jorge', 'Herrera', '1995-03-04');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`identificador`);

--
-- Indices de la tabla `carrera`
--
ALTER TABLE `carrera`
  ADD PRIMARY KEY (`identificador`);

--
-- Indices de la tabla `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`identificador`);

--
-- Indices de la tabla `docente`
--
ALTER TABLE `docente`
  ADD PRIMARY KEY (`identificador`);

--
-- Indices de la tabla `nota`
--
ALTER TABLE `nota`
  ADD PRIMARY KEY (`identificador`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`identificador`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `identificador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `docente`
--
ALTER TABLE `docente`
  MODIFY `identificador` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `nota`
--
ALTER TABLE `nota`
  MODIFY `identificador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `identificador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
