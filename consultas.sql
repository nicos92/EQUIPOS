-- obtener equipos
select *
from equipo;

-- para obtenes los jugadores por equipo
Select idCamiseta, nombre
From jugadores
where nombre_Equipo = "Arsenal de sarandi";


-- obtener puntaje por equipo                            
-- obtener Puntaje ganador
select nombre_equipo as equipo, sum(puntaje) as puntaje
from (Select nombre_equipo, count(*) * 3 as puntaje
		from partidos
		where nombre_equipo =  "Argentinos Junios"
			and resultado = "ganador"
		union all
		-- obtener puntaje empate
		Select nombre_equipo, count(*) as puntaje
		from partidos
		where nombre_equipo =  "Argentinos Junios"
				and resultado = "empate") t1
	group by nombre_equipo;
        
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
group by nombre_equipo;

-- obtener DT
select nombreyapellido
from directores_tecnicos
where nombre_equipo = "Argentinos junios";

-- obtener cantidad de partidos jugados
select count(*)
from partidos
where nombre_equipo = "Argentinos junios";

-- obtener todos los directores
select *
from directores_tecnicos;
        