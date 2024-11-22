Clínica Dental - Spring MVC

Este es un sistema de gestión para una clínica dental desarrollado con Spring MVC, que permite administrar pacientes, 
citas y turnos.


Tecnologías y herramientas
 - Spring Framework: Control de flujo de datos y configuración del backend.
 - Spring MVC: Gestión de controladores y vistas.
 - H2 Database: Base de datos en memoria para pruebas.
 - Thymeleaf: Motor de plantillas para el frontend.


Descripción del proyecto

El sistema de gestión para clínicas dentales es una aplicación desarrollada con Spring MVC, diseñada para simplificar
y automatizar la administración de citas, pacientes y procedimientos odontológicos. Su objetivo principal es ofrecer
una herramienta eficiente para manejar datos de manera segura y accesible, integrando tecnologías modernas como Thymeleaf
para vistas dinámicas y H2 Database para el almacenamiento.

La aplicación está estructurada siguiendo la arquitectura Modelo-Vista-Controlador (MVC), asegurando un flujo lógico y una
separación clara de responsabilidades.


Endpoints principales del API

Pacientes
- GET /pacientes: Lista todos los pacientes.
- POST /pacientes: Registra un nuevo paciente.
- GET /pacientes/{id}: Muestra información detallada de un paciente.

Citas
- GET /citas: Lista todas las citas.
- POST /citas: Programa una nueva cita.
- PUT /citas/{id}: Actualiza los detalles de una cita.

Administración
- GET /admin: Acceso al panel de administración.


Diagrama del proyecto
El proyecto sigue una arquitectura MVC:

Modelo: Manejo de datos y conexión con la base de datos usando JPA.
Vista: Renderizado dinámico mediante Thymeleaf.
Controlador: Manejo de solicitudes HTTP con Spring Controllers.
Estructura del directorio principal:

 ├── com.clinica  
 │   ├── controllers    # Controladores del proyecto  
 │   ├── models         # Entidades y lógica del negocio  
 │   ├── repositories   # Interfaces JPA  
 │   ├── services       # Lógica de negocio central  
 ├── resources  
 │   ├── templates      # Plantillas HTML  
 │   ├── application.properties  

