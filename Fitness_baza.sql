-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Czas generowania: 21 Kwi 2015, 16:01
-- Wersja serwera: 5.6.20
-- Wersja PHP: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Baza danych: `fitness`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `dni_tygodnia`
--

CREATE TABLE IF NOT EXISTS `dni_tygodnia` (
`id_dzien_tygodnia` int(5) unsigned NOT NULL,
  `nazwa` varchar(20) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `grafik_silownia`
--

CREATE TABLE IF NOT EXISTS `grafik_silownia` (
`id_grafik_silownia` int(5) unsigned NOT NULL,
  `id_dzien_tygodnia` int(5) unsigned NOT NULL,
  `godz_start_dyzur` time NOT NULL,
  `godz_koniec_dyzur` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `instruktor_silownia`
--

CREATE TABLE IF NOT EXISTS `instruktor_silownia` (
`id_instruktor_grafik` int(5) unsigned NOT NULL,
  `id_instruktor` int(5) unsigned NOT NULL,
  `id_grafik_silownia` int(5) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `rezerwacja`
--

CREATE TABLE IF NOT EXISTS `rezerwacja` (
`id_rezerwacja` int(5) unsigned NOT NULL,
  `id_grafik_fitness` int(5) unsigned NOT NULL,
  `id_grafik_silownia` int(5) unsigned NOT NULL,
  `id_klient` int(5) unsigned NOT NULL,
  `data` date NOT NULL,
  `godz_start` time NOT NULL,
  `godz_koniec` time NOT NULL,
  `id_typ_zajec` int(5) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `sala`
--

CREATE TABLE IF NOT EXISTS `sala` (
`id_sala` int(5) unsigned NOT NULL,
  `numer` int(5) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

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
  `opis` text,
  `rola` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Indeksy dla zrzutów tabel
--

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
-- AUTO_INCREMENT dla tabeli `dni_tygodnia`
--
ALTER TABLE `dni_tygodnia`
MODIFY `id_dzien_tygodnia` int(5) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT dla tabeli `grafik_fitness`
--
ALTER TABLE `grafik_fitness`
MODIFY `id_grafik_fitness` int(5) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `grafik_silownia`
--
ALTER TABLE `grafik_silownia`
MODIFY `id_grafik_silownia` int(5) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `instruktor_silownia`
--
ALTER TABLE `instruktor_silownia`
MODIFY `id_instruktor_grafik` int(5) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `rezerwacja`
--
ALTER TABLE `rezerwacja`
MODIFY `id_rezerwacja` int(5) unsigned NOT NULL AUTO_INCREMENT;
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
MODIFY `id_uzytkownik` int(5) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `zajecia`
--
ALTER TABLE `zajecia`
MODIFY `id_zajecia` int(5) unsigned NOT NULL AUTO_INCREMENT;
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
