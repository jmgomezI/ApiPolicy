Ejercicio
==========
El ejercicio consiste en implementar un API REST que exponga el API de pólizas mockeado en wiremock en el fichero de definición de exercise.json

El objetivo es simular una situación típica en la construcción de un BFF. Disponemos de unos servicios con "taras" a nivel de diseño de APIs, que no gestionan la autorización y que podrían incluso no ser congruentes. Nuestro API debe exponer un API REST más "decente" que ayude a nuestros compañeros de front a interactuar con back de forma congruente.

Se deben cubrir los siguientes objetivos:
* API REST implementado como aplicación de Spring Boot
* Buenas prácticas de diseño de APIs REST, puedes darle un vistazo a este recurso por ejemplo: https://www.vinaysahni.com/best-practices-for-a-pragmatic-restful-api
* Implementar autenticado utilizando base de datos en memoria donde el DNI será el usuario. Por simplicidad podemos utilizar basic auth.
* El API deberá exponer:
  - Listado de pólizas (servicio mock /polizas?dni)
  - Detalle de póliza (servicio mock /polizas/{idPoliza})
  - Listado de siniestros asociados a una póliza (servicio mock /polizas/{idPoliza}/siniestros)
  - Acceso al detalle de un siniestro (servicio mock /siniestros/{idSiniestro})
* Gestión de la autorización en base a los datos de los servicios
* Gestión de errores

Y en un segundo hito:
* Cache
* Circuit breaking con resilience4j

Cómo lanzar el API mock:
En la ruta de este proyecto, con el directorio de mappings, lanzar con docker
```docker run -it --rm -p 8081:8080 --name wiremock -v $PWD:/home/wiremock wiremock/wiremock:3.9.1```

Esto expondrá el API en el puerto 8081. Puedes probar que está funcionando con:

```curl -v http://localhost:8081/polizas\?dni\=OOOOOOOOT```