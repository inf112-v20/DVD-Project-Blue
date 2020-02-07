# DELOPPGAVE 1: ORGANISER TEAMET

Teamet består av Jørn, Håkon, Henrik, Tord og Gytis. Til dette prosjektet har vi valgt navnet DVD Project Blue. I tillegg til de tildelte rollene vil samtlige medlemmer være utviklere.

**Jørn**  
Jørn har blitt tildelt rollen som teamleder. Teamleder har det overordnete ansvar for gruppen og kan ta endelige beslutninger ved uenigheter i gruppen. Jørn har mye erfaring fra programmering, og er godt kjent med C++, Rust, Haskell, Python, Javascript og Java. Ved siden av studiene har han et deltidsstilling som utvikler i EVRY. Han har også erfaring innen spillutvikling. 

**Håkon**  
Håkon fikk rollen som leveransekontrakt i gruppen. Leveransekontakten skal ha ansvar for at det endelige produktet er av god kvalitet og at kundene får en god opplevelse. Rollen som leveransekontakt innebærer blant annet å fjerne unødvendig kode og andre elementer som ikke er nødvendig. Håkon har nokså lite erfaring med programmering, og går masterstudiet i økonomi ved siden av. 

**Henrik**  
Gruppen ble enig om å gjøre Henrik til regelansvarlig. Den regelansvarlige skal ha kontroll på reglene av selve spillet, slik at de andre medlemmene i gruppen kan rådføre seg med denne personen. Rollen innebærer at man har oversikt over at de andre har implementert reglene riktig. Henrik anses til å ha god erfaring med programmering. 

**Gytis**  
Gytis fikk tildelt rollen som brett- og grafikkansvarlig. Som ansvarlig for grafikk og brett har man det overordnede ansvaret for  å velge selve utseende på spillet. Gytis har moderat erfaring innen programmering, og har jobbet både med haskell, java og python. I tillegg har han litt erfaring fra Adobe Photoshop, som kan være en relevant fordel med tanke på grafikken. 

**Tord**  
Vi mente det var nødvendig med et gruppemedlem som hadde hovedansvar for GitHub og som kunne være tilgjengelig for spørsmål angående dette. Tord ble tildelt denne rollen, og anses til å ha god erfaring med programmering.

# DELOPPGAVE 2

**Overordnet mål**  
Vi ønsker å lage en digital versjon av brettspillet Roborally, som er mer fornøyelig og behagelig og spille enn det klassiske nettbrettet, ved at man selv har større valgfrihet med hensyn til strukturering av elementene på skjermen for de ulike fasene av spillet. Spillets gang skal ellers være trivielt likt brettspillet. Vi har også som mål at det skal være mulig å spille mot hverandre på tvers av nettverk.

**Høynivåkrav/MVP**  
* Skjerm viser hver spillers kontrollpanel.
* Skjerm viser banen.
* Brikker vises på banen.
* Flere flagg vises på banen.
* Spillerne blir tildelt en brikke hver.
* Hver spillers brikke får en startposisjon.
* Spillere blir tildelt kort ni fungerer som instruksjoner for sin brikkes bevegelse hver runde.
* Spillere kan velge fem kort som instrukser for sin brikkes bevegelser.
* Spillere angir sine kort i en rekkefølge de ønsker deres brikke skal utføre dem.
* Fasen der robotene beveger seg starter da hver spiller har angitt valg av kort.
* En nedtelling starter dersom det kun er to spillere som ennå ikke har angitt valg av kort.
* En spillers brikke beveger seg i tråd med kortene vedkommende har valgt.
* Et kort utføres av gangen for hver spiller i fem runder, eller helt til det ikke er kort igjen.
* En spiller har liv som kan mistes.
* En spiller dør dersom alt av liv til vedkommendes brikke går tapt.
* En spiller kan skru av brikken sin en runde - Powerdown.
* Dersom en brikke er skrudd av vil den ikke bevege seg den runden.
* En brikke regenerer sitt liv den runden den er skrudd av.
* En brikke som skrus på igjen etter å ha vært skrudd av starter på sin startposisjon.
* En spillers brikke fyrer av laser i retningen den peker.
* En spillers brikke mister liv dersom den står i banen til en annen brikkes laser.
* En spillers brikke mister liv dersom den faller utenfor brettet.
* En spiller vinner dersom han besøker flaggene på brettet i rekkefølgen som spesifisert.
* En spiller vinner dersom vedkommendes brikke er den eneste i livet på brettet.

**Nice-to-have:**  
* LAN/Lokalnett funksjonalitet med en lobby system


# DELOPPGAVE 3

* Vi bruker Kanban (via GitHub sitt “project board”) for å ha en oversikt over hvem som jobber med hva, og hva som gjenstår. Vi likte Kanban bedre enn Scrum siden gruppen kan operere med en kontinuerlig arbeidsflyt som burde resultere i mer ren og teknisk bra kode, enn når man tar korte kode sprinter som i Scrum.-

* Vi har også tenkt å ta noen timer med parprogrammering. Da kan vi jobbe med en ting sammen i lag på 2 personer. Det som vi synes er bra med parprogrammering er at det er to roller: driver og navigator/observer. Når en av oss skriver, så kan den andre finne feilene i koden som blir skrevet og si ifra. Det kan hjelpe oss med å implementere features mer korrekt. En annen fordel er at ved hjelp av kommunikasjon i paret kan man lære seg mye nytt, da folk gjerne har forskjellig kompetanse som de kan dele med hverandre.

* Vi bruker Travis-CI og Codacy for å hjelpe oss å forbedre koden, og vi bruker TDD sammen med Gherkin tests under utviklingen.

* Vi bruker Slack til å kommunisere med hverandre og diskutere ting som er relevante for prosjektet. I tillegg vil vi bruke Discord for å organisere voicechats og skjermdeling når vi er ikke på gruppene/samlet.


# DELOPPGAVE 4

**Brukerhistorie 1** 

_Brukerhistorie_
 * Som spiller ønsker jeg å se hvilken retning min brikke peker i.

_Arbeidsoppgave_
 * Implementer grafikk som viser hvilken retning brikke peker i. Det må også Implementeres funksjonalitet for å rotere brikken i ulike antall grader.

_Akseptansekrav_
 * Brikken beveger seg kun fremover dersom brikken beveger seg. Dersom brikken skal bevege seg i en annen retning enn rett frem, må brikken først rotere til intendert retning. 


**Brukerhistorie 2**  

_Brukerhistorie_
 * Som spiller, ønsker jeg å kunne velge å forstørre mine tilgjengelig kort i forhold til resten av hva som vises på skjermen.

_Arbeidsoppgave_
 * I klassen som er ansvarlig for display av de ulike elementene på brettet, må det lages en funksjonalitet i en knapp som forstørrer sitt eget kontrollpanel, slik at man tydelig ser sine kort på skjermen.

_Akseptansekrav_
 * Sine valgmuligheter av kort forstørres da man trykker på en bestemt knapp på skjermen.


**Brukerhistorie 3**  

_Brukerhistorie_
 * Som spiller ønsker jeg å kunne velge å forstørre brettet der brikkene beveger seg mens rundens bevegelser skjer.

_Arbeidsoppgave_
 * I klassen som som er ansvarlig for display av de ulike elementene på brettet, må det lages en knapp som er koblet til funksjonalitet som forstørrer banen der robotene beveger seg.
 
_Akseptansekrav_
 * Banen der robotene beveger seg blir større da man trykker på en bestemt knapp på skjermen.


**Brukerhistorie 4**  

_Brukerhistorie_
 * Som spiller ønsker jeg at det er tidsbegrensning på hvor lang tid man får på å velge kort.

_Arbeidsoppgave_
 * Det må lages en klokke som teller ned i funksjonaliteten som administrerer fasen i runden der spillerne velger sine kort. Dersom tiden går ut vil de kortene som til nå er valgt bli spillernes endelige valg. Tidsbegrensningen må også være synlig på skjermen.

_Akseptansekrav_
 * En nedtelling vises på skjermen i den gitte fasen hver runde. Dersom 


**Brukerhistorie 5**  

_Brukerhistorie_
 * Som spiller ønsker jeg at nedtellingen med hensyn til tidsbegrensning blir mer synlig da det er ti sekunder igjen, ved at det teller ned fra ti med store tall på skjermen.

_Arbeidsoppgave_
 * I funksjonaliteten som teller ned i fasen da spillerne velger sine kort, må det lages funksjonalitet som gjør tallene som teller ned større, samt at de blinker på skjermen.

_Akseptansekrav_
 * Hvis det blir ti sekunder igjen av fasen der spillerne skal velge i sine kort, må tallene som illustrerer nedtellingen bli større, og blinke.


**Brukerhistorie 6**  

_Brukerhistorie_
 * Som spiller ønsker jeg en mulighet å spille med andre personer som er koblet på samme nettverket

_Arbeidsoppgave_
 * LAN biblioteket må importeres og implementeres på en riktig måte, så vi må alltid ha lokalnett løsningen i bakhodet

_Akseptansekrav_
 * Klare å koble seg sammen med andre som kjører spiller på sine datamaskiner ved hjelp av lobby system og spille sammen.


**Brukerhistorie 7**  

_Brukerhistorie_
 * Som spiller ønsker jeg en mulighet å velge kvalitet på grafikken.

_Arbeidsoppgave_
 * Å implementere ekstra knapp i menyen for å endre på grafikkens kvalitet ved hjelp av teksturer eller skjermoppløsning

_Akseptansekrav_
 * Man må kunne gå inn i innstillinger menyen og endre på spillets utseende


# Oppsummering   

Vi har opplevd både positive og negative elementer knyttet til gruppearbeidet frem til nå. Det er konkrete problemer med hensyn til samarbeid som må tas tak i. Gruppen er enige i hva slags type problemer dette er, og hva som må til for å løse problemene.

Det positive med arbeidet frem til nå er at vi føler den første leveransen ble god, og er på et nivå vi er fornøyd med. Vi er og sterke i troen på at den første leveransen baner god vei for effektivt arbeid videre, og en bra sluttleveranse.

Arbeidet har vært preget av det vi alle kaller “oppstartsproblemer”. Dette gikk ut på å lage en sluttleveranse som kjørte på alles maskiner, med hensyn til ulike versjoner av Java og ulike operativsystemer, og lwjgl. Det var også problemer knyttet til å få git-repo satt opp, og at alle fikk til å foreta seg de essensielle handlinger man gjør via git.

Samtidig føler vi at arbeidsoppgavene som skulle gjøres på tvers av teamet ikke var ordentlig organisert. Vi følte ikke dette hadde effekt på kvaliteten i denne leveransen, men som trolig vil ha negative konsekvenser da oppgavene i prosjektet tiltar i kompleksitet. Dette mener vi vil forbedre seg med bruk av prosjektmetodikken som beskrevet i deloppgave 3.

Vi føler teamarbeidet til nå har belyst viktige problemstillinger med hensyn til oppstart og organisering av gruppearbeidet. Vi har måtte finne løsninger på dette. Vi mener disse løsningene er til god hjelp for kvaliteten på leveransene som kommer, og at det vil ha svært positiv effekt på vår trivsel i videre arbeid.

