-- v_rend_corsi_allcreate view v_rend_corsi_attivi as
SELECT c.id_corso,nomeCorso,sum(costo) as Totale, count(*) as numIscritti FROM tss_prova_paolo.tab_corsi c inner join tab_iscrizioni i 
    on  i.id_corso=c.id_corso
group by c.id_corso,nomeCorso;

-- create view v_rend_corsi_all as
SELECT nomeCorso, costo*count(id_iscrizione) Totale,count(id_iscrizione) numIscritti
FROM tss_prova_paolo.tab_iscrizioni i
right join tab_corsi c
on i.id_corso=c.id_corso
group by id_corso,nomeCorso;
