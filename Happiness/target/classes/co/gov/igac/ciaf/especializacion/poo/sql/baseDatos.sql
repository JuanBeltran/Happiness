CREATE DATABASE IF NOT EXISTS poo;
USE poo;

CREATE TABLE IF NOT EXISTS `persona` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `lugar` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

INSERT INTO `persona` (`id`, `nombre`, `lugar`) VALUES
	(1, 'Mahesh', 'Varanasi'),	
	(2, 'Ram', 'Ayodhya'); 
	