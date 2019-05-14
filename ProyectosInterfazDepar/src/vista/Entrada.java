package vista;

import java.util.List;
import java.util.Scanner;

import control.MainProyectos;
import modelo.Departamento;


public class Entrada {
private static Scanner sc = new Scanner(System.in);

	
	public static Departamento leerDepartamento() {
		String nombre;
		
		System.out.println("LECTURA DE DATOS DE NUEVO DEPARTAMENTO:");
		System.out.println("NOMBRE DEL DEAPARTAMENTO:\n");
		sc.nextLine();
		nombre=sc.nextLine();
		
			
		return  new Departamento(nombre);
	}
	
	
	

	public static int datosMenu() {

		int opcion;
		opcion = 0;
		System.out.println("-------PROYECTO EMPLEADOS Y DEPARTAMENTOS-----");
		System.out.println("Elija el número de opción que desee:");
	/*	System.out.println("OPCION 1: NUEVO EMPLEADO");
		System.out.println("OPCION 2: MODIFICAR DATOS DE EMPLEADO");
		System.out.println("OPCION 3: ELIMINAR UN EMPLEADO");
		System.out.println("OPCION 4: FICHERO DE EMPLEADOS");
		System.out.println("OPCION 5: NUEVO PROYECTO");
		System.out.println("OPCION 6: ASOCIAR UN EMPLEADO A UN PROYECTO");
		System.out.println("OPCION 7: LISTADO DE PROYECTOS");*/
		System.out.println("OPCION 8: NUEVO DEPARTAMENTO");
		System.out.println("OPCION 9: ELIMINAR DEPARTAMENTO");
		System.out.println("OPCION 10: CARGAR DEPARTAMENTOS DEL FICHERO DEPARTAMENTOS.CSV");
		System.out.println("OPCION 11: SALIR");
		
		opcion = sc.nextInt();
		return opcion;
	}
//**********************ELIMINACIONES **************************************************
	
public static int eliminarDepartamento(List<Departamento> listaD) {
		
		int id;
		Salida.mostrarDepartamentos(listaD);
		
		System.out.println("SELECCIONE EL CÃ“DIGO DE DEPARTAMENTO A ELIMINAR:");
		id=sc.nextInt();
		
				
		return id;
	}
}
