# 🚀 CRUD User Project 

<p align="center">
  <img src="https://img.shields.io/badge/Java-8-orange" />
  <img src="https://img.shields.io/badge/Spring%20Boot-2.x-brightgreen" />
  <img src="https://img.shields.io/badge/Gradle-6.x-blue" />
  <img src="https://img.shields.io/badge/OpenAPI-3-green" />
</p>


## 📝 Descripción
Este proyecto implementa un **microservicio REST** responsable de la **gestión de usuarios**, incluyendo la creación, consulta y administración de información personal.

El servicio está diseñado siguiendo buenas prácticas de **arquitectura por capas**, documentado para su revisión en **GitHub**, y preparado para integrarse con otros microservicios dentro de una arquitectura distribuida.

---

## 🧰 Tecnologías
- **Java:** 8 (JDK 1.8)
- **Framework:** Spring Boot 2.x
- **Gestor de dependencias:** Gradle
- **Persistencia:** Spring Data JPA
- **Base de datos:** H2 (en memoria)

---

## 🏗️ Arquitectura
El proyecto sigue una arquitectura clásica por capas:

```
Controller → Service → Repository → Database
```

- **Controller:** Exposición de endpoints REST
- **Service:** Lógica de negocio y validaciones
- **Repository:** Acceso a datos mediante JPA
- **DTOs:** Separación entre modelo de dominio y contratos REST

---

## 📋 Requisitos
Antes de ejecutar el proyecto asegúrate de contar con:

- JDK 1.8
- Gradle 6.x+
- MySQL 5.7+ (o compatible)
- Git
- Docker (opcional)

---

## ⚙️ Configuración
La base de datos **H2 en memoria** se configura automáticamente para ejecución local, por lo que **no se requieren variables de entorno** ni configuración adicional.

Ejemplo de configuración incluida:
```yaml
spring:
  datasource:
    url: jdbc:h2:mem:testdb
    driver-class-name: org.h2.Driver
    username: usuario
    password: 
  jpa:
    hibernate:
      ddl-auto: update
  h2:
    console:
      enabled: true
```

La consola H2 está disponible en:
```
http://localhost:8080/h2-console
```

---

## ▶️ Ejecución local

### Usando Gradle
```bash
./gradlew clean bootRun
```

El servicio se iniciará por defecto en:
```
http://localhost:8080
```

---



## 🔗 Endpoints principales

| Método | Endpoint | Descripción |
|------|---------|-------------|
| POST | /usuarios | Crear un usuario |
| GET | /usuarios/{id} | Obtener usuario por ID |
| GET | /usuarios | Listar usuarios |
| PUT | /usuarios/{id} | Actualizar usuario |
| DELETE | /usuarios/{id} | Eliminar usuario |

---





## 🚨 Manejo de errores
El servicio implementa un manejo centralizado de excepciones:

- `400 Bad Request`: errores de validación
- `404 Not Found`: recursos inexistentes
- `500 Internal Server Error`: errores inesperados

Las respuestas de error siguen un formato estándar:
```json
{
  "timestamp": "2026-01-14T10:30:00",
  "status": 400,
  "error": "Bad Request",
  "message": "El campo email es obligatorio"
}
```

---

## 🧠 Decisiones técnicas
- Uso de **H2 en memoria** para facilitar la ejecución y revisión del proyecto
- Arquitectura por capas (Controller / Service / Repository)
- Separación de entidades y DTOs
- Configuración mínima para enfoque en lógica y diseño

---

## 📌 Estado del proyecto
Este proyecto se encuentra en desarrollo activo y sirve como referencia para:
- Buenas prácticas en Spring Boot
- Documentación profesional para revisión técnica
- Diseño de microservicios REST

---

## 👤 Autor
**Andrés Pérez**  
Proyecto desarrollado con fines educativos y profesionales.

