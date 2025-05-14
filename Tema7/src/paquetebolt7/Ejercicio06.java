package paquetebolt7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio06 {
	public static void main(String[] args) {

		/*
		 * try-catch para establecer conexión con base de datos y avisar ante posibles excepciones
		 */
		try (Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.PASSWORD)) {

			/*
			 * Creamos una consulta
			 */
			String consulta = "UPDATE calificaciones SET nota = nota + 1 WHERE id_estudiante = 1 AND id_curso = 1";

			/*
			 * Mensaje de que se ha realizado la conexión con la BD
			 */
			System.out.println("La conexion se ha realizado.");
			
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
