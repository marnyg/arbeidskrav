DROP TABLE IF EXISTS oppdrag, historik,kvalifikasjon,Kandidat,Bedrift;


CREATE TABLE Kandidat (
  kandidatID iNTEGER PRIMARY KEY  NOT NULL AUTO_INCREMENT,
  Fornavn   VARCHAR(30),
  Etternavn VARCHAR(30),
  tlf       INTEGER,
  epost     VARCHAR(30)

);
create table Bedrift(
  organisasjonNr INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
  navn VARCHAR(30),
  tlf INTEGER,
  epost VARCHAR(30)
);
CREATE TABLE kvalifikasjon (
  kvalifikasjon VARCHAR(30) PRIMARY KEY NOT NULL,
  kandidatID    INTEGER,
  CONSTRAINT kandidat_fk FOREIGN KEY (kandidatID) REFERENCES Kandidat (kandidatID)
);
CREATE TABLE oppdrag (
  oppdragsNR    INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
  bedriftNavn   VARCHAR(30),
  startdato     DATE,
  sluttdato     DATE,
  organisasjon  INTEGER,
  kvalifikasjon VARCHAR(30),
  CONSTRAINT kval_fk FOREIGN KEY (kvalifikasjon) REFERENCES kvalifikasjon (kvalifikasjon),
  CONSTRAINT organisasjon_fk FOREIGN KEY (organisasjon) REFERENCES Bedrift (organisasjonNr)

);


CREATE TABLE historik (
  logID     INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
  startdato DATE,
  sluttdato DATE,
  antTimer  INTEGER,
  kandidat  INTEGER,
  oppdrag   INTEGER,
  CONSTRAINT oppdrag_fk FOREIGN KEY (oppdrag) REFERENCES oppdrag (oppdragsNR),
  CONSTRAINT kandidat_fkk FOREIGN KEY (kandidat) REFERENCES Kandidat (kandidatID)

);

INSERT Bedrift(navn, tlf, epost) VALUES ('Bedrift1',123,'epost@1');
INSERT Bedrift(navn, tlf, epost) VALUES ('Bedrift2',124,'epost@2');
INSERT Bedrift(navn, tlf, epost) VALUES ('Bedrift3',124,'epost@3');
INSERT Kandidat(Fornavn, Etternavn, tlf, epost) VALUES ('fornavn1','etternavn1', 321,'person_epost1');
INSERT Kandidat(Fornavn, Etternavn, tlf, epost) VALUES ('fornavn2','etternavn2', 322,'person_epost2');
INSERT Kandidat(Fornavn, Etternavn, tlf, epost) VALUES ('fornavn3','etternavn3', 323,'person_epost3');
INSERT kvalifikasjon(kvalifikasjon, kandidatID) VALUES ('ting1',1);
INSERT kvalifikasjon(kvalifikasjon, kandidatID) VALUES ('ting2',2);
INSERT kvalifikasjon(kvalifikasjon, kandidatID) VALUES ('ting3',3);


INSERT oppdrag(bedriftNavn, startdato, sluttdato, organisasjon, kvalifikasjon) VALUES ('bedrift1',DATE ('2000-01-01'),DATE ('2000-02-02'),1,'ting1');
INSERT oppdrag(bedriftNavn, startdato, sluttdato, organisasjon, kvalifikasjon) VALUES ('bedrift2',DATE ('2001-01-01'),DATE ('2001-02-02'),2,'ting2');
INSERT oppdrag(bedriftNavn, startdato, sluttdato, organisasjon, kvalifikasjon) VALUES ('bedrift3',DATE ('2002-01-01'),DATE ('2002-02-02'),3,'ting3');


INSERT historik(startdato, sluttdato, antTimer, kandidat, oppdrag) VALUES(DATE('2000-01-01'),DATE ('2000-02-02'),20,1,1);
INSERT historik(startdato, sluttdato, antTimer, kandidat, oppdrag) VALUES(DATE('2001-01-01'),DATE ('2001-02-02'),21,2,2);
INSERT historik(startdato, sluttdato, antTimer, kandidat, oppdrag) VALUES(DATE('2002-01-01'),DATE ('2002-03-03'),22,3,3);

