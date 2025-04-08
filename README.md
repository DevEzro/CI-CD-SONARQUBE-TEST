# 🕵🏻 GITHUB ACTIONS W/ SONARQUBE SETUP
## ⚙️ PASO 1 - DOCKER
### docker-compose.yml
- Postgres como DB de SonarQube
- SonarQube
- Ejecutar: `docker-compose up -d`

<br>

## 💭 PASO 2 - ALOJAMIENTO (NGROK, PINGGY, SERVIDOR...)
### NGROK
- [Ngrok download](https://download.ngrok.com/downloads/windows)
- [Autenticarse en CMD](https://dashboard.ngrok.com/get-started/your-authtoken)
- Alojar la dirección de SoanrQube: `ngrok http 9000`
### PINGGY
- [Pinggy (Instrucciones en la página)](https://pinggy.io)
<br>

## 🔐 PASO 3 - SONARQUBE TOKEN
- `localhost:9000`
-  user: `admin` pass: `admin`
-  New pass / My Account / Security / Generate Tokens:

### PASO 3.1 - GitHub repo secret
- Repo Settings / Secrets and variables -> Actions / New repository secret
  - Name: `SONAR_TOKEN` 
  - Value: `SONARQUBE TOKEN`
- Update secret

<br>

### 📚 PASO 4 - CONFIGURAR YML
- El fichero `workflow.yml` en `.github/workflows` define las tareas a realizar
- Para que funcione correctamente con SonarQube y se ejecute el análisis, modificar en `workflow.yml` el parámetro `-Dsonar.host.url=<URL SONARQUBE> \`

>[!CAUTION]
Tanto para Pinggy como Ngrok, el enlace generado se debe escribir tanto en el apartado de `Verificar SonarQube` como en el `host.url` del `workflow.yml`

<br>

### ▶️ PASO 5 - EJECUTAR JOBS
- `git add .` 
- `git commit -m "Jobs"`
- `git push -u origin main` 

>[!NOTE]
Para comprobar el funcionamiento de SonarQube respecto a este repositorio, se especifica a continuación los pasos para visualizar los efectos que tiene:

1. Asegurarse de tener el codigo del fichero `examples/Main.java.txt` en `src/com/example/sqlinjection/Main.java`.
2. Hacemos `git add .`, `git commit -m "init"` y `git push -u origin main`
3. El workflow lo detectará y comenzará el analisis.
4. Al finalizar accedemos a la URL donde tenemos sonar y vemos el analisis (el estado será `✅Passed`)
5. Copiamos el contenido de `examples/Vuln.java.txt` en `src/com/example/sqlinjection/Main.java` y repetimos el proceso.
6. Se ven el análisis con el estado `❌Failed`
7. Para corregir esos errores copiamos el contenido de `examples/VulnSolved2.java.txt` en el fichero `src/com/example/sqlinjection/Main.java`
8. Volvemos a realizar el proceso de git y visualizar sonar

<br>

>[!WARNING]
Es posible que aparezca como `❌Failed` debido a que habrá cosas por cubrir como tests o pruebas en el código. Puede ocurrir que no interese mostrar esos error por lo que se debe crear una `Quality Gate` en SonarQube, estableciendo todo a 0% excepto los `Security Hotspots Review`