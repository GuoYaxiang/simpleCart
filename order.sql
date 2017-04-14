use cart;

create table order_ (
  id int AUTO_INCREMENT,
  uid int,
  primary key(id)
)ENGINE=MyISAM DEFAULT CHARSET=UTF8;

create table orderitem(
  id int AUTO_INCREMENT,
  pid int,
  num int,
  oid int,
  primary key(id)
)ENGINE=MyISAM DEFAULT CHARSET=UTF8;