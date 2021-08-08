package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Contacto;

public class ContactoJBDC {

    private static final String SQL_SELECT = "SELECT id_contacto, Nombre, Apellido, "
            + "Email, Telefono, Mensaje FROM contacto";
    private static final String SQL_INSERT = "INSERT INTO contacto(Nombre, Apellido, "
            + "Email, Telefono, Mensaje) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM contacto WHERE id_contacto = ?";

    public static void insertar(Contacto contacto) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_INSERT);
            // pasamos los parametros por el numero de la consulta
            // en la consulta son 5 parametros
            stmt.setString(1, contacto.getNombre());
            stmt.setString(2, contacto.getApellido());
            stmt.setString(3, contacto.getEmail());
            stmt.setString(4, contacto.getTelefono());
            stmt.setString(5, contacto.getMensaje());
            System.out.println("Registros insertados: " + stmt.executeUpdate());
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            // ceramos variables de conexion
            Conexion.close(stmt);
            Conexion.close(conn);
        }
    }

    public static List<Contacto> listar() {
        // declaramos variables de conexion
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Contacto> contactos = new ArrayList<>();
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idContacto = rs.getInt("id_contacto");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                String email = rs.getString("Email");
                String telefono = rs.getString("Telefono");
                String mensaje = rs.getString("Mensaje");
                contactos.add(new Contacto(idContacto, nombre, apellido, email, telefono, mensaje));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            // ceramos variables de conexion
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return contactos;
    }
    
    public static void eliminar(Contacto contacto) {
        // declaramos variables de conexion
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_DELETE);
            // pasamos los parametros por el numero de la consulta
            stmt.setDouble(1, contacto.getIdContacto()); 
            System.out.println("Registros eliminados: " + stmt.executeUpdate());
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            // ceramos variables de conexion
            Conexion.close(stmt);
            Conexion.close(conn);
        }
    }
}
