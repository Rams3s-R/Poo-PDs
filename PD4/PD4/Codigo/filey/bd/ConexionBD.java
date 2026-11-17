package filey.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Capa de BD: único lugar donde se configura la conexión JDBC. */
public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/filey?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "filey_user";
    private static final String CONTRASENA = "filey123";

    private ConexionBD() { }

    public static Connection obtener() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }
}
