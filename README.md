# Java APP N5! - API REST | Integrador para Ventas
🍃 | Amigos de github, en el curso que estaba haciendo proponian un ejercicio integrador para afianzar conocoimientos y no pase la oportunidad.   
🍃 | Ya es la segunda app tipo API REST que subo incompleta, porque la realidad es que hay algunas funcionalidades que estan incompletas en esta y la anterior jeje   

### **Algunas otras cosas que me faltaron poner en el sistema:**
- Al ser una práctica de backend, en lo que son consultas CRUD me falto que traiga cualquier objeto por ID, si me falto alguna interfaz para enviar los datos.
- Esta vez no hice que se hostee en algun lado la API.
- Hacer que se reste la cantidad de productos al hacer una venta.

### **Tecnicas/Tecnologias usadas para el proyecto que considero interesantes:**
- Backend: Java 21 con Spring Boot 4.0.2
- Persistencia: Spring Data JPA + MySQL 9.5.0
- Dockerización: Uso de Docker para la API.
- Herramienta: Uso de Maven para gestionar las dependencias.

### **Problemas técnicos solucionados:**
- Uso de variables de entorno: para no exponer datos sensibles, configure el proyecto para que tenga variables en las credenciales (username, password, y url) de la base de datos.
- Uso de anotaciones para el @OneToMany: al subir una venta, no me mostraba la lista relacionada al detalle, pero con el uso de ```(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)``` pude solucionar el problema.

# Cómo utilizar la API:
Como no voy a hostear la API, se me ocurrió la idea de explicarlo con videos... así que en cuanto haga el video lo pongo por acá!

# **Siguiente proyecto:**  
❇️ | Ya el siguiente paso va a ser una aplicación fullstack con Angular, muy probablemente sea para repasar front con Angular y converja en un login!   
Dejo link al proyecto N°6: [AngularFV1-Primer-Proyecto](https://github.com/ViniBitCode/AngularFV1-Primer-Proyecto)
