CREATE TABLE `convidado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(500) DEFAULT NULL,
  `email` varchar(500) DEFAULT NULL,
  `telefone` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

INSERT INTO `convidado` VALUES 
(1,'Lazaro Prates Junior','lazaro@alura.com.br','99998888'),
(2,'Maria do Carmo','maria@gmail.com','33442233'),
(4,'Antonio da Silva','toni@alura.com.br','99997777'),
(5,'Luis','luis@alura.com','55554444'),
(6,'Pedro','pedro@alura.com','44555544'),
(7,'Jo�o da Silva','springbootalura@gmail.com','98899887');

insert into produto values (null , 'MTG005', 'Moto G6', 950);
insert into produto values (null , 'GLT007', 'Galaxy Note', 3950);
insert into produto values (null , 'S9U008', 'Galaxy S9', 4950);
insert into produto values (null , 'MTP007', 'Moto G6 Plus', 1950);