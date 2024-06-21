# liga_bet_play

La Liga BetPlay es la liga de fútbol profesional de Colombia, que requiere un sistema de gestión
integral para administrar todos los aspectos relacionados con la liga, desde la gestión de equipos
y jugadores hasta la programación de partidos y la interacción con los aficionados. Actualmente, la
gestión de la liga se realiza manualmente o con múltiples sistemas no integrados, lo que genera
ineficiencias, errores y dificultades en la toma de decisiones.

El sistema de gestión propuesto debe abordar las siguientes necesidades:

1. **Gestión de Equipos y Jugadores**: El sistema debe permitir registrar, editar y eliminar
información de los equipos y jugadores. Esto incluye detalles como nombre, ciudad, estadio,
entrenadores, jugadores, y estadísticas individuales y colectivas.
2. **Programación y Resultados de Partidos**: Debe ser posible programar los partidos de la liga,
asignando fechas, horarios y estadios. También debe permitir registrar los resultados de los
partidos, incluyendo goles, tarjetas y otros incidentes.
3. **Gestión de Lesiones y Rendimiento**: El sistema debe registrar y gestionar las lesiones de los
jugadores, así como hacer un seguimiento del rendimiento de los jugadores en cada partido,
incluyendo estadísticas como minutos jugados, goles, asistencias y tarjetas.
4. **Entrenamientos y Convocatorias**: Debe permitir a los equipos planificar y registrar
sesiones de entrenamiento, así como gestionar las convocatorias de jugadores para partidos
y torneos.
5. **Transferencias de Jugadores**: El sistema debe gestionar las transferencias de jugadores
entre equipos, incluyendo detalles como equipos de origen y destino, montos y fechas.
6. **Venta de Entradas y Patrocinios**: Debe facilitar la venta de entradas a los aficionados,
gestionando las transacciones y asignando asientos en los estadios. También debe gestionar
los contratos de patrocinio y publicidad.
7. **Comunicaciones y Relaciones Públicas**: El sistema debe permitir la emisión y gestión de
comunicaciones oficiales y noticias de la liga, dirigidas a diferentes actores como aficionados,
medios de comunicación y equipos.
8. **Estadísticas y Informes**: Debe proporcionar herramientas para generar y visualizar
estadísticas e informes detallados sobre diferentes aspectos de la liga, como rendimiento de
equipos y jugadores, asistencia a partidos, etc.
9. **Gestión de Usuarios y Roles**: El sistema debe gestionar los usuarios que acceden al sistema,
asignando roles y permisos específicos según su función (administradores, entrenadores,
jugadores, periodistas, aficionados).
10. **Seguridad y Acceso**: Debe garantizar la seguridad de la información y el acceso controlado
mediante autenticación de usuarios y gestión de permisos.

## Objetivos del Sistema
1. **Centralizar la Gestión**: Unificar la gestión de todos los aspectos de la liga en un único
sistema integrado.
2. **Mejorar la Eficiencia**: Reducir los errores y mejorar la eficiencia operativa mediante la
automatización de tareas y procesos.
3. **Facilitar la Toma de Decisiones**: Proporcionar información precisa y oportuna para la toma
de decisiones estratégicas.

4. **Incrementar la Interacción**: Mejorar la interacción con los aficionados y otros actores
mediante una plataforma accesible y funcional.
5. **Asegurar la Información**: Garantizar la seguridad y confidencialidad de la información
gestionada por el sistema.

## Clases Principales y Atributos
### Clase Equipo
- id : Identificador único del equipo.
- nombre : Nombre del equipo.
- ciudad : Ciudad de origen del equipo.
- estadio : Nombre del estadio donde juega el equipo.
- entrenador : Nombre del entrenador del equipo.
- jugadores : Lista de jugadores que pertenecen al equipo.
- partidos : Lista de partidos en los que ha participado el equipo.
### Clase Jugador
- id : Identificador único del jugador.
- nombre : Nombre del jugador.
- edad : Edad del jugador.
- posicion : Posición en la que juega (por ejemplo, delantero, mediocampista, etc.).
- nacionalidad : Nacionalidad del jugador.
- numeroCamiseta : Número de camiseta del jugador.
- equipo : Equipo al que pertenece el jugador.
- lesiones : Lista de lesiones que ha tenido el jugador.
- rendimientos : Lista de registros de rendimiento del jugador.
### Clase Partido
- id : Identificador único del partido.
- equipoLocal : Equipo que juega como local.
- equipoVisitante : Equipo que juega como visitante.
- fecha : Fecha del partido.
- hora : Hora del partido.
- estadio : Estadio donde se juega el partido.
- goles : Lista de goles anotados en el partido.
- tarjetas : Lista de tarjetas (amarillas y rojas) emitidas durante el partido.
- incidentes : Lista de incidentes ocurridos durante el partido.
- resultado : Resultado final del partido.

### Clase Gol
- id : Identificador único del gol.
- jugador : Jugador que anotó el gol.
- equipo : Equipo que anotó el gol.
- minuto : Minuto en el que se anotó el gol.
- partido : Partido en el que se anotó el gol.
### Clase Tarjeta
- id : Identificador único de la tarjeta.
- jugador : Jugador que recibió la tarjeta.
- partido : Partido en el que se emitió la tarjeta.
- tipo : Tipo de tarjeta (amarilla o roja).
- minuto : Minuto en el que se emitió la tarjeta.
### Clase Incidente
- id : Identificador único del incidente.
- partido : Partido en el que ocurrió el incidente.
- descripcion : Descripción del incidente.
- minuto : Minuto en el que ocurrió el incidente.
### Clase Resultado
- id : Identificador único del resultado.
- partido : Partido al que corresponde el resultado.
- golesEquipoLocal : Número de goles del equipo local.
- golesEquipoVisitante : Número de goles del equipo visitante.
### Clase Lesión
- id : Identificador único de la lesión.
- jugador : Jugador lesionado.
- tipo : Tipo de lesión.
- gravedad : Gravedad de la lesión.
- fechaInicio : Fecha de inicio de la lesión.
- fechaFin : Fecha de finalización de la lesión (recuperación).
### Clase Rendimiento
- id : Identificador único del rendimiento.
- jugador : Jugador al que corresponde el rendimiento.
- partido : Partido en el que se evaluó el rendimiento.
- minutosJugados : Minutos jugados por el jugador en el partido.
- goles : Número de goles anotados por el jugador en el partido.
- asistencias : Número de asistencias del jugador en el partido.
- tarjetasAmarillas : Número de tarjetas amarillas recibidas por el jugador en el partido.
- tarjetaRoja : Número de tarjetas rojas recibidas por el jugador en el partido.
### Clase Entrenamiento
- id : Identificador único del entrenamiento.
- equipo : Equipo que realiza el entrenamiento.
- fecha : Fecha del entrenamiento.
- hora : Hora del entrenamiento.
- lugar : Lugar donde se realiza el entrenamiento.
- actividades : Lista de actividades realizadas durante el entrenamiento.
- jugadoresConvocados : Lista de jugadores convocados para el entrenamiento.
### Clase Actividad
- id : Identificador único de la actividad.
- descripcion : Descripción de la actividad.
- duracion : Duración de la actividad.
### Clase Transferencia
- id : Identificador único de la transferencia.
- jugador : Jugador transferido.
- equipoOrigen : Equipo del cual proviene el jugador.
- equipoDestino : Equipo al cual se transfiere el jugador.
- monto : Monto de la transferencia.
- fecha : Fecha de la transferencia.
### Clase Usuario
- id : Identificador único del usuario.
- nombre : Nombre del usuario.
- email : Correo electrónico del usuario.
- password : Contraseña del usuario.
- rol : Rol del usuario (por ejemplo, administrador, entrenador, etc.).
### Clase Rol
- id : Identificador único del rol.
- nombre : Nombre del rol.
- permisos : Lista de permisos asociados al rol.
### Clase Permiso
- id : Identificador único del permiso.
- descripcion : Descripción del permiso.
### Clase Patrocinador
- id : Identificador único del patrocinador.
- nombre : Nombre del patrocinador.
- tipo : Tipo de patrocinio (por ejemplo, principal, secundario, etc.).
- monto : Monto del patrocinio.
- fechaInicio : Fecha de inicio del patrocinio.
- fechaFin : Fecha de finalización del patrocinio.
### Clase Comunicacion
- id : Identificador único de la comunicación.
- titulo : Título de la comunicación.
- contenido : Contenido de la comunicación.
- fechaPublicacion : Fecha de publicación de la comunicación.
- destinatarios : Lista de usuarios destinatarios de la comunicación.
### Clase Entrada
- id : Identificador único de la entrada.
- partido : Partido para el cual es la entrada.
- comprador : Usuario que compró la entrada.
- fechaCompra : Fecha de compra de la entrada.
- cantidad : Cantidad de entradas compradas.
- precioTotal : Precio total de la compra.
- ubicacion : Ubicación de los asientos en el estadio.
### Clase Estadio
- id : Identificador único del estadio.
- nombre : Nombre del estadio.
- ubicacion : Ubicación del estadio.
- capacidad : Capacidad del estadio.