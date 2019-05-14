package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.BBDDps;
import modelo.Departamento;
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
	
	
}
