-- para obtenes los jugadores
Select idCamiseta, nombre
From jugadores
where equipo_idEquipo = ( select idEquipo
                            from equipo
                            where nombre = "Argentinos Junios");
                            
-- obtener Puntaje ganador
select equipo_idEquipo, sum(puntaje) as puntaje
from (Select equipo_idEquipo, count(*) * 3 as puntaje
from partidos
where equipo_idEquipo = ( select idEquipo
                            from equipo
                            where nombre = "Argentinos Junios")
and resultado = "ganador"
union all
-- obtener puntaje empate
Select equipo_idEquipo, count(*) as puntaje
from partidos
where equipo_idEquipo = ( select idEquipo
                            from equipo
                            where nombre = "Argentinos Junios")
and resultado = "empate") t1
group by equipo_idEquipo;