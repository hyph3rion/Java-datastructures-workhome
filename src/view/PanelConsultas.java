package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelConsultas extends JPanel {

    // data office form
    private JLabel nitL;
    private JTextField nitF;
    private JLabel nombreConsultorioL;
    private JTextField nombreConsultorioF;
    private JLabel direccionL;
    private JTextField direccionF;
    private JLabel telefonoDoctorL;
    private JTextField telefonoDoctorF;

    // appointment form
    private JLabel codigoCitaL;
    private JTextField codigoCitaF;
    private JLabel cedulaPacienteCitaL;
    private JTextField cedulaPacienteCitaF;
    private JLabel doctorCitaL;
    private JComboBox<String> comboDoctores;
    private JButton btnAsignarConsulta;
    private JButton btnActualizarConsulta;
    private JButton btnCancelarConsulta;
    private JButton btnAtenderSiguiente;

    // search panels
    private JLabel lblBuscarNit;
    private JTextField txtBuscarNit;
    private JButton btnBuscarConsultorio;
    private JButton btnRefrescarDoctores;

    // split views and tabbed sub-modules
    private JTextArea vistaDatosConsultorio;
    private JTextArea vistaCitasAgendadas;
    private JTextArea vistaColaCitas;
    private JTextArea vistaLogCancelaciones;
    private JScrollPane scrollConsultorio;
    private JScrollPane scrollCitas;
    private JScrollPane scrollCola;
    private JScrollPane scrollLog;
    private JTabbedPane subModuloConsultas;

    public PanelConsultas() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelIzquierdo = new JPanel(new BorderLayout(0, 10));
        panelIzquierdo.setPreferredSize(new Dimension(340, 0));

        // form consultorio
        JPanel panelFormConsultorio = new JPanel(new GridBagLayout());
        panelFormConsultorio.setBorder(BorderFactory.createTitledBorder("Información del Consultorio"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        nitL = new JLabel("NIT Consultorio:");
        nitF = new JTextField(12);
        nombreConsultorioL = new JLabel("Nombre:");
        nombreConsultorioF = new JTextField(12);
        direccionL = new JLabel("Dirección:");
        direccionF = new JTextField(12);
        telefonoDoctorL = new JLabel("Tel. Contacto:");
        telefonoDoctorF = new JTextField(12);

        agregarFilaGBC(panelFormConsultorio, nitL, nitF, gbc, 0);
        agregarFilaGBC(panelFormConsultorio, nombreConsultorioL, nombreConsultorioF, gbc, 1);
        agregarFilaGBC(panelFormConsultorio, direccionL, direccionF, gbc, 2);
        agregarFilaGBC(panelFormConsultorio, telefonoDoctorL, telefonoDoctorF, gbc, 3);

        // form citas y cola
        JPanel panelFormCitas = new JPanel(new GridBagLayout());
        panelFormCitas.setBorder(BorderFactory.createTitledBorder("Gestión de Citas y Turnos"));

        codigoCitaL = new JLabel("Código Cita:");
        codigoCitaF = new JTextField(12);
        cedulaPacienteCitaL = new JLabel("Cédula Paciente:");
        cedulaPacienteCitaF = new JTextField(12);
        doctorCitaL = new JLabel("Doctor Asignado:");
        
        comboDoctores = new JComboBox<>();
        comboDoctores.addItem("[Auto-asignar disponible]");

        btnAsignarConsulta = new JButton("Agendar Cita");
        btnActualizarConsulta = new JButton("Actualizar Cita");
        btnCancelarConsulta = new JButton("Cancelar Consulta");
        btnAtenderSiguiente = new JButton("Atender Siguiente");

        JPanel panelBotonesCitas = new JPanel(new GridLayout(2, 2, 4, 4));
        panelBotonesCitas.add(btnAsignarConsulta);
        panelBotonesCitas.add(btnActualizarConsulta);
        panelBotonesCitas.add(btnCancelarConsulta);
        panelBotonesCitas.add(btnAtenderSiguiente);

        agregarFilaGBC(panelFormCitas, codigoCitaL, codigoCitaF, gbc, 0);
        agregarFilaGBC(panelFormCitas, cedulaPacienteCitaL, cedulaPacienteCitaF, gbc, 1);
        agregarFilaGBC(panelFormCitas, doctorCitaL, comboDoctores, gbc, 2);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(8, 2, 4, 2);
        panelFormCitas.add(panelBotonesCitas, gbc);

        panelIzquierdo.add(panelFormConsultorio, BorderLayout.NORTH);
        panelIzquierdo.add(panelFormCitas, BorderLayout.CENTER);

        // ==========================================
        // PANEL DERECHO: VISTAS Y SUB-PESTAÑAS (CENTER)
        // ==========================================
        JPanel panelDerecho = new JPanel(new BorderLayout(5, 5));

        // upper search bar 
        JPanel panelBusqueda = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 4));
        panelBusqueda.setBorder(BorderFactory.createTitledBorder("Filtro de Consulta"));

        lblBuscarNit = new JLabel("NIT Consultorio:");
        txtBuscarNit = new JTextField(10);
        btnBuscarConsultorio = new JButton("Buscar");
        btnRefrescarDoctores = new JButton("Actualizar Doctores");

        panelBusqueda.add(lblBuscarNit);
        panelBusqueda.add(txtBuscarNit);
        panelBusqueda.add(btnBuscarConsultorio);
        panelBusqueda.add(btnRefrescarDoctores);

        // Sub-módulo con pestañas para Consultorio, Cola de Espera y Log de Cancelaciones
        subModuloConsultas = new JTabbedPane();

        // Pestaña 1: Citas y Consultorio
        JPanel panelVistasDivididas = new JPanel(new GridLayout(2, 1, 0, 6));

        vistaDatosConsultorio = new JTextArea();
        vistaDatosConsultorio.setEditable(false);
        scrollConsultorio = new JScrollPane(vistaDatosConsultorio);
        scrollConsultorio.setBorder(BorderFactory.createTitledBorder("Detalles del Consultorio Seleccionado"));

        vistaCitasAgendadas = new JTextArea();
        vistaCitasAgendadas.setEditable(false);
        scrollCitas = new JScrollPane(vistaCitasAgendadas);
        scrollCitas.setBorder(BorderFactory.createTitledBorder("Citas Registradas en este Consultorio"));

        panelVistasDivididas.add(scrollConsultorio);
        panelVistasDivididas.add(scrollCitas);

        // Pestaña 2: Cola de Espera (Prioridad)
        vistaColaCitas = new JTextArea();
        vistaColaCitas.setEditable(false);
        scrollCola = new JScrollPane(vistaColaCitas);
        scrollCola.setBorder(BorderFactory.createTitledBorder("Cola de Espera de Pacientes (Turnos y Prioridades)"));

        // Pestaña 3: Log de Cancelaciones (Auditoría)
        vistaLogCancelaciones = new JTextArea();
        vistaLogCancelaciones.setEditable(false);
        scrollLog = new JScrollPane(vistaLogCancelaciones);
        scrollLog.setBorder(BorderFactory.createTitledBorder("Registro de Cancelaciones (Historial y Justificaciones)"));

        subModuloConsultas.addTab("Citas Agendadas", panelVistasDivididas);
        subModuloConsultas.addTab("Cola de Espera (Turnos)", scrollCola);
        subModuloConsultas.addTab("Log Cancelaciones", scrollLog);

        panelDerecho.add(panelBusqueda, BorderLayout.NORTH);
        panelDerecho.add(subModuloConsultas, BorderLayout.CENTER);

        // main panel
        add(panelIzquierdo, BorderLayout.WEST);
        add(panelDerecho, BorderLayout.CENTER);
    }

    private void agregarFilaGBC(JPanel panel, JLabel label, Object campo, GridBagConstraints gbc, int fila) {
        gbc.gridwidth = 1;
        gbc.gridy = fila;
        
        gbc.gridx = 0;
        gbc.weightx = 0.3;
        panel.add(label, gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        panel.add((java.awt.Component) campo, gbc);
    }

    // Getters y Setters
    public JTextField getNitF() { return nitF; }
    public JTextField getNombreConsultorioF() { return nombreConsultorioF; }
    public JTextField getDireccionF() { return direccionF; }
    public JTextField getTelefonoDoctorF() { return telefonoDoctorF; }
    public JTextField getCodigoCitaF() { return codigoCitaF; }
    public JTextField getCedulaPacienteCitaF() { return cedulaPacienteCitaF; }
    public JComboBox<String> getComboDoctores() { return comboDoctores; }
    public JButton getBtnAsignarConsulta() { return btnAsignarConsulta; }
    public JButton getBtnActualizarConsulta() { return btnActualizarConsulta; }
    public JButton getBtnCancelarConsulta() { return btnCancelarConsulta; }
    public JButton getBtnEliminarConsulta() { return btnCancelarConsulta; }
    public JButton getBtnAtenderSiguiente() { return btnAtenderSiguiente; }
    public JTextField getTxtBuscarNit() { return txtBuscarNit; }
    public JButton getBtnBuscarConsultorio() { return btnBuscarConsultorio; }
    public JButton getBtnRefrescarDoctores() { return btnRefrescarDoctores; }
    public JTextArea getVistaDatosConsultorio() { return vistaDatosConsultorio; }
    public JTextArea getVistaCitasAgendadas() { return vistaCitasAgendadas; }
    public JTextArea getVistaColaCitas() { return vistaColaCitas; }
    public JTextArea getVistaLogCancelaciones() { return vistaLogCancelaciones; }
    public JTabbedPane getSubModuloConsultas() { return subModuloConsultas; }
}