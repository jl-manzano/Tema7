package paquetebolt7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio04 {
	public static void main(String[] args) {

		/*
		 * try-catch para establecer conexión con base de datos y avisar ante posibles excepciones
		 */
		try (Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.PASSWORD)) {
			
			/*
			 * Creamos una consulta
			 */
			String consulta = "INSERT INTO CURSOS(nombre, descripcion, año_escolar) "
					+ "VALUES ('Historia 1º', 'Curso de Historia para primer año', '2025')";

			consulta += ",('Biología 1º', 'Curso de Biología para primer año', '2025')";
			consulta += ",('Educación Física 1º', 'Curso de Educación Física para primer año', '2025')";
			consulta += ",('Música 1º', 'Curso de Música para primer año', '2025')";
			consulta += ",('Tecnología 1º', 'Curso de Tecnología para primer año', '2025')";

			/*
			 * Mensaje de que se ha realizado la conexión con la BD
			 */
			System.out.println("La conexión se ha realizado.");

			/**
			 * Creamos una sentencia
			 */
			Statement statement = connection.createStatement();

			/*
			 * Ejecutamos la consulta
			 */
			statement.executeUpdate(consulta);

		} catch (SQLException e) {
			System.out.println("Error con la Base de Datos: " + e.getMessage());
		}
	}
}
