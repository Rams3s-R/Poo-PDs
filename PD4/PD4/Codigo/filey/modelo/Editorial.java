package filey.modelo;

public class Editorial {
    private final int id;
    private final String nombre;
    private final String correo;
    private final String telefono;
    private final String giro;

    public Editorial(int id, String nombre, String correo, String telefono, String giro) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.giro = giro;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }
    public String getGiro() { return giro; }

    @Override
    public String toString() {
        return String.format("%-3d | %-24s | %-27s | %-11s | %s", id, nombre, correo, telefono, giro);
    }
}
