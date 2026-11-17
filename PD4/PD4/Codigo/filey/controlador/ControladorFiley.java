package filey.controlador;

import filey.bd.ConexionBD;
import filey.dao.*;
import filey.vista.VistaConsola;
import java.sql.Connection;
import java.sql.SQLException;

/** Capa de controlador: pide los datos a los DAO y se los entrega a la vista. */
public class ControladorFiley {
    private final StandDAO standDAO = new StandDAO();
    private final EditorialDAO editorialDAO = new EditorialDAO();
    private final ReservaDAO reservaDAO = new ReservaDAO(standDAO, editorialDAO);
    private final VistaConsola vista;

    public ControladorFiley(VistaConsola vista) { this.vista = vista; }

    public void iniciar() {
        try (Connection con = ConexionBD.obtener()) {
            vista.mostrarMensaje("Conexión exitosa a la BD: " + con.getCatalog());
            vista.mostrarStands(standDAO.listar());
            vista.mostrarEditoriales(editorialDAO.listar());
            vista.mostrarReservas(reservaDAO.listar());
        } catch (SQLException e) {
            vista.mostrarError("No se pudo usar la BD: " + e.getMessage());
        }
    }
}
