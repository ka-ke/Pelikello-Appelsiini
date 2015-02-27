Ohjelmani tuli olemaan kutakuinkin sitä mitä hain alussa takaa. Suosikkiasetuksia en 
ikävä kyllä kerennyt toteuttamaan. Fantasioin kuitenkin mobiilille kääntämisestä, 
sillä tällöin saisin ohjelmasta suurimman hyödyn omassa käytössä. 

Minulta loppui aika lopussa ja siitä saivat erityisesti kärsiä sekvenssikaaviot
sekä JUnit testit. Testeistä tipuin kärryiltä oikeastaan aika alkupuoliskolla.
Olen tehnyt testit ainoastaan alunperin logiikkakansiossa olleille Domain luokille.
Olen tällä viikolla pyrkinyt parhaani mukaan eriyttämään logiikkaa käyttöliittymistä,
mutta en koe onnistuneeni siinä kovinkaan hyvin. Tämän vuoksi testien tekeminen
viimeisellä viikolla osittain eriytyneelle logiikalle tuntui liian vaikealta toteuttaa.

Logiikkani nojautuu suurilta osin monimutkaisiin ActionListenereihin, joita lisätään
käyttöliittymän painikkeille. Lähdin tekemään tätä toteutusta ohjan GUI-tehtävien 
pohjalta. Lopullinen luokkakaavioni näyttää siksi hieman tyhjältä, mutta en nähnyt
järkeväksi lisätä kaikkia kuuntelijoita kaavioon, vaan olettaa ne sisältyviksi GUI-
luokkiin (niin kuin ne alunperin olivatkin). Luokkakaaviossani en ikävä kyllä ole 
saanut myöskään näkymään nuolia tai rajoituksia yhteyksiin, mutta ne ovat pääosin 1-1
tai sitten edellisten kaavioiden mukaisia. Tärkein pointti on GUIOhjain luokan dominoiva
asema GUI-luokkien herättäjänä. Osa GUI-luokista tosin tuntee muitakin luokkia ja käyttää
näiden attribuutteja hyväksi.


