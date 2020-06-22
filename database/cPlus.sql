-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 22 juin 2020 à 16:45
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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
