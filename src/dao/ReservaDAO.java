package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
//import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.Reserva;

public class ReservaDAO {
	
	private Connection con;

    public ReservaDAO(Connection con) {
        this.con = con;
    }
    
    public void guardar(Reserva reserva) {
    	try {
    		String sql = "INSERT INTO reservas(fecha_entrada, fecha_salida, valor, forma_de_pago)"
    				+ "VALUES(?, ?, ?, ?)";
    		final PreparedStatement statement = con
                    .prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
    		try(statement) {
    			statement.setObject(1, reserva.getFechaEntrada());
    			statement.setObject(2, reserva.getFechaSalida());
    			statement.setString(3, reserva.getValor());
    			statement.setString(4, reserva.getFormaPago());
    			
    			statement.executeUpdate();
    			
    			final ResultSet resultSet = statement.getGeneratedKeys();
    			
    			try (resultSet) {
    				while (resultSet.next()) {
                        reserva.setId(resultSet.getInt(1));
                        // commit
                        //System.out.println(String.format("Fue guardada la reserva: %s", reserva));
                    }
    			}
    		}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
    }
    
    public List<Reserva> mostrar() {
    	List<Reserva> reservas = new ArrayList<Reserva>();
    	
    	try {
            String sql = "SELECT id, fecha_entrada, fecha_salida, valor, forma_de_pago FROM reservas";
            
            //System.out.println(sql);
            
            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                statement.execute();
                tranformarResultado(reservas, statement);
                }
            return reservas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Reserva> buscarId(String id) {
    	List<Reserva> reservas = new ArrayList<Reserva>();
    	
    	try {
            String sql = "SELECT id, fecha_entrada, fecha_salida, valor, forma_de_pago FROM reservas WHERE id = ?";
            
            //System.out.println(sql);
            
            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
            	statement.setString(1, id);
                statement.execute();
                tranformarResultado(reservas, statement);
                }
            return reservas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
         //int
    public void Actualizar(LocalDate fechaEntrada, LocalDate fechaSalida, String valor, String formaPago, Integer id) {
        try {
          
          	String sql = "UPDATE reservas SET "
                    + " fecha_entrada = ?, "
                    + " fecha_salida = ?,"
                    + " valor = ?,"
                    + " forma_de_pago = ?"
                    + " WHERE id = ?";
        	
        	final PreparedStatement statement = con.prepareStatement(sql);

            try (statement) {
                statement.setObject(1, java.sql.Date.valueOf(fechaEntrada));
                statement.setObject(2, java.sql.Date.valueOf(fechaSalida));
                statement.setString(3, valor);
                statement.setString(4, formaPago);
                statement.setInt(5, id);
                statement.execute();
                System.out.println("entrando a la base");
            } 
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
    }
    
    public void Eliminar(Integer id) {
		try {
			String sql = "DELETE FROM reservas WHERE id = ?";
        	//try (statement) {
        		java.sql.Statement state = con.createStatement();
        		state.execute("SET FOREIGN_KEY_CHECKS=0");
        		PreparedStatement statement = con.prepareStatement(sql);
                statement.setInt(1, id);
                statement.execute();
                state.execute("SET FOREIGN_KEY_CHECKS=1");
                System.out.println("entrando a la base");
        		
			//} 
		} catch (SQLException e) {
			throw new RuntimeException("Animal" + e.getMessage() +e);
		}
	}
    
    private void tranformarResultado(List<Reserva> reservas, PreparedStatement statement) throws SQLException {
    	final ResultSet resultSet = statement.getResultSet();

        try (resultSet) {
            while (resultSet.next()) {
            	int id = resultSet.getInt("id");
            	LocalDate fechaEntrada = resultSet.getDate("fecha_entrada").toLocalDate().plusDays(0);
            	LocalDate fechaSalida = resultSet.getDate("fecha_salida").toLocalDate().plusDays(0);
            	String valor = resultSet.getString("valor");
            	String formaPago = resultSet.getString("forma_de_pago");
            	
            	Reserva producto = new Reserva(id, fechaEntrada, fechaSalida, valor, formaPago);
            	reservas.add(producto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e); 
        }
    }
    


}
