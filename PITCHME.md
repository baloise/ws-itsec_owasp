# Open Web Application Security Project
---
## Agenda
1. Einleitung zu OWASP

2. A1 to A10
  1. Was ist A*
  2. Angriffsvektoren
  3. Demo
  4. Verteidigungsmassnahmen

3. Zusammenfassung
---



## Einleitung OWASP
+++

### Wer ist OWASP?
+++

### Was ist das Ziel?
+++

### Gefahrenmodell
![Gefahrenmodell](/res/PNGs/OWASP_Gefahrenmodell.png)



---?image=res/injection.png&size=cover&opacity=80
# @color[#282828](**A1: Injection**)
+++

### SQL-Interaction: User, WebApp and Server
---?image=res/injection.png&size=cover&opacity=35
![SQL-Req-Resp](/res/PNGs/SQL_Req-Resp.png)
+++

### SQL-Injection: Target and Impact
![SQL-Trarget_and_Impact](/res/PNGs/SQL_targets_and_impact_low.png)
+++

### SQL-Injection: Attack
![SQL-Injection](/res/PNGs/SQL_Injection.png)
+++

## @size[1.5em](Demo Injection)
@snap[]
@snapend

@snap[]
@css[demo](**Login Bypass**)
@snapend

@snap[]
@css[demo](**Command Injection**)
@snapend
+++

## Massnahmen

+++?code=res/snippets/prepeared-statements.java&lang=java&title=Prepared Statements (Java)
@[1]
@[3-4]
@[6-7]

+++?code=res/snippets/stored-procedure.java&lang=java&title=Stored Procedures (Java)
@[1-5]
@[7]

+++?code=res/snippets/white-list.java&lang=java&title=White Listing (Java)
@[1]
@[4]
@[5-6, 8]

+++?code=res/snippets/escaping.java&lang=java&title=Escaping All User Supplied (Java)
@[2,5]
@[1]
@[4,6]

---?image=/res/broken_auth.jpg&size=cover&opacity=35
# @color[#282828](**A2: Broken Authentication**)