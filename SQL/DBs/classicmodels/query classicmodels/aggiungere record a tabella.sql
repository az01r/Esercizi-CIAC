-- insert into params (ivaSTD,minBonus) values (0.22,1000);
update params set ivaSTD=ivaSTD+0.05,minBonus=2000 where 1; -- 1 significa true
-- delete from params where id_param > 1;