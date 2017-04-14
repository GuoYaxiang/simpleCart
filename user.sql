use cart;

drop table if exists `user`;

create table `user`(
`id` int,
`name` varchar(50),
`password` varchar(50)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


insert into user values(1, '张三', '333'); 
insert into user values(2, '李四', '444'); 
insert into user values(3, '王五', '555'); 
insert into user values(4, '朱六', '666'); 