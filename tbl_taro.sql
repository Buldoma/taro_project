create table tbl_taro(
card_name varchar2(100) not null,
card_num number(38) primary key,
mean varchar2(100) not null
);

insert into tbl_taro (card_name,card_num,mean) values
('The World(세계)',21,'완성, 완전');

select * from tbl_taro order by card_num;

select * from tbl_taro where card_num=4;

drop table tbl_taro;