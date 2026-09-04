package view;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//Date native libraries
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.Date;

public class PanelDatos extends JPanel{
	
	private JLabel cedulaL;
	private JTextField cedulaF;
	private JLabel nombreL;
	private JTextField nombreF;
	private JLabel telefonoL;
	private JTextField telefonoF;
	private JLabel cantidadL;
	private JTextField cantidadF;
	private JLabel tipoDeClienteL;
	private JComboBox<String> tipoDeClienteC;
	private JLabel tipoDeAtencionL;
	private JRadioButton rbCalzas;
	private JRadioButton rbLimpieza;
	private JRadioButton rbExtraccion;
	private JRadioButton rbDiagnostico;
	private JLabel fechaCitaL;
	private JSpinner fechaCitaS;
	
	private JLabel prioridadAtencionL;
	private JComboBox<String> prioridadAtencionC;
	
	public PanelDatos() {
		
		//cedula
		cedulaL = new JLabel("Ingrese un número de cédula: ");
		add(cedulaL);
		cedulaF = new JTextField("");
		add(cedulaF);
		
		//nombre
		nombreL = new JLabel("Ingrese un nombre: ");
		add(nombreL);
		nombreF = new JTextField("");
		add(nombreF);
		
		//telefono
		telefonoL = new JLabel("Ingrese un numero telefónico válido: ");
		add(telefonoL);
		telefonoF = new JTextField("");
		add(telefonoF);
		
		//quantity
		String defaultValue = "1";
		cantidadL = new JLabel("Ingrese Cantidad Numérica: ");
		add(cantidadL);
	
		cantidadF = new JTextField(defaultValue, 20);
		cantidadF.setEditable(false);
		add(cantidadF);
		
		java.awt.event.ActionListener radioListener = e -> {
			if(rbLimpieza.isSelected() || rbDiagnostico.isSelected()){
				cantidadF.setText("1");
				cantidadF.setEditable(false);
			}else if(rbCalzas.isSelected() || rbExtraccion.isSelected()) {
				cantidadF.setEditable(true);
				if(cantidadF.getText().trim().isEmpty() || cantidadF.getText().equals("0")) {
					cantidadF.setText("1");
				}
			}
		};
		
		
		//Client Type(Object reference)
		tipoDeClienteL = new JLabel("Seleccione una opción: ");
		add(tipoDeClienteL);
		String[] opciones = {"Particular", "EPS", "Prepagada"};
		tipoDeClienteC = new JComboBox<>(opciones);
		add(tipoDeClienteC);
		
		//tipo de atencion
		tipoDeAtencionL = new JLabel("Seleccione una opción: ");
		add(tipoDeAtencionL);
		
		// radio button components initialization
		rbCalzas = new JRadioButton("Calzas");
		rbLimpieza = new JRadioButton("Limpieza");
		rbExtraccion = new JRadioButton("Extraccion");
		rbDiagnostico = new JRadioButton("Diagnostico");
		//radio button action listener assigner
		rbCalzas.addActionListener(radioListener);
		rbLimpieza.addActionListener(radioListener);
		rbExtraccion.addActionListener(radioListener);
		rbDiagnostico.addActionListener(radioListener);
		
		// 3. Agrupación lógica (para exclusión mutua)
		ButtonGroup grupoAtencion = new ButtonGroup();
		grupoAtencion.add(rbCalzas);
		grupoAtencion.add(rbLimpieza);
		grupoAtencion.add(rbExtraccion);
		grupoAtencion.add(rbDiagnostico);

		// 4. Sub-panel visual (columna derecha del formulario)
		JPanel panelRadio = new JPanel((LayoutManager) new FlowLayout(FlowLayout.LEFT));
		panelRadio.add(rbCalzas);
		panelRadio.add(rbLimpieza);
		panelRadio.add(rbExtraccion);
		panelRadio.add(rbDiagnostico);

		// 5. Agregar el sub-panel al panel principal
		add(panelRadio);
		
		//prioridad atencion
		prioridadAtencionL = new JLabel("Seleccione una opción: ");
		add(prioridadAtencionL);
		
		String[] opcionesPrioridadAtencion = {"Normal", "Urgente"};
		prioridadAtencionC = new JComboBox<>(opcionesPrioridadAtencion);
		add(prioridadAtencionC);
		
		fechaCitaL = new JLabel("Seleccione una fecha valida: ");
		add(fechaCitaL);
		SpinnerDateModel modeloFecha = new SpinnerDateModel();
		fechaCitaS = new JSpinner(modeloFecha);
		JSpinner.DateEditor editor = new JSpinner.DateEditor(fechaCitaS, "dd/MM/yyyy");
		fechaCitaS.setEditor(editor);
		add(fechaCitaS);
		setLayout(new GridLayout(0, 2, 10, 10)); 
		setVisible(true);
	}

	public JLabel getCedulaL() {
		return cedulaL;
	}

	public void setCedulaL(JLabel cedulaL) {
		this.cedulaL = cedulaL;
	}

	public JTextField getCedulaF() {
		return cedulaF;
	}

	public void setCedulaF(JTextField cedulaF) {
		this.cedulaF = cedulaF;
	}

	public JLabel getNombreL() {
		return nombreL;
	}

	public void setNombreL(JLabel nombreL) {
		this.nombreL = nombreL;
	}

	public JTextField getNombreF() {
		return nombreF;
	}

	public void setNombreF(JTextField nombreF) {
		this.nombreF = nombreF;
	}

	public JLabel getTelefonoL() {
		return telefonoL;
	}

	public void setTelefonoL(JLabel telefonoL) {
		this.telefonoL = telefonoL;
	}

	public JTextField getTelefonoF() {
		return telefonoF;
	}

	public void setTelefonoF(JTextField telefonoF) {
		this.telefonoF = telefonoF;
	}

	public JLabel getCantidadL() {
		return cantidadL;
	}

	public void setCantidadL(JLabel cantidadL) {
		this.cantidadL = cantidadL;
	}

	public JTextField getCantidadF() {
		return cantidadF;
	}

	public void setCantidadF(JTextField cantidadF) {
		this.cantidadF = cantidadF;
	}

	public JLabel getTipoDeClienteL() {
		return tipoDeClienteL;
	}

	public void setTipoDeClienteL(JLabel tipoDeClienteL) {
		this.tipoDeClienteL = tipoDeClienteL;
	}

	public JComboBox<String> getTipoDeClienteC() {
		return tipoDeClienteC;
	}

	public void setTipoDeClienteC(JComboBox<String> tipoDeClienteC) {
		this.tipoDeClienteC = tipoDeClienteC;
	}

	public JLabel getTipoDeAtencionL() {
		return tipoDeAtencionL;
	}

	public void setTipoDeAtencionL(JLabel tipoDeAtencionL) {
		this.tipoDeAtencionL = tipoDeAtencionL;
	}

	public JRadioButton getRbCalzas() {
		return rbCalzas;
	}

	public void setRbCalzas(JRadioButton rbCalzas) {
		this.rbCalzas = rbCalzas;
	}

	public JRadioButton getRbLimpieza() {
		return rbLimpieza;
	}

	public void setRbLimpieza(JRadioButton rbLimpieza) {
		this.rbLimpieza = rbLimpieza;
	}

	public JRadioButton getRbExtraccion() {
		return rbExtraccion;
	}

	public void setRbExtraccion(JRadioButton rbExtraccion) {
		this.rbExtraccion = rbExtraccion;
	}

	public JRadioButton getRbDiagnostico() {
		return rbDiagnostico;
	}

	public void setRbDiagnostico(JRadioButton rbDiagnostico) {
		this.rbDiagnostico = rbDiagnostico;
	}

	public JLabel getFechaCitaL() {
		return fechaCitaL;
	}

	public void setFechaCitaL(JLabel fechaCitaL) {
		this.fechaCitaL = fechaCitaL;
	}

	public JSpinner getFechaCitaS() {
		return fechaCitaS;
	}

	public void setFechaCitaS(JSpinner fechaCitaS) {
		this.fechaCitaS = fechaCitaS;
	}

	public JLabel getPrioridadAtencionL() {
		return prioridadAtencionL;
	}

	public void setPrioridadAtencionL(JLabel prioridadAtencionL) {
		this.prioridadAtencionL = prioridadAtencionL;
	}

	public JComboBox<String> getPrioridadAtencionC() {
		return prioridadAtencionC;
	}

	public void setPrioridadAtencionC(JComboBox<String> prioridadAtencionC) {
		this.prioridadAtencionC = prioridadAtencionC;
	}
}
