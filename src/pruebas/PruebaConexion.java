package pruebas;

import java.sql.Connection;
import java.sql.SQLException;
import factory.ConnectionFactory;

public class PruebaConexion {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection con = factory.recuperaConexion();

        System.out.println("Abriendo la conexion");

        con.close();
        
        System.out.println("Cerrando la conexion");
    }

}
