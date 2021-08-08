package model;


public class Contacto {
    private int idContacto;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String mensaje;

    public Contacto() {
    }

    public Contacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public Contacto(int idContacto, String nombre, String apellido, String email, String telefono, String mensaje) {
        this.idContacto = idContacto;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.mensaje = mensaje;
    }
    
    public Contacto(String nombre, String apellido, String email, String telefono, String mensaje) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.mensaje = mensaje;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Contacto{" + "idCliente=" + idContacto + ", nombre=" + 
                nombre + ", apellido=" + apellido + ", email=" + email + 
                ", telefono=" + telefono + ", mensaje=" + mensaje + '}';
    }

}
