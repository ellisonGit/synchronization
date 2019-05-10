if object_id('sync_sign') is  null

create table sync_sign(
  id int unique ,
  sign_consume int default 0
);

insert sync_sign (id) select 1 where not exists(select id from sync_sign where id=1);
