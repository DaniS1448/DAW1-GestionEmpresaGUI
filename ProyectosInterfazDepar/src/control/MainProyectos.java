package control;


import java.io.IOException;
import java.sql.SQLException;
import vista.Entrada;
import vista.Salida;
import vista.VentanaPrincipal;

public class MainProyectos {

	public static void main(String[] args) {
		
		VentanaPrincipal vp = new VentanaPrincipal();
		vp.setVisible(true);

		/*try {
			// -----------OPCIONES DE
			// MENÚ---------------------------------------------------------
			int opcion = 0;

			while (opcion != 8) {
				opcion = Entrada.datosMenu();
				switch (opcion) {

				case 8:
				case 9:
				case 10:
					DepartamentoC.controlDepartamentos(opcion);
					break;
				case 11:
					Salida.finalizar();
					break;
				default:
					System.out.println("Opci�n no v�lida");
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}
	
}
