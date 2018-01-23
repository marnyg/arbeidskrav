CREATE TABLE Kandidat (
  kandidatID INTEGER NOT NULL AUTO_INCREMENT,
  Fornavn   VARCHAR(30),
  Etternavn VARCHAR(30),
  tlf       INTEGER,
  epost     VARCHAR(30)

);

CREATE TABLE oppdrag(
  oppdragsNR INTEGER NOT NULL AUTO_INCREMENT,
  bedriftNavn VARCHAR(30),
  startdato DATE,
  sluttdato DATE,

)
