package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;



public class Ficheros {
	public static List<String> lecturaFichero (String fichero) throws IOException{
		List<String> listaS=new ArrayList<String>();
		Path file= Paths.get(fichero);
		
		BufferedReader reader=null;
		
		try{
			//Creamos un BufferedReader de java.io de forma eficiente utilizando Files de java.nio
			reader = Files.newBufferedReader(file, StandardCharsets.ISO_8859_1);		
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		    	
		    	listaS.add(line);
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}finally {
			//Cerramos recursos.Aquí nos aseguramos de que se cierre aunque haya excepción
            if (reader != null) {
                reader.close();
            }
		}
		return listaS;
	}
	
	public static void escribirFichero(String fichero, List<String> listaS) {
		try {
			Path file = Paths.get(fichero);
			BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8);

			for (String linea : listaS) {
				writer.write(linea, 0, linea.length());
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
