-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 04-Dez-2019 às 17:59
-- Versão do servidor: 10.4.6-MariaDB
-- versão do PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `mercado`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `administrador`
--

CREATE TABLE `administrador` (
  `usuario` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `administrador`
--

INSERT INTO `administrador` (`usuario`, `senha`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `nome` varchar(50) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `bairro` varchar(50) NOT NULL,
  `cpf_cnpj` varchar(14) NOT NULL,
  `numero` varchar(10) NOT NULL,
  `celular` varchar(11) NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `cep` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`nome`, `endereco`, `bairro`, `cpf_cnpj`, `numero`, `celular`, `telefone`, `cep`) VALUES
('fjdoiks', '465', '5', '1545441', '1', '1', '15', '5'),
('Solomun DEUS ', '1', '1', '154545', '', '1', '1', '115'),
('Solomun porra', '1', '1', '1546', '1', '1', '1', '1'),
('hgf', '1', '1', '15465465', '1', '1', '1', '1'),
('dfokdjsnf', '1', '1', '157454', '1', '1', '1', '1'),
('Maik', '15745', '164', '1864', '164', '1542', '151', '1876'),
('fdsf', 'fdsf', 'fghd', '251546', '256', '2564', '5454', '451456'),
('Renan', 'dfresfd', 'uyrfgfd', '44444444444', '152', '365854412', '25874520', '02541200'),
('Daniel Silva Silva', 'Rua cipriano do brasil', 'Jardim Rodolfo Pirani', '44522363698', '142', '951160061', '951160061', '08310300'),
('sdkfhbks', '65', '64', '4867', '64', '654', '544', '6464'),
('dfdsfsd', 'dfnjdb', 'dfdsfds', '52547884521', '215', '1545', '1541215', '122151'),
('LUCAS SILVA', 'fdsafds', 'dfss', '54554', '564', '11951160061', '11951160061', '54513'),
('gfd', '165', '9', '5465', '1651', '165', '156', '654'),
('Daniel Oliveira da Silva', 'Rua cipriano do brasil', 'Jardim Rodolfo pirani', '55488969630', '142', '11951160061', '1125896510', '08310300'),
('gfd', '156', '165', '5745', '165', '65', '151', '1654'),
('hgfh', '165', '165', '654', '165', '65', '6541', '645'),
('lalalala', '6516', '6351', '65454', '1654456', '65', 'f56456', '615'),
('jhgj', '16521', '165', '65465', '65', '516', 'fghf', '165'),
('fgds', 'gfd', '4', '657', '456', '459', 'fgtgfd', '65'),
('ultimo teste', '354', '3348', '68786', '35', '354', '4465', '38378'),
('fgdfgsd', 'dfsf', '161', '94684', '46', '18594', 'fdgds', '168');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `nome_produto` varchar(50) NOT NULL,
  `codigo_produto` int(11) NOT NULL,
  `valor_produto` varchar(10) NOT NULL,
  `quantidade_produto` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`nome_produto`, `codigo_produto`, `valor_produto`, `quantidade_produto`) VALUES
('teste', 1, '100.00', 35),
('ultimo teste', 185, '874.00', 35),
('alooo', 454, '25.50', 10),
('hgfh', 545, '10.00', 564),
('teste de remove', 555, '35.00', 10),
('ultimo teste', 1234, '1.00', 11),
('teste do teste', 1545, '25.00', 10),
('dfdf', 5454, '100.00', 44),
('pato', 12414, '1.00', 5),
('qwert', 15412, '25,500,00', 10),
('foi porra', 15423, '25,350,00', 10),
('kkkkk', 15451, '25.50', 10),
('lolololol', 15454, '25.50', 10),
('CRL CABo', 15656, '1.00', 100),
('TERMINO', 45324, '30,500.00', 25),
('vai meu filho cabo', 585696, '25,500,00', 10);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`usuario`);

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`cpf_cnpj`) USING BTREE;

--
-- Índices para tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`codigo_produto`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `codigo_produto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=585697;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
