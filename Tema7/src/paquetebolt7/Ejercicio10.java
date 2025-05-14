package paquetebolt7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio10 {
	public static void main(String[] args) {

		/*
		 * Crear objeto Scannew
		 */
		Scanner sc = new Scanner(System.in);

		/*
		 * Variable para almacenar el curso del alumno
		 */
		String curso;

		/*
		 * Pedir al usuario que introduzca el curso
		 */
		System.out.println("Introduzca el curso: ");
		
		/*
		 * Leer curso introducido por el usuario
		 */
		curso = sc.nextLine();

		/*
		 * try-catch para establecer conexión con base de datos y avisar ante posibles excepciones
		 */
		try (Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.PASSWORD)) {

			/*
			 * Creamos una consulta
			 */
			String consulta = "SELECT nombre, fecha_nacimiento FROM estudiantes WHERE id_estudiante IN "
					+ "(SELECT id_estudiante FROM calificaciones WHERE id_curso IN "
					+ "(SELECT id_curso FROM cursos WHERE nombre = '" + curso + "'))";

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
			ResultSet rs = sentencia.executeQuery(consulta);

			/*
			 * Mostrar en pantalla un encabezado con el nombre de los datos de los
			 */
			System.out.println("\n" + "Nombre" + "  " + "Fecha de nacimiento");

			/*
			 * Bucle while para mostrar los resultados de la consulta (1 fila a la vez). 
			 */
			while (rs.next()) {
		        /*
                 * Se obtiene el valor del nombre y la fecha de nacimiento
                 * y se muestra en consola.
                 */
				System.out.println(rs.getString(1) + "  " + rs.getString(2));
			}

		} catch (SQLException e) {
			System.out.println("Error con la base de datos " + e.getMessage());
		}

		sc.close();

	}
}
