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
	private JTextField tfNombreDepartamento;
	
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
		btnCrearNuevoDepartamento.setBounds(194, 205, 162, 23);
		getContentPane().add(btnCrearNuevoDepartamento);
		
		variables.put("btnCrearNuevoDepartamento", btnCrearNuevoDepartamento);
		btnCrearNuevoDepartamento.setActionCommand("btnCrearNuevoDepartamento");
		btnCrearNuevoDepartamento.addActionListener(new ControlActionPrincipal(this, variables));
		
		tfNombreDepartamento = new JTextField();
		tfNombreDepartamento.setBounds(194, 26, 162, 20);
		getContentPane().add(tfNombreDepartamento);
		tfNombreDepartamento.setColumns(10);
		
		variables.put("tfNombreDepartamento", tfNombreDepartamento);
		tfNombreDepartamento.addActionListener(new ControlActionPrincipal(this, variables));
		
	}
}
