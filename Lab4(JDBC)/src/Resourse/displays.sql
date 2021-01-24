-- phpMyAdmin SQL Dump
-- version 3.2.3
-- http://www.phpmyadmin.net
--
-- Хост: localhost
-- Время создания: Янв 22 2021 г., 20:53
-- Версия сервера: 5.1.40
-- Версия PHP: 5.2.12

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `Displays`
--

-- --------------------------------------------------------

--
-- Структура таблицы `Displays`
--

CREATE TABLE IF NOT EXISTS `Displays` (
  `Display_ID` int(11) NOT NULL,
  `Display_Name` text NOT NULL,
  `Resolution` text NOT NULL,
  `Diagonal` int(11) NOT NULL,
  `Update_frequency` int(11) NOT NULL,
  `Price` int(11) NOT NULL,
  PRIMARY KEY (`Display_ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `Displays`
--

INSERT INTO `Displays` (`Display_ID`, `Display_Name`, `Resolution`, `Diagonal`, `Update_frequency`, `Price`) VALUES
(322, 'HP', '1920x1080', 19, 60, 5500),
(122, 'Philips', '1920x1080', 20, 60, 5500),
(340, 'AOC', '1920x1080', 21, 60, 7200),
(458, 'Acer', '1920x1080', 27, 75, 11000),
(501, 'Dell', '1920x1080', 27, 75, 12500);
