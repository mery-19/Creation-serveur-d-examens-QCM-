-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 15 juin 2020 à 12:54
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `informatique`
--

-- --------------------------------------------------------

--
-- Structure de la table `c/c++`
--

DROP TABLE IF EXISTS `c/c++`;
CREATE TABLE IF NOT EXISTS `c/c++` (
  `id` int(150) NOT NULL AUTO_INCREMENT,
  `question` varchar(255) NOT NULL,
  `ans1` varchar(70) NOT NULL,
  `ans2` varchar(70) NOT NULL,
  `ans3` varchar(70) NOT NULL,
  `ans4` varchar(70) NOT NULL,
  `correct` varchar(70) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=83 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `c/c++`
--

INSERT INTO `c/c++` (`id`, `question`, `ans1`, `ans2`, `ans3`, `ans4`, `correct`) VALUES
(1, 'The default access specifer for the class members is', 'public', 'private', 'protected', 'None of the above.', 'private'),
(2, '‘cin’ is an __', 'Class', 'Object', 'Package', 'Namespace', 'Object'),
(3, 'Operators sizeof and ?:', 'Both can be overloaded', 'Both cannot be overloaded', 'Only sizeof can be overloaded', 'Only ?: can be overloaded', 'Both can be overloaded'),
(4, 'What is the output of the following program?', '1 1 1', '0 0 0', '3 2 1', '1 2 3', '1 2 3'),
(5, 'What is the output of the following program?', '1', '2', 'Compile error', 'Runtime error', '2'),
(6, 'What is the output of the following program?', '5', 'Address of x', 'Compile error', '10', '10'),
(7, 'What is the output of the following program?', 'C++ C++', 'C++ ++', '++ ++', 'Compile error', 'Compile error');

-- --------------------------------------------------------

--
-- Structure de la table `etudiants`
--

DROP TABLE IF EXISTS `etudiants`;
CREATE TABLE IF NOT EXISTS `etudiants` (
  `id` int(150) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `Password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etudiants`
--

INSERT INTO `etudiants` (`id`, `nom`, `Password`) VALUES
(1, 'N133190744', 'CD701355'),
(4, 'user', 'user'),
(3, 'test', 'test'),
(5, 'user1', 'user1');

-- --------------------------------------------------------

--
-- Structure de la table `java`
--

DROP TABLE IF EXISTS `java`;
CREATE TABLE IF NOT EXISTS `java` (
  `id` int(150) NOT NULL AUTO_INCREMENT,
  `question` varchar(255) NOT NULL,
  `ans1` varchar(70) NOT NULL,
  `ans2` varchar(70) NOT NULL,
  `ans3` varchar(70) NOT NULL,
  `ans4` varchar(70) NOT NULL,
  `correct` varchar(70) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `java`
--

INSERT INTO `java` (`id`, `question`, `ans1`, `ans2`, `ans3`, `ans4`, `correct`) VALUES
(1, 'Java est un langage: ', 'Compilé', 'Interprété', 'Compilé et interprété', 'Ni compilé ni interprété', 'Compilé et interprété'),
(2, 'Java est un langage développé par:', 'Hewlett-Packard', 'Sun Microsystems', 'Microsoft', 'Oracle', 'Sun Microsystems'),
(3, 'La liaison tardive est essentielle pour assurer: ', 'l’encapsulation', 'le polymorphisme', 'l’héritage', 'la marginalisation', 'le polymorphisme'),
(4, 'qu’affichera le code suivant?', '2 et 2', '1 et 1', '2 et 1', '1 et 3', '2 et 1'),
(5, 'qu’affichera le code suivant?', '6 et 2009 et encore 4', '1 et 2004 et encore 4', ' 1 et 2004 et encore 2003', ' autre chose', '6 et 2009 et encore 4'),
(6, 'what does the code give?\r\nint i; ++i;syso(i);', 'rien', '0', '1', 'exception', '1'),
(7, 'Ecouter bien ...', 'switch', 'switsh', 'swich', 'swish', 'switch');

-- --------------------------------------------------------

--
-- Structure de la table `notes`
--

DROP TABLE IF EXISTS `notes`;
CREATE TABLE IF NOT EXISTS `notes` (
  `id` int(150) NOT NULL AUTO_INCREMENT,
  `etudiant` varchar(255) NOT NULL,
  `module` varchar(255) NOT NULL,
  `score` int(70) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=57 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `notes`
--

INSERT INTO `notes` (`id`, `etudiant`, `module`, `score`) VALUES
(12, 'test', 'java', 2),
(13, 'user', 'java', 6),
(14, 'test', 'java', 3),
(15, 'test', 'java', 3),
(16, 'test', 'java', 2),
(17, 'test', 'java', 2),
(18, 'test', 'java', 2),
(19, 'test', 'java', 2),
(20, 'test', 'java', 2),
(21, 'test', 'java', 2),
(22, 'test', 'java', 0),
(23, 'test', 'java', 2),
(24, 'test', 'java', 0),
(25, 'test', 'java', 3),
(26, 'test', 'java', 2),
(27, 'test', 'java', 2),
(28, 'test', 'java', 3),
(29, 'test', 'java', 0),
(30, 'test', 'java', 0),
(31, 'test', 'java', 0),
(32, 'test', 'java', 2),
(33, 'test', 'java', 2),
(34, 'test', 'java', 1),
(35, 'test', 'java', 1),
(36, 'test', 'java', 3),
(37, 'test', 'java', 6),
(38, 'test', 'java', 3),
(39, 'test', 'java', 3),
(40, 'test', 'java', 3),
(41, 'test', 'java', 0),
(42, 'test', 'java', 0),
(43, 'test', 'java', 3),
(44, 'test', 'java', 3),
(45, 'test', 'java', 3),
(46, 'test', 'java', 3),
(47, 'test', 'java', 3),
(48, 'test', 'java', 3),
(49, 'test', 'java', 0),
(50, 'test', 'java', 3),
(51, 'test', 'java', 2),
(52, 'test', 'cLanguage', 0),
(53, 'test', 'cLanguage', 1),
(54, 'test', 'cLanguage', 3),
(55, 'test', 'C/C++', 0),
(56, 'test', 'C/C++', 0);

-- --------------------------------------------------------

--
-- Structure de la table `professeurs`
--

DROP TABLE IF EXISTS `professeurs`;
CREATE TABLE IF NOT EXISTS `professeurs` (
  `id` int(150) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `spécialité` varchar(255) NOT NULL,
  `liste des QCM crées` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `professeurs`
--

INSERT INTO `professeurs` (`id`, `nom`, `spécialité`, `liste des QCM crées`) VALUES
(1, 'meryam', '', 'java+c');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
