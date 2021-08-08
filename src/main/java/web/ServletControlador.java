package web;

import datos.ContactoJBDC;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.Contacto;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String mensaje = request.getParameter("mensaje");
        
        ContactoJBDC.insertar(new Contacto(nombre, apellido, email, telefono, mensaje));
        response.sendRedirect("/FormularioContacto/respuesta.jsp");
    }
}
