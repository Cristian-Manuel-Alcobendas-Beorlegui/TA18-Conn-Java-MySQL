package Ejercicio9;

public class Main {

	public static void main(String[] args) {
		// 1. Crear e instanciar el objeto de la clase SQL
		SQL sql = new SQL();
		
		// 2. Insertar datos
		// Tabla "facultad"
		sql.insertarDatos("ejercicio9", "facultad", "Facultad de medicina");
		sql.insertarDatos("ejercicio9", "facultad", "Facultad de derecho");
		sql.insertarDatos("ejercicio9", "facultad", "Facultad de ciéncias");
		sql.insertarDatos("ejercicio9", "facultad", "Facultad de química");
		sql.insertarDatos("ejercicio9", "facultad", "Facultad de la información");
		
		// Tabla "investigadores"
		sql.insertarDatos("ejercicio9", "investigadores", "3023432F", "Indiana Jess", 3);
		sql.insertarDatos("ejercicio9", "investigadores", "5023013C", "Peter Anderson", 2);
		sql.insertarDatos("ejercicio9", "investigadores", "5232315H", "Bob Parker", 1);
		sql.insertarDatos("ejercicio9", "investigadores", "9281233O", "Peter Burke", 2);
		sql.insertarDatos("ejercicio9", "investigadores", "1242568A", "John Whilson", 5);
		
		// Tabla "equipos"
		sql.insertarDatosEquipos("ejercicio9", "equipos", "000A", "Salvavidas", 1);
		sql.insertarDatosEquipos("ejercicio9", "equipos", "000B", "Legal Legal Force", 2);
		sql.insertarDatosEquipos("ejercicio9", "equipos", "000C", "Solución simple", 3);
		sql.insertarDatosEquipos("ejercicio9", "equipos", "000D", "Los Alquimistas", 4);
		sql.insertarDatosEquipos("ejercicio9", "equipos", "000E", "Guias", 5);
		
		// Tabla "reserva"
		sql.insertarDatos("ejercicio9", "reserva", "3023432F", "000C", "2022-09-18 12:45:00", "2022-10-12 19:30:00");
		sql.insertarDatos("ejercicio9", "reserva", "5023013C", "000B", "2022-09-20 18:10:00", "2022-11-23 10:10:00");
		sql.insertarDatos("ejercicio9", "reserva", "5232315H", "000A", "2022-09-19 08:35:00", "2022-10-01 11:30:00");
		sql.insertarDatos("ejercicio9", "reserva", "9281233O", "000B", "2022-09-10 12:15:00", "2022-10-10 20:50:00");
		sql.insertarDatos("ejercicio9", "reserva", "1242568A", "000E", "2022-09-01 19:00:00", "2022-10-20 21:35:00");
	
	}
}
