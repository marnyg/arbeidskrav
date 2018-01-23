CREATE TABLE Kandidat (
  kandidatID iNTEGER PRIMARY KEY  NOT NULL AUTO_INCREMENT,
  Fornavn   VARCHAR(30),
  Etternavn VARCHAR(30),
  tlf       INTEGER,
  epost     VARCHAR(30)


);

CREATE TABLE oppdrag(
  oppdragsNR INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
  bedriftNavn VARCHAR(30),
  startdato DATE,
  sluttdato DATE
);

create table Bedrift(
  organisasjonNr INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
  navn VARCHAR(30),
  tlf INTEGER,
  epost VARCHAR(30)
);
CREATE TABLE kalifikasjon (
  kvalifikasjon VARCHAR(30) PRIMARY KEY NOT NULL
);
CREATE TABLE historik (
  logID     INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
  startdato DATE,
  sluttdato DATE,
  antTimer  INTEGER

);
