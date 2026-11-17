package filey.servicios;

import filey.modelo.Stand;
import filey.modelo.Zona;
import java.util.ArrayList;
import java.util.List;

public class GestorStands {
    private final List<Stand> stands = new ArrayList<>();

    public void agregar(Stand stand) { stands.add(stand); }

    public List<Stand> verMapa() { return new ArrayList<>(stands); }

    public Stand buscarPorCodigo(String codigo) {
        for (Stand s : stands) {
            if (s.getCodigo().equalsIgnoreCase(codigo)) return s;
        }
        throw new IllegalArgumentException("No existe el stand " + codigo);
    }

    public List<Stand> listarDisponibles() {
        List<Stand> resultado = new ArrayList<>();
        for (Stand s : stands) {
            if (s.estaDisponible()) resultado.add(s);
        }
        return resultado;
    }

    public List<Stand> listarPorZona(Zona zona) {
        List<Stand> resultado = new ArrayList<>();
        for (Stand s : stands) {
            if (s.getZona() == zona) resultado.add(s);
        }
        return resultado;
    }
}
