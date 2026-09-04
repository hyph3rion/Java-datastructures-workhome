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

import model.Consultorio;

public class ConsultorioDao {

	private HashMap<Integer, Consultorio> mapaConsultorio;
	private final String ARCHIVO = "consultorios.dat";

	public ConsultorioDao() {
		this.mapaConsultorio = cargarArchivo();
	}

	private void guardarArchivo() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
			oos.writeObject(mapaConsultorio);
		} catch (IOException e) {
			System.err.println("Error al guardar consultorios.dat: " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	private HashMap<Integer, Consultorio> cargarArchivo() {
		File f = new File(ARCHIVO);
		if (!f.exists()) {
			return new HashMap<>();
		}
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
			return (HashMap<Integer, Consultorio>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.err.println("Error al leer consultorios.dat: " + e.getMessage());
			return new HashMap<>();
		}
	}

	public boolean registrarConsultorio(Consultorio consultorio) {
		int nit = consultorio.getNit();
		if (mapaConsultorio.containsKey(nit)) {
			return false;
		}
		mapaConsultorio.put(nit, consultorio);
		guardarArchivo();
		return true;
	}


	public boolean eliminarConsultorio(int nit) {
		if (mapaConsultorio.remove(nit) != null) {
			guardarArchivo();
			return true;
		}
		return false;
	}

	public boolean eliminarConsultorio(Consultorio consultorio) {
		if (consultorio == null) {
			return false;
		}
		return eliminarConsultorio(consultorio.getNit());
	}

	public boolean actualizarConsultorio(Consultorio consultorio) {
		int nit = consultorio.getNit();
		if (mapaConsultorio.containsKey(nit)) {
			mapaConsultorio.put(nit, consultorio);
			guardarArchivo();
			return true;
		}
		return false;
	}

	public Consultorio buscarConsultorio(int nit) {
		return mapaConsultorio.get(nit);
	}

	public List<Consultorio> listarTodos() {
		return new ArrayList<>(mapaConsultorio.values());
	}
}
