package registroapp;

public class Usuario { 
    private int id; 
    private String nombre; 
    private String correo; 
    private String contrasena; 
    private String telefono; 
    private String tipoCuenta; 
    private String nombreEntidad; 
    private String fechaRegistro;

    // Constructor vacío
    public Usuario() {}

    // Constructor con parámetros
    public Usuario(int id, String nombre, String correo, String contrasena,
                   String telefono, String tipoCuenta, String nombreEntidad,
                   String fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.tipoCuenta = tipoCuenta;
        this.nombreEntidad = nombreEntidad;
        this.fechaRegistro = fechaRegistro;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String n) { this.nombre = n; }

    public String getCorreo() { return correo; }
    public void setCorreo(String c) { this.correo = c; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String c) { this.contrasena = c; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String t) { this.telefono = t; }

    public String getTipoCuenta() { return tipoCuenta; }
    public void setTipoCuenta(String t) { this.tipoCuenta = t; }

    public String getNombreEntidad() { return nombreEntidad; }
    public void setNombreEntidad(String n) { this.nombreEntidad = n; }

    public String getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(String f) { this.fechaRegistro = f; }
}