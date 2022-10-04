create table cards(
cardno bigint primary key,
cvv int,
name varchar(35),
expirymonth int,
expiryyear int);

insert into cards values(1234567812345678,123,'Jesse',8,27);

alter table cards add column accountno bigint;

alter table cards add constraint f_k foreign key (accountno) references account(accountno);

update cards set accountno = 56785678 where cardno = 1234567812345678;