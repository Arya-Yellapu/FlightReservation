create table flights(
flightno varchar(35) primary key,
source varchar(35),
destination varchar(35),
seatsavailable int,
traveldate date);

insert into flights values('T1001','Vizag','Bangalore',150,'2022-12-20'),('T1002','Hyderabad','Kerala',150,'2022-11-19'),('T1003','Vizag','Delhi',150,'2022-10-18'),('T1004','Mumbai','Goa',150,'2022-09-17'),('T1005','Chennai','Goa',150,'2022-08-16');

alter table flights add column name varchar(35);

alter table flights add column priceperperson int;


update flights set name='Kingfisher' ,priceperperson=1500 where flightno='T1001';
update flights set name='Rynair' ,priceperperson=900 where flightno='T1002';
update flights set name='Deccan' ,priceperperson=700 where flightno='T1003';
update flights set name='Air India' ,priceperperson=1000 where flightno='T1004';
update flights set name='Ethiad' ,priceperperson=2000 where flightno='T1005';