package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Consultorio implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nombreConsultorio;
	private String direccion;
	private ArrayList<Long> telefonoContactoDoctores = new ArrayList<Long>();
	private HashMap<String, Cliente> consultas = new HashMap<>();
	private int nit;
	private ArrayList<String> colaCitas = new ArrayList<String>();
	
	public Consultorio(String nombreConsultorioP, String direccionP, ArrayList<Long> telefonoContactoDoctoresP, HashMap<String, Cliente> consultasP, int nitP) {
		super();
		this.nombreConsultorio = nombreConsultorioP;
		this.direccion = direccionP;
		this.telefonoContactoDoctores = telefonoContactoDoctoresP;
		this.consultas = consultasP;
		this.nit = nitP;
		this.colaCitas = new ArrayList<String>();
	}

	public String getNombreConsultorio() {
		return nombreConsultorio;
	}

	public void setNombreConsultorio(String nombreConsultorio) {
		this.nombreConsultorio = nombreConsultorio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public ArrayList<Long> getTelefonoContactoDoctores() {
		return telefonoContactoDoctores;
	}

	public void setTelefonoContactoDoctores(ArrayList<Long> telefonoContactoDoctores) {
		this.telefonoContactoDoctores = telefonoContactoDoctores;
	}

	public int getNit() {
		return nit;
	}

	public void setNit(int nit) {
		this.nit = nit;
	}

	public HashMap<String, Cliente> getConsultas() {
		return consultas;
	}

	public void setConsultas(HashMap<String, Cliente> consultas) {
		this.consultas = consultas;
	}

	public ArrayList<String> getColaCitas() {
		if (colaCitas == null) {
			colaCitas = new ArrayList<String>();
		}
		return colaCitas;
	}

	public void setColaCitas(ArrayList<String> colaCitas) {
		this.colaCitas = colaCitas;
	}

	// Sistema de cola elegante con prioridad de atención
	public void encolarCita(String codigoCita, Cliente cliente) {
		if (colaCitas == null) {
			colaCitas = new ArrayList<String>();
		}
		if (colaCitas.contains(codigoCita)) {
			return;
		}

		boolean esUrgente = false;
		if (cliente != null && cliente.getPrioridadAtencion() != null && cliente.getPrioridadAtencion().length > 0) {
			esUrgente = "Urgente".equalsIgnoreCase(cliente.getPrioridadAtencion()[0]);
		}

		if (esUrgente) {
			// Ubicar de manera prioritaria al frente (después de las urgencias previas)
			int indiceInsercion = 0;
			for (String cod : colaCitas) {
				Cliente c = consultas.get(cod);
				if (c != null && c.getPrioridadAtencion() != null && c.getPrioridadAtencion().length > 0
						&& "Urgente".equalsIgnoreCase(c.getPrioridadAtencion()[0])) {
					indiceInsercion++;
				} else {
					break;
				}
			}
			colaCitas.add(indiceInsercion, codigoCita);
		} else {
			// Pacientes de atención regular van al final de la cola (FIFO)
			colaCitas.add(codigoCita);
		}
	}

	public String desencolarSiguiente() {
		if (colaCitas == null || colaCitas.isEmpty()) {
			return null;
		}
		return colaCitas.remove(0);
	}

	public boolean removerDeCola(String codigoCita) {
		if (colaCitas == null) {
			return false;
		}
		return colaCitas.remove(codigoCita);
	}

	@Override
	public String toString() {
		return "Consultorio [nombreConsultorio=" + nombreConsultorio + ", direccion=" + direccion
				+ ", telefonoContactoDoctores=" + telefonoContactoDoctores + ", consultas=" + consultas + ", nit=" + nit
				+ ", colaCitas=" + getColaCitas().size() + "]";
	}
}
