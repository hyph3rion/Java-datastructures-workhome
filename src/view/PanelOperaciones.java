package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOperaciones extends JPanel{
	//attributes
	private JButton botonGuardar;
	private JButton eliminarRegistro;
	private JButton actualizarRegistro;
	
	//bob the constructor c:
	public PanelOperaciones() {
		//layout(flow)
		setLayout(new FlowLayout());
		
		botonGuardar = new JButton("Guardar");
		add(botonGuardar);
		
		eliminarRegistro = new JButton("Eliminar");
		add(eliminarRegistro);
		
		actualizarRegistro = new JButton("Actualizar");
		add(actualizarRegistro);
		
		setVisible(true);
	}

	public JButton getBotonGuardar() {
		return botonGuardar;
	}

	public JButton getEliminarRegistro() {
		return eliminarRegistro;
	}

	public JButton getActualizarRegistro() {
		return actualizarRegistro;
	}
}
