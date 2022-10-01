package Ejercicio6;

public class Main {

	public static void main(String[] args) {
		// 1. Crear el objeto de la clase
		SQL sql = new SQL();
		
		// 2. Insertar 5 datos en las tablas "piezas", "proveedores", "suministra"
		// Insertar datos en la tabla "piezas"
		sql.insertarDatos("ejercicio6", "piezas", "CPU");
		sql.insertarDatos("ejercicio6", "piezas", "Memoria RAM");
		sql.insertarDatos("ejercicio6", "piezas", "Tarjeta gráfica");
		sql.insertarDatos("ejercicio6", "piezas", "Tarjeta de red");
		sql.insertarDatos("ejercicio6", "piezas", "Placa base");
		
		// Insertar datos en la tabla "proveedores"
		sql.insertarDatos("ejercicio6", "proveedores", "Amazon");
		sql.insertarDatos("ejercicio6", "proveedores", "PC Componentes");
		sql.insertarDatos("ejercicio6", "proveedores", "PC Box");
		sql.insertarDatos("ejercicio6", "proveedores", "BEEP");
		sql.insertarDatos("ejercicio6", "proveedores", "Neobyte");
		
		// Insertar datos en la tabla "suministra"
		sql.insertarDatos("ejercicio6", "suministra", "4", "1", 500);
		sql.insertarDatos("ejercicio6", "suministra", "2", "2", 350);
		sql.insertarDatos("ejercicio6", "suministra", "5", "3", 200);
		sql.insertarDatos("ejercicio6", "suministra", "3", "4", 150);
		sql.insertarDatos("ejercicio6", "suministra", "1", "5", 120);
		
		
		// 3. Mostrar los datos de la base de datos por pantalla
		// Mostrar los datos de la tabla "piezas"
		System.out.println("\n\nTABLA PIEZAS");
		System.out.println("----------------------");
		sql.mostrarDatos("ejercicio6", "piezas");
		
		// Mostrar los datos de la tabla "piezas"
		System.out.println("\n\nTABLA PROVEEDORES");
		System.out.println("----------------------");
		sql.mostrarDatos("ejercicio6", "proveedores");
		
		// Mostrar los datos de la tabla "piezas"
		System.out.println("\n\nTABLA SUMINISTRA");
		System.out.println("----------------------");
		sql.mostrarDatosSuministra("ejercicio6", "suministra");
		
	}
}
