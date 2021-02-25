SELECT cognome,nome,nomeCorso,concat(nomeSede,"-",cs.comune)as sede,c.comune,c.lat,c.lon,cs.comune,cs.lon,(c.lat-cs.lat) deltaLat,
(c.lon-cs.lon) as deltaLon FROM tss_prova_paolo.tab_anagrafica a 
-- a è un nome che posso dare per riferirmi a tab_anagrafica
inner join
tab_comuni c
on a.id_comune=c.id_comune
inner join tab_iscrizioni i
on i.id_anagrafica=a.id_anagrafica
inner join tab_corsi co
on i.id_corso=co.id_corso
inner join tab_sedi s
on s.id_sede= co.id_sede
inner join tab_comuni cs
on cs.id_comune=s.id_comune
;