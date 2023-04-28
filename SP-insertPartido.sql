CREATE DEFINER=`root`@`localhost` PROCEDURE `insertPartido`(
IN _Id int, _resultadoA varchar(40) , _equipoA varchar(40), _golEquipoA int, _resultadoB varchar(40), _equipoB varchar(40), _golEquipoB int)
BEGIN

INSERT INTO `dbequipos`.`partidos` (`idPartido`, `nombre_equipo`, `resultado`, `goles_hechos`, `goles_recibidos`) 
							VALUES (_Id, _equipoA, _resultadoA, _golEquipoA , _golEquipoB);

INSERT INTO `dbequipos`.`partidos` (`idPartido`, `nombre_equipo`, `resultado`, `goles_hechos`, `goles_recibidos`) 
							VALUES (_Id, _equipoB, _resultadoB, _golEquipoB, _golEquipoA );


END