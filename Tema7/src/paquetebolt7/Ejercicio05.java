package paquetebolt7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio05 {
	public static void main(String[] args) {

		/*
		 * try-catch para establecer conexión con base de datos y avisar ante posibles excepciones
		 */
		try (Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.PASSWORD)) {
			
			/**
			 * Creamos una consulta
			 */
			String consulta = "INSERT INTO Calificaciones (id_estudiante, id_curso, id_profesor, tipo_evaluacion, nota, fecha_evaluacion) "
					+ "VALUES (1, 3, 1, 'Examen', 8.0, '2025-03-20')";
			consulta += ",(2, 3, 1, 'Trabajo', 7.5, '2025-03-21')";
			consulta += ",(3, 3, 1, 'Participación', 9.0, '2025-03-22')";
			consulta += ",(1, 4, 1, 'Examen', 8.5, '2025-03-23')";
			consulta += ",(2, 4, 1, 'Examen', 7.0, '2025-03-24')";
			consulta += ",(3, 4, 1, 'Trabajo', 9.2, '2025-03-25')";
			consulta += ",(1, 5, 1, 'Participación', 10.0, '2025-03-26')";
			consulta += ",(2, 6, 1, 'Trabajo', 8.7, '2025-03-27')";
			consulta += ",(3, 7, 1, 'Examen', 7.8, '2025-03-28')";

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
