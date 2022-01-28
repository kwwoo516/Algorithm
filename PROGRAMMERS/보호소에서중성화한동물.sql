SELECT o.animal_id, o.animal_type, o.name from animal_outs o join animal_ins i
on i.animal_id = o.animal_id 
where SEX_UPON_INTAKE like "intact%" and sex_upon_outcome not like "intact%"
order by o.animal_id