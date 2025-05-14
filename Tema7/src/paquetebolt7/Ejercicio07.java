package paquetebolt7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio07 {
	public static void main(String[] args) {
		/*
		 * Creamos ujn objeto Scanner
		 */
		Scanner sc = new Scanner(System.in);
		
		/*
		 * Variable para almacenar el nombre del alumno
		 */
		String nombre;

		/*
		 * Variable para almacenar el apellido del alumno
		 */
		String apellido;

		/*
		 * Variable para almacenar la fecha de nacimiento del alumno
		 */
		String fechaNacimiento;

		/*
		 * Variable para almacenar el correo eléctronico del alumno
		 */
		String email;

		/*
		 * Variable para almacenar el teléfono del alumno
		 */
		String telefono;

		/*
		 * Pedir al usuario que introduzca su nombre
		 */
		System.out.println("Introduzca el nombre del alumno: ");
		
		/*
		 * Leer nombre del alumno
		 */
		nombre = sc.nextLine();

		/*
		 * Pedir al usuario que introduzca su apellido
		 */
		System.out.println("Introduzca el apellido del alumno: ");
		
		/*
		 * Leer apellido del alumno
		 */
		apellido = sc.nextLine();

		/*
		 * Pedir al usuario que introduzca su fecha de nacimiento
		 */
		System.out.println("Introduzca la fecha de nacimiento del alumno: ");
		
		/*
		 * Leer fecha de nacimiento del alumno
		 */
		fechaNacimiento = sc.nextLine();

		/*
		 * Pedir al usuario que introduzca su correo electrónico
		 */
		System.out.println("Introduzca el correo electrónico del alumno: ");
		
		/*
		 * Leer correo electrónico del alumno
		 */
		email = sc.nextLine();

		/*
		 * Pedir al usuario que introduzca su teléfono de contacto
		 */
		System.out.println("Introduzca el telefono del alumno: ");
		
		/*
		 * Leer teléfono del alumno
		 */
		telefono = sc.nextLine();

		/*
		 * try-catch para establecer conexión con base de datos y avisar ante posibles excepciones
		 */
		try (Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.PASSWORD)) {

			/*
			 * Creamos una consulta
			 */
			String consulta = "INSERT INTO estudiantes (nombre, apellido, fecha_nacimiento, email, telefono) VALUES"
					+ "('" + nombre + "'" + ", '" + apellido + "'" + ", '" + fechaNacimiento + "'" + ", '" + email + "'"
					+ ", '" + telefono + "')";

			/*
			 * Mensaje de que se ha realizado la conexión con la BD
			 */
			System.out.println("La conexion se ha realizado.");

			/*
			 * Creamos una sentencia
			 */
			Statement sentencia = connection.createStatement();

			/*
			 * Ejecutamos la consulta
			 */
			sentencia.executeUpdate(consulta);

		} catch (SQLException e) {
			System.out.println("Error con la base de datos " + e.getMessage());
		}

		sc.close();
	}
}
