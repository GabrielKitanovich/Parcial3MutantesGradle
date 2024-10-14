# Mutantes Application

This is a Spring Boot application that detects if a human is a mutant based on their DNA sequence. The application provides a REST API to check DNA sequences and stores the results in a database. It also provides statistics on the DNA sequences checked.

## Prerequisites

- Java 21
- Gradle 8.10.0
- Docker (optional, for containerization)
- An IDE like IntelliJ IDEA

## Getting Started

### Clone the Repository

```sh
git clone https://github.com/GabrielKitanovich/Parcial3MutantesGradle.git
cd Mutantes
```
### Build the Application

```sh
./gradlew build
```

### Run the Application

```sh
./gradlew bootRun
```

The application will start on http://localhost:8080.

## API Endpoints
### Check if DNA is Mutant

### Endpoint: POST /mutant/  

### Request Body:
```json
{
  "dna": ["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}
```
### Response:
- HTTP Status: 200 OK (if the DNA is mutant)
- HTTP Status: 403 Forbidden (if the DNA is not mutant)
- HTTP Status: 400 Bad Request (if the DNA is invalid)

### Get DNA Stats

### Endpoint: GET /mutant/stats

### Response:
```json
{
  "count_mutant_dna": 40,
  "count_human_dna": 100,
  "ratio": 0.4
}
```

## Running the Tests

To run the tests, execute the following command:

```sh
./gradlew test
```

## Code Coverage with JaCoCo

To generate the code coverage report, execute the following command:

```sh
./gradlew test jacocoTestReport
```

The code coverage report will be generated in the `build/jacocoHtml/index.html` directory.

Automatic Tests will run every time there is a change in the code.