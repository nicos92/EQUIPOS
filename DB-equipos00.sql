-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: equipos_de_futbol
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `directores_tecnicos`
--

DROP TABLE IF EXISTS `directores_tecnicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `directores_tecnicos` (
  `idDirector` int NOT NULL,
  `nombreYapellido` varchar(45) NOT NULL,
  `equipo_idEquipo` int NOT NULL,
  PRIMARY KEY (`idDirector`),
  UNIQUE KEY `idDirector_UNIQUE` (`idDirector`),
  KEY `fk_directores_tecnicos_equipo1_idx` (`equipo_idEquipo`),
  CONSTRAINT `fk_directores_tecnicos_equipo1` FOREIGN KEY (`equipo_idEquipo`) REFERENCES `equipo` (`idEquipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `directores_tecnicos`
--

LOCK TABLES `directores_tecnicos` WRITE;
/*!40000 ALTER TABLE `directores_tecnicos` DISABLE KEYS */;
INSERT INTO `directores_tecnicos` VALUES (1,'Gabriel Milito',1),(2,'Moncho Ruiz',2),(3,'Pusineri',3),(4,'Claudio Vivas',4),(5,'Rodolfo de Paoli',5),(6,'Guillermo Farre',6),(7,'Hugo ibarra',7),(8,'Leonardo Madelon',8),(9,'Marcelo Saralegui',9),(10,'Jorge García',10),(11,'Eduardo Domínguez',11),(12,'Néstor Gorosito',12),(13,'Diego Flores',13),(14,'Pipo Rossi',14),(15,'Leandro Stillitano',15),(16,'Lucas Bovaglio',16),(17,'Frank Darío',17),(18,'Juan Carlos Montes',18),(19,'Omar De Felippe',19),(20,'Fernando Gago',20),(21,'Martín Demichelis',21),(22,'Miguel Ángel Russo',22),(23,'Rubén Darío Insua',23),(24,'Martín Funes',24),(25,'Javier Gandolfi',25),(26,'Diego Martínez',26),(27,'Sebastián Méndez ',27),(28,'Alexander Medina',28);
/*!40000 ALTER TABLE `directores_tecnicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipo`
--

DROP TABLE IF EXISTS `equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipo` (
  `idEquipo` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idEquipo`),
  UNIQUE KEY `idEquipo_UNIQUE` (`idEquipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipo`
--

LOCK TABLES `equipo` WRITE;
/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
INSERT INTO `equipo` VALUES (1,'Argentinos Junios'),(2,'Arsenal de Sarandi'),(3,'Atletico Tucuman'),(4,'Banfield'),(5,'Barracas Central'),(6,'Belgrano'),(7,'Boca Juniors'),(8,'Central de Cordoba'),(9,'Colon de Santa Fe'),(10,'Defensa y Justicia'),(11,'Estudiantes de la Plata'),(12,'Gimnasia la Plata'),(13,'Godoy Cruz'),(14,'Huracan'),(15,'Independiente'),(16,'Instituto'),(17,'Lanus'),(18,'Newells old boys'),(19,'Platense'),(20,'Racing Club'),(21,'River Plate'),(22,'Rosario Central'),(23,'San Lorenzo'),(24,'Sarmiento'),(25,'Talleres de Cordoba'),(26,'Tigre'),(27,'Union de Santa Fe'),(28,'Velez Sarsfield');
/*!40000 ALTER TABLE `equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jugadores`
--

DROP TABLE IF EXISTS `jugadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jugadores` (
  `idCamiseta` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `titular` char(10) NOT NULL,
  `equipo_idEquipo` int NOT NULL,
  PRIMARY KEY (`idCamiseta`),
  UNIQUE KEY `idCamiseta_UNIQUE` (`idCamiseta`),
  KEY `fk_jugadores_equipo_idx` (`equipo_idEquipo`),
  CONSTRAINT `fk_jugadores_equipo` FOREIGN KEY (`equipo_idEquipo`) REFERENCES `equipo` (`idEquipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugadores`
--

LOCK TABLES `jugadores` WRITE;
/*!40000 ALTER TABLE `jugadores` DISABLE KEYS */;
INSERT INTO `jugadores` VALUES (2,'Torren','s',1),(3,'sanchez','s',1),(4,'Mac Allister','s',1),(5,'Redondo','s',1),(6,'Villalba','s',1),(7,'Cabrera','s',1),(9,'Avalos','s',1),(10,'veron','s',1),(11,'Nuss','s',1),(12,'Cardozo','s',1),(13,'Gonzalez Metilli','s',1),(14,'Vera','n',1),(15,'Heredia','n',1),(16,'Cabral','n',1),(17,'Moyano','n',1),(18,'Montiel','n',1),(19,'Ferreyra','n',1),(20,'Lanzillota','n',1),(21,'Dominguez','n',1),(24,'Gonzalez','n',1),(25,'Martin Arias','n',1),(27,'Bittolo','n',1),(29,'Di Cesare','n',1),(30,'Minissale','n',1);
/*!40000 ALTER TABLE `jugadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partidos`
--

DROP TABLE IF EXISTS `partidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partidos` (
  `idPartido` int NOT NULL AUTO_INCREMENT,
  `equipo_idEquipo` int NOT NULL,
  `resultado` varchar(45) DEFAULT NULL,
  `goles_hechos` int DEFAULT NULL,
  `goles_recibidos` int DEFAULT NULL,
  PRIMARY KEY (`idPartido`,`equipo_idEquipo`),
  KEY `fk_partidos_equipo1_idx` (`equipo_idEquipo`),
  CONSTRAINT `fk_partidos_equipo1` FOREIGN KEY (`equipo_idEquipo`) REFERENCES `equipo` (`idEquipo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partidos`
--

LOCK TABLES `partidos` WRITE;
/*!40000 ALTER TABLE `partidos` DISABLE KEYS */;
INSERT INTO `partidos` VALUES (1,1,'ganador',1,0),(1,2,'perdedor',0,1),(2,3,'empate',2,2),(2,4,'empate',2,2),(3,1,'empate',1,1),(3,2,'empate',1,1);
/*!40000 ALTER TABLE `partidos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-24 21:15:05
