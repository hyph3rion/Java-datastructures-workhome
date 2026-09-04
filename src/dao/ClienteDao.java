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

import model.Cliente;

public class ClienteDao {

	private HashMap<Integer, Cliente> mapaClientes;
	private final String ARCHIVO = "pacientes.dat";

	public ClienteDao() {
		this.mapaClientes = cargarArchivo();
	}

	private void guardarArchivo() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
			oos.writeObject(mapaClientes);
		} catch (IOException e) {
			System.err.println("Error al guardar pacientes.dat: " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	private HashMap<Integer, Cliente> cargarArchivo() {
		File f = new File(ARCHIVO);
		if (!f.exists()) {
			return new HashMap<>();
		}
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
			return (HashMap<Integer, Cliente>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.err.println("Error al leer pacientes.dat: " + e.getMessage());
			return new HashMap<>();
		}
	}

	public boolean registrarPaciente(Cliente cliente) {
		int cedula = cliente.getCedula();
		if (mapaClientes.containsKey(cedula)) {
			return false;
		}
		mapaClientes.put(cedula, cliente);
		guardarArchivo();
		return true;
	}

	public boolean eliminarPaciente(int cedula) {
		if (mapaClientes.remove(cedula) != null) {
			guardarArchivo();
			return true;
		}
		return false;
	}

	public boolean eliminarPaciente(Cliente cliente) {
		if (cliente == null) {
			return false;
		}
		return eliminarPaciente(cliente.getCedula());
	}

	public boolean actualizarPaciente(Cliente cliente) {
		int cedula = cliente.getCedula();
		if (mapaClientes.containsKey(cedula)) {
			mapaClientes.put(cedula, cliente);
			guardarArchivo();
			return true;
		}
		return false;
	}

	public Cliente buscarPaciente(int cedula) {
		return mapaClientes.get(cedula);
	}

	public List<Cliente> listarTodos() {
		return new ArrayList<>(mapaClientes.values());
	}
}
