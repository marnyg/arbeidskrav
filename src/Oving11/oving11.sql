
-- 1.   Finn alle borettslag etablert i årene 1975-1985.

SELECT bolag_navn FROM borettslag WHERE etabl_aar BETWEEN 1975 AND 1985;

-- 2.   Skriv ut en liste over andelseiere. Listen skal ha linjer som ser slik ut (tekster i kursiv er data fra databasen):
--      "fornavn etternavn, ansiennitet: ansiennitet år".
--      Listen skal være sortert på ansiennitet, de med lengst ansiennitet øverst.

SELECT CONCAT(fornavn, ' ', etternavn, ', ansiennitet: ', ansiennitet)
  FROM andelseier
  ORDER BY ansiennitet
  DESC;

-- 3.   I hvilket år ble det eldste borettslaget etablert?

SELECT etabl_aar FROM borettslag ORDER BY etabl_aar ASC LIMIT 1;

-- 4.   Finn adressene til alle bygninger som inneholder leiligheter med minst tre rom.
-- MAA gjoeres paa nytt!

SELECT bygn_adr, COUNT(leilighet.ant_rom) AS leiligheter_m_minst_3
  FROM leilighet JOIN bygning ON leilighet.bygn_id = bygning.bygn_id
  GROUP BY bygn_adr
  HAVING leiligheter_m_minst_3 > 2;

-- 5.   Finn antall bygninger i borettslaget "Tertitten".

SELECT bolag_navn, COUNT(bolag_navn) AS antall_bygninger
  FROM (borettslag NATURAL JOIN bygning)
  GROUP BY bolag_navn
  HAVING bolag_navn = 'Tertitten';

-- 6.   Lag en liste som viser antall bygninger i hvert enkelt borettslag. Listen skal være sortert på borettslagsnavn.
--      Husk at det kan finnes borettslag uten bygninger - de skal også med.

SELECT borettslag.bolag_navn, COUNT(bygning.bolag_navn) AS antall_bygninger
  FROM borettslag LEFT JOIN bygning ON borettslag.bolag_navn = bygning.bolag_navn
  GROUP BY borettslag.bolag_navn
  ORDER BY antall_bygninger DESC;

-- 7.   Finn antall leiligheter i borettslaget "Tertitten".

SELECT borettslag.bolag_navn, COUNT(leilighet.bygn_id) AS antall_leiligheter
  FROM borettslag LEFT JOIN bygning ON borettslag.bolag_navn = bygning.bolag_navn
  LEFT JOIN leilighet ON bygning.bygn_id = leilighet.bygn_id
  GROUP BY borettslag.bolag_navn
  HAVING borettslag.bolag_navn = 'Tertitten';

-- 8.   Hvor høyt kan du bo i borettslaget "Tertitten"?

SELECT MAX(etasje) AS hoeste_etasje
  FROM borettslag RIGHT JOIN bygning b ON borettslag.bolag_navn = b.bolag_navn
  RIGHT JOIN leilighet l ON b.bygn_id = l.bygn_id;

-- 9.   Finn navn og nummer til andelseiere som ikke har leilighet.

SELECT fornavn, etternavn, telefon
FROM andelseier
WHERE and_eier_nr NOT IN(
  SELECT and_eier_nr FROM leilighet
);

-- 10.  Finn antall andelseiere pr borettslag, sortert etter antallet. Husk at det kan finnes borettslag uten andelseiere - de skal også med.

SELECT borettslag.bolag_navn, COUNT(andelseier.bolag_navn) AS andelseiere
FROM borettslag LEFT JOIN andelseier ON borettslag.bolag_navn = andelseier.bolag_navn
GROUP BY borettslag.bolag_navn
ORDER BY andelseiere DESC;

-- 11.  Skriv ut en liste over alle andelseiere. For de som har leilighet, skal leilighetsnummeret skrives ut.

SELECT IF((leil_nr IS NOT NULL),
          (CONCAT(fornavn, ' ', etternavn, ', leilighetsnummer: ', leil_nr)),
          (CONCAT(fornavn, ' ', etternavn))
       )
  AS andelseiere
  FROM andelseier
  LEFT JOIN leilighet
  ON andelseier.and_eier_nr = leilighet.and_eier_nr;

-- 12.  Hvilke borettslag har leiligheter med eksakt 4 rom?

SELECT bolag_navn
FROM bygning JOIN leilighet l ON bygning.bygn_id = l.bygn_id
WHERE ant_rom = 4
GROUP BY bolag_navn;

-- 13.  Skriv ut en liste over antall andelseiere pr postnr og poststed,
--      begrenset til de som bor i leiligheter tilknyttet et borettslag. Husk at postnummeret til disse er
--      postnummeret til bygningen de bor i, og ikke postnummeret til borettslaget.
--      Du trenger ikke ta med poststeder med 0 andelseiere. (Ekstraoppgave: Hva hvis vi vil ha med poststeder med 0 andelseiere?)

SELECT poststed, COUNT(fornavn) AS antall_eiere
  FROM poststed NATURAL JOIN bygning
  NATURAL JOIN leilighet
  NATURAL JOIN andelseier
  GROUP BY poststed;

