# Proyecto Personal

Este proyecto me ayudará a poner en práctica lo que voy aprendiendo.

### TODO List

#### **1. Configuración Inicial del Proyecto**

- [ ] Crear proyecto Spring Boot con **Spring Initializr**:
  - [ ] Seleccionar dependencias:
  - [ ] Definir estructura de paquetes:

#### **2. Configuración de Bases de Datos**

- [ ] Configurar **application.properties**:
  - [ ] Conexión a PostgreSQL/MySQL:
  - [ ] Conexión a MongoDB:

#### **3. Modelado de Entidades**

- [ ] **Entidades SQL (JPA)**:
- [ ] **Documentos MongoDB**:

#### **4. Repositorios (Spring Data)**

- [ ] Repositorios SQL:
  - [ ] Crear `OwnerRepository` que extienda `JpaRepository<Owner, UUID>`.
  - [ ] Crear `AppointmentRepository` con métodos personalizados (ej: `findByStatus`).
- [ ] Repositorios MongoDB:
  - [ ] Crear `MedicalRecordRepository` que extienda `MongoRepository<MedicalRecord, String>`.
  - [ ] Crear `ActivityLogRepository` para consultas de registros.

#### **5. Lógica de Servicios**

- [ ] Servicios SQL:
  - [ ] Crear `OwnerService` con métodos para CRUD de dueños.
  - [ ] Crear `AppointmentService` para gestionar estados de citas (`scheduled` → `completed`).
- [ ] Servicios MongoDB:
  - [ ] Crear `MedicalRecordService` para añadir visitas médicas con documentos anidados.
  - [ ] Crear `LoggingService` para registrar acciones en `activity_logs`.

#### **6. Controladores REST**

- [ ] Crear endpoints para:
  - [ ] `OwnerController`:
    - `GET /api/owners` (listar dueños)
    - `POST /api/owners` (crear dueño)
  - [ ] `AppointmentController`:
    - `PUT /api/appointments/{id}/status` (actualizar estado)
  - [ ] `MedicalRecordController`:
    - `POST /api/pets/{id}/medical-visits` (añadir visita médica).

#### **7. Validación y Seguridad**

- [ ] Añadir validaciones básicas:
  - [ ] Usar `@Valid` en controladores para validar entradas.
  - [ ] Anotaciones como `@Email` en `Owner.email`.
- [ ] Configurar seguridad básica (opcional):
  - [ ] Integrar `Spring Security` para autenticación JWT.

#### **8. Pruebas**

- [ ] Pruebas unitarias:
  - [ ] Probar `OwnerService` con `@DataJpaTest`.
  - [ ] Probar `MedicalRecordService` con `@DataMongodbTest`.
- [ ] Pruebas de integración:
  - [ ] Simular flujo completo: crear dueño → mascota → cita → factura.

#### **9. Documentación**

- [ ] Generar documentación API con **Swagger**:
  - [ ] Añadir dependencia `springdoc-openapi`.
  - [ ] Configurar en `http://localhost:8080/swagger-ui.html`.

#### **10. Despliegue**

- [ ] Dockerizar la aplicación:
  - [ ] Crear `Dockerfile` para Spring Boot.
  - [ ] Configurar `docker-compose.yml` con PostgreSQL y MongoDB.
- [ ] Desplegar en nube (ej: Heroku, AWS):
  - [ ] Configurar variables de entorno para conexiones remotas.

### Modelos relacionales

![Core Entities](relational_model/core_entities.png "Core Entities")
