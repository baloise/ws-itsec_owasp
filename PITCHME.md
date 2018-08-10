---?image=/res/owasp_logo.jpg&size=contain&color=black

+++?color=lightgray
## Agenda
1. Einleitung zu OWASP

2. A1 to A10
  1. Was ist A*
  2. Angriffsvektoren
  3. Demo
  4. Verteidigungsmassnahmen

3. Zusammenfassung


---?image=res/light_bulb.jpg&size=cover&opacity=60
# @color[#282828](**Einleitung**)

+++?image=res/light_bulb.jpg&size=cover&opacity=40
### Wer ist OWASP?
<br>
@ul
- Community
- Chapter (Region)
- Leader
@ulend
Note:
Community: Firmen, Bildungseinrichtungen und Einzelpersonen aller Welt
- Konferenzen, Sponsoring, Werbebanner
- 5 Angestellte
- Prämien für vielversprechende Applikations-Sicherheits-Forschungsprojekte

Region / Chapter: Offen und für jedermann
- Erarbeiten Materialien, Konferenzen (Räumlichkeiten), etc

Leader: Leitung des Chapters / Organisation etc.

+++?image=res/light_bulb.jpg&size=cover&opacity=40
### Was ist das Ziel?
<br>
@ul
- Awareness
- Know How
- OpenSource / frei
@ulend
Note:
- JuiceShop, WebGoat, ..
- Slides / Wiki (Beispiele + Lösungen + Empfehlungen)

+++?image=res/light_bulb.jpg&size=cover&opacity=40
### Gefahrenmodell
![Gefahrenmodell](/res/PNGs/OWASP_Gefahrenmodell.png)
$
\frac {(AN + VB + AB)} {3} * tAU
$
Note:
Bedrohungsquelle: 
- Wer: potentielle Angreifer (Script Kiddie,  Cybercriminal, State Sponsored Hacker)
- Was/Wo: Anzahl, Schnittstellen, Sicherheitszustand
- AN: Angriffsvektor
- VB: Verbreitung
- AB: Aufindbarkeit
- tAU: technische Auswirkungen

Angriffsvektoren:
- Ausnutzbarkeit: Schwierigkeit des Angriffs / benötigte Infrastruktur

Schwachstelle:
- Verbreitung: Anzahl, alter / neuer Code
- Auffindbarkeit: Wahrscheinlichkeit Entdeckung

Technische Auswirkungen:
- Systembezogne Möglichkeiten (Daten lesen / manipulieren / Funktionen ausführen / Systemzugriff)

Auswirkungen Unternehmen:
- Schaden für Unternehemen: Image, Bussen (GDPR?), Firmengeheimnisse, Finanzen


---?image=res/injection.png&size=cover&opacity=80
# @color[#282828](**A1: Injection**)

+++?image=res/injection.png&size=cover&opacity=45
@size[1.5em](Injection 2004 - 2017)

<canvas data-chart="line">
<!-- 
{
 "data": {
  "labels": [" 2004"," 2007"," 2010"," 2013"," 2017"],
  "datasets": [
   {
    "data":[5,9,10,10,10],
    "label":"Trend Injection","backgroundColor":"rgba(20,220,220,.8)"
   }
  ]
 }, 
 "options": { "responsive": true, "scales": { "xAxes": [{ "stacked": true }], "yAxes": [{ "stacked": true }] } }
}
-->
</canvas>

+++?image=res/injection.png&size=cover&opacity=45
### SQL-Interaction: User, WebApp and Server
![SQL-Req-Resp](/res/PNGs/SQL_Req-Resp.png)
Note:
- User startet Abfrage
- WebApp: Prüfung + Erstellen der Abfrage-Request
- SQL-Server: Verarbeitung Abfrage & Antwort
- Applikation rendert? Antwort

+++?image=res/injection.png&size=cover&opacity=45
@size[1.3em](SQL-Injection: Target and Impact)

<br>

  @ul
  - SQL, NoSQL, HQL, LDAP
  - Bash, PowerShell
  @ulend

<br>

  @ul[uppercase]
  - Bypassing Authentication
  - Spying Data
  - Manipulating Data
  - System Takeover
  @ulend


+++?image=res/injection.png&size=cover&opacity=45
### SQL-Injection: Attack
![SQL-Injection](/res/PNGs/SQL_Injection.png)
Note:
Normal:
- Parameter eingesetzt
- Statement wie vorgesehen

Injection:
- Parameter eingesetzt
- Statement ergänzt "oder" (4=4)

+++?image=res/injection.png&size=cover&opacity=45
## @size[1.5em](Demo Injection)



@css[demo](**Login Bypass**)



@css[demo](**Command Injection**)

Note:
Insecure Web App

Damm Vulnerable Web Application
- file erstellen

+++?image=res/injection.png&size=cover&opacity=45
## Massnahmen

+++?code=res/snippets/prepeared-statements.java&lang=java&title=Prepared Statements (Java)
@[1]
@[3-4]
@[6-7]
Note:
- Prepared Statement -Objekt erstellen
- Definieren Statement
- Input in def. Statement einfügen

+++?code=res/snippets/stored-procedure.java&lang=java&title=Stored Procedures (Java)
@[1-5]
@[7]
Note:
- Server?: Statement erstellen & Definieren
- WebApp?: Aufrufen des Statements
- + Performance (cache)

+++?code=res/snippets/white-list.java&lang=java&title=White Listing (Java)
@[1]
@[5]
@[6]
@[8]
Note:
- Pattern definieren Postleitzahl
- Prüfung ob Postleitzahl Pattern entspricht
- Nicht Pattern -> Improper zipcode format
- Entspricht Pattern -> Fortgesetzt

+++?code=res/snippets/escaping.java&lang=java&title=Escaping All User Supplied Input (Java)
@[2,5]
@[1]
@[4,6]
Note:
- altes Statement (legacy code)
- OrcaleCode() Objekt erzeugt
- Encoder für userID und pwd anwenden


---?image=/res/broken_auth.jpg&size=cover&opacity=60
# @color[#282828](**A2: Broken Authentication**)

+++?image=/res/broken_auth.jpg&size=cover&opacity=40
@size[1.2em](Broken Authentication 2004 - 2017)

<canvas data-chart="line">
<!-- 
{
 "data": {
  "labels": [" 2004"," 2007"," 2010"," 2013"," 2017"],
  "datasets": [
   {
    "data":[8,4,8,9,9],
    "label":"Trend Broken Authentication","backgroundColor":"rgba(20,220,220,.8)"
   },
   {
    "data":[2],
    "label":"","backgroundColor":"rgba(0,0,0,.0)"
   }
  ]
 }, 
 "options": { "responsive": true, "scales": { "xAxes": [{ "stacked": true }], "yAxes": [{ "stacked": true }] } }
}
-->
</canvas>

+++?image=/res/broken_auth.jpg&size=cover&opacity=40
### Überblick
![BrokenAuthOverview](res/PNGs/Broken_Auth-Overview.png)
Note:
- Credential Stuffing: bekannte Kombis (mail+pw)

+++?image=/res/broken_auth.jpg&size=cover&opacity=40
### Brute Force
![BruteForceLogin](res/PNGs/BruteForce-Login.png)
Note:
- Default Logins, Lists (Dict.+prefixes, topX, leaked), BruteForce
- Falscher Benutzer / PW
- Falsches etwas


+++?image=/res/broken_auth.jpg&size=cover&opacity=40
### Passwort wiederherstellen
![RecQuestion1](res/PNGs/SecurityQuestion1.png)

+++?image=/res/broken_auth.jpg&size=cover&opacity=40
### Passwort wiederherstellen
![RecQuestion2](res/PNGs/SecurityQuestion2.png)

+++?image=/res/broken_auth.jpg&size=cover&opacity=40
### Passwort wiederherstellen
![RecQuestion3](res/PNGs/SecurityQuestion3.png)


+++?image=/res/broken_auth.jpg&size=cover&opacity=40
### Cookie: UserID
![CookieParameter1](/res/PNGs/CookieParameter1.png)
Note:
- Admin Login -Server> Cookie UserID=1

+++?image=/res/broken_auth.jpg&size=cover&opacity=40
### Cookie: UserID
![CookieParameter2](/res/PNGs/CookieParameter2.png)
Note:
- Hacker Login -Server> Cookie UserID=4825
- Hacker ändert Wert
- Problem: Validierung userID = username/sessID/etc.


+++?image=/res/broken_auth.jpg&size=cover&opacity=40
### Session Fixation
![SessionFix](/res/PNGs/Session_Fixation.png)


+++?image=/res/broken_auth.jpg&size=cover&opacity=40
## @size[1.5em](Demo Broken Authentication)

@css[demo](**Brute Force Attack**)



@css[demo](**Playing with Cookies**)

Note:
- ?hydra
- BurpSuite
- Mutillidae

+++?image=/res/broken_auth.jpg&size=cover&opacity=40
## Massnahmen


+++?image=/res/broken_auth.jpg&size=cover&opacity=40
### Multi-Faktor Authentication
![MultiFactor](/res/PNGs/MultiFactor.png)

+++?image=/res/broken_auth.jpg&size=cover&opacity=40
### Session Management
<br>
@ul
- Built-In Session Manager
- Name ≠ PHPSESSID, CFID, ..)
- Länge: >128bits (BruteForce)
- starke Entropie (Zufälligkeit)
- ID Inhalt ≠ sensitive Daten
@ulend

+++?image=/res/broken_auth.jpg&size=cover&opacity=40
### Brute Force verzögern
<br>
@ul
- Verzögerung einbauen (Argon2, bcrypt, ..)
- Captcha nach x Fehlversuchen
- IP (für x Minuten) blockieren
- Account (für x Minuten) blockieren
- Reaktivierung via Mail-Link
- Einheitliche Fehlermeldung
@ulend

+++?image=/res/broken_auth.jpg&size=cover&opacity=40
### Passwörter und Sicherheitsfragen
![PwdSec](/res/PNGs/PwdSec.png)

+++?image=/res/broken_auth.jpg&size=cover&opacity=40
### Securing Cookies
![SecCookie](/res/PNGs/SecuringCookies.png)

+++
Test
@css[test-font](Test)