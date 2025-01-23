# GITHUB ACTIONS W/ SONARQUBE SETUP
## PASO 1 - DOCKER
### docker-compose.yml
- Postgres como DB de SonarQube
- SonarQube
- Ejecutar: `docker-compose up -d`

<br>

## PASO 2 - NGROK (OPCIONAL)
- [Ngrok download](https://download.ngrok.com/downloads/windows)
- [Autenticarse en CMD](https://dashboard.ngrok.com/get-started/your-authtoken)

<br>

## PASO 3 - SONARQUBE TOKEN
- `localhost:9000`
-  user: `admin` pass: `admin`
-  New pass / My Account / Security / Generate Tokens:

### PASO 3.1 - GitHub repo secret
- Repo Settings / Secrets and variables -> Actions / New repository secret
  - Name: `SONAR_TOKEN` 
  - Value: `SONARQUBE TOKEN`
- Update secret

<br>

### PASO 4 - CONFIGURAR YML
- El fichero `workflow.yml` en `.github/workflows` define las tareas a realizar
- Para que funcione correctamente con SonarQube y se ejecute el análisis, modificar en `workflow.yml` el parámetro `-Dsonar.host.url=<URL SONARQUBE> \`

>[!TIP] En el caso de usar ngrok:
`ngrok http 9000` (crea un enlace para el puerto)

<br>

### PASO 5 - EJECUTAR JOBS
- `git add .` 
- `git commit -m "Jobs"`
- `git push -u origin main` 