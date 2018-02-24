
-- 1. List ut all informasjon (ordrehode og ordredetalj) om ordrer for leverandør nr 44.
SELECT * from ordredetalj
  NATURAL JOIN ordrehode
WHERE levnr = 44;

-- 2. Finn navn og by ("LevBy") for leverandører som kan levere del nummer 1.
SELECT navn, levby
FROM levinfo
  NATURAL JOIN prisinfo
WHERE delnr = 1;

-- 3. Finn nummer, navn og pris for den leverandør som kan levere del nummer 201 til billigst pris.
SELECT levinfo.levnr, levinfo.navn, prisinfo.pris
FROM levinfo
  NATURAL JOIN prisinfo
WHERE delnr = 201
ORDER BY pris
LIMIT 1;

-- 4. Lag fullstendig oversikt over ordre nr 16, med ordrenr, dato, delnr, beskrivelse, kvantum, (enhets-)pris og beregnet beløp (=pris*kvantum).
SELECT ordrenr,dato,delnr,beskrivelse,kvantum, concat(pris*ordredetalj.kvantum) AS Totalbeløp
FROM ordrehode
  NATURAL JOIN ordredetalj NATURAL JOIN prisinfo NATURAL JOIN delinfo
WHERE ordrenr = 16;

-- 5. Finn delnummer og leverandørnummer for deler som har en pris som er høyere enn prisen for del med katalognr X7770.
SELECT delnr, levnr
FROM prisinfo
WHERE pris > (SELECT pris FROM prisinfo WHERE katalognr = 'X7770');

-- 6
-- i)
-- Tenk deg at tabellen levinfo skal deles i to.
-- Sammenhengen mellom by og fylke skal tas ut av tabellen.
-- Det er unødvendig å lagre fylketilhørigheten for hver forekomst av by.
-- Lag én ny tabell som inneholder byer og fylker. Fyll denne med data fra levinfo.
-- Lag også en tabell som er lik levinfo unntatt kolonnen Fylke. (Denne splittingen av tabellen levinfo gjelder bare i denne oppgaven.
-- I resten av oppgavesettet antar du at du har den opprinnelige levinfo-tabellen.)
CREATE TABLE nySplittet AS
  SELECT DISTINCT levby,fylke
  FROM levinfo;

CREATE TABLE nySplittet2 AS
  SELECT levnr,navn,adresse,levby,postnr
  FROM levinfo;

-- ii)
-- Lag en virtuell tabell (view) slik at brukerne i størst mulig grad kan jobbe på samme måte mot de to nye tabellene som den gamle.
-- Prøv ulike kommandoer mot tabellen (select, update, delete, insert). Hvilke begrensninger, hvis noen, har brukerne i forhold til tidligere?
CREATE VIEW virtuellNySplittet AS
  SELECT * FROM nySplittet;

CREATE VIEW virtuellNySplittet2 AS
  SELECT * FROM nySplittet2;

UPDATE nySplittet
SET levby = 'Bodø'
WHERE fylke = 'Oslo';

UPDATE virtuellNySplittet
SET levby = 'Oslo'
WHERE fylke='Oslo';

INSERT INTO virtuellNySplittet VALUES ('Bodø','Nordland');

--  7. Anta at en vurderer å slette opplysningene om de leverandørene som ikke er representert i Prisinfo-tabellen.
--  Finn ut hvilke byer en i tilfelle ikke får leverandør i. (Du skal ikke utføre slettingen.) (Tips: Svaret skal bli kun én by, "Ål".)
SELECT levby
FROM levinfo
WHERE levby NOT IN (SELECT levby from prisinfo NATURAL JOIN levinfo);

-- Oppgave 2

-- A)
-- Sett opp en SELECT-setning som er UNION mellom alle forlag med Oslo-nummer (telefonnummer begynner med 2) og alle som ikke er Oslo-nummer.
-- Får du med forlaget med NULL-verdi på telefonnummer? Hvis ikke, utvid unionen med en mengde til.
SELECT * FROM forlag WHERE telefon LIKE '2%'
UNION
SELECT * FROM forlag;

-- B)
-- Sett opp SQL-setninger som finner gjennomsnittlig alder på forfattere der fødselsåret er oppgitt.
-- For forfattere der dødsåret ikke er oppgitt, skal du kun ta med de som er født etter 1900.  Tips for å få ut året i år:
-- MySQL: SELECT YEAR(CURRENT_DATE) FROM ... hvilken tabell som helst ..
SELECT AVG(forfatter.dod_aar-forfatter.fode_aar)
FROM forfatter
WHERE dod_aar IS NOT NULL;

SELECT AVG(YEAR(current_date)-forfatter.fode_aar) FROM forfatter
WHERE dod_aar IS NULL AND fode_aar>1900;

-- C)
-- Sett opp SQL-setninger som finner hvor stor andel av forfatterne som ble med i beregningene under b).
CREATE VIEW dead1 AS SELECT forfatter_id,forfatter.dod_aar-forfatter.fode_aar
                     FROM forfatter
                     WHERE dod_aar IS NOT NULL;

CREATE VIEW dead2 AS SELECT forfatter_id, YEAR(current_date)-forfatter.fode_aar FROM forfatter
WHERE dod_aar IS NULL AND fode_aar>1900;

CREATE VIEW forf_age AS
  SELECT * FROM dead1
  UNION
  SELECT * FROM dead2;

SELECT (SELECT count(forfatter_id) FROM forf_age) / (SELECT count(forfatter_id) FROM forfatter)*100;