-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 22 juin 2020 à 16:44
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
) ENGINE=MyISAM AUTO_INCREMENT=106 DEFAULT CHARSET=latin1;

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
(7, 'What is the output of the following program?', 'C++ C++', 'C++ ++', '++ ++', 'Compile error', 'Compile error'),
(8, 'Escape sequence character \'\\0\' occupies _ amount of memory.', '0', '1', '2', '4', '1'),
(9, 'What is the full form of RTTI.', 'Runtime type identification', 'Runtime template identification', 'Robust Template Type Inheritance', 'None of the above.', 'Runtime type identification'),
(10, 'What is a generic class.', 'Function template', 'Class template', 'Inherited class', 'None of the above.', 'Class template'),
(11, 'An exception is __', 'Runtime error', 'Compile time error', 'Logical error', 'None of the above', 'Runtime error'),
(12, 'What is the size of ‘int’?', '2', '4', '8', 'Compiler dependent', 'Compiler dependent'),
(13, 'What is the output of the main(){}', 'No output', 'Garbage', 'Compile error', 'Runtime error', 'No output'),
(14, 'Delaration a pointer more than once may cause ____', 'Error', 'Abort', 'Trap', 'Null', 'Trap'),
(15, 'Which one is not a correct variable type in C++?', 'float', 'real', 'int', 'double', 'real'),
(16, 'Which operation is used as Logical \'AND\'', 'Operator-&', 'Operator-||', 'Operator-&&', 'Operator +', 'Operator-&&'),
(17, 'An expression A.B in C++ means __', 'A is member of object B', 'B is member of Object A', 'Product of A and B', 'None of these', 'B is member of Object A'),
(18, 'A C++ code line ends with ___', 'A Semicolon (;)', 'A Fullstop(.)', 'A Comma (,)', 'A Slash (/)', 'A Semicolon (;)'),
(19, '	\r\n____ function is used to allocate space for array in memory.', 'malloc()', 'realloc()', 'alloc()', 'calloc()', 'malloc()'),
(20, 'A ponter pointing to a variable that is not initialized is called ____', 'Void Pointer', 'Null Pointer', 'Empty Pointer', 'Wild Pointer', 'Null Pointer'),
(21, 'Default constructor has ____ arguments.', 'No argument', 'One Argument', 'Two Argument', 'None of these', 'No argument'),
(22, 'A class whos objects can not be created is known as _____', 'Absurd Class', 'Dead Class', 'Super Class', 'Abstract Class', 'Abstract Class'),
(23, 'Which class allows only one object to be created.', 'Nuclear Family Class', 'Abstruct Class', 'Sigleton Class', 'Numero Uno Class', 'Sigleton Class'),
(24, 'Reusability of code in C++ is achieved through ____', 'Polymorphism', 'Inheritance', 'Encapsulation', 'Both A and B', 'Inheritance'),
(25, 'In CPP, members of a class are ______ by default.', 'Public', 'Private', 'Protected', 'Static', 'Private'),
(26, 'In C++ Program, inline fuctions are expanded during ____', 'Run Time', 'Compile Time', 'Debug Time', 'Coding Time', 'Run Time'),
(27, 'An exceptio in C++ can be generated using which keywords.', 'thrownB', 'threw', 'throw', 'throws', 'throw'),
(28, 'To perfor file input/output operation,we must include?', '<fiostream>', '<ifstream>', '<ofstream>', '<fstream>', '<fstream>'),
(29, 'What is the output of the following program?', '12', '4', '8', 'Compile error', '4'),
(30, 'What is the output of the following program?', '10', '20', '11', '21', '11');

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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `professeurs`
--

INSERT INTO `professeurs` (`id`, `nom`, `spécialité`, `liste des QCM crées`) VALUES
(1, 'meryam', '', 'java+c'),
(2, 'youssef', '', 'english');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
