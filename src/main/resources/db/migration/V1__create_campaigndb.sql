CREATE TABLE campaign (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  employees int(10) NOT NULL,
  email varchar(45) NOT NULL,
  price float NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;