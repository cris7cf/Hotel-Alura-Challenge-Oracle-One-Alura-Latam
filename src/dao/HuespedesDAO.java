package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.Huespedes;
import modelo.Reserva;

public class HuespedesDAO {
	
	private Connection con;

    public HuespedesDAO(Connection con) {
        this.con = con;
    }
    
    public void guardar(Huespedes huespedes) {
    	try {
    		String sql = "INSERT INTO huespedes(nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id_reserva)"
    				+ "VALUES(?, ?, ?, ?, ?, ?)";
    		final PreparedStatement statement = con
                    .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    		try(statement) {
    			statement.setString(1, huespedes.getNombre());
    			statement.setString(2, huespedes.getApellido());
    			statement.setObject(3, huespedes.getFechaNacimiento());
    			statement.setString(4, huespedes.getNacionalidad());
    			statement.setString(5, huespedes.getTelefono());
    			statement.setInt(6, huespedes.getIdReserva());
    			
    			//statement.executeUpdate();
    			statement.execute();
    			
    			final ResultSet resultSet = statement.getGeneratedKeys();
    			
    			try (resultSet) {
    				while (resultSet.next()) {
    					huespedes.setId(resultSet.getInt(1));
                    }
    			}
    		}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
    }
    
    public List<Huespedes> mostrar() {
    	List<Huespedes> huespedes = new ArrayList<Huespedes>();
    	
    	try {
            String sql = "SELECT id, nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id_reserva FROM huespedes";
            
            //System.out.println(sql);
            
            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                statement.execute();
                tranformarResultado(huespedes, statement);
                }
            return huespedes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
   public int ActualizarH(String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad,
			String telefono, Integer idReserva, Integer id) {
        try {
          
			String sql = "UPDATE huespedes SET nombre = ?, apellido = ?, fecha_nacimiento = ?, nacionalidad = ?, " 
			+ "telefono = ?, id_reserva = ? WHERE id = ?";
        	
        	final PreparedStatement statement = con.prepareStatement(sql);

            try (statement) {
            	statement.setString(1, nombre);
            	statement.setString(2, apellido);
                statement.setObject(3, java.sql.Date.valueOf(fechaNacimiento));
            	//statement.setObject(3, fechaNacimiento);
                statement.setString(4, nacionalidad);
                statement.setString(5, telefono);
                statement.setInt(6, idReserva);
                statement.setInt(7, id);
                statement.execute();
                System.out.println("entrando a la base");
                int updateCount = statement.getUpdateCount();

                return updateCount;
                
            } 
		} catch (SQLException e) {
			throw new RuntimeException("Animal" + e.getMessage() +e);
		}
    }
    
    public void Eliminar(Integer id) {
		try {
			String sql = "DELETE FROM huespedes WHERE id = ?";
			PreparedStatement statement = con.prepareStatement(sql);
        	try (statement) {
        		//java.sql.Statement state = con.createStatement();
        		//state.execute("SET FOREIGN_KEY_CHECKS=0");
        		
                statement.setInt(1, id);
                statement.execute();
                //state.execute("SET FOREIGN_KEY_CHECKS=1");
                System.out.println("entrando a la base");
        		
			} 
		} catch (SQLException e) {
			throw new RuntimeException("Animal" + e.getMessage() +e);
		}
	}
    
    private void tranformarResultado(List<Huespedes> huespedes, PreparedStatement statement) throws SQLException {
    	final ResultSet resultSet = statement.executeQuery();

        try (resultSet) {
            while (resultSet.next()) {
            	int id = resultSet.getInt("id");
            	String nombre = resultSet.getString("nombre");
            	String apellido = resultSet.getString("apellido");
            	LocalDate fechaNacimiento = resultSet.getDate("fecha_nacimiento").toLocalDate().plusDays(0);
            	String nacionalidad = resultSet.getString("nacionalidad");
            	String telefono = resultSet.getString("telefono");
            	int idReserva = resultSet.getInt("id_reserva");
            	
            	Huespedes producto = new Huespedes(id, nombre, apellido, fechaNacimiento, nacionalidad, telefono, idReserva);
            	huespedes.add(producto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e); 
        }
    }
    
    public List<Huespedes> buscarId(String id) {
    	List<Huespedes> huespedes = new ArrayList<Huespedes>();
    	
    	try {
            String sql = "SELECT id, nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id_reserva FROM huespedes WHERE id = ?";
            
            //System.out.println(sql);
            
            final PreparedStatement statement = con.prepareStatement(sql);

            try (statement) {
            	statement.setString(1, id);
                statement.execute();
                tranformarResultado(huespedes, statement);
                }
            return huespedes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
