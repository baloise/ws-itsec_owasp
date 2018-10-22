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
### Injection: Vorkommen und Auswirkungen

<br>

  @ul
  - SQL, NoSQL, HQL, LDAP
  - Bash, PowerShell
  @ulend

<br>

  @ul[uppercase]
  - Authentifizierung umgehen
  - Daten auslesen
  - Daten manipulieren
  - System-Übernahme
  @ulend


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
## @size[1.5em](Demo Injection)
@css[demo](**Login Bypass**)
<br>
@css[demo](**Command Injection**)

Note:
Insecure Web App

Damm Vulnerable Web Application
- file erstellen

+++?image=res/injectionO45.png&size=cover
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
@[2,5, 7]
@[4,6]
Note:
- altes Statement (legacy code)
- OrcaleCode() Objekt erzeugt
- Encoder für userID und pwd anwenden






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
### Cookie: UserID
![CookieParameter1](/res/PNGs/CookieParameter1.png)
Note:
- Admin Login -Server> Cookie UserID=1

+++?image=/res/broken_authO40.jpg&size=cover
### Cookie: UserID
![CookieParameter2](/res/PNGs/CookieParameter2.png)
Note:
- Hacker Login -Server> Cookie UserID=4825
- Hacker ändert Wert
- Problem: Validierung userID = username/sessID/etc.


+++?image=/res/broken_authO40.jpg&size=cover
### Session Fixation
![SessionFix](/res/PNGs/Session_Fixation.png)


+++?image=/res/broken_authO40.jpg&size=cover
## @size[1.5em](Demo Broken Authentication)

@css[demo](**Brute Force Attack**)
<br>
@css[demo](**Playing with Cookies**)

Note:
- ?hydra
- BurpSuite
- Mutillidae

+++?image=/res/broken_authO40.jpg&size=cover
## Massnahmen


+++?image=/res/broken_authO40.jpg&size=cover
### Multi-Faktor Authentication
![MultiFactor](/res/PNGs/MultiFactor.png)

+++?image=/res/broken_authO40.jpg&size=cover
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

+++?image=/res/broken_authO40.jpg&size=cover
### Passwörter und Sicherheitsfragen
![PwdSec](/res/PNGs/PwdSec.png)
*keine NIST Regelung

+++?image=/res/broken_authO40.jpg&size=cover
### Session Management
<br>
@ul
- Built-In Session Manager
- Name ≠ PHPSESSID, CFID, ..)
- Länge: >128bits (BruteForce)
- starke Entropie (Zufälligkeit)
- ID Inhalt ≠ sensitive Daten
@ulend

+++?image=/res/broken_authO40.jpg&size=cover
### Securing Cookies
![SecCookie](/res/PNGs/SecuringCookies2.png)






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
### latley on SSL/TLS
![SSL-TLS](/res/PNGs/SSL-TLS_attacks_timeline.png)
Note:
- Nicht lesen!
  - Soll dynamik / Wandel zeigen
- Grund SSL/TLS für nicht Banking
- 2014 Heartbleed; zeigt Memorydump (sehr einfach)
- 2015: Let's Encrypt; gratis Zertifikate
- 2017: Warnung nicht verschlüsselt
  - zeige Bsp.

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
### Daten in Ruhe (Shodan)
![shodan](/res/PNGs/Shodan.png)
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

+++?image=/res/Data_ExposureO40.jpg&size=cover
## @size[1.5em](Demo Sensitive Data Exposure)
@css[demo](**Demo1**)
<br>
@css[demo](**Demo2**)
Note: 
- MiM Proxy (Pineapple + ssl-strip?)
- Heartbleed

+++?image=/res/Data_ExposureO40.jpg&size=cover
## Massnahmen

+++?image=/res/Data_ExposureO40.jpg&size=cover
### Daten in Ruhe:
@ul
- Starke Verschlüsselung (AES / RSA)
- Passwörter sicher gepsichert
- Zugang absicheren
@ulend
Note:
- Stark verschl. Daten - Datenleak
- Hash: "Einweg-Funktion" - Passwortleak
- Salt: "Random-Data" (überall selbe) + Pw -> Hash - RainbowTables
- Pepper: "Radom-Data" (zufällig nicht + gespeichert) - Brute-/Dict-Attacks
- Kabel, IPs, Zonen - kleine Angriffsfläche

+++?image=/res/Data_ExposureO40.jpg&size=cover
### Daten in Ruhe (Hash)
![Hashing](/res/PNGs/Hash.png)

+++?image=/res/Data_ExposureO40.jpg&size=cover
### Daten in Ruhe (Salt)
![Salt](/res/PNGs/Salt.png)

+++?image=/res/Data_ExposureO40.jpg&size=cover
### Daten in Ruhe (Pepper)
![Pepper](/res/PNGs/Pepper.png)

+++?image=/res/Data_ExposureO40.jpg&size=cover
### Daten in Transport:
@ul
- Immer verschlüsselt
- Verschlüsselung:
  - ≥TLS1.1
  - kein RC4 support
  - kein export-grade support
  - https://ssllabs.com
- keine 302 Redirects
- HTTP Strict Transport Security
@ulend
Note:
- Verschlüsselte Verbindungen anbieten & benutzen
- +TLS 1.1 (Heartbleed, POODLE)
- RC4 erhebliche Sicherheitsmängel (Intägritätsschutz)
- export-grade (kürzere Schlüssel)
- Redirects SSLStrip+
- HSTS (nur über HTTPS verbinden)




---?image=/res/xxeO40.png&size=cover
# @color[#282828](**A4: XML External Entity**)

+++?image=/res/xxeO10.png&size=cover
### Entities
![entites](/res/PNGs/entites.png)
Note:
- Representieren
- ähnlich Variablen

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

+++?code=/res/snippets/billion-laughs.xml&lang=xml&title=Billion Laughs (XML)
@[1]
@[12]
@[11]
@[10-11]
@[3-11]
Note:
- Praktisches Beispiel 10
- 7^9 ~ 125MB

+++?image=/res/xxeO10.png&size=cover
### Dateien auslesen
![access-file](/res/PNGs/entity-access-file.png)&title=Dateien auslesen
Note:
- Definieren (injection) getFile (Entity)
- Wert / Referenzierung auf Datei
- XML Parser bettet Datei in Webseite ein
- (Leerzeichen + gewisse (spez.) Zeichen funktionieren nicht -bricht Parser, Error)

+++?code=/res/snippets/access-data.xml&lang=xml&title=Dateien auslesen (XML)
@[2]
@[2, 4]
@[2, 4-5]
Note:
- Definition Entity
  - Name = getFile
  - Wert = Referenz zu File
- Vorname = Max
- Nachname = Inhalt von File (via Entity)

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


+++?code=/res/snippets/access-network.xml&lang=xml&title=Netzwerk Zugang (XML)
@[4]
@[4, 5]
Note:
- Definieren Entity getFile
- Referenzierung auf File
- Ausgabe via erstelltes Element <foo> ?

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

+++?code=/res/snippets/oob-xxe.xml&lang=xml&title=Out of band XXE (XML)
@[1-7]
@[9-16]
@[1,4]
@[1,4-5]
@[3,10,12]
@[12,16]
@[13]
@[7]
@[7,10,13]
Note:
- Injizierter Code (ie. Webseite)
- Hosted Attacker-Code (Attacker-Server)
- Definiere % ext (param) mit Referenz send.dtd
- Lade %ext;
- Definiere payload mit Referenz auf Datei
- Definiere all
- Führe all aus
- *Setzte Entities geschickt zusammen*
  - Definiere external mit Link+Datei-Inhalt
- Führe external aus
  - Link + Data via payload

+++?image=/res/xxeO10.png&size=cover
## @size[1.5em](Demo XML External Entity)
@css[demo](**Demo1**)
<br>
@css[demo](**Demo2**)

+++?image=/res/xxeO10.png&size=cover
## Massnahmen

+++?image=/res/xxeO10.png&size=cover
### Vertrau User-Input nicht!

+++?image=/res/xxeO10.png&size=cover
### Allgemein
@ul
- DTDs (komplett) deaktivieren
<br>
- Alternativ, deaktivieren
  - external entities
  - external DTDs
@ulend

+++?image=/res/xxeO10.png&size=cover
### Features abstellen (Java)
#### Xerces 1
- /external-general-entities
- /external-general-entities
- /load-external-dtd

+++?image=/res/xxeO10.png&size=cover
### Features abstellen (Java)
#### Xerces 2
- /disallow-doctype-decl
- /external-general-entities
- /external-parameter-entities
- /load-external-dtd

+++?image=/res/xxeO10.png&size=cover
### Mehr / anwendungsbezogene Infos
<a href="https://www.owasp.org/index.php/XML_External_Entity_(XXE)_Prevention_Cheat_Sheet">XXE Prevention Cheat Sheet</a>






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

+++?image=/res/PNGs/B-A_Control20i.png&size=cover
## @size[1.5em](Demo Broken Access Control)
@css[demo](**Demo1**)
<br>
@css[demo](**Demo2**)

+++?image=/res/PNGs/B-A_Control20i.png&size=cover
## Massnahmen

+++?image=/res/PNGs/B-A_Control20i.png&size=cover
### Vertrau User Input nicht!

+++?image=/res/PNGs/B-A_Control20i.png&size=cover
### Validation
@ul
- Server-side code
- Server-less API
- Client-side code höchstens als Ergänzung!
@ulend
Note:
- Kontollmechanismen server-sdie!
- Server-less tbd..

+++?image=/res/PNGs/B-A_Control20i.png&size=cover
### forced Browsing
@ul
- Kontroll-Mechanismus
- Überall und immer den selben KM
@ulend
Note:
- Prüfe Zugriffsrechte
- selber Mechanismus -> kleinere Angriffsfläche + Übersicht

+++?image=/res/PNGs/B-A_Control20i.png&size=cover
### Path Traversal
@ul
- Vermeide User-Input
- Whitelist / hardcoded *.ext
- Input-Validation
- set permission / policies (file-access)
@ulend


---?image=/res/PNGs/Sec-MisConf50.png&size=cover
# **A6: Security Misconfiguration**

+++?image=/res/PNGs/Sec-MisConf8.png&size=cover
### Einleitung
![misconf-intro](/res/PNGs/misconf-overview.png)

+++?image=/res/PNGs/Sec-MisConf8.png&size=cover
### Enumeration / default Login
![def-pw](/res/PNGs/defaultPwd.png)

+++?image=/res/PNGs/Sec-MisConf8.png&size=cover
### Error-Handling
![def-pw](/res/PNGs/sql-error.png)

+++?image=/res/PNGs/Sec-MisConf8.png&size=cover
### Outdated Version
![def-pw](/res/PNGs/out-dated.png)

+++?image=/res/PNGs/Sec-MisConf10.png&size=cover
### SOP & CORS
@ul
- Same Origin Policy
- Cross-Origin Request Sharing
@ulend

+++?image=/res/PNGs/Sec-MisConf10.png&size=cover
### Cross-Origin Request Sharing (1)
![ac_cors-info1](/res/PNGs/a-c_cors-sop.png)

+++?image=/res/PNGs/Sec-MisConf10.png&size=cover
### Cross-Origin Request Sharing (2)
![ac_cors-info2](/res/PNGs/a-c_cors.png)

+++?image=/res/PNGs/Sec-MisConf10.png&size=cover
### Workarrounds
#### Simple Origin Reflection
![ac_cors-simple-reflection](/res/PNGs/a-c_cors-simple-reflection.png)

+++?image=/res/PNGs/Sec-MisConf10.png&size=cover
### Workarround: Startswith
![ac_cors-Startswith](/res/PNGs/a-c_cors-startswith.png)

+++?image=/res/PNGs/Sec-MisConf10.png&size=cover
### Workarround: Endswith
![ac_cors-Startswith](/res/PNGs/a-c_cors-endswith.png)

+++?image=/res/PNGs/Sec-MisConf10.png&size=cover
### Origin null
"[...]request is issued from a file on a user’s computer"

+++?image=/res/PNGs/Sec-MisConf10.png&size=cover
### Origin null
![ac_cors-origin-null](/res/PNGs/a-c_cors-origin-null2.png)

+++?image=/res/PNGs/Sec-MisConf10.png&size=cover
## @size[1.5em](Demo Security Misconfiguration)
@css[demo](**Enumeration**)
<br>
@css[demo](**Error-Handling**)
<br>
@css[demo](**Outdated Version**)

+++?image=/res/PNGs/Sec-MisConf10.png&size=cover
## Massnahmen

+++?image=/res/PNGs/Sec-MisConf10.png&size=cover
### Allgemein (1)
@ul
- update!
- Security headers
- Error Messages
- Sicherheits-Features
  - Benutzen
  - Konfigurieren
@ulend

+++?image=/res/PNGs/Sec-MisConf10.png&size=cover
### Allgemein (2)
@ul
- geringste Privilegien
- unnötige Angriffsvektoren
  - Benutzerkonten
  - vergessene Server
  - Funktionen / Plugins
- Enumeration
@ulend

+++?code=/res/snippets/nginx-config.conf&title=Nginx - enable SSL
@[3, 5-8]
@[9, 10]
@[11]

+++?image=/res/PNGs/Sec-MisConf10.png&size=cover
### Nginx Hardening (1)
#### ssl.conf
@ul
- ssl_protocols
- ssl_ciphers
- server_tokens off
@ulend

+++?image=/res/PNGs/Sec-MisConf10.png&size=cover
### Nginx Hardening (2)
#### ssl.conf
@ul
- Secure Diffie-Hellman
  - openssl dhparam -out dhparams.pem 4096
  - ssl_dhparam
- Implement WAF
- update!
@ulend

+++?code=/res/snippets/nginx-config2.conf&title=Nginx - additional config
@[1-5]
@[7, 8]
@[10-11]

+++?image=/res/PNGs/Sec-MisConf10.png&size=cover
### Apache Hardening (1)
#### httpd.config
@ul
- TraceEnable off
- ServerSignature Off
- ServerTokens Prod
- SSLProtocol
- SSLCipherSuite
@ulend

+++?image=/res/PNGs/Sec-MisConf10.png&size=cover
### Apache Hardening (2)
#### httpd.config
@ul
- User apache
- Group apache
- Remove unnecessary DSO Modules
- update!
@ulend

+++?code=/res/snippets/apache-no-dir-listen.conf&title=Disable Directory Listening

+++?image=/res/PNGs/Sec-MisConf10.png&size=cover
### SSH Hardening (1)
#### ssh_config
@ul
- Protocol 2
- PermitRootLogin no
- ClientAliveInterval 300
- ClientAliveMax 2
- AllowUsers HereComesUsername
- SSH-PublicKey Login
  - PasswordAuthentication no
- X11Forwarding no
@ulend

+++?image=/res/PNGs/Sec-MisConf10.png&size=cover
### SSH Hardening (2)
#### SSH - additional
@ul
- Fail2Ban
- Multi-Factor Authentication
  - google-authenticator
  - UsePAM yes
  - ChallengeResponseAuthentication yes
- ssh-aufit.py
- Regenerate Moduli (prime numbers & generators)
@ulend






---?image=/res/xss-background40.png
# @color[#282828](**A7: Cross-Site Scripting**)

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
### Document Object Model (DOM) XSS
![DOM](/res/PNGs/DOM.png)
JS: add, del, read, manipulate

+++?image=/res/xss-background10.png
### Dom & JavaScript
![DOM_js](/res/PNGs/DOM_js.png)

+++?image=/res/xss-background10.png
### DOM XSS
![dom_xss](/res/PNGs/DOM_XSS1.png)

+++?image=/res/xss-background10.png
### DOM XSS (Fragments)
![dom_xss](/res/PNGs/DOM_XSS-f1.png)

+++?image=/res/xss-background10.png
### DOM XSS (Fragments)
![dom_xss](/res/PNGs/DOM_XSS-f2.png)

+++?image=/res/xss-background10.png
### MySpace Worm "Samy"
![samy-worm](/res/PNGs/samy.png)

+++?image=/res/xss-background10.png
## @size[1.5em](Demo Cross-Site Scripting)
@css[demo](**XSS!**)
<br>
@css[demo](**Cookie**)

+++?image=/res/xss-background10.png
## Massnahmen

+++?image=/res/xss-background10.png
### Vertau Input nicht!

+++?image=/res/xss-background10.png
### Escaping
@ul
- HTML Entity Encoding
- URL Encoding
- CSS Hex Encoding
- Sanitize HTML
  - HtmlSanitizer
  - OWASP Java HTML Sanitizer
@ulend

+++?image=/res/xss-background10.png
### Input Validation (server-side!)
@ul
<br>
- Validation:
  - RegEx
  - Pattern
  - Whitelist
  - MIME
<br>
- Beispiel Postleitzahl:
  - Nur Zahlen
  - vier Ziffern
@ulend

+++?code=/res/snippets/csp1.txt&title=Content Security Policy (CSP)

+++?code=/res/snippets/csp2.txt&title=Content Security Policy (CSP)

+++?code=/res/snippets/csp3.txt&title=Content Security Policy (CSP)

+++?image=/res/xss-background10.png
### Headers & Cookie
@ul
- Header:
  - X-XSS-Protection: 1; mode=block 
  - (Content-Security-Policy-Header)
<br>
- Cookie:
  - Set-Cookie: Secure (HTTPS)
  - Set-Cookie: HttpOnly (no javascript)
  - Set-Cookie: SameSite
@ulend

+++?image=/res/xss-background10.png
### HTML5 Security Cheatsheet
https://html5sec.org/






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

+++?image=/res/serial-bg10.jpg
## Massnahmen

+++?image=/res/serial-bg10.jpg
### Serialization - Trust
<br>
@ul
- nur vertrauenswürdige Quellen!
- nicht-vertr. Quellen, nur primitive Daten
@ulend

+++?image=/res/serial-bg10.jpg
### Serialization - Checks
@ul
- Integritäts-Checks (digitale Signaturen)
- Deserialization-Ausführung in low privilege env.
- Logging des. expetions and failures
- Monitoring / Restriktionen
  - In- & ausgehende Konnectivität
  - Alarm wenn konstante deserial. von user






---?image=/res/known-vuln-bg20.jpg
# @color[#282828](**A9: Using Components with Known Vulnerabilities**)

+++?image=/res/known-vuln-bg10.jpg
### Veraltete / verwundbare Komponenten
![known-vuln](/res/PNGs/known-vulnerability.png)

+++?image=/res/known-vuln-bg10.jpg
### Veraltete / verwundbare Komponenten
@ul
Beispiele:
<br>
- Web Server
  - Apache --> Sturts
<br>
- Database Server
  - Oracle --> Java VM
<br>
- TLS / SSL
  - Heartbleed
@ulend

+++?image=/res/known-vuln-bg10.jpg
## Massnahmen

+++
### Unterhaltungs-Zyklus
![maintenance-circel](/res/PNGs/com-circel.png)

+++?image=/res/PNGs/pythagoras-tree20.png&size=cover
### Komponenten
<a href="https://www.owasp.org/index.php/OWASP_Dependency_Check">Dependency Check</a>
![dep-checker](/res/PNGs/dep-check.png)


+++?image=/res/known-vuln-bg10.jpg
### Monitoring
@ul
- Bleib dran: Vulnerabilities & Patches
  - CVE / NVD
  - Mail-Newsletter
  - Twitter-Feeds
<br>
- aktuelle Libraries / Komponenten
@ulend

+++?image=/res/known-vuln-bg10.jpg
### Konfiguration
@ul
- Anforderungen Prüfen
  - Konfiguration
  - Features, etc
<br>
- Überflüssige Funktionen

+++?image=/res/patch60.jpg
# Patch!






---?image=/res/monitor-bg30.png
# @color[#282828](**A10: Insufficient Logging&Monitoring**)

+++?image=/res/monitor-bg11.png
### Watch your logs
![logs-monitoring](/res/PNGs/logging_on-off.png)

+++?image=/res/monitor-bg11.png
### Passende Schwellenwerte
![treshold-logging](/res/PNGs/logging_treshold.png)

+++?image=/res/monitor-bg11.png
### Intrusion Systems
@ul
- Intrusion Detection System (IDS)
<br>
- Intrusion Protection System (IPS)
<br>
- Typen: Host, Netzwerk & Hybrid
@ulend

+++?image=/res/monitor-bg11.png
### Host-basiertes IDS
![Hb-IDS](/res/PNGs/HIDS.png)

+++?image=/res/monitor-bg11.png
### Netzwerk-basiertes IPS
![Nb-IDS](/res/PNGs/NIDS.png)

+++?image=/res/monitor-bg11.png
### WAF vs IPS
@ul
- Web Application Firewall: HTTP - Layer 7
  - SSL, GET, POST, XSS, Injection, etc

- Intrusion Prevention System - Layer 3/4
  - DNS, SMTP, SSH, RDP, etc
@ulend

+++?image=/res/monitor-bg11.png
### Web App Firewall (WAF)
@ul
- ModSecurity
  - https://modsecurity.org/
- OWASP ModSecurity Core Rule Set
  - https://coreruleset.org/
@ul






---
# Testumgebung

+++
### Schriften
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