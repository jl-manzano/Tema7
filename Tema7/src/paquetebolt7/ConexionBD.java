package paquetebolt7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.PASSWORD)) {

			System.out.println("La conexión se ha realizado.");

		} catch (SQLException e) {

			System.out.println("Error al establecer la conexión con la base de datos: " + e);
		}
	}
}
