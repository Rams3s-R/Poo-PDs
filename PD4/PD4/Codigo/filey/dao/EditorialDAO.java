package filey.dao;

import filey.bd.ConexionBD;
import filey.modelo.Editorial;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EditorialDAO {
    private static final String SQL_BASE = "SELECT id_editorial, nombre, correo, telefono, giro FROM editorial";

    public List<Editorial> listar() throws SQLException {
        List<Editorial> lista = new ArrayList<>();
        try (Connection con = ConexionBD.obtener();
             PreparedStatement ps = con.prepareStatement(SQL_BASE + " ORDER BY id_editorial");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapear(rs));
        }
        return lista;
    }

    public Editorial buscarPorId(int id) throws SQLException {
        try (Connection con = ConexionBD.obtener();
             PreparedStatement ps = con.prepareStatement(SQL_BASE + " WHERE id_editorial = ?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? mapear(rs) : null;
            }
        }
    }

    private Editorial mapear(ResultSet rs) throws SQLException {
        return new Editorial(rs.getInt("id_editorial"), rs.getString("nombre"),
                rs.getString("correo"), rs.getString("telefono"), rs.getString("giro"));
    }
}
