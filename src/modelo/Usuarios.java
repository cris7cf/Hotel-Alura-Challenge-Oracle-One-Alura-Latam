package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConnectionFactory;

public class Usuarios {
	
	private String usuario;
	private String contraseña;
	
	public Usuarios(String usuario, String contraseña) {
		this.usuario = usuario;
		this.contraseña = contraseña;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public static boolean validarUsuario(String usuario, String contraseña) {
		ConnectionFactory factory = new ConnectionFactory();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
        	con = factory.recuperaConexion();
			statement = con.prepareStatement("SELECT * FROM usuarios WHERE usuario = ? AND contraseña = ?");
        	statement.setString(1, usuario);
        	statement.setString(2, contraseña);
        	resultSet = statement.executeQuery();
        	return resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
	
}
