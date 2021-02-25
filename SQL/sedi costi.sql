create view v_rend_sedi_all as
SELECT nomeSede,sum(Totale) as Totale FROM tss_prova_paolo.v_rend_corsi_all r
inner join tab_corsi c on r.id_corso=c.id_corso
inner join tab_sedi s on s.id_sede=c.id_sede
group by 