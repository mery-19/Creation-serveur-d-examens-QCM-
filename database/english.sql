-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 23 juin 2020 à 23:55
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
-- Structure de la table `english`
--

DROP TABLE IF EXISTS `english`;
CREATE TABLE IF NOT EXISTS `english` (
  `id` int(150) NOT NULL AUTO_INCREMENT,
  `question` varchar(255) NOT NULL,
  `ans1` varchar(255) NOT NULL,
  `ans2` varchar(255) NOT NULL,
  `ans3` varchar(255) NOT NULL,
  `ans4` varchar(255) NOT NULL,
  `correct` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `english`
--

INSERT INTO `english` (`id`, `question`, `ans1`, `ans2`, `ans3`, `ans4`, `correct`) VALUES
(1, 'John Le Carré … for his novels on\r\nespionage.', 'A. Famous', 'B. Is famous', 'C. his fame\r\n', 'D. who is famous\r\n', 'B. Is famous'),
(2, 'Which radio station do you listen … most\r\noften?', 'A. through', 'B. to', 'C. for', 'D. along', 'B. to'),
(3, 'Please return the book … you’ve finished\r\nwith it.', 'A. as soon like\r\n', 'B. so soon than', 'C. as soon as', 'D. so soon when', 'C. as soon as'),
(4, 'The whole team was present at the\r\nmeeting … for Jonathan.', 'A. except\r\n', 'B. around\r\n', 'C. apart\r\n', 'D. besides\r\n', 'A. except\r\n'),
(5, 'We need to leave the trade fair … 7pm.', 'A. on\r\n', 'B. in\r\n', 'C. by\r\n', 'D. during\r\n', 'C. by\r\n'),
(6, 'The school … I attended last year is in\r\nthe town centre.', 'A. whence\r\n', 'B. that\r\n', 'C. who\r\n', 'D. than\r\n', 'B. that\r\n'),
(7, 'Please look before … the road.', 'A. to be crossing\r\n', 'B. to cross\r\n', 'C. cross\r\n', 'D. crossing\r\n', 'D. crossing\r\n'),
(8, 'Jane’s behaviour has improved: it’s\r\nmuch … than last year.', 'A. better\r\n', 'B. best\r\n', 'C. worse\r\n', 'D. more good\r\n', 'A. better\r\n'),
(9, 'This is my favourite jacket, which … a\r\nthousand times!', 'A. is worn\r\n', 'B. has been worn\r\n', 'C. is wore\r\n', 'D. has been wore\r\n', 'B. has been worn\r\n'),
(10, '… the children played in the garden, I\r\nprepared the evening meal.', 'A. Throughout\r\n', 'B. At once\r\n', 'C. While\r\n', 'D. However\r\n', 'C. While\r\n'),
(11, 'We wrote a letter asking everyone ….\r\na packed lunch.', 'A. to bring\r\n', 'B. brought\r\n', 'C. bringing\r\n', 'D. to have brought\r\n', 'A. to bring\r\n'),
(12, 'English is the ... second-language in\r\nthe world.', 'A. more widely spoken\r\n', 'B. most widely spoken\r\n', 'C. more spoken than\r\n', 'D. most spoken than\r\n', 'B. most widely spoken\r\n'),
(13, ' If you had given me a 5% reduction,\r\nI … 25 boxes.', 'A. would order\r\n', 'B. will order\r\n', 'C. shall order\r\n', 'D. would have ordered\r\n', 'D. would have ordered\r\n'),
(14, 'The Republicans have … the Democrats\r\nin the polls.', 'A. beated\r\n', 'B. beating\r\n', 'C. beaten\r\n', 'D. beat\r\n', 'C. beaten\r\n'),
(15, ' … part-time is much more difficult\r\nnowadays.', 'A. The work\r\n', 'B. To work \r\n', 'C. Worked\r\n', 'D. Working\r\n', 'D. Working\r\n'),
(16, 'If I have enough time tomorrow\r\nmorning, I … the coffee.', 'A. would make\r\n', 'B. will make\r\n', 'C. had made\r\n', 'D. made', 'B. will make\r\n'),
(17, ' He said he would definitely … touch.', 'A. keep in\r\n', 'B. keep on\r\n', 'C. stay at\r\n', 'D. stay with\r\n', 'A. keep in\r\n'),
(18, ' Winter is clearly upon us,\r\nas it’s getting ….', 'A. cold as cold\r\n', 'B. cold and cold\r\n', 'C. colder and colder\r\n', 'D. colder than coldest\r\n', 'C. colder and colder\r\n'),
(19, ' I was … by sirens in the middle of the\r\nnight.', 'A. wake\r\n', 'B. awoke\r\n', 'C. awoken\r\n', 'D. woke\r\n', 'C. awoken\r\n'),
(20, 'I\'m very happy _____ in India. I really miss being there.', 'a.to live\r\n', 'b.to have lived\r\n', 'c.to be lived\r\n', 'd.to be living\r\n', 'b.to have lived\r\n'),
(21, 'They didn\'t reach an agreement ______ their differences.', 'a.on account of\r\n', 'b.due\r\n', 'c.because\r\n', 'd.owing\r\n', 'a.on account of\r\n'),
(22, 'I wish I _____ those words. But now it\'s too late.', 'b. have never said\r\n', 'b. have never said\r\n', 'c. never said\r\n', 'd. had never said', 'd. had never said'),
(23, 'The woman, who has been missing for 10 days, is believed _____.', 'a. to be abducted', 'b. to be abducting\r\n', 'c. to have been abducted', 'd. to have been abducting\r\n', 'c. to have been abducted'),
(24, 'She was working on her computer with her baby next to _____.', 'a. herself', 'b. her', 'c. her own\r\n', 'd. hers\r\n', 'b. her'),
(25, '___ to offend anyone, she said both cakes were equally good.', 'a. Not wanting', 'b. As not wanting\r\n', 'c. She didn\'t want\r\n', 'd. Because not wanting\r\n', 'a. Not wanting'),
(26, '_____ in trying to solve this problem. It\'s clearly unsolvable.', 'a. There\'s no point', 'b. It\'s no point\r\n', 'c. There isn\'t point\r\n', 'd. It\'s no need\r\n', 'a. There\'s no point'),
(27, 'He _____ robbed as he was walking out of the bank.\r\n', 'a. had', 'b. did\r\n', 'c. got', 'd. were\r\n', 'c. got'),
(28, '_____ forced to do anything. He acted of his own free will.\r\n', 'a. In no way was he', 'b. No way he was\r\n', 'c. In any way he was\r\n', 'd. In any way was he\r\n', 'a. In no way was he'),
(29, 'They _____ in the basement for three months.\r\n', 'a. were made sleeping', 'b. were made sleep\r\n', 'c. were made to sleep', 'd. made to sleep\r\n', 'c. were made to sleep'),
(30, '______ gifts to the judges.\r\n', 'a. It\'s not allowed offering', 'b. It\'s not permitted to offer', 'c. It\'s not permitted offering\r\n', 'd. It\'s not allowed to offer\r\n', 'b. It\'s not permitted to offer');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
