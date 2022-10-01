package Ejercicio6;

// Importar librerias
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL {
	// Atributos de la clase
	private Connection conexion;
	
	// -------------------------------------------------------------------------- //
	
	// Constructores de la clase
	// Constructor por defecto
	public SQL() {
		abrirConexion();
		crearBD("ejercicio6");
		crearTablas("ejercicio6", "piezas", "proveedores", "suministra");
	}
	
	// -------------------------------------------------------------------------- //
	
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
	
	
	// Método 4: Crear una tabla
	public void crearTablas(String nombreBD, String nombreTabla1, String nombreTabla2, String nombreTabla3) {
		// Variables
		String consulta;
		
		// Intentar ejecutar el código
		try {
			// Abrir la conexión
			abrirConexion();
			
			// Indicar que base de datos utilizar.
			consulta = "USE " + nombreBD + ";";
			Statement stbd = conexion.createStatement();
			stbd.executeUpdate(consulta);
			
			// Crear y ejecutar la consulta que creará la tabla "piezas"
			consulta = "CREATE TABLE " + nombreTabla1 + "("
					+ "id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					+ "nombre VARCHAR(100) NOT NULL"
					+ ");";
			Statement st = conexion.createStatement();
			st.executeUpdate(consulta);
			System.out.println("Se ha creado la tabla (" + nombreTabla1 + ").");
			
			// Crear y ejecutar la consulta que creará la tabla "proveedores"
			consulta = "CREATE TABLE " + nombreTabla2 + "("
					+ "id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					+ "nombre VARCHAR(100) NOT NULL"
					+ ");";
			st.executeUpdate(consulta);
			System.out.println("Se ha creado la tabla (" + nombreTabla2 + ").");
			
			// Crear y ejecutar la consulta que creará la tabla "suministra"
			consulta = "CREATE TABLE " + nombreTabla3 + "("
					+ "idPieza INT UNSIGNED NOT NULL,"
					+ "idProveedor INT UNSIGNED NOT NULL,"
					+ "precio INT UNSIGNED NOT NULL,"
					+ "PRIMARY KEY(idPieza, idProveedor),"
					+ "CONSTRAINT FK_Suministra"
					+ " FOREIGN KEY (idPieza) REFERENCES piezas(id),"
					+ " FOREIGN KEY (idProveedor) REFERENCES proveedores(id)"
					+ ");";
			st.executeUpdate(consulta);
			System.out.println("Se ha creado la tabla (" + nombreTabla3 + ").");
			
			// Cerrar la conexión
			cerrarConexion();
		}
		
		// Control de errores
		catch(SQLException ex) {
			System.out.println("Ha habido un error, es posible que alguna de las tablas no haya sido creada.");
		} // Fin CATCH
	}
	
	// Método 4: Añadir datos a la tabla
	// Añadir datos para la tabla "piezas" y la tabla "proveedores"
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
		
		// Control de errores
		catch(SQLException ex) {
			System.out.println("No se ha podido añadir los datos en la tabla (" + nombreTabla + ").");
		}
	}
	
	// Añadir datos para la tabla "suministra"
	public void insertarDatos(String nombreBD, String nombreTabla, String idPieza, String idProveedor, int precio) {
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
			consulta = "INSERT INTO " + nombreTabla + "(idPieza, idProveedor, precio) VALUES(" + idPieza + ", " + idProveedor + ", " + precio + ");";
			Statement st = conexion.createStatement();
			st.executeUpdate(consulta);
			
			// Mostrar un mensaje por pantalla que indique que los datos se han añadido
			System.out.println("Se han añadido datos en la tabla (" + nombreTabla + ").");
			
			// Cerrar la conexión
			cerrarConexion();
		}
		
		// Control de errores
		catch(SQLException ex) {
			System.out.println("No se ha podido añadir los datos en la tabla (" + nombreTabla + ").");
		}
	}
	
	// Método 5: Mostrar los datos de la tabla
	public void mostrarDatos(String nombreBD, String nombreTabla) {
		// Variables
		String consulta;

		// Intentar ejecutar código
		try {
			// Abrir conexión
			abrirConexion();

			// Indicar que base de datos hay que usar
			consulta = "USE " + nombreBD + ";";
			Statement stbd = conexion.createStatement();
			stbd.executeUpdate(consulta);

			// Consulta para coneguir todos los resultados de la tabla
			consulta = "SELECT * FROM " + nombreTabla + ";";

			// Guardar los resultados
			Statement st = conexion.createStatement();
			java.sql.ResultSet listaResultados;
			listaResultados = st.executeQuery(consulta);

			// Mostrar los datos de la consulta por pantalla
			System.out.println("ID " + nombreTabla.toUpperCase() + " | Nombre");
			while (listaResultados.next()) {
				System.out.println(listaResultados.getString("id") + " | " + listaResultados.getString("nombre"));
			}

			// Cerrar conexión
			cerrarConexion();
		} // Fin TRY

		// Control de errores
		catch (SQLException ex) {
			System.out.println("No se ha podido mostrar los datos de la tabla (" + nombreTabla + ").");
		}
	}
	
	// Mostrar los datos de la tabla "suminitra"
	public void mostrarDatosSuministra(String nombreBD, String nombreTabla) {
		// Variables
		String consulta;

		// Intentar ejecutar código
		try {
			// Abrir conexión
			abrirConexion();

			// Indicar que base de datos hay que usar
			consulta = "USE " + nombreBD + ";";
			Statement stbd = conexion.createStatement();
			stbd.executeUpdate(consulta);

			// Consulta para coneguir todos los resultados de la tabla
			consulta = "SELECT * FROM " + nombreTabla + ";";

			// Guardar los resultados
			Statement st = conexion.createStatement();
			java.sql.ResultSet listaResultados;
			listaResultados = st.executeQuery(consulta);

			// Mostrar los datos de la consulta por pantalla
			System.out.println("ID Pieza | ID Proveedor | Precio");
			while (listaResultados.next()) {
				System.out.println(listaResultados.getString("idPieza") + " | " + listaResultados.getString("idProveedor") + " | " + listaResultados.getString("precio") + " €");
			}

			// Cerrar conexión
			cerrarConexion();
		} // Fin TRY

		// Control de errores
		catch (SQLException ex) {
			System.out.println("No se ha podido mostrar los datos de la tabla (" + nombreTabla + ").");
		}
	}
	
}
