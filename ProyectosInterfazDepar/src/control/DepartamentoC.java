package control;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BBDDps;

import dao.Ficheros;
import modelo.Departamento;
import vista.Entrada;
import vista.Salida;

public class DepartamentoC {
	//Opciones de departamentos
	public static void controlDepartamentos(int opcion) throws SQLException, IOException {
		BBDDps enlaceBD=new BBDDps();
		switch(opcion) {
		case 8: enlaceBD.insertarDepartamento(Entrada.leerDepartamento());Salida.mostrarDepartamentos(enlaceBD.seleccionarDepartamentos());break;	
		case 9: enlaceBD.eliminarDepartamento(Entrada.eliminarDepartamento(enlaceBD.seleccionarDepartamentos()));break;
		case 10: cargarDepartamentos2();
		
	}
	}
	/*//carga de departamentos desde el fichero, controlado por la clase DepartamentoC
	public static void cargarDepartamentos() throws IOException, SQLException {
		BBDDps enlaceBD=new BBDDps();
		
		List<String> listaS=new ArrayList<String>();
		listaS=Ficheros.lecturaFichero("Archivos/Departamentos.csv");
		for (String s: listaS) {
			enlaceBD.insertarDepartamento(new Departamento(s));
		}
	}*/
	
	public static void cargarDepartamentos2() throws IOException, SQLException {
		BBDDps enlaceBD=new BBDDps();
		List<Departamento> listaD=new ArrayList<Departamento>();
		List<String> listaS=new ArrayList<String>();
		listaS=Ficheros.lecturaFichero("Archivos/Departamentos.csv");
		for (String s: listaS) {
			listaD.add(new Departamento(s));
		}
		enlaceBD.insertarListaDepartamentos(listaD);
	}
	
}
