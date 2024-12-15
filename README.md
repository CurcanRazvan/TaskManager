# TaskManager GenTech

Aceasta este o aplicație Spring Boot pentru gestionarea task-urilor. Permite utilizatorilor să adauge, vizualizeze, actualizeze și șteargă task-uri.

## Funcționalități

- Crearea unui task cu detalii precum descriere și starea de completare.
- Vizualizarea tuturor task-urilor.
- Actualizarea unui task existent.
- Ștergerea unui task.

## Tehnologii folosite

- **Java 17**
- **Spring Boot 3.x**
- **Spring Web** pentru crearea API-ului RESTful.
- **Spring Data JPA** pentru interacțiunea cu baza de date.
- **H2 Database** (bază de date în memorie, folosită pentru testare).
- **Lombok** pentru a reduce boilerplate-ul de cod (generarea automată a getter-urilor, setter-urilor, toString-ului etc.).

## Cum să rulezi aplicația

### 1. Clonează acest repository:

Pentru a începe să lucrezi cu proiectul, clonează-l pe mașina ta locală folosind comanda:

git clone https://github.com/USERNAME/TaskManager-GenTech.git

### 2. Intră în directorul proiectului:

După ce ai clonat repository-ul, navighează în directorul proiectului:

cd TaskManager-GenTech

### 3. Rulează aplicația:
Pentru a rula aplicația, poți folosi comanda Maven:

./mvnw spring-boot:run

Dacă ai deja Maven instalat, poți să construiești și să rulezi aplicația folosind comanda:

./mvnw clean install
java -jar target/TaskManager-GenTech-0.0.1-SNAPSHOT.jar

### 4. Testează API-ul
Poți testa API-ul folosind Postman, cURL sau orice alt instrument pentru interacțiunea cu API-urile RESTful. Iată câteva exemple de endpoint-uri pentru a interacționa cu aplicația:

GET toate task-urile:
Endpoint: GET http://localhost:8080/api/tasks

POST pentru a crea un task:
Endpoint: POST http://localhost:8080/api/tasks

Corpul JSON:
{
  "description": "Finish project",
  "isComplete": false
}

PUT pentru a actualiza un task:
Endpoint: PUT http://localhost:8080/api/tasks/{id}

Corpul JSON:
{
  "description": "Finish project",
  "isComplete": true
}

DELETE pentru a șterge un task:
Endpoint: DELETE http://localhost:8080/api/tasks/{id}

Accesarea consolei H2
Aplicația folosește baza de date H2 pentru testare. Pentru a accesa consola H2, urmează acești pași:

Asigură-te că aplicația este pornită.

Deschide un browser web și navighează la: http://localhost:8080/h2-console

Introdu detaliile de conectare:

JDBC URL: jdbc:h2:file:./data/demoo

User Name: sa

Password: password





