# Documentación de Endpoints del EstudianteController

Esta documentación detalla todos los endpoints disponibles en el controlador de estudiantes (`EstudianteController.java`).

URL Base: `/api/estudiantes`

## Operaciones CRUD

### Obtener Todos los Estudiantes
- **Método:** GET
- **Endpoint:** `/`
- **Descripción:** Retorna una lista de todos los estudiantes registrados.
- **Respuesta Exitosa:**
  - Código: 200 OK
  - Contenido: Array de objetos Estudiante

### Obtener Estudiante por ID
- **Método:** GET
- **Endpoint:** `/{id}`
- **Parámetros URL:**
  - `id`: ID del estudiante (Long)
- **Descripción:** Obtiene un estudiante específico por su ID.
- **Respuesta Exitosa:**
  - Código: 200 OK
  - Contenido: Objeto Estudiante

### Crear Estudiante
- **Método:** POST
- **Endpoint:** `/`
- **Descripción:** Crea un nuevo estudiante.
- **Cuerpo de la Petición:** Objeto Estudiante
- **Respuesta Exitosa:**
  - Código: 201 CREATED
  - Contenido: Objeto Estudiante creado

### Actualizar Estudiante
- **Método:** PUT
- **Endpoint:** `/{id}`
- **Parámetros URL:**
  - `id`: ID del estudiante a actualizar (Long)
- **Descripción:** Actualiza la información de un estudiante existente.
- **Cuerpo de la Petición:** Objeto Estudiante
- **Respuesta Exitosa:**
  - Código: 200 OK
  - Contenido: Objeto Estudiante actualizado

### Eliminar Estudiante
- **Método:** DELETE
- **Endpoint:** `/{id}`
- **Parámetros URL:**
  - `id`: ID del estudiante a eliminar (Long)
- **Descripción:** Elimina un estudiante del sistema.
- **Respuesta Exitosa:**
  - Código: 204 NO CONTENT

## Operaciones Adicionales

### Buscar por Número de Documento
- **Método:** GET
- **Endpoint:** `/documento/{numeroDocumento}`
- **Parámetros URL:**
  - `numeroDocumento`: Número de documento del estudiante (String)
- **Descripción:** Busca un estudiante por su número de documento.
- **Respuesta Exitosa:**
  - Código: 200 OK
  - Contenido: Objeto Estudiante
- **Respuesta Error:**
  - Código: 404 NOT FOUND

### Buscar por Grupo
- **Método:** GET
- **Endpoint:** `/grupo/{grupoId}`
- **Parámetros URL:**
  - `grupoId`: ID del grupo (Long)
- **Descripción:** Obtiene una lista de estudiantes pertenecientes a un grupo específico.
- **Respuesta Exitosa:**
  - Código: 200 OK
  - Contenido: Array de objetos Estudiante

### Obtener Notas de Estudiante
- **Método:** GET
- **Endpoint:** `/{id}/notas`
- **Parámetros URL:**
  - `id`: ID del estudiante (Long)
- **Descripción:** Obtiene todas las notas asociadas a un estudiante.
- **Respuesta Exitosa:**
  - Código: 200 OK
  - Contenido: Array de objetos Nota
- **Respuesta Error:**
  - Código: 404 NOT FOUND

### Asignar Grupo a Estudiante
- **Método:** PUT
- **Endpoint:** `/{id}/grupo/{grupoId}`
- **Parámetros URL:**
  - `id`: ID del estudiante (Long)
  - `grupoId`: ID del grupo a asignar (Long)
- **Descripción:** Asigna un estudiante a un grupo específico.
- **Respuesta Exitosa:**
  - Código: 200 OK
  - Contenido: Objeto Estudiante actualizado
- **Respuesta Error:**
  - Código: 404 NOT FOUND