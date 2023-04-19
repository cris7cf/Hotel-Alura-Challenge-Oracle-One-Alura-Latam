package controller;

import factory.ConnectionFactory;
import java.time.LocalDate;
import java.util.List;
import dao.ReservaDAO;
import modelo.Reserva;

public class ReservaController {

	private ReservaDAO reservaDao;

	public ReservaController() {
		ConnectionFactory factory = new ConnectionFactory();
        this.reservaDao = new ReservaDAO(factory.recuperaConexion());
	}

	public void guardar(Reserva reserva) {
		this.reservaDao.guardar(reserva);
	}
	
	public List<Reserva> mostrar() {
		return this.reservaDao.mostrar();
	}
	
	public List<Reserva> buscar(String id) {
		return this.reservaDao.buscarId(id);
	}
	
	public void actualizarReserva(LocalDate fechaEntrada, LocalDate fechaSalida, String valor, String formaPago, Integer id) {
        this.reservaDao.Actualizar(fechaEntrada, fechaSalida, valor, formaPago, id);
    }
	
	public void Eliminar(Integer id) {
		this.reservaDao.Eliminar(id);
	}

}
