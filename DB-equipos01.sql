-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: dbequipos
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
  `nombre_equipo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idDirector`),
  UNIQUE KEY `idDirector_UNIQUE` (`idDirector`),
  KEY `nombre_equipo` (`nombre_equipo`),
  CONSTRAINT `directores_tecnicos_ibfk_1` FOREIGN KEY (`nombre_equipo`) REFERENCES `equipo` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `directores_tecnicos`
--

LOCK TABLES `directores_tecnicos` WRITE;
/*!40000 ALTER TABLE `directores_tecnicos` DISABLE KEYS */;
INSERT INTO `directores_tecnicos` VALUES (1,'monzon','argentinos junios');
/*!40000 ALTER TABLE `directores_tecnicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipo`
--

DROP TABLE IF EXISTS `equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipo` (
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipo`
--

LOCK TABLES `equipo` WRITE;
/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
INSERT INTO `equipo` VALUES ('Argentinos Junios'),('Arsenal de Sarandi'),('Atletico Tucuman'),('Banfield'),('Barracas Central'),('Belgrano'),('Boca Juniors'),('Central de Cordoba'),('Colon de Santa Fe'),('Defensa y Justicia'),('Estudiantes de la Plata'),('Gimnasia la Plata'),('Godoy Cruz'),('Huracan'),('Independiente'),('Instituto'),('Lanus'),('Newells old boys'),('Platense'),('Racing Club'),('River Plate'),('Rosario Central'),('San Lorenzo'),('Sarmiento'),('Talleres de Cordoba'),('Tigre'),('Union de Santa Fe'),('Velez Sarsfield');
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
  `nombre_equipo` varchar(45) NOT NULL,
  PRIMARY KEY (`idCamiseta`,`nombre_equipo`),
  KEY `jugadores_ibfk_1` (`nombre_equipo`),
  CONSTRAINT `jugadores_ibfk_1` FOREIGN KEY (`nombre_equipo`) REFERENCES `equipo` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugadores`
--

LOCK TABLES `jugadores` WRITE;
/*!40000 ALTER TABLE `jugadores` DISABLE KEYS */;
INSERT INTO `jugadores` VALUES (1,'nicolas sandoval','si','Banfield'),(2,'Torren','si','Argentinos Junios'),(3,'sanchez','s','Argentinos Junios'),(3,'nicolas S','si','Boca Juniors'),(4,'Mac Allister','s','Argentinos Junios'),(4,'nicolas S','si','Boca Juniors'),(5,'Redondo','s','Argentinos Junios'),(6,'Villalba','s','Argentinos Junios'),(7,'Cabrera','s','Argentinos Junios'),(9,'Avalos','s','Argentinos Junios'),(10,'veron','s','Argentinos Junios'),(11,'Nuss','s','Argentinos Junios'),(12,'Cardozo','s','Argentinos Junios'),(13,'Gonzalez Metilli','s','Argentinos Junios'),(14,'Vera','n','Argentinos Junios'),(15,'Heredia','n','Argentinos Junios'),(16,'Cabral','n','Argentinos Junios'),(17,'Moyano','n','Argentinos Junios'),(18,'Montiel','n','Argentinos Junios'),(19,'Ferreyra','n','Argentinos Junios'),(20,'Lanzillota','n','Argentinos Junios'),(21,'Dominguez','n','Argentinos Junios'),(24,'Gonzalez','n','Argentinos Junios'),(25,'Martin Arias','n','Argentinos Junios'),(27,'Bittolo','n','Argentinos Junios'),(29,'Di Cesare','n','Argentinos Junios'),(30,'Minissale','n','Argentinos Junios');
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
  `nombre_equipo` varchar(45) NOT NULL,
  `resultado` varchar(45) DEFAULT NULL,
  `goles_hechos` int DEFAULT NULL,
  `goles_recibidos` int DEFAULT NULL,
  PRIMARY KEY (`idPartido`,`nombre_equipo`),
  KEY `nombre_equipo` (`nombre_equipo`),
  CONSTRAINT `partidos_ibfk_1` FOREIGN KEY (`nombre_equipo`) REFERENCES `equipo` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partidos`
--

LOCK TABLES `partidos` WRITE;
/*!40000 ALTER TABLE `partidos` DISABLE KEYS */;
INSERT INTO `partidos` VALUES (1,'Argentinos Junios','ganador',2,0),(1,'Arsenal de Sarandi','perdedor',0,2);
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

-- Dump completed on 2023-04-26 21:51:50
