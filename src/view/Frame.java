package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Frame extends JFrame{
	//Data writing GUI
	private PanelDatos panelDatos;
	private PanelDoctores panelDoctores;
	//Data reading GUI
	private PanelVista panelVista;
	private PanelDoctoresVista panelDocsVista;
	private PanelConsultas panelConsultas;
	//Data Access Operations
	private PanelOperaciones panelOperaciones;
	//Tabbed Container
	private JTabbedPane moduloPestanas;
	
	
	public Frame() {
		// Swing Java configuration
		setTitle("Sistema de agendamiento consultorio odontologico");
		setSize(900, 600); // Slightly wider to accommodate views properly
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout()); // Main JFrame layout
		
		// Initialize all panels
		panelDatos = new PanelDatos();
		panelDoctores = new PanelDoctores();
		panelVista = new PanelVista();
		panelConsultas = new PanelConsultas();
		
		panelDocsVista = new PanelDoctoresVista();
		panelOperaciones = new PanelOperaciones();
		
		// Create the tab container
		moduloPestanas = new JTabbedPane();
		
		// Build the Patients Tab
		// Use an intermediate JPanel with BorderLayout
		JPanel tabPacientes = new JPanel(new BorderLayout());
		tabPacientes.add(panelDatos, BorderLayout.WEST); // Form on the left
		tabPacientes.add(panelVista, BorderLayout.CENTER); // Results view in the center
		
		// Build the Doctors Tab
		JPanel tabDoctores = new JPanel(new BorderLayout());
		tabDoctores.add(panelDoctores, BorderLayout.NORTH); // Form on top
		tabDoctores.add(panelDocsVista, BorderLayout.CENTER); // Results view in the center
		
		JPanel tabConsultorios = new JPanel(new BorderLayout());
		tabConsultorios.add(panelConsultas, BorderLayout.CENTER);
		
		// Add panels to the JTabbedPane
		moduloPestanas.addTab("Gestion de Consultorios", tabConsultorios);
		moduloPestanas.addTab("Gestion de Pacientes", tabPacientes); // Removed accent just in case
		moduloPestanas.addTab("Gestion de Doctores", tabDoctores); // Removed accent just in case
		
		// Add tabs to the center of the Frame and operations to the south
		add(moduloPestanas, BorderLayout.CENTER);
		add(panelOperaciones, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	public PanelDatos getPanelDatos() {
		return panelDatos;
	}

	public void setPanelDatos(PanelDatos panelDatos) {
		this.panelDatos = panelDatos;
	}

	public PanelVista getPanelVista() {
		return panelVista;
	}

	public void setPanelVista(PanelVista panelVista) {
		this.panelVista = panelVista;
	}

	public PanelOperaciones getPanelOperaciones() {
		return panelOperaciones;
	}

	public void setPanelOperaciones(PanelOperaciones panelOperaciones) {
		this.panelOperaciones = panelOperaciones;
	}

	public PanelDoctores getPanelDoctores() {
		return panelDoctores;
	}

	public void setPanelDoctores(PanelDoctores panelDoctores) {
		this.panelDoctores = panelDoctores;
	}
	
	public PanelConsultas getPanelConsultas() {
	    return panelConsultas;
	}

	public void setPanelConsultas(PanelConsultas panelConsultas) {
	    this.panelConsultas = panelConsultas;
	}

	public PanelDoctoresVista getPanelDocsVista() {
		return panelDocsVista;
	}

	public void setPanelDocsVista(PanelDoctoresVista panelDocsVista) {
		this.panelDocsVista = panelDocsVista;
	}

	public JTabbedPane getModuloPestanas() {
		return moduloPestanas;
	}

	public void setModuloPestanas(JTabbedPane moduloPestanas) {
		this.moduloPestanas = moduloPestanas;
	}
}
