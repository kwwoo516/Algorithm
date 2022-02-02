select if(g.grade >= 8, s.name, null), g.grade, s.marks from students s join grades g
on s.marks >= g.min_mark and s.marks <= g.max_mark
order by g.grade desc, s.name