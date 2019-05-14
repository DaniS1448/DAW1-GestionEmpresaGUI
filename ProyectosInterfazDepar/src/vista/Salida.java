package vista;

import java.util.List;

import modelo.*;



public class Salida {
	
	public static void finalizar() {
		System.out.println("PROGRAMA FINALIZADO");
		System.out.println();
		System.out.println("**************************");
	}
	
	public static void mostrarDepartamentos(List<Departamento> listaD) {
		for (Departamento d: listaD) {
			System.out.println(d.toString());
			
		}
	}
}
