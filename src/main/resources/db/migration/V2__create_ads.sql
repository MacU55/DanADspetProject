CREATE TABLE ads (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
   message varchar(45) NOT NULL,
   campaign_id int(11) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
