package controller;

import java.time.LocalDate;
import java.util.List;

import dao.HuespedesDAO;
import factory.ConnectionFactory;
import modelo.Huespedes;
import modelo.Reserva;

public class HuespedesController {
	
	private HuespedesDAO huespedesDao;

	public HuespedesController() {
		ConnectionFactory factory = new ConnectionFactory();
        this.huespedesDao = new HuespedesDAO(factory.recuperaConexion());
	}
	
	public void guardar(Huespedes huespedes) {
		this.huespedesDao.guardar(huespedes);
	}
	
	public List<Huespedes> mostrarHuesped() {
		return this.huespedesDao.mostrar();
	}
	
	public List<Huespedes> buscarHuesped(String id) {
		return this.huespedesDao.buscarId(id);
	}
	
	public void actualizarH(String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad,
			String telefono, Integer idReserva, Integer id) {
        this.huespedesDao.ActualizarH(nombre, apellido, fechaNacimiento, nacionalidad, telefono, idReserva, id);
    }
	
	/*public void Eliminar(Integer id) {
		this.huespedesDao.Eliminar(id);
	}*/
	
	public void Eliminar(Integer idReserva) {
		this.huespedesDao.Eliminar(idReserva);
	}

}
