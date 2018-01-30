#1
SELECT navn,tlf,epost FROM Bedrift;

#2
SELECT oppdragsNR,navn,tlf FROM oppdrag,Bedrift where organisasjon=Bedrift.organisasjonNr;

#3
SELECT Kandidat.kandidatID,Fornavn,Etternavn, kvalifikasjon FROM Kandidat,kvalifikasjon where Kandidat.kandidatID=kvalifikasjon.kandidatID;

#4
SELECT Kandidat.kandidatID,Fornavn,Etternavn, kvalifikasjon from Kandidat LEFT JOIN kvalifikasjon ON Kandidat.kandidatID = kvalifikasjon.kandidatID;

#5
SELECT Fornavn,Etternavn,sluttdato,oppdrag,navn FROM historik,Kandidat,Bedrift WHERE KandidatID=3 and historik.kandidat=Kandidat.kandidatID and =historik.oppdrag;

