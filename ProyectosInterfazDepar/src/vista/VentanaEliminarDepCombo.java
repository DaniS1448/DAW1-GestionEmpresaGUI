package vista;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import control.ControlActionPrincipal;
import dao.BBDDps;
import modelo.Departamento;

import javax.swing.JComboBox;

public class VentanaEliminarDepCombo extends JDialog{
	
	private Map<String,Object> variables = new HashMap<String, Object>();
	private JTextField jtfNombreDepartamento;
	
	public VentanaEliminarDepCombo() {
		
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
		
		variables.put("btnEliminarElDepCombo", btnEliminarElDepartamento);
		btnEliminarElDepartamento.setActionCommand("btnEliminarElDepCombo");
		btnEliminarElDepartamento.addActionListener(new ControlActionPrincipal(this, variables));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(194, 41, 162, 23);
		getContentPane().add(comboBox);		
		
		try {
			BBDDps enlaceBD = new BBDDps();
			List<Departamento> departamentos= enlaceBD.seleccionarDepartamentos();
			
			if(departamentos.size()>0) {
				for(Departamento d : departamentos) {
					comboBox.addItem(d.getNomDepartamento());
				}
			} else {
				JOptionPane.showMessageDialog(this, "ERROR, el fichero no contiene departamentos ", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		variables.put("comboBox", comboBox);
		comboBox.addActionListener(new ControlActionPrincipal(this, variables));
	}
}
