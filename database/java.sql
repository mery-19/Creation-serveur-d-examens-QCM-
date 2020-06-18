-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 18 juin 2020 à 17:56
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
) ENGINE=MyISAM AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

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
(7, 'Ecouter bien ...', 'switch', 'switsh', 'swich', 'swish', 'switch'),
(8, 'What is the result?', 'Match 1\r\n', 'Match 2', 'No Match', 'NullPointerException', 'Match 2'),
(9, 'What is the result?', 'int e=0;e<=4;e++', 'int e=0;e<5;e+=2', 'int e=1;e<=5;e+=1', 'int e=1;e<5;e+=2', 'int e=0;e<5;e+=2'),
(10, 'What is the result?', '[Robb, Rick, Bran]', '[Robb, Rick]\r\n', '[Robb, Bran, Rick, Bran]\r\n', 'Exception', '[Robb, Rick, Bran]'),
(11, 'What is the result?\r\n', '2 4', '0 2 4 6', '0 2 4', 'Compilation fails\r\n', '0 2 4'),
(12, 'What is the result?\r\n', 'Area is 6.0', 'Area is 3.0', 'Compilation fails at line n1', 'Compilation fails at line n2.', 'Area is 6.0'),
(13, 'What is the result?\r\n', '1324', '2313', '3142', '4231', '4231'),
(14, 'Quand la surcharge de méthode est-elle déterminée?\r\n', 'A Au moment de l’exécution', 'Au moment de la compilation', 'Au moment du codage', 'Au moment de l’exécution', 'Au moment de la compilation'),
(15, 'Comment ça s’appelle si un objet a son propre cycle de vie?', 'Agrégation', 'Composition', 'Encapsulation', 'Association', 'Association'),
(16, 'Pour avoir un commentaire sur une ligne, on place en début de ligne le(s) caractère(s) :', '%', '//', '#', '/*', '//'),
(17, 'Lequel de ces identificateurs est incorrect :', 'MonNom', 'mon_nom', 'mon$nom', '2noms', '2noms'),
(18, 'What is the result?\r\n', 'Sum is 600\r\n', 'Compilation fails at line n1.', 'Compilation fails at line n2.', 'ClassCastException is thrown at line n1.', 'Compilation fails at line n2.'),
(19, 'What is the result?', 'A B C D\r\n', 'A C D', 'A B C C', 'A B D C', 'A B C C'),
(20, 'What is the result if the integer aVar is 9?', 'Compilation fails.', '10 Hello Universe!', '10 Hello World!', '9 Hello World!', '10 Hello World!'),
(21, 'Which method signature do you use at line n1?', 'public int findMax (int [] numbers)', 'static int[] findMax (int max)', 'static int findMax (int [] numbers)', 'final int findMax (int [] )', 'static int findMax (int [] numbers)'),
(22, 'Which of the below is reserved keyword in Java?', 'array', 'go', 'null', 'int', 'int'),
(23, 'Select one of the core concepts of OOPS.', 'Abstraction', 'Interface', 'Generics', 'None of the above.', 'Abstraction'),
(24, 'What is a correct syntax to output \"Hello World\" in Java?', 'echo(\"Hello World\");', 'System.out.println(\"Hello World\");', 'Console.WriteLine(\"Hello World\");', 'print (\"Hello World\");', 'System.out.println(\"Hello World\");'),
(25, 'Which data type is used to create a variable that should store text?', 'myString', 'String', 'string', 'txt', 'String'),
(26, 'What is the size of short variable?', '8 bit', '16 bit', '32 bit', '64 bit', '16 bit'),
(27, 'What is the size of int variable?', '8 bit', '16 bit', '32 bit', '64 bit', '32 bit'),
(28, 'Static binding uses which information for binding?', 'type.', 'object.', 'Both of the above.', 'None of the above.', 'type.'),
(29, 'This is the parent of Error and Exception classes', 'Throwable', 'Catchable', 'MainError', 'MainException', 'Throwable'),
(30, 'What is an Interface?', 'An interface is a collection of abstract methods.', 'Interface is an abstract class.', 'Interface is an concrete class.', 'None of the above.', 'Interface is an concrete class.');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
