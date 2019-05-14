package vista;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

import control.ControlActionPrincipal;

public class VentanaNuevoDepartamento extends JDialog{
	
	private Map<String,Object> variables = new HashMap<String, Object>();
	private JTextField jtfNombreDepartamento;
	
	public VentanaNuevoDepartamento() {
		
		configurarVentana();
		inicializarComponentes();
	}
	
	public void configurarVentana() {
		
		this.setTitle("NUEVO DEPARTAMENTO - GESTIÓN DE EMPRESA - DaniS");
		this.setBounds(100,100,600,400);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		getContentPane().setLayout(null);
		
	}
	
	public void inicializarComponentes() {
		
		JButton btnCrearNuevoDepartamento = new JButton("CREAR DEPARTAMENTO");
		btnCrearNuevoDepartamento.setBounds(177, 249, 204, 40);
		getContentPane().add(btnCrearNuevoDepartamento);
		
		variables.put("btnCrearNuevoDepartamento", btnCrearNuevoDepartamento);
		btnCrearNuevoDepartamento.setActionCommand("btnCrearNuevoDepartamento");
		btnCrearNuevoDepartamento.addActionListener(new ControlActionPrincipal(this, variables));
		
		jtfNombreDepartamento = new JTextField();
		jtfNombreDepartamento.setBounds(200, 146, 162, 20);
		getContentPane().add(jtfNombreDepartamento);
		jtfNombreDepartamento.setColumns(10);
		
		variables.put("tfNombreDepartamento", jtfNombreDepartamento);
		jtfNombreDepartamento.addActionListener(new ControlActionPrincipal(this, variables));
		
	}
}
