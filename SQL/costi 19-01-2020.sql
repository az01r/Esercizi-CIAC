-- create view v_stat as
SELECT concat(nome," ",cognome) Nominativo,
count(*),
sum(costo+bollo) Totale,
max(costo+bollo) Massimo,
min(costo+bollo) Minimo,
avg(costo+bollo) Media
FROM tss_prova_paolo.tab_anagrafica a
inner join
tab_iscrizioni i
on a.id_anagrafica=i.id_anagrafica
inner join
tab_corsi c
on i.id_corso=c.id_corso
group by nominativo