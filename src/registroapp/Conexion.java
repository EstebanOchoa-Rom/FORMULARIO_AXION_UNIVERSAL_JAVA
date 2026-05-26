package registroapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // Datos reales obtenidos de tus variables de Railway
    private static final String URL = "jdbc:mysql://shuttle.proxy.rlwy.net:29221/railway";
    private static final String USER = "root";
    private static final String PASSWORD = "mItDFwOHFATfIbISgBoTdFKczbnbKmnA";

    public static Connection getConexion() {
        Connection con = null;
        try {
            // Forzar la carga del driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Error: ¡No se encontró el Driver de MySQL! Agrega el archivo JAR a la carpeta Libraries.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a Railway: " + e.getMessage());
        }
        return con;
    }
}