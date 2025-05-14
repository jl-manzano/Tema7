package paquetebolt7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio02 {
	public static void main(String[] args) {

		/*
		 * try-catch para establecer conexión con base de datos y avisar ante posibles excepciones
		 */
		try (Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.PASSWORD)) {
			
			/*
			 * Creamos la primera consulta
			 */
			String consulta1 = "UPDATE estudiantes SET nombre = 'Ana López' WHERE nombre = 'Ana'";
			
			/*
			 * Creamos la segunda consulta
			 */
			String consulta2 = "UPDATE profesores SET nombre = 'Javier Travado' WHERE nombre = 'Ana'";
			
			/*
			 * Creamos la tercera consulta
			 */
			String consulta3 = "UPDATE cursos SET nombre = 'Matemáticas 2º' WHERE nombre = 'Matemáticas 1º'";

			/*
			 * Mensaje de que se ha realizado la conexión con la BD
			 */
			System.out.println("La conexión se ha realizado.");

			/**
			 * Creamos una sentencia
			 */
			Statement statement = connection.createStatement();

			/*
			 * Ejecutamos la consulta 1
			 */
			statement.executeUpdate(consulta1);
			
			/*
			 * Ejecutamos la consulta 2
			 */
			statement.executeUpdate(consulta2);
			
			/*
			 * Ejecutamos la consulta 3
			 */
			statement.executeUpdate(consulta3);

		} catch (SQLException e) {
			System.out.println("Error con la Base de Datos: " + e.getMessage());
		}
	}
}
