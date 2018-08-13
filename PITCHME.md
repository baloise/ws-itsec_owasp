---?image=/res/owasp_logo.jpg&size=contain&color=black

---?image=res/light_bulb.jpg&size=cover&opacity=60
# @color[#282828](**Einleitung**)

+++?image=res/light_bulb.jpg&size=cover&opacity=40
### Wer ist OWASP?
Note:
Community: Firmen, Bildungseinrichtungen und Einzelpersonen aller Welt
Region / Chapter: Offen und für jedermann

+++?image=res/light_bulb.jpg&size=cover&opacity=40
### Was ist das Ziel?
<br>
@ul
- Awareness
- Know How
- OpenSource / frei
@ulend
Note:
- Web sicherer machen
- Erarbeiten von Materialien

+++?image=res/light_bulb.jpg&size=cover&opacity=40
### Was ist OWASP Top 10
@ul
- Unterprojekt
- schwerwiegenste Schwachstellen
@ulend
Note:
- Sensibilisierung
- Tools (ZAP-proxy)
- Wiki: Know How - Vorbeugemassnahmen
+++?image=res/light_bulb.jpg&size=cover&opacity=40

### Open Web Application Security Project Top 10 2017
@ul
- A1: Injection
- A2: Broken Authentication
- A3: Sensitive Data Exposure
- A4: XML External Entities
- A5: Broken Access Controll
- A6: Security Misconfigurarion
- A7: Cross-Site Scripting
- A8: Insecure Deserialization
- A9: Using Components with Known Vulnerabilities
- A10: Insufficient Logging & Monitoring
@ulend

Note:

+++?image=res/light_bulb.jpg&size=cover&opacity=40
### Gefahrenmodell (Top 10 Rating)
![Gefahrenmodell](/res/PNGs/OWASP10-Risks.png)
Note:
Beispiel: Injection
Fast alle Datenquellen sind Agriffsvektoren
- Environment Variabeln, Parameter, ext. & int. web services,vers. User
- Injection titt auf wenn Metazeichen an Interpreter geschickt werden können

Injection ist verbreitet (legacy code)
- SQL LDAP, XPath or NoSQL queries
- OS commands, XML parsers, SMTP headers

Injection leicht zu entdecken (Quellcode)

Injection:
- Datenverlust
- Zugriff / Manipulation
- Systemübernahme

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
### Recent Injections
- 2018 Joomla SQLi und mehr
- 2017 GoDaddy (WAF) encoded SQLi commands
- 2017 WordPress SQLi (Plugin) flaw
- 2017 Equifax SQLi und mehr
- 2016 Italienische Regierungswebseite


+++?image=res/injection.png&size=cover&opacity=45
### SQL-Interaction: User, WebApp and Server
![SQL-Req-Resp](/res/PNGs/SQL_Req-Resp.png)
Note:
- User startet Abfrage
- WebApp: Prüfung + Erstellen der Abfrage-Request
- SQL-Server: Verarbeitung Abfrage & Antwort
- Applikation rendert? Antwort

+++?image=res/injection.png&size=cover&opacity=45
@size[1.3em](Injection: Vorkommen und Auswirkungen)

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
standart font
<br>
@css[oSans](Open Sans, sans-serif)
<br>
@css[jSans](Jua, sans-serif)
<br>
@css[wSans](Work Sans, sans-serif)
<br>
@css[fSans](Fjalla One, sans-serif)
<br>
@css[aSans](Acme, sans-serif)
<br>
@css[cCursive](Concert One, cursive)
<br>
@css[rCursive](Righteous, cursive)
