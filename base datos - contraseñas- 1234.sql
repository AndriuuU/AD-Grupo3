-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-01-2023 a las 21:58:41
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestioncursos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administradores`
--

CREATE TABLE `administradores` (
  `id_administrador` int(11) NOT NULL,
  `password` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `usuario` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `administradores`
--

INSERT INTO `administradores` (`id_administrador`, `password`, `usuario`) VALUES
(1, '1234', 'admin@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `id_alumno` int(11) NOT NULL,
  `apellidos` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `foto` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `id_usuario` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`id_alumno`, `apellidos`, `email`, `foto`, `nombre`, `password`, `id_usuario`) VALUES
(36, 'alumno1', 'alumno1@gmail.com', NULL, 'alumno1', '$2a$10$fOAxhJOz4tSj5kGH7h4L7.OuD2PtVMCQj6mNtZqIZ4qZn86yk6kJK', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentarios`
--

CREATE TABLE `comentarios` (
  `id_comentarios` int(11) NOT NULL,
  `comentario` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `alumno_id` int(11) DEFAULT NULL,
  `curso_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `comentarios`
--

INSERT INTO `comentarios` (`id_comentarios`, `comentario`, `alumno_id`, `curso_id`) VALUES
(41, 'No esta mal', 36, 30),
(42, 'A la espera que de empezar el curso con ganas', 36, 31);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE `cursos` (
  `id_curso` int(11) NOT NULL,
  `descripcion` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha_fin` datetime DEFAULT NULL,
  `fecha_inicio` datetime DEFAULT NULL,
  `nivel` int(11) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `profesor_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cursos`
--

INSERT INTO `cursos` (`id_curso`, `descripcion`, `fecha_fin`, `fecha_inicio`, `nivel`, `nombre`, `profesor_id`) VALUES
(30, 'programacion terminada', '2023-01-18 23:00:00', '2022-12-31 23:00:00', 9, 'programacion0', 1),
(29, 'para programar', '2023-01-19 23:00:00', '2022-12-31 23:00:00', 10, 'programacion', 1),
(31, 'programacion para dar', '2023-04-07 22:00:00', '2023-02-15 23:00:00', 10, 'programacion3', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(43);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `matricula`
--

CREATE TABLE `matricula` (
  `id_matricula` int(11) NOT NULL,
  `valoracion` float NOT NULL,
  `alumno_id` int(11) DEFAULT NULL,
  `curso_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `matricula`
--

INSERT INTO `matricula` (`id_matricula`, `valoracion`, `alumno_id`, `curso_id`) VALUES
(38, 9.5, 36, 30),
(39, 0, 36, 29),
(40, 0, 36, 31);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `noticias`
--

CREATE TABLE `noticias` (
  `id_noticias` int(11) NOT NULL,
  `descripcion` text COLLATE utf8_spanish_ci DEFAULT NULL,
  `imagen` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `titulo` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `administrador_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `noticias`
--

INSERT INTO `noticias` (`id_noticias`, `descripcion`, `imagen`, `titulo`, `administrador_id`) VALUES
(35, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Donec ac odio tempor orci dapibus ultrices in iaculis. Egestas erat imperdiet sed euismod nisi. A erat nam at lectus urna duis. Aliquam sem fringilla ut morbi tincidunt augue interdum velit euismod. Tincidunt nunc pulvinar sapien et. Consequat nisl vel pretium lectus quam id leo in. Eget sit amet tellus cras adipiscing enim eu turpis. Nibh praesent tristique magna sit amet purus gravida. Diam quis enim lobortis scelerisque fermentum dui faucibus in. Cursus mattis molestie a iaculis at erat pellentesque adipiscing commodo. Eget gravida cum sociis natoque penatibus. Posuere morbi leo urna molestie. Habitant morbi tristique senectus et. Cursus risus at ultrices mi tempus imperdiet nulla. Amet venenatis urna cursus eget nunc scelerisque. Aliquam vestibulum morbi blandit cursus risus at. Quam nulla porttitor massa id neque aliquam vestibulum morbi blandit. Bibendum at varius vel pharetra vel turpis nunc eget lorem.  A diam maecenas sed enim ut sem viverra aliquet eget. Habitant morbi tristique senectus et netus. Id aliquet risus feugiat in ante metus dictum at. In hendrerit gravida rutrum quisque non. Senectus et netus et malesuada fames. Massa placerat duis ultricies lacus sed turpis tincidunt. Bibendum neque egestas congue quisque egestas diam in arcu cursus. Et malesuada fames ac turpis egestas maecenas. Hac habitasse platea dictumst vestibulum rhoncus. Ut tortor pretium viverra suspendisse potenti nullam. Sit amet porttitor eget dolor morbi non arcu risus. Massa eget egestas purus viverra accumsan in nisl nisi scelerisque. Fermentum posuere urna nec tincidunt praesent semper feugiat nibh. Morbi tincidunt augue interdum velit. Augue interdum velit euismod in pellentesque. Duis at consectetur lorem donec massa. Euismod nisi porta lorem mollis.  Elementum integer enim neque volutpat ac. A condimentum vitae sapien pellentesque habitant morbi. Nisl purus in mollis nunc sed. Sed risus pretium quam vulputate dignissim suspendisse in. Aliquam vestibulum morbi blandit cursus risus. Dolor sit amet consectetur adipiscing. Suspendisse in est ante in nibh mauris cursus mattis molestie. Metus dictum at tempor commodo ullamcorper. In hac habitasse platea dictumst vestibulum. Sapien faucibus et molestie ac. Eget nulla facilisi etiam dignissim. Etiam sit amet nisl purus in mollis. Orci sagittis eu volutpat odio facilisis mauris sit.  Quam quisque id diam vel quam. Mi ipsum faucibus vitae aliquet nec. Augue eget arcu dictum varius duis at consectetur. Sed risus ultricies tristique nulla aliquet enim. In pellentesque massa placerat duis ultricies lacus sed turpis tincidunt. Enim eu turpis egestas pretium aenean pharetra magna ac. Nisl nisi scelerisque eu ultrices vitae. Id faucibus nisl tincidunt eget nullam non nisi est. Euismod quis viverra nibh cras pulvinar mattis. Aliquet bibendum enim facilisis gravida neque convallis a cras semper. Morbi tristique senectus et netus et malesuada fames ac turpis.  At ultrices mi tempus imperdiet nulla malesuada pellentesque elit. Rhoncus dolor purus non enim praesent elementum facilisis leo. Volutpat sed cras ornare arcu dui vivamus. Egestas sed tempus urna et pharetra pharetra massa massa. Morbi tristique senectus et netus. Tortor at risus viverra adipiscing. Sed felis eget velit aliquet sagittis id consectetur purus. Egestas purus viverra accumsan in nisl nisi scelerisque eu ultrices. Enim blandit volutpat maecenas volutpat. Magna ac placerat vestibulum lectus mauris ultrices eros in. Maecenas accumsan lacus vel facilisis. Euismod quis viverra nibh cras pulvinar mattis nunc sed. Pellentesque sit amet porttitor eget dolor morbi non arcu. A pellentesque sit amet porttitor eget dolor morbi non arcu. Elementum eu facilisis sed odio morbi quis commodo odio aenean.', 'Noticia 2.png', 'Noticia 2', NULL),
(34, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Pellentesque diam volutpat commodo sed egestas egestas fringilla. Mi eget mauris pharetra et ultrices neque ornare. Ut consequat semper viverra nam libero justo laoreet sit amet. Tincidunt ornare massa eget egestas purus viverra accumsan in. Aliquam purus sit amet luctus. Lobortis mattis aliquam faucibus purus in massa tempor nec feugiat. Lectus sit amet est placerat in egestas. Aliquam vestibulum morbi blandit cursus risus at. Amet mattis vulputate enim nulla. Nunc sed id semper risus in hendrerit gravida. Velit dignissim sodales ut eu. Feugiat scelerisque varius morbi enim.  Diam donec adipiscing tristique risus. Curabitur vitae nunc sed velit dignissim sodales ut eu. Pretium viverra suspendisse potenti nullam ac tortor vitae purus. Aliquam eleifend mi in nulla posuere. Volutpat lacus laoreet non curabitur gravida arcu ac tortor. Pellentesque elit eget gravida cum. Natoque penatibus et magnis dis parturient montes nascetur ridiculus mus. Sagittis eu volutpat odio facilisis. Risus quis varius quam quisque id diam vel. Viverra justo nec ultrices dui sapien. Nulla pellentesque dignissim enim sit amet venenatis urna cursus eget. Lorem ipsum dolor sit amet. Rhoncus est pellentesque elit ullamcorper dignissim cras. Nunc eget lorem dolor sed viverra ipsum nunc. Viverra mauris in aliquam sem. Tellus pellentesque eu tincidunt tortor aliquam nulla facilisi cras.  Purus semper eget duis at tellus at urna condimentum mattis. Nulla aliquet enim tortor at auctor urna nunc id. Sagittis vitae et leo duis ut diam quam nulla porttitor. Congue quisque egestas diam in arcu cursus euismod quis viverra. Ultricies leo integer malesuada nunc. Nisl suscipit adipiscing bibendum est ultricies. Nunc mattis enim ut tellus elementum sagittis. In nibh mauris cursus mattis molestie a iaculis at erat. Sit amet commodo nulla facilisi nullam vehicula ipsum a arcu. Dui accumsan sit amet nulla facilisi morbi tempus iaculis urna. Libero nunc consequat interdum varius sit amet. Tortor aliquam nulla facilisi cras fermentum odio eu. Donec et odio pellentesque diam volutpat commodo sed egestas.  Euismod elementum nisi quis eleifend quam adipiscing vitae. Ut ornare lectus sit amet est. Ut aliquam purus sit amet. Vitae sapien pellentesque habitant morbi. Porta nibh venenatis cras sed felis eget velit aliquet. Mauris sit amet massa vitae. Sed vulputate odio ut enim blandit volutpat maecenas volutpat blandit. Vitae elementum curabitur vitae nunc sed velit dignissim sodales ut. Id aliquet lectus proin nibh nisl condimentum id venenatis. Sodales neque sodales ut etiam sit amet. Scelerisque in dictum non consectetur a. Orci sagittis eu volutpat odio facilisis. Laoreet suspendisse interdum consectetur libero id faucibus nisl tincidunt eget. Facilisis leo vel fringilla est ullamcorper eget nulla facilisi. Quam id leo in vitae turpis massa sed. Tellus cras adipiscing enim eu turpis egestas. Risus quis varius quam quisque id diam. Egestas sed tempus urna et pharetra pharetra. Enim nunc faucibus a pellentesque.  Ante metus dictum at tempor commodo ullamcorper. Cursus eget nunc scelerisque viverra. Magna fringilla urna porttitor rhoncus. Eros donec ac odio tempor orci. Ante metus dictum at tempor. Tellus orci ac auctor augue mauris augue neque gravida in. Aliquam malesuada bibendum arcu vitae elementum curabitur vitae. Suspendisse faucibus interdum posuere lorem ipsum dolor sit amet. Ultrices in iaculis nunc sed augue. Montes nascetur ridiculus mus mauris. Egestas erat imperdiet sed euismod nisi. Risus in hendrerit gravida rutrum quisque non. Diam vulputate ut pharetra sit amet aliquam. In hendrerit gravida rutrum quisque non tellus. Mauris pellentesque pulvinar pellentesque habitant morbi. Nec ultrices dui sapien eget mi. Massa placerat duis ultricies lacus sed.', 'Noticia 1.png', 'Noticia 1', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesores`
--

CREATE TABLE `profesores` (
  `id_profesor` int(11) NOT NULL,
  `apellidos` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `id_usuario` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `profesores`
--

INSERT INTO `profesores` (`id_profesor`, `apellidos`, `email`, `nombre`, `password`, `id_usuario`) VALUES
(1, 'programador', 'programador1@gmail.com', 'profesorprogramador', '$2a$10$9gLHD2gJjCfuE61okWSBbe5MStwSBg5eyXKuxSL0MVFkyU5oud/aC', NULL),
(2, 'basededatador', 'basedatos@gmail.com', 'profesorbasedatador', '$2a$10$9gLHD2gJjCfuE61okWSBbe5MStwSBg5eyXKuxSL0MVFkyU5oud/aC', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `role` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `enabled`, `password`, `role`, `username`) VALUES
(10, b'0', '$2a$10$9gLHD2gJjCfuE61okWSBbe5MStwSBg5eyXKuxSL0MVFkyU5oud/aC', 'ROL_ADMIN', 'admin@gmail.com'),
(90, b'1', '$2a$10$9gLHD2gJjCfuE61okWSBbe5MStwSBg5eyXKuxSL0MVFkyU5oud/aC', 'ROL_PROFESOR', 'programador1@gmail.com'),
(37, b'0', '$2a$10$i6U/43q8nLhzB3i/3LLdcOXWhEx6cympw2lcVCMMoKsDsP2XKVZK6', 'ROL_ALUMNO', 'alumno1@gmail.com');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administradores`
--
ALTER TABLE `administradores`
  ADD PRIMARY KEY (`id_administrador`);

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`id_alumno`),
  ADD KEY `FK9ouf6d7l8xrfgel7mrcn7hfn4` (`id_usuario`);

--
-- Indices de la tabla `comentarios`
--
ALTER TABLE `comentarios`
  ADD PRIMARY KEY (`id_comentarios`),
  ADD KEY `FKiuhescqt1socaycyb2m2ked68` (`alumno_id`),
  ADD KEY `FKefxm6b3vs7awj0pvtk23cjhj1` (`curso_id`);

--
-- Indices de la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD PRIMARY KEY (`id_curso`),
  ADD KEY `FK6sw8s0sluxsy2mbwu9yk9ko2g` (`profesor_id`);

--
-- Indices de la tabla `matricula`
--
ALTER TABLE `matricula`
  ADD PRIMARY KEY (`id_matricula`),
  ADD KEY `FKjy2pbif3rjao9972v4cldils6` (`alumno_id`),
  ADD KEY `FK2cv670h6q6fsjio1nedtq82h2` (`curso_id`);

--
-- Indices de la tabla `noticias`
--
ALTER TABLE `noticias`
  ADD PRIMARY KEY (`id_noticias`),
  ADD KEY `FKhwxhsl06ufy5crk2ae53tp42r` (`administrador_id`);

--
-- Indices de la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD PRIMARY KEY (`id_profesor`),
  ADD KEY `FKgs892siaqu267ij5epmpfkm7r` (`id_usuario`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
