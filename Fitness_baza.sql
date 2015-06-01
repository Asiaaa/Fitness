-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Czas generowania: 01 Cze 2015, 21:15
-- Wersja serwera: 5.6.21
-- Wersja PHP: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Baza danych: `fitness`
--

DELIMITER $$
--
-- Procedury
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `rejestracja`(IN `login` VARCHAR(20), IN `haslo` VARCHAR(32), IN `imie` VARCHAR(32), IN `nazwisko` VARCHAR(32), IN `email` VARCHAR(32), IN `telefon` VARCHAR(32))
    NO SQL
begin
INSERT INTO UZYTKOWNIK (LOGIN, HASLO, IMIE, NAZWISKO, EMAIL, TELEFON, OPIS) VALUES (login, haslo, imie, nazwisko, email, telefon, null);
INSERT INTO AUTORYZACJA (ID_UZYTKOWNIK, ROLA) VALUES (last_insert_id(), "ROLE_USER");
end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `autoryzacja`
--

CREATE TABLE IF NOT EXISTS `autoryzacja` (
`id_rola` int(5) unsigned NOT NULL,
  `id_uzytkownik` int(5) unsigned NOT NULL,
  `rola` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `autoryzacja`
--

INSERT INTO `autoryzacja` (`id_rola`, `id_uzytkownik`, `rola`) VALUES
(1, 1, 'ROLE_ADMIN'),
(2, 2, 'ROLE_STAFF'),
(3, 4, 'ROLE_USER'),
(4, 3, 'ROLE_INSTRUCTOR');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `dni_tygodnia`
--

CREATE TABLE IF NOT EXISTS `dni_tygodnia` (
`id_dzien_tygodnia` int(5) unsigned NOT NULL,
  `nazwa` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `dni_tygodnia`
--

INSERT INTO `dni_tygodnia` (`id_dzien_tygodnia`, `nazwa`) VALUES
(1, 'poniedzialek'),
(2, 'wtorek'),
(3, 'sroda'),
(4, 'czwartek'),
(5, 'piatek'),
(6, 'sobota'),
(7, 'niedziela');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `grafik_fitness`
--

CREATE TABLE IF NOT EXISTS `grafik_fitness` (
`id_grafik_fitness` int(5) unsigned NOT NULL,
  `id_zajecia` int(5) unsigned NOT NULL,
  `id_instruktor` int(5) unsigned NOT NULL,
  `godz_start` time NOT NULL,
  `godz_koniec` time NOT NULL,
  `id_dzien_tygodnia` int(5) unsigned NOT NULL,
  `id_sala` int(5) unsigned NOT NULL,
  `max_ilosc_miejsc` int(5) unsigned NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `grafik_fitness`
--

INSERT INTO `grafik_fitness` (`id_grafik_fitness`, `id_zajecia`, `id_instruktor`, `godz_start`, `godz_koniec`, `id_dzien_tygodnia`, `id_sala`, `max_ilosc_miejsc`) VALUES
(1, 1, 3, '09:00:00', '10:00:00', 1, 1, 20),
(2, 2, 3, '15:00:00', '16:00:00', 5, 1, 20),
(3, 1, 3, '11:00:00', '12:00:00', 4, 1, 10);

-- --------------------------------------------------------

--
-- Zastąpiona struktura widoku `grafik_fitness_view`
--
CREATE TABLE IF NOT EXISTS `grafik_fitness_view` (
`id_grafik_fitness` int(5) unsigned
,`id_sala` int(5) unsigned
,`id_instruktor` int(5) unsigned
,`godz_start` time
,`godz_koniec` time
,`id_dzien_tygodnia` int(5) unsigned
,`nazwa` varchar(30)
);
-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `grafik_silownia`
--

CREATE TABLE IF NOT EXISTS `grafik_silownia` (
`id_grafik_silownia` int(5) unsigned NOT NULL,
  `id_dzien_tygodnia` int(5) unsigned NOT NULL,
  `godz_start_dyzur` time NOT NULL,
  `godz_koniec_dyzur` time NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `grafik_silownia`
--

INSERT INTO `grafik_silownia` (`id_grafik_silownia`, `id_dzien_tygodnia`, `godz_start_dyzur`, `godz_koniec_dyzur`) VALUES
(1, 2, '09:00:00', '17:00:00');

-- --------------------------------------------------------

--
-- Zastąpiona struktura widoku `grafik_silownia_view`
--
CREATE TABLE IF NOT EXISTS `grafik_silownia_view` (
`id_grafik_silownia` int(5) unsigned
,`godz_start_dyzur` time
,`godz_koniec_dyzur` time
,`id_dzien_tygodnia` int(5) unsigned
,`imie` varchar(32)
,`nazwisko` varchar(32)
,`id_uzytkownik` int(5) unsigned
);
-- --------------------------------------------------------

--
-- Zastąpiona struktura widoku `instruktorzy_view`
--
CREATE TABLE IF NOT EXISTS `instruktorzy_view` (
`id_uzytkownik` int(5) unsigned
,`imie` varchar(32)
,`nazwisko` varchar(32)
,`opis` text
);
-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `instruktor_silownia`
--

CREATE TABLE IF NOT EXISTS `instruktor_silownia` (
`id_instruktor_grafik` int(5) unsigned NOT NULL,
  `id_instruktor` int(5) unsigned NOT NULL,
  `id_grafik_silownia` int(5) unsigned NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `instruktor_silownia`
--

INSERT INTO `instruktor_silownia` (`id_instruktor_grafik`, `id_instruktor`, `id_grafik_silownia`) VALUES
(1, 3, 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `rezerwacja`
--

CREATE TABLE IF NOT EXISTS `rezerwacja` (
`id_rezerwacja` int(5) unsigned NOT NULL,
  `id_grafik_fitness` int(5) unsigned NOT NULL,
  `id_grafik_silownia` int(5) unsigned DEFAULT NULL,
  `id_klient` int(5) unsigned NOT NULL,
  `data` date DEFAULT NULL,
  `godz_start` time DEFAULT NULL,
  `godz_koniec` time DEFAULT NULL,
  `id_typ_zajec` int(5) unsigned DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `rezerwacja`
--

INSERT INTO `rezerwacja` (`id_rezerwacja`, `id_grafik_fitness`, `id_grafik_silownia`, `id_klient`, `data`, `godz_start`, `godz_koniec`, `id_typ_zajec`) VALUES
(8, 3, NULL, 4, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `sala`
--

CREATE TABLE IF NOT EXISTS `sala` (
`id_sala` int(5) unsigned NOT NULL,
  `numer` int(5) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `sala`
--

INSERT INTO `sala` (`id_sala`, `numer`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `stopien_trudnosci`
--

CREATE TABLE IF NOT EXISTS `stopien_trudnosci` (
`id_stopien_trudnosci` int(5) unsigned NOT NULL,
  `nazwa` varchar(20) NOT NULL,
  `skala` int(5) unsigned NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `stopien_trudnosci`
--

INSERT INTO `stopien_trudnosci` (`id_stopien_trudnosci`, `nazwa`, `skala`) VALUES
(1, 'niski', 1),
(2, 'sredni', 2),
(3, 'wysoki', 3);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `typ_zajec`
--

CREATE TABLE IF NOT EXISTS `typ_zajec` (
`id_typ_zajec` int(5) unsigned NOT NULL,
  `nazwa` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `typ_zajec`
--

INSERT INTO `typ_zajec` (`id_typ_zajec`, `nazwa`) VALUES
(1, 'fitness'),
(2, 'silownia');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `uzytkownik`
--

CREATE TABLE IF NOT EXISTS `uzytkownik` (
`id_uzytkownik` int(5) unsigned NOT NULL,
  `login` varchar(20) NOT NULL,
  `haslo` varchar(32) CHARACTER SET utf16 NOT NULL,
  `imie` varchar(32) CHARACTER SET utf16 NOT NULL,
  `nazwisko` varchar(32) NOT NULL,
  `email` varchar(32) NOT NULL,
  `telefon` varchar(32) NOT NULL,
  `opis` text
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `uzytkownik`
--

INSERT INTO `uzytkownik` (`id_uzytkownik`, `login`, `haslo`, `imie`, `nazwisko`, `email`, `telefon`, `opis`) VALUES
(1, 'alpha', 'alpha', 'Mateusz', 'Królikowski', 'mkrolikowski@fitness.pl', '791566341', 'Administrator strony fitness.'),
(2, 'beti', 'beti', 'Beata', 'Jankowska', 'bjankowska@fitness.pl', '605489331', 'Pracownik recepcji.'),
(3, 'dario', 'dario', 'Dariusz', 'Ostrowski', 'dostrowski', '888481265', 'Trener siłowni.'),
(4, 'kaska', 'kaska', 'Katarzyna', 'Smuda', 'ksmuda@onet.pl', '502964723', NULL);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `zajecia`
--

CREATE TABLE IF NOT EXISTS `zajecia` (
`id_zajecia` int(5) unsigned NOT NULL,
  `nazwa` varchar(30) NOT NULL,
  `czas_trwania` time NOT NULL,
  `id_stopien_trudnosci` int(5) unsigned NOT NULL,
  `opis` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `zajecia`
--

INSERT INTO `zajecia` (`id_zajecia`, `nazwa`, `czas_trwania`, `id_stopien_trudnosci`, `opis`) VALUES
(1, 'BPU', '01:00:00', 2, 'Trening modelujący dolne partie ciała, brzuch, pośladki i uda. Składa się z rozgrzewki w prostym układzie choreograficznym oraz części ćwiczeń modelujących. '),
(2, 'Pump', '01:00:00', 3, 'Trening z wykorzystaniem sztang o zróżnicowanym obciążeniu. Ma wpływ na poprawę wydolności organizmu, wzrost wytrzymałości i siły mięśni bez wzrostu ich obwodów, utratę tkanki tłuszczowej oraz przeciwdziała osteoporozie. '),
(3, 'Step', '01:00:00', 3, 'Trening wytrzymałościowy prowadzony na specjalnie przeznaczonych do tego platformach. Doskonale działa na mięśnie nóg, pośladków, wzmacnia układ sercowo- mięśniowy, a do tego poprawia kondycję i pomaga stracić zbędne kilogramy. Sekwencje prostych kroków oraz ich ewolucje umożliwiają dopasowanie zajęć do każdego poziomu zaawansowania co czyni je niezwykle atrakcyjnymi. '),
(4, 'Zumba', '01:00:00', 3, 'Jest to zainspirowana latynoskimi rytmami fuzja tańca i aerobiku. Zumba jest bardzo innowacyjnym systemem fitness, który poprzez świetną zabawę kształtuje naszą sylwetkę, dba o naszą kondycję, a przede wszystkim napawa nas optymizmem i wprawia w świetne samopoczucie, które zostaje na długo, długo poza zajęciami. Proste kroki taneczne, świetne kombinacje ruchów i motywująca muzyka stwarzają atmosferę świetnej imprezy i totalnie porywają nas do zabawy.'),
(5, 'TRX', '01:00:00', 3, 'TRX to system regulowanych pasków w kształcie litery Y, zrobionych z niezwykle wytrzymałego polimeru. Urządzenie daje możliwość kompleksowego treningu całego ciała. '),
(6, 'Pilates', '01:00:00', 1, 'Podstawą tej techniki jest oddychanie, na którym oparte są wszystkie ćwiczenia. Technika polega na precyzyjnym spinaniu, rozluźnianiu oraz rozciąganiu poszczególnych partii mięśniowych. Polecany dla osób z wadami postawy oraz dolegliwościami związanymi z kręgosłupem. '),
(7, 'Body Ball', '01:00:00', 1, 'Trening z wykorzystaniem piłek o różnej średnicy. Wykonuje się ćwiczenia na wszystkie grupy mięśniowe, polecany jest również dla osób, które mają problemy z kręgosłupem. '),
(8, 'Indoor Cycling', '01:00:00', 3, 'To połączenie treningu grupowego z treningiem kolarskim na rowerze stacjonarnym. Dzięki takiemu rozwiązaniu każdy trening jest planowany i kontrolowany przez wyszkolonego instruktora, wzrasta motywacja i atrakcyjność zajęć dzięki odpowiedniej, energetyzującej muzyce oraz poczuciu „bycia w grupie”. Indoor Cycling nie wymaga poczucia rytmu, tanecznych ruchów ani znajomości specyficznych kroków. Jest treningiem bezpiecznym, w którym ryzyko kontuzji ograniczone jest do minimum. ');

-- --------------------------------------------------------

--
-- Zastąpiona struktura widoku `zajecia_view`
--
CREATE TABLE IF NOT EXISTS `zajecia_view` (
`czas_trwania` time
,`id_zajecia` int(5) unsigned
,`nazwa` varchar(30)
,`opis` text
,`stopien_trudnosci` varchar(20)
);
-- --------------------------------------------------------

--
-- Struktura widoku `grafik_fitness_view`
--
DROP TABLE IF EXISTS `grafik_fitness_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `grafik_fitness_view` AS select `grafik_fitness`.`id_grafik_fitness` AS `id_grafik_fitness`,`grafik_fitness`.`id_sala` AS `id_sala`,`grafik_fitness`.`id_instruktor` AS `id_instruktor`,`grafik_fitness`.`godz_start` AS `godz_start`,`grafik_fitness`.`godz_koniec` AS `godz_koniec`,`grafik_fitness`.`id_dzien_tygodnia` AS `id_dzien_tygodnia`,`zajecia`.`nazwa` AS `nazwa` from (`grafik_fitness` join `zajecia`) where (`grafik_fitness`.`id_zajecia` = `zajecia`.`id_zajecia`);

-- --------------------------------------------------------

--
-- Struktura widoku `grafik_silownia_view`
--
DROP TABLE IF EXISTS `grafik_silownia_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `grafik_silownia_view` AS select `gs`.`id_grafik_silownia` AS `id_grafik_silownia`,`gs`.`godz_start_dyzur` AS `godz_start_dyzur`,`gs`.`godz_koniec_dyzur` AS `godz_koniec_dyzur`,`gs`.`id_dzien_tygodnia` AS `id_dzien_tygodnia`,`u`.`imie` AS `imie`,`u`.`nazwisko` AS `nazwisko`,`u`.`id_uzytkownik` AS `id_uzytkownik` from ((`grafik_silownia` `gs` join `instruktor_silownia` `i`) join `uzytkownik` `u`) where ((`gs`.`id_grafik_silownia` = `i`.`id_grafik_silownia`) and (`i`.`id_instruktor` = `u`.`id_uzytkownik`));

-- --------------------------------------------------------

--
-- Struktura widoku `instruktorzy_view`
--
DROP TABLE IF EXISTS `instruktorzy_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `instruktorzy_view` AS select `u`.`id_uzytkownik` AS `id_uzytkownik`,`u`.`imie` AS `imie`,`u`.`nazwisko` AS `nazwisko`,`u`.`opis` AS `opis` from (`uzytkownik` `u` join `autoryzacja` `a`) where ((`u`.`id_uzytkownik` = `a`.`id_uzytkownik`) and (`a`.`id_rola` = 4));

-- --------------------------------------------------------

--
-- Struktura widoku `zajecia_view`
--
DROP TABLE IF EXISTS `zajecia_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `zajecia_view` AS select `z`.`czas_trwania` AS `czas_trwania`,`z`.`id_zajecia` AS `id_zajecia`,`z`.`nazwa` AS `nazwa`,`z`.`opis` AS `opis`,`st`.`nazwa` AS `stopien_trudnosci` from (`zajecia` `z` join `stopien_trudnosci` `st`) where (`z`.`id_stopien_trudnosci` = `st`.`id_stopien_trudnosci`);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `autoryzacja`
--
ALTER TABLE `autoryzacja`
 ADD PRIMARY KEY (`id_rola`), ADD KEY `id_uzytkownik` (`id_uzytkownik`);

--
-- Indexes for table `dni_tygodnia`
--
ALTER TABLE `dni_tygodnia`
 ADD PRIMARY KEY (`id_dzien_tygodnia`);

--
-- Indexes for table `grafik_fitness`
--
ALTER TABLE `grafik_fitness`
 ADD PRIMARY KEY (`id_grafik_fitness`), ADD KEY `id_zajecia` (`id_zajecia`), ADD KEY `id_instruktor` (`id_instruktor`), ADD KEY `id_dzien_tygodnia` (`id_dzien_tygodnia`), ADD KEY `id_sala` (`id_sala`);

--
-- Indexes for table `grafik_silownia`
--
ALTER TABLE `grafik_silownia`
 ADD PRIMARY KEY (`id_grafik_silownia`), ADD KEY `id_dzien_tygodnia` (`id_dzien_tygodnia`);

--
-- Indexes for table `instruktor_silownia`
--
ALTER TABLE `instruktor_silownia`
 ADD PRIMARY KEY (`id_instruktor_grafik`), ADD KEY `id_instruktor` (`id_instruktor`), ADD KEY `id_grafik_silownia` (`id_grafik_silownia`);

--
-- Indexes for table `rezerwacja`
--
ALTER TABLE `rezerwacja`
 ADD PRIMARY KEY (`id_rezerwacja`), ADD KEY `id_grafik_fitness` (`id_grafik_fitness`), ADD KEY `id_grafik_silownia` (`id_grafik_silownia`), ADD KEY `id_klient` (`id_klient`), ADD KEY `id_typ_zajec` (`id_typ_zajec`);

--
-- Indexes for table `sala`
--
ALTER TABLE `sala`
 ADD PRIMARY KEY (`id_sala`);

--
-- Indexes for table `stopien_trudnosci`
--
ALTER TABLE `stopien_trudnosci`
 ADD PRIMARY KEY (`id_stopien_trudnosci`);

--
-- Indexes for table `typ_zajec`
--
ALTER TABLE `typ_zajec`
 ADD PRIMARY KEY (`id_typ_zajec`);

--
-- Indexes for table `uzytkownik`
--
ALTER TABLE `uzytkownik`
 ADD PRIMARY KEY (`id_uzytkownik`);

--
-- Indexes for table `zajecia`
--
ALTER TABLE `zajecia`
 ADD PRIMARY KEY (`id_zajecia`), ADD KEY `id_stopien_trudnosci` (`id_stopien_trudnosci`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `autoryzacja`
--
ALTER TABLE `autoryzacja`
MODIFY `id_rola` int(5) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT dla tabeli `dni_tygodnia`
--
ALTER TABLE `dni_tygodnia`
MODIFY `id_dzien_tygodnia` int(5) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT dla tabeli `grafik_fitness`
--
ALTER TABLE `grafik_fitness`
MODIFY `id_grafik_fitness` int(5) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT dla tabeli `grafik_silownia`
--
ALTER TABLE `grafik_silownia`
MODIFY `id_grafik_silownia` int(5) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT dla tabeli `instruktor_silownia`
--
ALTER TABLE `instruktor_silownia`
MODIFY `id_instruktor_grafik` int(5) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT dla tabeli `rezerwacja`
--
ALTER TABLE `rezerwacja`
MODIFY `id_rezerwacja` int(5) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT dla tabeli `sala`
--
ALTER TABLE `sala`
MODIFY `id_sala` int(5) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT dla tabeli `stopien_trudnosci`
--
ALTER TABLE `stopien_trudnosci`
MODIFY `id_stopien_trudnosci` int(5) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT dla tabeli `typ_zajec`
--
ALTER TABLE `typ_zajec`
MODIFY `id_typ_zajec` int(5) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT dla tabeli `uzytkownik`
--
ALTER TABLE `uzytkownik`
MODIFY `id_uzytkownik` int(5) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT dla tabeli `zajecia`
--
ALTER TABLE `zajecia`
MODIFY `id_zajecia` int(5) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `grafik_fitness`
--
ALTER TABLE `grafik_fitness`
ADD CONSTRAINT `grafik_fitness_ibfk_1` FOREIGN KEY (`id_zajecia`) REFERENCES `zajecia` (`id_zajecia`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `grafik_fitness_ibfk_2` FOREIGN KEY (`id_instruktor`) REFERENCES `uzytkownik` (`id_uzytkownik`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `grafik_fitness_ibfk_3` FOREIGN KEY (`id_dzien_tygodnia`) REFERENCES `dni_tygodnia` (`id_dzien_tygodnia`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `grafik_fitness_ibfk_4` FOREIGN KEY (`id_sala`) REFERENCES `sala` (`id_sala`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ograniczenia dla tabeli `grafik_silownia`
--
ALTER TABLE `grafik_silownia`
ADD CONSTRAINT `grafik_silownia_ibfk_1` FOREIGN KEY (`id_dzien_tygodnia`) REFERENCES `dni_tygodnia` (`id_dzien_tygodnia`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ograniczenia dla tabeli `instruktor_silownia`
--
ALTER TABLE `instruktor_silownia`
ADD CONSTRAINT `instruktor_silownia_ibfk_1` FOREIGN KEY (`id_instruktor`) REFERENCES `uzytkownik` (`id_uzytkownik`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `instruktor_silownia_ibfk_2` FOREIGN KEY (`id_grafik_silownia`) REFERENCES `grafik_silownia` (`id_grafik_silownia`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ograniczenia dla tabeli `rezerwacja`
--
ALTER TABLE `rezerwacja`
ADD CONSTRAINT `rezerwacja_ibfk_1` FOREIGN KEY (`id_grafik_fitness`) REFERENCES `grafik_fitness` (`id_grafik_fitness`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `rezerwacja_ibfk_2` FOREIGN KEY (`id_grafik_silownia`) REFERENCES `grafik_silownia` (`id_grafik_silownia`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `rezerwacja_ibfk_3` FOREIGN KEY (`id_klient`) REFERENCES `uzytkownik` (`id_uzytkownik`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `rezerwacja_ibfk_4` FOREIGN KEY (`id_typ_zajec`) REFERENCES `typ_zajec` (`id_typ_zajec`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ograniczenia dla tabeli `zajecia`
--
ALTER TABLE `zajecia`
ADD CONSTRAINT `zajecia_ibfk_1` FOREIGN KEY (`id_stopien_trudnosci`) REFERENCES `stopien_trudnosci` (`id_stopien_trudnosci`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
