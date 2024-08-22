# ApiPolicy

API that connect with the wiremock service for a better dev experience provided of security and good practices.

### Requirements

- Java 17
- Spring Boot 3.3.2
- Postman (Optional)

### Starting instructions

1. Clone this proyect using the command:</br>
` git clone https://github.com/jmgomezI/APIPolicy.git `
2. Run proyect.
3. Run wiremock service using the following command in the `wiremock-main` terminal:</br>
` docker run -it --rm -p 8081:8080 --name wiremock -v $PWD:/home/wiremock wiremock/wiremock:3.9.1 `
4. Go to postman or the navigator and copy this URL:</br>
http://localhost:8080/policies?dni=00000000T</br>
5. Insert user `admin` and password `admin`

> [!NOTE]
> Do a Maven reload or download for update dependencies.

### Characteristics

- It has security configuration.
- Api development focused on good practices.
- Organized in the correct packages.

