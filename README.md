# Gestion de Cursos Web
_El trabajo práctico consistirá en un sistema web para una organización que dicta cursos (cursos de programación, idiomas, etc…). El sistema permitirá a la organización publicar los diferentes cursos que dicta, y de esta forma, los usuarios podrán visualizar e inscribirse a los que deseen._



## Algunas especificaciones del negocio
_Cada curso que se dicta en la organización, tiene una fecha de inicio y fecha fin. Los cursos se dividen en comisiones, cada comisión tiene un día, un horario y un cupo (se considera que a cada comisión se le asigna sólo un horario para un día específico de la semana). Los usuarios pueden inscribirse a una comisión de un curso siempre y cuando haya cupos disponibles y no tenga clases en una comisión de otro curso, en ese mismo día y horario._


## Funcionalidades del sistema
### Gestión de Usuarios:
* ABM Usuarios
* Logueo de cuentas de distintos tipos: usuarios del tipo Cliente y Administrador.
### Gestión de Cursos:
* ABM Cursos
    Cada curso puede dictarse en una o más comisiones:
* ABM comisiones
* Desde el perfil de administrador poder generar cursos, modificar cupos, poder ver todos los clientes de un curso.
* Listado de cursos
* Listado de comisiones por curso y cupo disponible.
* Desde el Cliente poder inscribirse a diferentes cursos, a una comisión en particular, la cual tenga cupos disponibles. Los clientes solo podrán inscribir a aquellos cursos en comisiones que tengan cupo y cuya fecha no coincida con la fecha de aquellos cursos que están realizando actualmente.
* El cliente podrá darle “like” a aquellos cursos en los que se encuentra inscripto.


## URL de acceso al sistema
* [Gestion de Cursos Web](https://java2020-gestion-de-cursos-web.herokuapp.com) - Acceso a la aplicación web.


## Credenciales

### Usuario administrador:
Mail: admin@gmail.com
Contraseña: admin

### Usuario cliente:
Mail: usuario@gmail.com
Contraseña: usuario


## Casos de uso
Dirigirse a la documentación [Documentación]https://github.com/Gabriel-Campitelli/TP_Java_2020-GestionDeCursosWeb/blob/master/Documentacion/Trabajo%20Práctico%20Integrador%20Java%20-%20Sistema%20de%20Gestión%20de%20Cursos%20-%20Campitelli%20-%20Moreyra.pdf) para detalles de los casos de uso.


## Autores ✒️
* **Sebastian Moreyra** - *Trabajo Inicial* - [Sebastián Moreyra](https://github.com/SebaMoreyra)
* **Gabriel Campitelli** - *Documentación* - [Gabriel Campitelli](https://github.com/Gabriel-Campitelli)
