Proyecto JDBC con MySQL y Derby
Requisitos previos
Antes de comenzar, asegúrate de tener instalados los siguientes componentes:

Docker
Java JDK
Apache Derby (si trabajas con Derby)
Configuración de la Base de Datos
Uso de MySQL con Docker
Para trabajar con MySQL, es necesario ejecutar el archivo docker-compose.yml, que levantará un contenedor Docker con una base de datos MySQL.

Pasos para levantar el contenedor de MySQL:
Asegúrate de tener Docker instalado.

Ejecuta el siguiente comando en la raíz del proyecto para iniciar el contenedor:

bash
Copiar código
docker-compose up
Esto levantará un contenedor con MySQL corriendo en el puerto 3307, listo para ser utilizado.

Uso de Derby
Para trabajar con Derby, no es necesario ejecutar un contenedor. La base de datos se creará automáticamente al ejecutar el programa en la configuración para Derby. Derby se ejecutará en el puerto 1527 en localhost.

Pasos para configurar Derby:
Al ejecutar el programa con la configuración de Derby en el archivo Main.java, la base de datos se creará automáticamente.

Configuración en la clase Main.java
El código en la clase Main está diseñado para usar una sola base de datos a la vez. Por defecto, está configurado para trabajar con MySQL. Si deseas usar Derby, debes modificar la configuración manualmente.

Cambiar a Derby
Para usar Derby, debes descomentar y configurar la siguiente información en Main.java:

URL de conexión para Derby:

java
Copiar código
String url = "jdbc:derby://localhost:1527/arqui_db;create=true";
Usuario y contraseña (en este caso, no es necesario establecerlos para Derby, puedes dejarlos vacíos):

java
Copiar código
String usuario = "";
String contrasena = "";
Tipo de base de datos: Cambia a "derby" para indicar que estás utilizando Derby:

java
Copiar código
String database = "derby";
DAO para Derby: Cambia el DAO para que utilice Derby en lugar de MySQL:

java
Copiar código
DAOFactory dao = new DerbyDAOFactory(conexion);
Volver a MySQL
Si deseas volver a usar MySQL, realiza lo siguiente:

Descomenta y configura nuevamente la información de MySQL en Main.java:

java
Copiar código
String url = "jdbc:mysql://localhost:3307/test_db";
String usuario = "root";
String contrasena = "root";
String database = "mysql";
Cambia el DAO para que utilice MySQL:

java
Copiar código
DAOFactory dao = new MySQLDAOFactory(conexion);
Archivos CSV
Los archivos .csv que contienen los datos de prueba se encuentran en el directorio util/CSVs. El programa utiliza una ruta relativa para acceder a ellos, por lo que no es necesario mover los archivos.

Cómo cargar los datos:
Dentro del archivo Main.java, hay una sección que permite cargar los datos desde los archivos .csv. Esta sección está comentada por defecto y debe ejecutarse una sola vez.

Para ejecutar esta sección, descomenta las siguientes líneas en Main.java:

java
Copiar código
cargador.readProductos();
cargador.readClientes();
cargador.readFacturas();
cargador.readFacturasProductos();
Esto cargará los datos en la base de datos desde los archivos CSV.

Notas adicionales
Asegúrate de utilizar una sola base de datos a la vez. Si usas Derby, comenta las configuraciones de MySQL y viceversa.
Solo descomenta la carga de datos desde los .csv en la primera ejecución del programa.
