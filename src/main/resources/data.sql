insert into city values(101,'Pune','India',1,'411057','Maharashtra');
insert into city values(102,'Goa','India',1,'403001','Goa');
insert into city values(103,'Nagpur','India',1,'440001','Maharashtra');


insert into office values(1011,1,'Hinjawadi-Vedas Complex',101);
insert into office values(1021,1,'Goa-Beach Complex',102);
insert into office values(1012,1,'Blue Ridge-Rented Complex',101);
insert into office values(1031,1,'Nagpur-Oranges Complex',103);

insert into building values(911,'Rigved',1,1011);
insert into building values(912,'Atharva Ved',1,1011);
insert into building values(921,'G K buiding',1,1021);
insert into building values(931,'N K buiding',1,1031);

insert into floor values(9110,'E0','E',1,911);
insert into floor values(9111,'E1','E',1,911);
insert into floor values(9113,'E3','E',1,911);
insert into floor values(9120,'A0','A',1,912);


insert into seat values(130,0,1,'e30',111,1,9113);
insert into seat values(131,1,1,'e31',122,1,9113);
insert into seat values(110,0,1,'e00',111,1,9110);

insert into seat_type values(1,'AAA','TL');
insert into seat_type values(2,'BBB','CL');