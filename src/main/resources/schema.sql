--CREATE TABLE `message` (
--  `id` int(11) AUTO_INCREMENT,
--  `userID` varchar(20) DEFAULT NULL,
--  `currencyFrom` varchar(10) DEFAULT NULL,
--  `currencyTo` varchar(10) DEFAULT NULL,
--  `amount_sell` double DEFAULT NULL,
--  `amount_buy` double DEFAULT NULL,
--  `rate` double DEFAULT NULL,
--  `time_placed` datetime DEFAULT NULL,
--  `originating_country` varchar(30) DEFAULT NULL,
--  PRIMARY KEY (id)
--);

CREATE TABLE `person` (
    `id` int(11) AUTO_INCREMENT,
    `age` int(11),
    `name` varchar(30) DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE `event` (
    `id` int(11) AUTO_INCREMENT,
    `event_time` datetime,
    `name` varchar(30) DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE `watchlist` (
	`id` int(11) AUTO_INCREMENT,
    `watchlistcode` varchar(30) DEFAULT NULL,
    `symbol` varchar(30) DEFAULT NULL,
    `active` varchar(30) DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE `stockquote` (
	`id` int(11) AUTO_INCREMENT,
    `symbol` varchar(30) DEFAULT NULL,
    `price_time` datetime,
    `close_price` double,
    `high_price` double,
    `low_price` double,
    `open_price` double,
    `volume` double,
    PRIMARY KEY (id)
);

CREATE TABLE `member` (
	`id` int(11) AUTO_INCREMENT,
    `username` varchar(30) DEFAULT NULL,
    `active` varchar(30) DEFAULT NULL,
    `email` varchar(30) DEFAULT NULL,
    `fullname` varchar(30) DEFAULT NULL,
    `password` varchar(30) DEFAULT NULL,
    `role` varchar(30) DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE `signalhistory` (
	`id` int(11) AUTO_INCREMENT,
    `symbol` varchar(30) DEFAULT NULL,
    `signal_time` datetime,
    `signal_name` varchar(30) DEFAULT NULL,
    `signal_price` double,
    PRIMARY KEY (id)
);

CREATE TABLE `signalperday` (
	`id` int(11) AUTO_INCREMENT,
    `signal_day` varchar(30) DEFAULT NULL,
    `symbol` varchar(30) DEFAULT NULL,
    `signal_name` varchar(30) DEFAULT NULL,
    `signal_price` double,
    PRIMARY KEY (id)
);