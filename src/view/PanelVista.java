package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelVista extends JPanel{
	//Busqueda por cedula
	private JLabel lblBuscar;
	private JTextField txtBuscarCedula;
	private JButton btnBuscar;
	
	//reportes y listas
	private JLabel resultadosVista;
	private JTextArea vistaResultados;
	private JScrollPane scrollObject;
	
	public PanelVista() {
		setLayout(new BorderLayout(5, 5));
		
		//seccion busqueda paciente
		JPanel panelBusqueda = new JPanel(new FlowLayout());
		lblBuscar = new JLabel("Buscar por cédula: ");
		txtBuscarCedula = new JTextField(10);
		btnBuscar = new JButton("Buscar");

		panelBusqueda.add(lblBuscar);
		panelBusqueda.add(txtBuscarCedula);
		panelBusqueda.add(btnBuscar);
		
		resultadosVista = new JLabel("Panel de resultados ");
		add(resultadosVista);
		vistaResultados = new JTextArea(10, 30);
		vistaResultados.setEditable(false);
		scrollObject = new JScrollPane(vistaResultados);
		add(scrollObject);
		
		add(panelBusqueda, BorderLayout.NORTH);
		add(scrollObject, BorderLayout.CENTER);
		setVisible(true);
	}

	public JLabel getLblBuscar() {
		return lblBuscar;
	}

	public void setLblBuscar(JLabel lblBuscar) {
		this.lblBuscar = lblBuscar;
	}

	public JTextField getTxtBuscarCedula() {
		return txtBuscarCedula;
	}

	public void setTxtBuscarCedula(JTextField txtBuscarCedula) {
		this.txtBuscarCedula = txtBuscarCedula;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JLabel getResultadosVista() {
		return resultadosVista;
	}

	public void setResultadosVista(JLabel resultadosVista) {
		this.resultadosVista = resultadosVista;
	}

	public JTextArea getVistaResultados() {
		return vistaResultados;
	}

	public void setVistaResultados(JTextArea vistaResultados) {
		this.vistaResultados = vistaResultados;
	}

	public JScrollPane getScrollObject() {
		return scrollObject;
	}

	public void setScrollObject(JScrollPane scrollObject) {
		this.scrollObject = scrollObject;
	}
	
}
