package paquetebolt7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio08 {
	public static void main(String[] args) {

		/*
		 * Creamos un objeto Scanner
		 */
		Scanner sc = new Scanner(System.in);

		/*
		 * Variable para almacenar el ID del alumno
		 */
		int id;

		/*
		 * Pedir al usuario que introduzca su ID
		 */
		System.out.println("Introduzca el ID del estudiante a eliminar de la Base de Datos: ");
		
		/*
		 * Leer ID del alumno
		 */
		id = sc.nextInt();

		/*
		 * try-catch para establecer conexión con base de datos y avisar ante posibles excepciones
		 */
		try (Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.PASSWORD)) {

			/*
			 * Creamos una consulta
			 */
			String consulta = "DELETE FROM estudiantes WHERE id_estudiante = " + id;

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
