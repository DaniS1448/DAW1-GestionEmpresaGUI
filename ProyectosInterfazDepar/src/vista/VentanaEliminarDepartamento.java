package vista;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

import control.ControlActionPrincipal;

public class VentanaEliminarDepartamento extends JDialog{
	
	private Map<String,Object> variables = new HashMap<String, Object>();
	private JTextField jtfNombreDepartamento;
	
	public VentanaEliminarDepartamento() {
		
		configurarVentana();
		inicializarComponentes();
	}
	
	public void configurarVentana() {
		
		this.setTitle("ELIMINAR DEPARTAMENTO - GESTIÓN DE EMPRESA - DaniS");
		this.setBounds(100,100,600,400);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		getContentPane().setLayout(null);
		
	}
	
	public void inicializarComponentes() {
		
		JButton btnEliminarElDepartamento = new JButton("ELIMINAR DEPARTAMENTO");
		btnEliminarElDepartamento.setBounds(194, 205, 162, 23);
		getContentPane().add(btnEliminarElDepartamento);
		
		variables.put("btnEliminarElDepartamento", btnEliminarElDepartamento);
		btnEliminarElDepartamento.setActionCommand("btnEliminarElDepartamento");
		btnEliminarElDepartamento.addActionListener(new ControlActionPrincipal(this, variables));
		
		jtfNombreDepartamento = new JTextField();
		jtfNombreDepartamento.setBounds(194, 26, 162, 20);
		getContentPane().add(jtfNombreDepartamento);
		jtfNombreDepartamento.setColumns(10);
		
		variables.put("tfNombreDepartamento", jtfNombreDepartamento);
		jtfNombreDepartamento.addActionListener(new ControlActionPrincipal(this, variables));
		
	}
}
