CREATE DATABASE `MEGALOCADORA` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `ALUGUEIS` (
  `idAluguel` int(11) NOT NULL AUTO_INCREMENT,
  `dataDeInicioAluguel` date NOT NULL,
  `dataDeTerminoAluguel` date NOT NULL,
  `quantidadeDeDiarias` int(11) NOT NULL,
  `valorDiaria` double NOT NULL,
  `taxas` double NOT NULL,
  `valorTotal` double NOT NULL,
  `nomeClienteAluguel` varchar(100) NOT NULL,
  `cpfClienteAluguel` varchar(45) NOT NULL,
  `placaVeiculoAluguel` varchar(45) NOT NULL,
  `nomeVeiculoAluguel` varchar(45) NOT NULL,
  `kmPre` int(11) NOT NULL,
  `kmPos` int(11) NOT NULL,
  PRIMARY KEY (`idAluguel`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

CREATE TABLE `CLIENTES` (
  `cpf` varchar(14) NOT NULL,
  `nome` varchar(60) DEFAULT NULL,
  `endereco` varchar(150) DEFAULT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `sexo` varchar(2) DEFAULT NULL,
  `dataDeNascimento` date DEFAULT NULL,
  UNIQUE KEY `CPF` (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `VEICULOS` (
  `placa` varchar(100) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `modelo` varchar(45) DEFAULT NULL,
  `marca` varchar(45) DEFAULT NULL,
  `anoDeFabricacao` int(11) DEFAULT NULL,
  `anoDeVenda` int(11) DEFAULT NULL,
  UNIQUE KEY `Placa` (`placa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SELECT * FROM MEGALOCADORA.ALUGUEIS;
SELECT * FROM MEGALOCADORA.CLIENTES;
SELECT * FROM MEGALOCADORA.VEICULOS;

insert into ALUGUEIS (dataDeInicioAluguel, dataDeTerminoAluguel, quantidadeDeDiarias, valorDiaria, taxas, valorTotal, nomeClienteAluguel, cpfClienteAluguel, placaVeiculoAluguel, nomeVeiculoAluguel, kmPre, kmPos) values ('2018-05-01' , '2018-05-04'  , 3  , 40.90 , 15.00 ,  55.90, 'Tiago Megale', '067', 'HMP-0774', 'Civic', 829, 880);


