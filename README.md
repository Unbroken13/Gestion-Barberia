# 💈 Gestión Barbería - REST API

API RESTful para la gestión integral de agendamiento de turnos, catálogo de servicios y administración de usuarios en una barbería. Desarrollada con arquitectura de 3 capas.

---

## 🚀 Estado del MVP (Hoja de Ruta)

- [x] **EPIC-01: Configuración Base & Catálogo de Servicios (Release v0.1.0)**
    - [x] Configuración inicial, conexión a MySQL y GlobalExceptionHandler.
    - [x] CRUD completo de Servicios con DTOs y MapStruct.
- [x] **EPIC-02: Módulo de Usuarios & Roles**
    - [x] Jerarquía de Persona (Cliente y Empleado) y modelo de Usuario.
    - [x] Enums de Rol y TipoEmpleado.
- [ ] **EPIC-03: Módulo Core de Turnos**
    - [ ] Modelo Turno y tabla intermedia DetalleTurno (Relación N:M).
- [ ] **EPIC-04: Lógica de Negocio & Disponibilidad**
    - [ ] Algoritmo de validación de solapamiento de horarios por barbero.

---

## 🛠️ Stack Tecnológico

* **Lenguaje:** Java 17
* **Framework:** Spring Boot 3.x (Spring Data JPA, Spring Web, Validation)
* **Base de Datos:** MySQL 8.0
* **Mapeo de Datos:** MapStruct
* **Herramientas de Productividad:** Lombok
* **Gestor de Dependencias:** Apache Maven
* **Control de Versiones:** Git & GitHub (GitHub Flow)

---

## 🏗️ Arquitectura del Sistema

El proyecto implementa una **Arquitectura en 3 Capas** desacoplada mediante DTOs:

```text
[ HTTP Request ]
       │
       ▼
┌──────────────┐   (Controller Layer)
│ Controllers  │ ──► Mapea HTTP a RequestDTOs / Retorna ResponseDTOs
└──────┬───────┘
       │
       ▼
┌──────────────┐   (Service Layer)
│   Services   │ ──► Contiene la lógica de negocio, reglas y validaciones
└──────┬───────┘
       │
       ▼
┌──────────────┐   (Data Access Layer)
│ Repositories │ ──► Spring Data JPA interfaces / Consultas a la BD
└──────┬───────┘
       │
       ▼
┌──────────────┐
│ MySQL Database│
└──────────────┘
```
---

## 🌐 Endpoints Expuestos (v0.1.0)

### ✂️ Catálogo de Servicios (`/api/v1/servicios`)

| Método | Endpoint | Descripción | HTTP Status |
| :--- | :--- | :--- | :--- |
| `POST` | `/api/v1/servicios` | Crear un nuevo servicio | `201 Created` |
| `GET` | `/api/v1/servicios` | Listar todos los servicios | `200 OK` |
| `GET` | `/api/v1/servicios/{id}` | Obtener un servicio por ID | `200 OK` |
| `PUT` | `/api/v1/servicios/{id}` | Actualizar un servicio | `200 OK` |
| `DELETE` | `/api/v1/servicios/{id}` | Eliminar un servicio por ID | `204 No Content` |

### 👥 Módulo de Usuarios

#### Clientes (`/api/v1/customers`)
| Método | Endpoint | Descripción | HTTP Status |
| :--- | :--- | :--- | :--- |
| `POST` | `/api/v1/customers` | Registrar un nuevo cliente | `201 Created` |
| `GET` | `/api/v1/customers` | Listar todos los clientes | `200 OK` |
| `GET` | `/api/v1/customers/{id}` | Obtener cliente por ID | `200 OK` |
| `PUT` | `/api/v1/customers/{id}` | Actualizar datos del cliente | `200 OK` |
| `DELETE` | `/api/v1/customers/{id}` | Eliminar cliente (Baja) | `204 No Content` |

#### Empleados (`/api/v1/empleados`)
| Método | Endpoint | Descripción | HTTP Status |
| :--- | :--- | :--- | :--- |
| `POST` | `/api/v1/empleados` | Registrar un nuevo empleado | `201 Created` |
| `GET` | `/api/v1/empleados` | Listar todos los empleados | `200 OK` |
| `GET` | `/api/v1/empleados/{id}` | Obtener empleado por ID | `200 OK` |
| `PUT` | `/api/v1/empleados/{id}` | Actualizar datos del empleado | `200 OK` |
| `DELETE` | `/api/v1/empleados/{id}` | Eliminar empleado (Baja) | `204 No Content` |
#### 📄 Ejemplos de Payload (JSON)

**POST /api/v1/servicios (Body - ServicioRequestDTO):**
```json
{
  "nombre": "Corte de Barba Express",
  "precio": 4500.00,
  "duracion": 20,
  "descripcion": "Perfilado y recorte rápido de barba"
}
```

**Respuesta Exitosa (ServicioResponseDTO):**
```json
{
  "id": 1,
  "nombre": "Corte de Barba Express",
  "precio": 4500.00,
  "duracion": 20,
  "descripcion": "Perfilado y recorte rápido de barba"
}
```

---

## ⚙️ Instalación y Configuración Local

### Pre-requisitos
* Java JDK 17 o superior.
* MySQL Server 8.0 corriendo localmente.
* Maven 3.8+ (o utilizar el wrapper `./mvnw` incluido).

### Pasos de Configuración

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/Unbroken13/Gestion-Barberia.git
   cd Gestion-Barberia
   ```

2. **Configurar la Base de Datos:**
   Crea la base de datos localmente en MySQL:
   ```sql
   CREATE DATABASE gestion_barberia;
   ```

3. **Configurar las credenciales:**
   Edita el archivo `src/main/resources/application.properties` con tus credenciales de MySQL:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/gestion_barberia?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
   spring.datasource.username=tu_usuario_mysql
   spring.datasource.password=tu_contraseña_mysql
   spring.jpa.hibernate.ddl-auto=update
   ```

4. **Ejecutar la aplicación:**
   ```bash
   ./mvnw spring-boot:run
   ```
   *La API iniciará por defecto en `http://localhost:8080`.*

---

## 🌿 Estrategia de Git & Commits

El proyecto sigue una adaptación de **GitHub Flow** con commits semánticos bajo el estándar **Conventional Commits**:

- **Ramas Principales:** `main` (Producción/Releases) y `develop` (Desarrollo).
- **Ramas de Feature:** `feature/#<issue_id>-<breve-descripcion>`
- **Estructura de Commit:** `tipo(alcance): descripción imperativa`
    - *Ejemplo:* `feat(servicio): crear entidad JPA Servicio y ServicioRepository`