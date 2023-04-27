DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getTablaPosiciones`()
BEGIN
-- obtener ranking de todos los equipos
select nombre_equipo as equipos, sum(puntaje) as puntaje
from (Select nombre_equipo, count(*) * 3 as puntaje
		from partidos
		where resultado = "ganador"
        group by nombre_equipo
		union all
		-- obtener puntaje empate
		Select nombre_equipo, count(*) as puntaje
		from partidos
		where resultado = "empate"
        group by nombre_equipo
        union all
        select nombre, 0 as puntaje
        from equipo) t1
group by nombre_equipo
limit 10;

END$$
DELIMITER ;
