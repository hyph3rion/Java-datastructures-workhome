package view;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PanelDoctores extends JPanel{
	
	private JLabel idDoctorLabel;
	private JTextField idDoctorTextF;
	private JLabel cedulaProfesionalLabel;
	private JTextField cedulaProfesionalTextF;
	private JLabel nombreDoctorLabel;
	private JTextField nombreDoctorTextField;
	private JRadioButton RbDisponibilidadTrue;
	private JRadioButton RbDisponibilidadFalse;
	
	public PanelDoctores() {
		// Doctor Fields
		idDoctorLabel = new JLabel("Numeral identificador doctor: ");
		add(idDoctorLabel);
		idDoctorTextF = new JTextField(10);
		add(idDoctorTextF);
		
		// Id number
		cedulaProfesionalLabel = new JLabel("Ingrese la cédula profesional del doctor: ");
		add(cedulaProfesionalLabel);
		cedulaProfesionalTextF = new JTextField(15);
		add(cedulaProfesionalTextF);
		
		// Doctor Name
		nombreDoctorLabel = new JLabel("Ingrese nombre y apellido del doctor: ");
		add(nombreDoctorLabel);
		nombreDoctorTextField = new JTextField(20);
		add(nombreDoctorTextField);
		
		// Radio Button Boolean
		RbDisponibilidadTrue = new JRadioButton("Disponible");
		RbDisponibilidadFalse = new JRadioButton("No Disponible");
		
		// ButtonGroup last attribute
		ButtonGroup disponibilidadGroup = new ButtonGroup();
		disponibilidadGroup.add(RbDisponibilidadTrue);
		disponibilidadGroup.add(RbDisponibilidadFalse);
		
		RbDisponibilidadTrue.setSelected(true);
		
		add(RbDisponibilidadTrue);
		add(RbDisponibilidadFalse);
	}

	public JLabel getIdDoctorLabel() {
		return idDoctorLabel;
	}

	public void setIdDoctorLabel(JLabel idDoctorLabel) {
		this.idDoctorLabel = idDoctorLabel;
	}

	public JTextField getIdDoctorTextF() {
		return idDoctorTextF;
	}

	public void setIdDoctorTextF(JTextField idDoctorTextF) {
		this.idDoctorTextF = idDoctorTextF;
	}

	public JLabel getCedulaProfesionalLabel() {
		return cedulaProfesionalLabel;
	}

	public void setCedulaProfesionalLabel(JLabel cedulaProfesionalLabel) {
		this.cedulaProfesionalLabel = cedulaProfesionalLabel;
	}

	public JTextField getCedulaProfesionalTextF() {
		return cedulaProfesionalTextF;
	}

	public void setCedulaProfesionalTextF(JTextField cedulaProfesionalTextF) {
		this.cedulaProfesionalTextF = cedulaProfesionalTextF;
	}

	public JLabel getNombreDoctorLabel() {
		return nombreDoctorLabel;
	}

	public void setNombreDoctorLabel(JLabel nombreDoctorLabel) {
		this.nombreDoctorLabel = nombreDoctorLabel;
	}

	public JTextField getNombreDoctorTextField() {
		return nombreDoctorTextField;
	}

	public void setNombreDoctorTextField(JTextField nombreDoctorTextField) {
		this.nombreDoctorTextField = nombreDoctorTextField;
	}

	public JRadioButton getRbDisponibilidadTrue() {
		return RbDisponibilidadTrue;
	}

	public void setRbDisponibilidadTrue(JRadioButton rbDisponibilidadTrue) {
		RbDisponibilidadTrue = rbDisponibilidadTrue;
	}

	public JRadioButton getRbDisponibilidadFalse() {
		return RbDisponibilidadFalse;
	}

	public void setRbDisponibilidadFalse(JRadioButton rbDisponibilidadFalse) {
		RbDisponibilidadFalse = rbDisponibilidadFalse;
	}
}
