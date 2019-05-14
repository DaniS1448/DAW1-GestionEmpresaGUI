package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.BBDDps;
import dao.Ficheros;
import modelo.Departamento;
import vista.VentanaEliminarDepCombo;
import vista.VentanaEliminarDepartamento;
import vista.VentanaNuevoDepartamento;

public class ControlActionPrincipal implements ActionListener{
	
	JDialog jd;
	JFrame jf;
	private Map<String,Object> variables = new HashMap<String, Object>();

	public ControlActionPrincipal(JFrame jf, Map<String,Object> variables){
		this.jf=jf;
		this.variables=variables;
	}
	
	public ControlActionPrincipal(JDialog jd, Map<String,Object> variables){
		this.jd=jd;
		this.variables=variables;
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		Object opcion = evento.getActionCommand();
		
		if (opcion.equals("btnNuevoDepartamento")) {
			//jf.setVisible(false);;
			VentanaNuevoDepartamento v = new VentanaNuevoDepartamento();
			v.setVisible(true);
						
		}
		else if(opcion.equals("btnCrearNuevoDepartamento")) {
			String departamento = ((JTextField)variables.get("tfNombreDepartamento")).getText();
			
			if (departamento.isEmpty()) {
				JOptionPane.showMessageDialog(jd, "ERROR, debes escribir un nombre de departamento ", "ERROR", JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(jd, "Se va a crear el departamento: "+departamento, "EXITO", JOptionPane.INFORMATION_MESSAGE);
				boolean estado=false;
				try {
					BBDDps enlaceBD=new BBDDps();
					Departamento d = new Departamento(departamento);
					estado = enlaceBD.insertarDepartamento(d);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				if(estado) {
					JOptionPane.showMessageDialog(jd, "El departamento: "+departamento+" se ha creado correctamente", "EXITO", JOptionPane.INFORMATION_MESSAGE);
					jd.dispose();
				} else {
					JOptionPane.showMessageDialog(jd, "ERROR, no se ha creado el departamento: "+departamento, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		else if (opcion.equals("btnEliminarDepartamento")) {
			//jf.setVisible(false);;
			VentanaEliminarDepartamento v = new VentanaEliminarDepartamento();
			v.setVisible(true);
						
		}
		else if(opcion.equals("btnEliminarElDepartamento")) {
			String departamento = ((JTextField)variables.get("tfNombreDepartamento")).getText();
			
			if (departamento.isEmpty()) {
				JOptionPane.showMessageDialog(jd, "ERROR, debes escribir un nombre de departamento ", "ERROR", JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(jd, "Se va a eliminar el departamento: "+departamento, "EXITO", JOptionPane.INFORMATION_MESSAGE);
				boolean estado=false;
				try {
					BBDDps enlaceBD=new BBDDps();
					int id = enlaceBD.seleccionarCodDepartamento(departamento);
					estado = enlaceBD.eliminarDepartamento(id);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				if(estado) {
					JOptionPane.showMessageDialog(jd, "El departamento: "+departamento+" se ha eliminado correctamente", "EXITO", JOptionPane.INFORMATION_MESSAGE);
					jd.dispose();
				} else {
					JOptionPane.showMessageDialog(jd, "ERROR, no se ha podido eliminar el departamento: "+departamento, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		else if (opcion.equals("btnCargarDepartamentos")) {
			
			List<Departamento> listaD = new ArrayList<Departamento>();
			List<String> lecturaFichero = new ArrayList<String>();
			
			try {
				lecturaFichero = Ficheros.lecturaFichero("Archivos/Departamentos.csv");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(lecturaFichero.size()>0) {
				for(String s : lecturaFichero) {
					Departamento d = new Departamento(s);
					listaD.add(d);
				}
				
				try {
					BBDDps enlaceBD=new BBDDps();
					boolean estado = enlaceBD.insertarListaDepartamentos(listaD);
					
					if(estado) {
						JOptionPane.showMessageDialog(jf, "Los departamentos se han creado correctamente", "EXITO", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(jf, "ERROR, no se han podido crear los departamentos ", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(jf, "ERROR, el fichero no contiene departamentos ", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if (opcion.equals("btnEliminarDepCombo")) {
			//jf.setVisible(false);
			VentanaEliminarDepCombo v = new VentanaEliminarDepCombo();
			v.setVisible(true);
						
		}
		else if(opcion.equals("btnEliminarElDepCombo")) {
			String departamento = (String)(((JComboBox)variables.get("comboBox")).getSelectedItem());

			if (departamento.isEmpty()) {
				JOptionPane.showMessageDialog(jd, "ERROR, debes escribir un nombre de departamento ", "ERROR", JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(jd, "Se va a eliminar el departamento: "+departamento, "EXITO", JOptionPane.INFORMATION_MESSAGE);
				boolean estado=false;
				try {
					BBDDps enlaceBD=new BBDDps();
					int id = enlaceBD.seleccionarCodDepartamento(departamento);
					estado = enlaceBD.eliminarDepartamento(id);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				if(estado) {
					JOptionPane.showMessageDialog(jd, "El departamento: "+departamento+" se ha eliminado correctamente", "EXITO", JOptionPane.INFORMATION_MESSAGE);
					jd.dispose();
				} else {
					JOptionPane.showMessageDialog(jd, "ERROR, no se ha podido eliminar el departamento: "+departamento, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		
	}
}
