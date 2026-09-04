package model;

import java.io.Serializable;

public class Doctor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int idDoctor;
	private int cedulaProfesional;
	private String nombreDoctor;
	private boolean disponibilidad;
	
			
	
	public Doctor(int idDoctorP, int cedulaProfesionalP, String nombreDoctorP, boolean disponibilidadP) {
		super();
		this.idDoctor = idDoctorP;
		this.cedulaProfesional = cedulaProfesionalP;
		this.nombreDoctor = nombreDoctorP;
		this.disponibilidad = disponibilidadP;
	}


	public int getIdDoctor() {
		return idDoctor;
	}


	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}


	public int getCedulaProfesional() {
		return cedulaProfesional;
	}


	public void setCedulaProfesional(int cedulaProfesional) {
		this.cedulaProfesional = cedulaProfesional;
	}


	public String getNombreDoctor() {
		return nombreDoctor;
	}


	public void setNombreDoctor(String nombreDoctor) {
		this.nombreDoctor = nombreDoctor;
	}


	public boolean isDisponibilidad() {
		return disponibilidad;
	}


	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}


	@Override
	public String toString() {
		return "Doctor [idDoctor=" + idDoctor + ", cedulaProfesional=" + cedulaProfesional + ", nombreDoctor="
				+ nombreDoctor + ", disponibilidad=" + disponibilidad + "]";
	}
	
	
}
