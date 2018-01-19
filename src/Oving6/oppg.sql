#a)
#seleksjon
SELECT *
FROM bok
WHERE utgitt_aar > 1990;


#projeksjon
SELECT
  tittel,
  utgitt_aar
FROM bok;


#b)
#produktet forlag og bok
SELECT *
FROM forlag, bok;


#c)
#equijoin forlag og bok
SELECT *
FROM forlag, bok
WHERE forlag.forlag_id = bok.forlag_id;


#naturlig join forlag og bok
SELECT *
FROM bok
  NATURAL JOIN forlag;

#d)union
SELECT telefon
FROM forlag
UNION SELECT utgitt_aar
      FROM bok;


SELECT
  telefon,
  adresse
FROM forlag
UNION SELECT
        utgitt_aar,
        tittel
      FROM bok;

#oppg2
#a)finn navn p[ forlag
SELECT forlag_navn
FROM forlag;


#b)finn forlag som ikke har utgitt boker
SELECT DISTINCT forlag_navn, forlag_id
FROM forlag
WHERE forlag.forlag_id not in(SELECT forlag_id FROM bok);

#c)finn forfattere fodt i 1948
SELECT
  fornavn,
  etternavn
FROM forfatter
WHERE fode_aar = 1948;


#d)finn navn og adresse til forlag som har gitt ut boka 'generasjon X'
SELECT
  forlag_navn,
  adresse
FROM forlag
WHERE forlag_id IN (SELECT forlag_id
                    FROM bok
                    WHERE tittel = 'Generation X');


#e)finn tiltlene til hamsun sine boker
SELECT tittel
FROM bok
WHERE bok_id IN (
  SELECT bok_id
  FROM bok_forfatter
  WHERE forfatter_id IN (SELECT forfatter.forfatter_id
                         FROM forfatter
                         WHERE etternavn = 'Hamsun'));

#f)
SELECT DISTINCT tittel, utgitt_aar, forlag_navn FROM bok,forlag WHERE bok.forlag_id=forlag.forlag_id