---?image=/res/owasp_logo.jpg&size=contain&color=black

---?image=res/light_bulbO60.jpg&size=cover
# @color[#282828](**Einleitung**)

+++?image=res/light_bulbO40.jpg&size=cover
### OWASP?
@ul
- Open Web Application Security Project
<br>
- OWASP Top 10
@ulend

+++?image=res/light_bulbO40.jpg&size=cover
- A1: Injection
- A2: Broken Authentication
- A3: Sensitive Data Exposure
- A4: XML External Entities
- A5: Broken Access Control
- A6: Security Misconfigurarion
- A7: Cross-Site Scripting
- A8: Insecure Deserialization
- A9: Using Components with Known Vulnerabilities
- A10: Insufficient Logging & Monitoring

+++?image=res/light_bulbO40.jpg&size=cover
### Gefahrenmodell (Top 10 Rating)
![Gefahrenmodell](/res/PNGs/OWASP10-Risks-transparent.png)




---?image=res/injectionO80.png&size=cover
# @color[#282828](**A1: Injection**)

+++?image=res/injectionO45.png&size=cover
### SQL-Interaction: User, WebApp and Server
![SQL-Req-Resp](/res/PNGs/SQL_Req-Resp.png)
Note:
- User startet Abfrage
- WebApp: Prüfung + Erstellen der Abfrage-Request
- SQL-Server: Verarbeitung Abfrage & Antwort
- Applikation rendert? Antwort

+++?image=res/injectionO45.png&size=cover
### SQL-Injection: Attack
![SQL-Injection](/res/PNGs/SQL_Injection.png)
Note:
Normal:
- Parameter eingesetzt
- Statement wie vorgesehen

Injection:
- Parameter eingesetzt
- Statement ergänzt "oder" (4=4)

+++?image=res/injectionO45.png&size=cover
### Injection: Auswirkungen

  @ul[]
  - Authentifizierung umgehen
  - Daten auslesen
  - Daten manipulieren
  - System-Übernahme
  @ulend



---?image=/res/broken_authO60.jpg&size=cover
# @color[#282828](**A2: Broken Authentication**)

+++?image=/res/broken_authO40.jpg&size=cover
### Überblick
![BrokenAuthOverview](res/PNGs/Broken_Auth-Overview.png)
Note:
- Credential Stuffing: bekannte Kombis (mail+pw)

+++?image=/res/broken_authO40.jpg&size=cover
### Brute Force
![BruteForceLogin](res/PNGs/BruteForce-Login.png)
Note:
- Default Logins, Lists (Dict.+prefixes, topX, leaked), BruteForce
- Falscher Benutzer / PW
- Falsches etwas


+++?image=/res/broken_authO40.jpg&size=cover
### Passwort wiederherstellen
![RecQuestion1](res/PNGs/SecurityQuestion1.png)

+++?image=/res/broken_authO40.jpg&size=cover
### Passwort wiederherstellen
![RecQuestion2](res/PNGs/SecurityQuestion2.png)

+++?image=/res/broken_authO40.jpg&size=cover
### Passwort wiederherstellen
![RecQuestion3](res/PNGs/SecurityQuestion3.png)

+++?image=/res/broken_authO40.jpg&size=cover
### Session Fixation
![SessionFix](/res/PNGs/Session_Fixation.png)






---?image=/res/Data_ExposureO60.jpg&size=cover
# @color[#282828](**A3: Sensitive Data Exposure**)
Note:
- Risiko: A6 -> A3
- Daten nicht oder unzureichen Geschüzt
- Entdecken - einfach
- Auswirkungen - sensitive Daten (Gesundheit, persönliche, Kreditkarte, Zugangsdaten)

+++?image=/res/Data_ExposureO40.jpg&size=cover
### Transportierte Daten
### Gespeicherte Daten

+++?image=/res/Data_ExposureO40.jpg&size=cover
### Unverschlüsselter Traffic
![SensDataExp](/res/PNGs/Sensitive_Data_Exposure.png)
Note:
- Typische unverschlüsselte Protokolle:
  - HTTP
  - POP / IMAP + SMTP
  - FTP
  - Telnet
- Daten können mitgelsen werden
  - Email, Photos, ..
  - Zugangsdaten
- Überall
  - "Intern", Kaffee, Hotel, (WLAN Zugang)
  - "Extern", Zwischen-Station; Proxy, VPN, Provider, Knotenpunkte

+++?image=/res/Data_ExposureO40.jpg&size=cover
### Heartbeat (keep-alive)
![Heartbeat-concept](/res/PNGs/Heartbeat-concept.png)
Note:
- Konzept für Demo (nachher)
- Session bricht nach x inaktiv
  - Sicherheit!
  - Browser sendet KeepAlive
- KeepAlive:
  - Client, Heartbeat-Anfrage (Zeichen+Länge)
  - Server kopiert Zeich in Memory
  - Server, Heartbeat-Antwort (Zeichen+Antwort)

+++?image=/res/Data_ExposureO40.jpg&size=cover
### Heartbeat vs Heartbleed (1)
![Heartbeat](/res/PNGs/Heartbeat.png)
Note:
- Zeichen können irgendetwas sein!
- Server-Antwort Logik:
  - Server liest von Memory x Zeichen
  - Sendet sie zurück (+ padding)

+++?image=/res/Data_ExposureO40.jpg&size=cover
### Heartbeat vs Heartbleed (2)
![Heartbleed](/res/PNGs/Heartbleed.png)
Note:
- Problem: Server überprüft nicht!
  - Client Länge > Paylouad
  - Server liest weiter
  - Sendet Daten aus dem Memory-Speicher
  - 
+++?image=/res/Data_ExposureO40.jpg&size=cover
### Misconfigured encryption (ssl-strip)
![ssl-strip](/res/PNGs/ssl-strip.png)
Note:
- Client ruft Webseite
  - Weiterleitung TLS
  - verschl. kein Mitlesen
- Angreifer stellt sich in Mitte
- Client unver. Angreifer vers. Webseite

+++?image=/res/Data_ExposureO40.jpg&size=cover
### Daten in Ruhe (Google)
![gogHack](/res/PNGs/GoogleHacks.png)
Note:
- Google-Suche + Parameter
- (via Suche) gefundene Psyeudo(!)-Webseiten
- Paramter:
  - ext: Extension
  - intext: Vorkommen in text
  - intitle: Vorkommen im Titel
  
+++?image=/res/Data_ExposureO40.jpg&size=cover
### Daten in Ruhe (Google)
![gogHack](/res/PNGs/G-Dork-Screenshot.png)
Note:
- Google-Suche + Parameter
- (via Suche) gefundene Psyeudo(!)-Webseiten
- Paramter:
  - ext: Extension
  - intext: Vorkommen in text
  - intitle: Vorkommen im Titel

+++?image=/res/Data_ExposureO40.jpg&size=cover
### Daten in Ruhe (Shodan)
![shodan](/res/PNGs/Shodan.png)
Note:
- Suche nach IP ranges
- Server / Port
- Land

+++?image=/res/Data_ExposureO40.jpg&size=cover
### Daten in Ruhe (Shodan)
![shodan](/res/PNGs/Shodan-Screenshot2.png)
Note:
- Suche nach IP ranges
- Server / Port
- Land


+++?image=/res/Data_ExposureO40.jpg&size=cover
### Daten in Ruhe (Social Media)
![social-exp](/res/PNGs/SocialMediaExp.png)
Note:
- Veröffetnlichung sensibler Daten
  - Fotos
  - Screenshots
  - Selfies


---?image=/res/xxeO40.png&size=cover
# @color[#282828](**A4: XML External Entity**)

+++?code=/res/snippets/entity-example.xml&lang=xml&lang=xml&title=Example Entity (XML)
@[1]
@[2]
@[4]
@[2,4-5]
<br>
@ul
Max Mustermann
@ulend
Note:
- Entity definiert
  - Entity-Name = Nachname
  - Entity-Wert = Mustermann
- Vorname = Max (harcoded)
- Nachname = Mustermann (via Entity)

+++?image=/res/xxeO10.png&size=cover
### Denial of Service
![Billion_Laughs](/res/PNGs/entity-bil-lol.png)
Note:
- Stichwort Rekrusion
- 2^x (Beispiel)
- allozierter Speicher


+++?image=/res/xxeO10.png&size=cover
### Dateien auslesen
![access-file](/res/PNGs/entity-access-file.png)&title=Dateien auslesen
Note:
- Definieren (injection) getFile (Entity)
- Wert / Referenzierung auf Datei
- XML Parser bettet Datei in Webseite ein
- (Leerzeichen + gewisse (spez.) Zeichen funktionieren nicht -bricht Parser, Error)

+++?image=/res/xxeO10.png&size=cover
### Netzwerk-Zugang
![access-netfile](/res/PNGs/entity-access-network.png)&title=Netzwerk Zugang
Note:
- Selbe wie "Datei auslesen"
- Pfad zu Datei über Netzwerk
- Bedingungen:
  - Zugriff auf existierender Server
  - limitierte Zeichen
  - Pfad bekannte
- XML-Parser als Proxy
- Standartpfade


+++?image=/res/xxeO10.png&size=cover
### Out of band XXE
![oob-xxe](/res/PNGs/entity-oob.png)
Note:
- Out-of-Band
  - Injektion Schnittstelle aber keine Ausgabe / Reflektion (Blind)
  - Umgehung der Charakter-Limitierung
- Definition:
  - lokal: getFile (holt Datei)
  - lokal: dtd (holt / importiert in send.dtd beschriebene entities)
  - remote: all (lädt / exec send)
  - remote: send (holt fiktives File von *url+Datei-Content* (von getFile) )
- Ablauf:
  - Aufruf: dtd
    - Definition all
    - Aufruf all
      - Definition send
  - Aufruf: send
    - Aufruf getFile (hole Datei Inhalt)
    - Request "attacker.ch/"+"getFile=Inhalt"





---?image=/res/PNGs/B-A_Control40i.png&size=cover
# @color[#282828](**A5: Broken Access Control**)

+++?image=/res/PNGs/B-A_Control20i.png&size=cover
### Zugriff durch unüberprüfter Input
![getAcctInfo](/res/PNGs/a-c_unverified.png)
Note:
- 1. Normales Surfverhalten
- 2. Bemerkt Parameter (acct)
- 3. Setzt anderer Wert
- Funktioniert, weil kein Prüfung param(wert)==user

+++?image=/res/PNGs/B-A_Control20i.png&size=cover
### Zugriff via "forced browsing"
![FrocedBrowsing](/res/PNGs/a-c_fored-browsing.png)
Note:
- Selbe wie zuvor
- aber Manipulation Pfad anstatt Paramter

+++?image=/res/PNGs/B-A_Control20i.png&size=cover
### Path Traversal (Basics)
![PathTrav1B1](/res/PNGs/a-c_path-traversal-basic1.png)+++
Note:
- ../ == eine Stufe "Hierarchie" zurück / höher
- Ausbrechen / Zugriff auf andere Directories

+++?image=/res/PNGs/B-A_Control20i.png&size=cover
### Path Traversal (Basics)
![PathTrav1B2](/res/PNGs/a-c_path-traversal-basic2.png)
Note:
- Man sieht Pfad (blau)
  - links: in /var/www/html
  - rechts weg zu /var/www/html
- ls zeigt Inhalt
- Pro "../" geht es eine Stufe höher vgl. Pfad

+++?image=/res/PNGs/B-A_Control20i.png&size=cover
### Path Traversal - URL (1)
![PathTravURL](/res/PNGs/a-c_path-traversal1.png)
Note:
- Normal (oben)
  - Klicke Link -> Request -> MP3
- Attack (unten)
  - ../ bis zum root (/)
  - zuviel "../" -> immer noch /
  - Pfad zu Datei

+++?image=/res/PNGs/B-A_Control20i.png&size=cover
### Path Traversal - URL (2)
![PathTravURLencoded](/res/PNGs/a-c_path-traversal2.png)
Note:
- Selbe wei vorher
- Machmal Blacklists ".", "/", ..
- Encoding

+++?image=/res/PNGs/B-A_Control20i.png&size=cover
### Path Traversal - Cookie
![PathTravCookie](/res/PNGs/a-c_path-traversal-cookie-temp.png)
Note:
- PathTrav via Referenz in Cookie
- Template (red.php, blue.php, ..) wird in Cookie gespeichert
  - normal => include /home/path/blue.php
  - attack => include /home/path/../../file

+++?image=/res/PNGs/B-A_Control20i.png&size=cover
### Client-Side Kontrollen - Hidden Field
![ac_hidden-field](/res/PNGs/a-c_cs-hidden-field.png)
Note:
- JavaScript client-side Kontrolle
- verstecktes (hidden) Post-Formular mit entsprechendem Wert
  - + Server Entlastung
  - - Client kann manipulieren


---?image=/res/PNGs/Sec-MisConf50.png&size=cover
# **A6: Security Misconfiguration**

+++?image=/res/PNGs/Sec-MisConf10.png&size=cover
### Enumeration / default Login
![def-pw](/res/PNGs/defaultPwd.png)

+++?image=/res/PNGs/Sec-MisConf10.png&size=cover
### Error-Handling
![def-pw](/res/PNGs/sql-error.png)

+++?image=/res/PNGs/Sec-MisConf10.png&size=cover
### Outdated Version
![def-pw](/res/PNGs/out-dated.png)






---?image=/res/xss-background40.png
# @color[#282828](**A7: Cross-Site Scripting**)

+++?image=/res/xss-background10.png
### Cross-Site-Scripting (XSS)
![html-tags](/res/PNGs/html-tags.png)

+++?image=/res/xss-background10.png
### Cross-Site-Scripting (XSS)
<br>
@ul
- Reflected XSS (server-basiert)
- Stored XSS (server-basiert)
- DOM / (client-basiert)
@ulend

+++?image=/res/xss-background10.png
### Reflected XSS
![reflected_xss](/res/PNGs/Reflected_XSS.png)

+++?image=/res/xss-background10.png
### Stored XSS
![stored_xss](/res/PNGs/Stored_XSS.png)

+++?image=/res/xss-background10.png
### DOM XSS (Fragments)
![dom_xss](/res/PNGs/DOM_XSS-f1.png)

+++?image=/res/xss-background10.png
### DOM XSS (Fragments)
![dom_xss](/res/PNGs/DOM_XSS-f2.png)

+++?image=/res/xss-background10.png
### MySpace Worm "Samy"
![samy-worm](/res/PNGs/samy.png)






---?image=/res/serial-bg30.jpg
# @color[#282828](**A8: Insecure Deserialization**)

+++?image=/res/serial-bg10.jpg
### Was ist Serialization?
![Serialize-Concept](/res/PNGs/Serialization.png)
@ul
- Daten Transport (Kabel)
- Speichern von Daten
@ulend

+++?image=/res/serial-bg10.jpg
### Object Injection - Gadgets
![Serialization-gadgets](/res/PNGs/Serialization-gadgets.png)






---?image=/res/known-vuln-bg20.jpg
# @color[#282828](**A9: Using Components with Known Vulnerabilities**)

+++?image=/res/known-vuln-bg10.jpg
### Veraltete / verwundbare Komponenten
![known-vuln](/res/PNGs/known-vulnerability.png)

+++?image=/res/known-vuln-bg10.jpg
### ExploitDB (1)
![Exploitdb1](/res/PNGs/ExploitDB_WordPress1.png)

+++?image=/res/known-vuln-bg10.jpg
### ExploitDB (2)
![Exploitdb2](/res/PNGs/ExploitDB_WordPress2.png)





---?image=/res/monitor-bg30.png
# @color[#282828](**A10: Insufficient Logging & Monitoring**)

+++?image=/res/monitor-bg11.png
### Watch your logs
![logs-monitoring](/res/PNGs/logging_on-off.png)

+++?image=/res/monitor-bg11.png
### Passende Schwellenwerte
![treshold-logging](/res/PNGs/logging_treshold.png)





---
### Checkout the  OWASP CheatSheets
[Cheat Sheet Series](https://github.com/OWASP/CheatSheetSeries/tree/master/cheatsheets)

+++
# Vielen Dank für Eure Aufmerksamkeit