package Ejercicio9;

// Importar librerias
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL {
	// Atributos de la clase
	private Connection conexion;
	
	// ----------------------------------------------------------------------- //
	
	// Constructores de la clase
	// Constructor por defecto
	public SQL() {
		crearBD("ejercicio9");
		crearTablas("ejercicio9");
	}
	
	// ----------------------------------------------------------------------- //
	
	// Métodos y funciones
	// Método 1: Abrir la conexión con mySQL.
	public void abrirConexion() {
		// Intentar ejecutar el código
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306", "Necrozma", "#~01UltraNecrozma04~#");
			System.out.println("Conexión establecida.");
		} // Fin TRY

		// Control de errores
		catch (SQLException | ClassNotFoundException ex) {
			System.out.println("No se ha podido establecer conexión con la base de datos.");
			System.out.println(ex);
		} // Fin CATCH
	}

	// ############################################################################################################### //
	
	// Método 2: Cerrar la conexión con mySQL
	public void cerrarConexion() {
		// Intentar ejecutar el código
		try {
			conexion.close();
			System.out.println("Se ha cerrado la conexión.");
		} // Fin TRY

		// Control de errores
		catch (SQLException ex) {
			System.out.println("Ha habido un error.");
		} // Fin CATCH
	}

	// ############################################################################################################### //
	
	// Método 3: Crear una base de datos
	public void crearBD(String nombreBD) {
		// Variables
		String consulta;

		// Intentar ejecutar el código.
		try {
			// Abrir conexión
			abrirConexion();

			// Crear la consulta
			consulta = "CREATE DATABASE " + nombreBD;

			// Crear la conexión con mySQL
			Statement st = conexion.createStatement();
			st.executeUpdate(consulta);

			// Mostrar un mensaje indicando que la base de datos se ha creado.
			System.out.println("Se ha creado la base de datos (" + nombreBD + ").");

			// Cerrar la conexión
			cerrarConexion();
		} // Fin TRY

		// Control de errores
		catch (SQLException ex) {
			System.out.println("No se ha podido crear la base de datos.");
		} // Fin CATCH
	}
	// ############################################################################################################### //
	
	// Método 4: Crear tablas
	public void crearTablas(String nombreBD) {
		// Variables
		String consulta;
		
		// Intentar ejecutar el código
		try {
			// Abrir la conexión
			abrirConexion();
			
			// Indicar la base de datos que vamos a usar
			consulta = "USE " + nombreBD + ";";
			Statement stbd = conexion.createStatement();
			stbd.executeUpdate(consulta);
			
			// Crear la tabla "facultad"
			consulta = "CREATE TABLE facultad("
					+ "codigo INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					+ "nombre VARCHAR(100) NOT NULL"
					+ ");";
			Statement st = conexion.createStatement();
			st.executeUpdate(consulta);
			System.out.println("Se ha creado la tabla (facultad)");
			
			// Crear la tabla "investigadores"
			consulta = "CREATE TABLE investigadores("
					+ "dni VARCHAR(8) NOT NULL PRIMARY KEY,"
					+ "nombre VARCHAR(255) NOT NULL,"
					+ "facultad INT UNSIGNED NOT NULL,"
					+ "CONSTRAINT FK_investigadores "
					+ "FOREIGN KEY(facultad) REFERENCES facultad(codigo)"
					+ ");";
			st.executeUpdate(consulta);
			System.out.println("Se ha creado la tabla (investigadores)");
			
			// Crear la tabla "equipos"
			consulta = "CREATE TABLE equipos("
					+ "numSerie CHAR(4) NOT NULL PRIMARY KEY,"
					+ "nombre VARCHAR(100) NOT NULL,"
					+ "facultad INT UNSIGNED NOT NULL,"
					+ "CONSTRAINT FK_equipos "
					+ "FOREIGN KEY(facultad) REFERENCES facultad(codigo)"
					+ ");";
			st.executeUpdate(consulta);
			System.out.println("Se ha creado la tabla (equipos)");
			
			// Crear la tabla "reserva"
			consulta = "CREATE TABLE reserva("
					+ "dni CHAR(8) NOT NULL,"
					+ "numSerie CHAR(8) NOT NULL,"
					+ "comienzo DATETIME NOT NULL,"
					+ "final DATETIME NOT NULL,"
					+ "PRIMARY KEY(dni, numSerie),"
					+ "CONSTRAINT FK_reserva "
					+ "FOREIGN KEY(dni) REFERENCES investigadores(dni),"
					+ "FOREIGN KEY(numSerie) REFERENCES equipos(numSerie)"
					+ ");";
			st.executeUpdate(consulta);
			System.out.println("Se ha creado la tabla (reserva)");
		
			// Cerrar la conexión 
			cerrarConexion();
		} // Fin TRY
		
		// Control de errores
		catch(SQLException ex) {
			System.out.println("No se ha podido crear algunas de las tablas.");
		} // Fin CATCH
	}
	

	// ############################################################################################################### //
	
	// Método 5 (Sobrecarga): Insertar datos en la tabla
	// Insertar datos en la tabla "facultad"
	public void insertarDatos(String nombreBD, String nombreTabla, String nombre) {
		// Variables
		String consulta;
		
		// Intentar ejecutar el código
		try {
			// Abrir la conexión
			abrirConexion();
			
			// Indicar que base de datos usar
			consulta = "USE " + nombreBD + ";";
			Statement stbd = conexion.createStatement();
			stbd.executeUpdate(consulta);
			
			// Insertar los datos en la base de datos
			consulta = "INSERT INTO " + nombreTabla + "(nombre) VALUES('" + nombre + "')";
			Statement st = conexion.createStatement();
			st.executeUpdate(consulta);
			
			// Mostrar un mensaje por pantalla que indique que los datos se han añadido
			System.out.println("Se han añadido datos en la tabla (" + nombreTabla + ").");
			
			// Cerrar la conexión
			cerrarConexion();
		} // Fin TRY
		
		catch(SQLException ex) {
			System.out.println("No se han podido añadir los datos a la tabla (" + nombreTabla + ").");
		} // Fin CATCH
	}
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ // 
	
	// Insertar datos en la tabla "investigadores"
	public void insertarDatos(String nombreBD, String nombreTabla, String dni, String nombre, int facultad) {
		// Variables
		String consulta;
		
		// Intentar ejecutar el código
		try {
			// Abrir la conexión
			abrirConexion();
			
			// Indicar que base de datos utilizar
			consulta = "USE " + nombreBD + ";";
			Statement stbd = conexion.createStatement();
			stbd.executeUpdate(consulta);
			
			// Insertar los datos en la base de datos
			consulta = "INSERT INTO " + nombreTabla + "(dni, nombre, facultad) VALUES('" + dni + "', '" + nombre +"', " + facultad +")";
			Statement st = conexion.createStatement();
			st.executeUpdate(consulta);
			
			// Mostrar un mensaje por pantalla que indique que los datos se han añadido
			System.out.println("Se han añadido datos en la tabla (" + nombreTabla + ").");
			
			// Cerrar la conexión
			cerrarConexion();
		} // Fin TRY
		
		catch(SQLException ex) {
			System.out.println("No se han podido añadir los datos a la tabla (" + nombreTabla + ").");
		} // Fin CATCH
	}
	

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ // 
	
	// Insertar datos en la tabla "equipos"
	public void insertarDatosEquipos(String nombreBD, String nombreTabla, String numSerie, String nombre, int facultad) {
		// Variables
		String consulta;
		
		// Intentar ejecutar el código
		try {
			// Abrir la conexión
			abrirConexion();
			
			// Indicar que base de datos utilizar
			consulta = "USE " + nombreBD + ";";
			Statement stbd = conexion.createStatement();
			stbd.executeUpdate(consulta);
			
			// Insertar los datos en la base de datos
			consulta = "INSERT INTO " + nombreTabla + "(numSerie, nombre, facultad) VALUES('" + numSerie + "', '" + nombre +"', " + facultad +")";
			Statement st = conexion.createStatement();
			st.executeUpdate(consulta);
			
			// Mostrar un mensaje por pantalla que indique que los datos se han añadido
			System.out.println("Se han añadido datos en la tabla (" + nombreTabla + ").");
			
			// Cerrar la conexión
			cerrarConexion();
		} // Fin TRY
		
		catch(SQLException ex) {
			System.out.println("No se han podido añadir los datos a la tabla (" + nombreTabla + ").");
		} // Fin CATCH
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ // 
	
	// Insertar datos en la tabla "reserva"
	public void insertarDatos(String nombreBD, String nombreTabla, String dni, String numSerie, String comienzo, String fin) {
		// Variables
		String consulta;
		
		// Intentar ejecutar el código
		try {
			// Abrir la conexión
			abrirConexion();
			
			// Indicar que base de datos utilizar
			consulta = "USE " + nombreBD + ";";
			Statement stbd = conexion.createStatement();
			stbd.executeUpdate(consulta);
			
			// Insertar los datos en la base de datos
			consulta = "INSERT INTO " + nombreTabla + "(dni, numSerie, comienzo, final) VALUES('" + dni + "', '" + numSerie +"', '" + comienzo +"', '" + fin + "')";
			Statement st = conexion.createStatement();
			st.executeUpdate(consulta);
			
			// Mostrar un mensaje por pantalla que indique que los datos se han añadido
			System.out.println("Se han añadido datos en la tabla (" + nombreTabla + ").");
			
			// Cerrar la conexión
			cerrarConexion();
		} // Fin TRY
		
		catch(SQLException ex) {
			System.out.println("No se han podido añadir los datos a la tabla (" + nombreTabla + ").");
		} // Fin CATCH
	}
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ // 
	
}
