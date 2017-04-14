create database cart;

use cart;

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
       `id` int(11) DEFAULT NULL,
       `name` varchar(50) DEFAULT NULL,
       `price` float DEFAULT NULL
) ENGINE = MyISAM DEFAULT CHARSET=utf8;

insert into product values(1,'盖聂',1000);
insert into product values(2,'卫庄',900);
insert into product values(3,'张良',800);
insert into product values(4,'章邯',800);
insert into product values(5,'高渐离',800);