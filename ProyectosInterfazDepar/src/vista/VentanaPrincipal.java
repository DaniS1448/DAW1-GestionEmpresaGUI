package vista;

import javax.swing.JFrame;

import control.ControlActionPrincipal;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;

public class VentanaPrincipal extends JFrame{
	
	private Map<String,Object> variables = new HashMap<String, Object>();
	
	public VentanaPrincipal() {
		
		configurarVentana();
		inicializarComponentes();
	}
	
	public void configurarVentana() {
		
		this.setTitle("GESTIÓN DE EMPRESA - DaniS");
		this.setBounds(100,100,600,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		getContentPane().setLayout(null);
		
	}
	
	public void inicializarComponentes() {
		
		JButton btnNuevoDepartamento = new JButton("NUEVO DEPARTAMENTO");
		btnNuevoDepartamento.setBounds(161, 28, 265, 23);
		getContentPane().add(btnNuevoDepartamento);
		
		variables.put("btnNuevoDepartamento", btnNuevoDepartamento);
		btnNuevoDepartamento.setActionCommand("btnNuevoDepartamento");
		btnNuevoDepartamento.addActionListener(new ControlActionPrincipal(this, variables));
		
		
		JButton btnEliminarDepartamento = new JButton("ELIMINAR DEPARTAMENTO CON JTextField");
		btnEliminarDepartamento.setBounds(161, 62, 265, 23);
		getContentPane().add(btnEliminarDepartamento);
		
		variables.put("btnEliminarDepartamento", btnEliminarDepartamento);
		btnEliminarDepartamento.setActionCommand("btnEliminarDepartamento");
		btnEliminarDepartamento.addActionListener(new ControlActionPrincipal(this, variables));
		
		JButton btnCargarDepartamentos = new JButton("CARGAR DEPARTAMENTOS");
		btnCargarDepartamentos.setBounds(161, 96, 265, 23);
		getContentPane().add(btnCargarDepartamentos);
		
		variables.put("btnCargarDepartamentos", btnCargarDepartamentos);
		btnCargarDepartamentos.setActionCommand("btnCargarDepartamentos");
		btnCargarDepartamentos.addActionListener(new ControlActionPrincipal(this, variables));
		
		JButton btnEliminarDepCombo = new JButton("ELIMINAR DEPARTAMENTO CON ComboBox");
		btnEliminarDepCombo.setBounds(161, 130, 265, 23);
		getContentPane().add(btnEliminarDepCombo);
		
		variables.put("btnEliminarDepCombo", btnEliminarDepCombo);
		btnEliminarDepCombo.setActionCommand("btnEliminarDepCombo");
		btnEliminarDepCombo.addActionListener(new ControlActionPrincipal(this, variables));
		
	}
}
