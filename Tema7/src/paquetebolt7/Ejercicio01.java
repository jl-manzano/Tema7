package paquetebolt7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio01 {
	public static void main(String[] args) {

		/*
		 * try-catch para establecer conexión con base de datos y avisar ante posibles excepciones
		 */
		try (Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.PASSWORD)) {
			
			/*
			 * Creamos la primera consulta
			 */
			String sqlEstudiantes = "INSERT INTO Estudiantes (nombre, apellido, fecha_nacimiento, email, telefono) VALUES "
					+ "('Ana', 'González', '2006-03-15', 'ana.gonzalez@email.com', '123456789'), "
					+ "('Luis', 'Martínez', '2005-08-22', 'luis.martinez@email.com', '987654321'), "
					+ "('Carla', 'Pérez', '2006-11-02', 'carla.perez@email.com', '456789123')";

			/*
			 * Creamos la segunda consulta
			 */
			String sqlProfesores = "INSERT INTO Profesores (nombre, apellido, especialidad, email) VALUES "
					+ "('Javier', 'López', 'Matemáticas', 'javier.lopez@email.com'), "
					+ "('Laura', 'Suárez', 'Lengua', 'laura.suarez@email.com')";

			/*
			 * Creamos la tercera consulta
			 */
			String sqlCursos = "INSERT INTO Cursos (nombre, descripcion, año_escolar) VALUES "
					+ "('Matemáticas 1º', 'Curso de matemáticas básicas para primer año', 2025), "
					+ "('Lengua 1º', 'Lengua y literatura para primer año', 2025)";

			/*
			 * Mensaje de que se ha realizado la conexión con la BD
			 */
			System.out.println("La conexión se ha realizado.");

			/*
			 * Creamos una sentencia
			 */
			Statement statement = connection.createStatement();

			/*
			 * Ejecutamos la consulta 1
			 */
			statement.executeUpdate(sqlEstudiantes);
			
			/*
			 * Ejecutamos la consulta 2
			 */
			statement.executeUpdate(sqlProfesores);
			
			/*
			 * Ejecutamos la consulta 3
			 */
			statement.executeUpdate(sqlCursos);

		} catch (SQLException e) {
			System.out.println("Error con la Base de Datos: " + e.getMessage());
		}
	}
}
