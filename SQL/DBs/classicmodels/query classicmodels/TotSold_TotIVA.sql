-- v_totsold_totivacreate view v_TotSold_TotIVA as
SELECT TotSold,totSold*ivaSTD as TotIVA,TotSold/(1+ivaSTD) as TotNoIVA FROM classicmodels.v_sales,params;
-- facendo il prodotto cartesiano tra 2 tabelle di cui una con un solo campo
-- si può usare questo campo per delle operazioni senza il bisogno
-- di collegare le 2 tabelle con una join