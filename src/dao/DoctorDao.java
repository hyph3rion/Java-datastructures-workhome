package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Doctor;

public class DoctorDao {

	private HashMap<Integer, Doctor> mapaDoctores;
	private final String ARCHIVO = "doctores.dat";

	public DoctorDao() {
		this.mapaDoctores = cargarArchivo();
	}

	private void guardarArchivo() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
			oos.writeObject(mapaDoctores);
		} catch (IOException e) {
			System.err.println("Error al guardar doctores.dat: " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	private HashMap<Integer, Doctor> cargarArchivo() {
		File f = new File(ARCHIVO);
		if (!f.exists()) {
			return new HashMap<>();
		}
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
			return (HashMap<Integer, Doctor>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.err.println("Error al leer doctores.dat: " + e.getMessage());
			return new HashMap<>();
		}
	}

	public boolean registrarDoctor(Doctor doctor) {
		int idDoctor = doctor.getIdDoctor();
		if (mapaDoctores.containsKey(idDoctor)) {
			return false;
		}
		mapaDoctores.put(idDoctor, doctor);
		guardarArchivo();
		return true;
	}

	public boolean eliminarDoctor(int idDoctor) {
		if (mapaDoctores.remove(idDoctor) != null) {
			guardarArchivo();
			return true;
		}
		return false;
	}

	public boolean eliminarDoctor(Doctor doctor) {
		if (doctor == null) {
			return false;
		}
		return eliminarDoctor(doctor.getIdDoctor());
	}

	public boolean actualizarDoctor(Doctor doctor) {
		int idDoctor = doctor.getIdDoctor();
		if (mapaDoctores.containsKey(idDoctor)) {
			mapaDoctores.put(idDoctor, doctor);
			guardarArchivo();
			return true;
		}
		return false;
	}

	public Doctor buscarDoctor(int idDoctor) {
		return mapaDoctores.get(idDoctor);
	}

	public Doctor buscarPorCedulaProfesional(int cedulaProfesional) {
		for (Doctor d : mapaDoctores.values()) {
			if (d.getCedulaProfesional() == cedulaProfesional) {
				return d;
			}
		}
		return null;
	}

	public List<Doctor> listarTodos() {
		return new ArrayList<>(mapaDoctores.values());
	}
}
