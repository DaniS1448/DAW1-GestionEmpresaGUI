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
		btnNuevoDepartamento.setBounds(185, 28, 210, 23);
		getContentPane().add(btnNuevoDepartamento);
		
		variables.put("btnNuevoDepartamento", btnNuevoDepartamento);
		btnNuevoDepartamento.setActionCommand("btnNuevoDepartamento");
		btnNuevoDepartamento.addActionListener(new ControlActionPrincipal(this, variables));
		
		
		JButton btnEliminarDepartamento = new JButton("ELIMINAR DEPARTAMENTO CON JTextField");
		btnEliminarDepartamento.setBounds(185, 62, 210, 23);
		getContentPane().add(btnEliminarDepartamento);
		
		variables.put("btnEliminarDepartamento", btnEliminarDepartamento);
		btnEliminarDepartamento.setActionCommand("btnEliminarDepartamento");
		btnEliminarDepartamento.addActionListener(new ControlActionPrincipal(this, variables));
		
		JButton btnCargarDepartamentos = new JButton("CARGAR DEPARTAMENTOS");
		btnCargarDepartamentos.setBounds(185, 96, 210, 23);
		getContentPane().add(btnCargarDepartamentos);
		
		variables.put("btnCargarDepartamentos", btnCargarDepartamentos);
		btnCargarDepartamentos.setActionCommand("btnCargarDepartamentos");
		btnCargarDepartamentos.addActionListener(new ControlActionPrincipal(this, variables));
		
	}
}
