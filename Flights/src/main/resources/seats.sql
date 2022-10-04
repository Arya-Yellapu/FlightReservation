create table seats(
seatno varchar(35),
status varchar(35),
reservationid varchar(35),
flightno varchar(35),
constraint foreign_key foreign key(flightno) REFERENCES flights(flightno));

insert into seats(seatno,status,flightno) values('E01','Available','T1001'),('E02','Available','T1001'),('E03','Available','T1001'),('E04','Available','T1001'),('E05','Available','T1001');