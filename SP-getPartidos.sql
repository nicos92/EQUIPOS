CREATE DEFINER=`root`@`localhost` PROCEDURE `getPartidos`()
BEGIN
	select A.idPartido, A.resultado, A.nombre_equipo, A.goles_hechos, B.resultado, B.nombre_equipo, B.goles_hechos
	from partidos as A, partidos as B
	where A.nombre_equipo <> B.nombre_equipo and A.idPartido = B.idPartido
	group by A.idPartido;
END