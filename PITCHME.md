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
---



## A1: Injection
+++

### SQL-Interaction: User, WebApp and Server
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
+++

### A1: 
+++

### A1: 
+++