package test;

import datos.ContactoJBDC;
import java.util.List;
import model.Contacto;


public class Main {
    public static void main(String[] args) {
        //insert();
        //leer();
        //eliminar();  
    }
    
    public static void insert() {
        Contacto contacto = new Contacto("Juan", "Ingar", "ingar@mail.com", "5569-5452", "Probando...");
        ContactoJBDC.insertar(contacto);
    }
    
    public static void leer() {
        List<Contacto> contactos = ContactoJBDC.listar();
        for (Contacto contacto : contactos) {
            System.out.println("contacto = " + contacto);
        }
    }
    
    public static void eliminar() {
        ContactoJBDC.eliminar(new Contacto(9));
    }
}
