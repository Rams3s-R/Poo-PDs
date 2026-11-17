package filey.dao;

import filey.bd.ConexionBD;
import filey.modelo.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {
    private final StandDAO standDAO;
    private final EditorialDAO editorialDAO;

    public ReservaDAO(StandDAO standDAO, EditorialDAO editorialDAO) {
        this.standDAO = standDAO;
        this.editorialDAO = editorialDAO;
    }

    public List<Reserva> listar() throws SQLException {
        List<Reserva> lista = new ArrayList<>();
        String sql = "SELECT id_reserva, codigo_stand, id_editorial, fecha, estado FROM reserva ORDER BY id_reserva";
        try (Connection con = ConexionBD.obtener();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Stand stand = standDAO.buscarPorCodigo(rs.getString("codigo_stand"));
                Editorial editorial = editorialDAO.buscarPorId(rs.getInt("id_editorial"));
                lista.add(new Reserva(rs.getInt("id_reserva"), stand, editorial,
                        rs.getDate("fecha").toLocalDate(),
                        EstadoReserva.valueOf(rs.getString("estado"))));
            }
        }
        return lista;
    }
}
