---?image=/res/owasp_logo.jpg&size=contain&color=black

---?image=res/light_bulbO60.jpg&size=cover
# @color[#282828](**Einleitung**)

+++?image=res/light_bulbO40.jpg&size=cover
### Wer ist OWASP?
Note:
Community: Firmen, Bildungseinrichtungen und Einzelpersonen aller Welt
Region / Chapter: Offen und für jedermann

+++?image=res/light_bulbO40.jpg&size=cover
### Was ist das Ziel?
<br>
@ul
- Awareness
- Know How
@ulend
Note:
- Web sicherer machen
- Erarbeiten von Materialien

+++?image=res/light_bulbO40.jpg&size=cover
### Was ist OWASP Top 10
@ul
- Unterprojekt
- schwerwiegenste Schwachstellen
@ulend
Note:
- Sensibilisierung
- Tools (ZAP-proxy)
- Wiki: Know How - Vorbeugemassnahmen

+++?image=res/light_bulbO40.jpg&size=cover
### Open Web Application Security Project Top 10 2017
@ul
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
@ulend

Note:

+++?image=res/light_bulbO40.jpg&size=cover
### Gefahrenmodell (Top 10 Rating)
![Gefahrenmodell](/res/PNGs/OWASP10-Risks-transparent.png)
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

---?image=res/injectionO80.png&size=cover
# @color[#282828](**A1: Injection**)

+++?image=res/injectionO45.png&size=cover
### Injection
![arrow-up](/res/PNGs/trend-middle.png)

+++?image=res/injectionO45.png&size=cover
### real-world Beispiele
@ul
- 2018 Joomla
- 2017 GoDaddy (WAF)
- 2017 WordPress
- 2017 Equifax
- 2016 Italienische Regierungswebseite
@ulend

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
  - Bypassing Authentication
  - Spying Data
  - Manipulating Data
  - System Takeover
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
@[2,5]
@[1]
@[4,6]
Note:
- altes Statement (legacy code)
- OrcaleCode() Objekt erzeugt
- Encoder für userID und pwd anwenden


---?image=/res/broken_authO60.jpg&size=cover
# @color[#282828](**A2: Broken Authentication**)

+++?image=/res/broken_authO40.jpg&size=cover
### Broken Authentication
![arrow-middle](/res/PNGs/trend-middle.png)

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

---?image=/res/Data_ExposureO60.jpg&size=cover
# @color[#282828](**A3: Sensitive Data Exposure**)

+++?image=/res/Data_ExposureO40.jpg&size=cover
### Sensitive Data Exposure
![arrow-up](/res/PNGs/trend-up.png)

+++?image=/res/Data_ExposureO40.jpg&size=cover
### real-world Beispiele
@ul
- Sensitive Daten - 198 Milionen US-Wähler (2017)
- Verizon: Logs, Logindaten, config-Dateien (2017)
- Exactis: sens. Daten - 340 Milionen Records (2018)
@ulend

+++?image=/res/Data_ExposureO40.jpg&size=cover
### Unverschlüsselter Traffic
![SensDataExp](/res/PNGs/Sensitive_Data_Exposure.png)

+++?image=/res/Data_ExposureO40.jpg&size=cover
### latly on SSL/TLS
![SSL-TLS](/res/PNGs/SSL-TLS_attacks_timeline.png)

+++?image=/res/Data_ExposureO40.jpg&size=cover
### Heartbeat (keep-alive)
![Heartbeat-concept](/res/PNGs/Heartbeat-concept.png)

+++?image=/res/Data_ExposureO40.jpg&size=cover
### Heartbeat vs Heartbleed (1)
![Heartbeat](/res/PNGs/Heartbeat.png)

+++?image=/res/Data_ExposureO40.jpg&size=cover
### Heartbeat vs Heartbleed (2)
![Heartbleed](/res/PNGs/Heartbleed.png)

+++?image=/res/Data_ExposureO40.jpg&size=cover
### Misconfigured encryption (ssl-strip)
![ssl-strip](/res/PNGs/ssl-strip.png)

+++?image=/res/Data_ExposureO40.jpg&size=cover
### Daten in Ruhe: 
#### AWS S3 Bucket
![s3-bucket](/res/PNGs/leaking-bucket.png)

+++?image=/res/Data_ExposureO40.jpg&size=cover
### Daten in Ruhe: 
- Google Hacking
- Shodan
- Social Media

+++?image=/res/Data_ExposureO40.jpg&size=cover
## @size[1.5em](Demo Sensitive Data Exposure)
@css[demo](**Demo1**)
<br>
@css[demo](**Demo2**)
Note: 
- Google Hacking
- MiM Proxy (Pineapple + ssl-strip?)
- ?social mapper
- Heartbleed

+++?image=/res/Data_ExposureO40.jpg&size=cover
## Massnahmen

+++?image=/res/Data_ExposureO40.jpg&size=cover
### Daten in Ruhe:
- Starke Verschlüsselung (AES / RSA)
- Hashed, Salt & Pepper
- Zugang absicheren

+++?image=/res/Data_ExposureO40.jpg&size=cover
### Daten in Transport:
- Immer verschlüsselt
- Verschlüsselung: 
  - ≥TLS1.1
  - kein RC4 support
  - kein export-grade support
- keine 302 Redirects
- HTTP Strict Transport Security



---?image=/res/xxeO40.png&size=cover
# @color[#282828](**A4: XML External Entity**)

+++?image=/res/xxeO10.png&size=cover
### Entities
![entites](/res/PNGs/entites.png)

+++?code=/res/snippets/xxe-example.xml&lang=xml&lang=xml&title=Example Entity (XML)
@[1]
@[2]
@[2,5]
<br>
Max Mustermann

+++?image=/res/xxeO10.png&size=cover
### Denial of Service
![Billion_Laughs](/res/PNGs/entity-bil-lol.png)

+++?code=/res/snippets/billion-laughs.xml&lang=xml&title=Billion Laughs (XML)
@[1]
@[12]
@[11]
@[10-11]
@[3-11]

+++?image=/res/xxeO10.png&size=cover
### Dateien auslesen
![access-file](/res/PNGs/entity-access-file.png)&title=Dateien auslesen

+++?code=/res/snippets/access-data.xml&lang=xml&title=Dateien auslesen (XML)
@[2]
@[2, 4]
@[2, 4-5]

+++?image=/res/xxeO10.png&size=cover
### Netzwerk-Zugang
![access-netfile](/res/PNGs/entity-access-network.png)&title=Netzwerk Zugang

+++?code=/res/snippets/access-network.xml&lang=xml&title=Netzwerk Zugang (XML)
@[4]
@[4, 5]


+++?image=/res/xxeO10.png&size=cover
### Out of band XXE
![oob-xxe](/res/PNGs/entity-oob.png)

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
### DTDs (External Entities) deaktivieren
/features/disallow-doctype-decl: true

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

---
# @color[#282828](**A5: Broken Access Control**)

+++
### Zugriff durch unüberprüfter Input
![getAcctInfo](/res/PNGs/a-c_unverified.png)

+++
### Zugriff via "forced browsing"
![FrocedBrowsing](/res/PNGs/a-c_fored-browsing.png)

+++
### Path Traversal (Basics)
![PathTrav1B1](/res/PNGs/a-c_path-traversal-basic1.png)+++

+++
### Path Traversal (Basics)
![PathTrav1B2](/res/PNGs/a-c_path-traversal-basic2.png)+++

+++
### Path Traversal - URL (1)
![PathTravURL](/res/PNGs/a-c_path-traversal1.png)

+++
### Path Traversal - URL (2)
![PathTravURLencoded](/res/PNGs/a-c_path-traversal2.png)

+++
### Path Traversal - Cookie
![PathTravCookie](/res/PNGs/a-c_path-traversal-cookie-temp.png)

+++
### JWT - Verify-Algorhithmen
![jwtAsyncSyncAlgo](/res/PNGs/a-c_jwt-forge-problem.png)

+++
### JWT - Verify-Algorhithmen
![jwtAsyncSyncAlgo](/res/PNGs/a-c_jwt-forge.png)

+++
### Client-Side Kontrollen - Hidden Field
![ac_hidden-field](/res/PNGs/a-c_cs-hidden-field.png)

+++
### Cross-Origin Request Sharing (1)
![ac_cors-info1](/res/PNGs/a-c_cors-sop.png)

+++
### Cross-Origin Request Sharing (2)
![ac_cors-info2](/res/PNGs/a-c_cors.png)

+++
### CORS Misskonfigurationen (1)
Access-Control-Allow-Origin:
<br>
##### Supported:
@ul
- * (wildcard)
- origin (domain-name)
- origin-list-or-null
@ulend

+++
### CORS Misskonfigurationen (2)
<br>
##### Realitiy:
@ul
- https://*.mywebsite.ch (NOT WORKING)
- one-site.ch, another-site.ch (lack of support)
@ulend

+++
### CORS Misskonfigurationen (3)
#### Workarrounds
@ul
- Simple Origin Reflection
- Startswith
- Endswith
- Origin: null
@ulend

+++
### Workarrounds
#### Simple Origin Reflection
![ac_cors-simple-reflection](/res/PNGs/a-c_cors-simple-reflection.png)

+++
### Workarround: Startswith
![ac_cors-Startswith](/res/PNGs/a-c_cors-startswith.png)

+++
### Workarround: Endswith
![ac_cors-Startswith](/res/PNGs/a-c_cors-endswith.png)


+++
### Workarround: Origin null
![ac_cors-origin-null](/res/PNGs/a-c_cors-origin-null2.png)

+++?code=res/snippets/ac_cors-iframe-sandbox.html&lang=HTML&title=iframe sandbox (null)

+++
### ACA-Credentials: true
<br>

#### Not working
Access-Control-Allow-Origin: *
<br>
Access-Control-Allow-Credentials: true
<br>
<br>

#### WORKING!
Access-Control-Allow-Origin: null
<br>
Access-Control-Allow-Credentials: true

+++
## @size[1.5em](Demo Sensitive Data Exposure)
@css[demo](**Demo1**)
<br>
@css[demo](**Demo2**)

+++
## Massnahmen

+++
### Vertrauen
@ul
- Server-side code
- Server-less API
- Client-side code höchstens als Ergänzung!
@ulend

+++
### forced Browsing
@ul
- Kontroll-Mechanismus
- Überall und immer den selbern KM
@ulend

+++
### Path Traversal
@ul
- Vermeide User-Input
- Whitelist / hardcoded *.ext
- Input-Validation
- set permission / policies (file-access)
@ulend

+++
### CORS
@ul
- Möglichst verzichten
- *, null, ..
- set Vary: Origin
@ulend


---
# @color[#282828](**A6: Security Misconfiguration**)

+++
### Einleitung
![misconf-intro](/res/PNGs/misconf-overview.png)

+++
### Allgemein
@ul
- update!
- Sicherheits-Features
  - Benutzen
  - Konfigurieren
- geringste Privilegien
- unnötige Angriffsvektoren
  - Benutzerkonten
  - vergessene Server
  - Funktionen / Plugins
- Security headers
@ulend

+++
### veraltete Versionen

+++?code=/res/snippets/nginx-config.conf&title=Nginx - enable SSL
@[2]
@[5,6]

+++
### Fehlendes "Hardening"
#### Nginx - ssl.conf
@ul
- ssl_protocols
- ssl_ciphers
- Secure Diffie-Hellman
  - openssl dhparam -out dhparams.pem 4096
  - ssl_dhparam
- server_tokens off
- Implement WAF
- update!
@ulend

+++?code=/res/snippets/nginx-config2.conf&title=Nginx - additional config


+++
### Fehlendes "Hardening"
#### Apache - httpd.config
@ul
- TraceEnable off
- User apache
- Group apache
- ServerSignature Off
- ServerTokens Prod
- SSLProtocol -ALL +TLSv1.2
- SSLCipherSuite
- Remove unnecessary DSO Modules
- update!
@ulend

+++?code=/res/snippets/apache-no-dir-listen.conf&title=Disable Directory Listening

+++
### Fehlendes "Hardening"
#### SSH - config
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

+++
### Fehlendes "Hardening"
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