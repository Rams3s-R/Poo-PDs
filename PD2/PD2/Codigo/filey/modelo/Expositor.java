package filey.modelo;

public class Expositor {
    private final String nombre;
    private final String correo;
    private final String telefono;
    private final String giro;

    public Expositor(String nombre, String correo, String telefono, String giro) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.giro = giro;
    }

    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }
    public String getGiro() { return giro; }
}
