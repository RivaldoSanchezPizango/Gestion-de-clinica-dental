Gestión de Clínica Dental


Descripción
Gestión de Clínica Dental es una aplicación web diseñada para optimizar la administración de una clínica dental. Permite gestionar pacientes, citas y tratamientos de manera eficiente, proporcionando una interfaz intuitiva para los usuarios.

Características
Gestión de Pacientes: Registro y actualización de información de pacientes.
Programación de Citas: Creación, modificación y cancelación de citas.
Control de Tratamientos: Seguimiento de tratamientos y procedimientos realizados.
Autenticación de Usuarios: Acceso seguro mediante roles y permisos.
Tecnologías Utilizadas
Backend
Java

Lenguaje de programación robusto y orientado a objetos.
Usado para implementar la lógica de negocio y las funcionalidades del sistema.
Spring Boot

Framework que facilita la creación de aplicaciones Java rápidas y seguras.
Proporciona configuraciones predeterminadas, lo que reduce la complejidad del desarrollo.
Usado aquí para:
Creación de APIs REST: Manejo de peticiones HTTP (GET, POST, PUT, DELETE).
Gestión de dependencias con Maven.
Spring MVC (Model-View-Controller)

Se utiliza para estructurar el proyecto según la arquitectura MVC.
Divide la aplicación en:
Modelo: Lógica y entidades de negocio.
Vista: Plantillas dinámicas para mostrar la información.
Controlador: Manejo de solicitudes y respuestas.
Spring Security

Framework de seguridad que permite proteger la aplicación.
Implementa:
Autenticación de usuarios.
Autorización con roles (por ejemplo: administrador, usuario).
Asegura que solo usuarios autorizados puedan acceder a determinadas funcionalidades.
H2 Database

Base de datos relacional en memoria utilizada para desarrollo y pruebas rápidas.
Permite ejecutar la aplicación sin necesidad de configurar bases de datos externas.
Ideal para demostrar el funcionamiento completo del sistema en un entorno local.
JPA (Java Persistence API) con Hibernate

Framework ORM (Mapeo Objeto-Relacional) que simplifica la interacción con la base de datos.
Permite trabajar con entidades Java en lugar de escribir consultas SQL manuales.
Frontend
Thymeleaf

Motor de plantillas para generar vistas HTML dinámicas en aplicaciones Spring.
Facilita la integración del modelo de datos con el HTML de manera sencilla y eficiente.
Utilizado para mostrar la información de pacientes, citas y tratamientos.
Bootstrap

Framework CSS que proporciona componentes y estilos predefinidos para crear interfaces atractivas y responsivas.
Garantiza que la aplicación funcione bien en diferentes dispositivos (móviles, tabletas, computadoras).
Herramientas de Construcción y Gestión
Maven

Herramienta para la gestión de dependencias y construcción del proyecto.
Facilita la integración de bibliotecas externas (Spring Boot, Thymeleaf, etc.).
Utilizado para compilar, empaquetar y ejecutar la aplicación.
Spring DevTools

Herramienta que permite un desarrollo más ágil con actualizaciones automáticas de la aplicación durante el desarrollo.
Estructura del Proyecto
El proyecto sigue la arquitectura Modelo-Vista-Controlador (MVC):

bash
Copiar código
src/
│
├── main/
│   ├── java/
│   │   ├── com.example.clinicadental/   # Paquete principal
│   │   │   ├── controllers/             # Controladores Spring MVC
│   │   │   ├── models/                  # Clases de entidades (Pacientes, Citas, Tratamientos)
│   │   │   ├── repositories/            # Interfaces JPA para acceso a la base de datos
│   │   │   ├── services/                # Lógica de negocio
│   │
│   ├── resources/
│   │   ├── templates/                   # Plantillas Thymeleaf
│   │   ├── static/                      # Archivos estáticos (CSS, JS, imágenes)
│   │   └── application.properties       # Configuración de la aplicación
│
└── test/                                # Pruebas unitarias
Instalación y Ejecución
Clonar el repositorio:

bash
Copiar código
git clone https://github.com/RivaldoSanchezPizango/Gestion-de-clinica-dental.git
Ingresar al directorio del proyecto:

bash
Copiar código
cd Gestion-de-clinica-dental
Compilar y ejecutar la aplicación:

bash
Copiar código
./mvnw spring-boot:run
Acceder a la aplicación:

Abrir un navegador web y navegar a http://localhost:8080.

