# PadelNexo · MDAI · Entrega 1

## Estudiante

| Nombre | Usuario Git | Partes principales en las que ha trabajado |
|----------|------------|--------------------------------------------|
| Samuel Fabián Montero | sfabianm | Modelo Jugador, API REST, vistas Thymeleaf, configuración y filtros |

---

## Temática

PadelNexo es una aplicación web orientada a jugadores de pádel que permite consultar información sobre jugadores registrados, analizar su rendimiento y filtrarlos según distintos criterios como el nivel o la zona.

La aplicación está pensada para facilitar la búsqueda de jugadores y servir como base para futuras funcionalidades relacionadas con partidos, reservas y competiciones.

Entidad principal: **Jugador**

Atributos:

- id
- nombre
- nivel
- posicion
- zona
- partidosJugados
- victorias

Valor calculado:

- porcentajeVictorias

---

## Vídeo de presentación

PENDIENTE DE AÑADIR ENLACE

---

## Cómo arrancar

Requisitos:

- JDK 21

Ejecutar:

```bash
./mvnw spring-boot:run
```

o desde IntelliJ ejecutando:

```text
PadelNexoApplication
```

Página de inicio:

```text
http://localhost:8080/
```

---

## API REST

| Método | Ruta | Parámetros | Respuesta |
|----------|------|------------|------------|
| GET | /api/jugadores | nivel (opcional) | Lista de jugadores |
| GET | /api/jugadores/{id} | id | Un jugador |
| GET | /api/jugadores/destacados | - | Jugadores destacados |
| GET | /api/jugadores/zona/{zona} | zona | Jugadores de una zona |

---

## Ejemplos (salidas reales)

### Todos los jugadores

```bash
curl -s localhost:8080/api/jugadores
```

Pega aquí la salida real de tu aplicación.

### Jugador concreto

```bash
curl -s localhost:8080/api/jugadores/1
```

Pega aquí la salida real.

### Error 404

```bash
curl -i localhost:8080/api/jugadores/9999
```

Ejemplo:

```text
HTTP/1.1 404
```

---

## Vistas

| Ruta | Qué muestra |
|--------|------------|
| / | Página principal |
| /jugadores | Listado de jugadores |
| /jugadores?nivel=Intermedio | Jugadores filtrados por nivel |
| /jugadores/{id} | Detalle de un jugador |

---

## Configuración

| Propiedad | Valor por defecto | Efecto |
|------------|------------------|---------|
| padelnexo.nombre | PadelNexo | Nombre de la aplicación |
| padelnexo.zona-destacada | Merida | Zona destacada de la plataforma |
| padelnexo.minimo-victorias | 20 | Mínimo de victorias para considerar un jugador destacado |

### Demostración

Ejemplo:

```bash
java -jar target/padelnexo.jar --padelnexo.minimo-victorias=50
```

Al aumentar el valor, disminuye el número de jugadores que aparecen en:

```text
/api/jugadores/destacados
```

sin necesidad de modificar el código Java.

---

## Decisiones de diseño

### ¿Por qué esta entidad y estos atributos?

Se eligió la entidad Jugador porque es el elemento principal dentro de una plataforma de gestión de pádel. Los atributos permiten representar tanto información descriptiva como estadística del jugador.

### ¿Qué consultas propias habéis elegido y por qué son útiles?

- Búsqueda por nivel.
- Búsqueda por zona.
- Jugadores destacados.

Estas consultas permiten localizar jugadores compatibles y analizar el rendimiento de la comunidad.

### ¿Qué cambiaría al pasar a base de datos en la entrega 2?

La colección en memoria basada en CopyOnWriteArrayList sería sustituida por una base de datos gestionada mediante Spring Data JPA. El servicio mantendría la lógica de negocio, mientras que la persistencia se delegaría en repositorios especializados.