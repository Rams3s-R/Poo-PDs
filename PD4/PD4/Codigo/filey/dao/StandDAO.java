package filey.dao;

import filey.bd.ConexionBD;
import filey.modelo.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StandDAO {
    private static final String SQL_BASE = "SELECT codigo, tipo, largo, ancho, estado FROM stand";

    public List<Stand> listar() throws SQLException {
        List<Stand> lista = new ArrayList<>();
        try (Connection con = ConexionBD.obtener();
             PreparedStatement ps = con.prepareStatement(SQL_BASE + " ORDER BY codigo");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapear(rs));
        }
        return lista;
    }

    public Stand buscarPorCodigo(String codigo) throws SQLException {
        try (Connection con = ConexionBD.obtener();
             PreparedStatement ps = con.prepareStatement(SQL_BASE + " WHERE codigo = ?")) {
            ps.setString(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? mapear(rs) : null;
            }
        }
    }

    /** Convierte una fila en el subtipo de Stand que corresponde. */
    private Stand mapear(ResultSet rs) throws SQLException {
        String codigo = rs.getString("codigo");
        double largo = rs.getDouble("largo");
        double ancho = rs.getDouble("ancho");
        EstadoStand estado = EstadoStand.valueOf(rs.getString("estado"));
        switch (rs.getString("tipo")) {
            case "GASTRONOMICO": return new StandGastronomico(codigo, largo, ancho, estado);
            case "ARTESANAL":    return new StandArtesanal(codigo, largo, ancho, estado);
            case "COMERCIAL":    return new StandComercial(codigo, largo, ancho, estado);
            default: throw new SQLException("Tipo de stand desconocido en la BD.");
        }
    }
}
