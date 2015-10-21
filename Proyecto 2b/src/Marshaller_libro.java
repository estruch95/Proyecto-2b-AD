import java.io.File;
import java.util.ArrayList;


public class Marshaller_libro {
	//Atributos de la clase
	private static ArrayList<Libro> libros;
	private static Libro libro1, libro2, libro3;

	
	//Bucle de inicialización del programa (Main)
	public static void main(String[] args) {
		//Declaración de atributos de la clase
		libros = new ArrayList<Libro>();
		libro1 = new Libro("Hojas movidas por el viento", "Pedro", 1990, "Anaya", 250);
		libro2 = new Libro("En la cima", "Juan", 1999, "Bromera", 145);
		libro3 = new Libro("El hecho de progresar", "Adrian", 2003, "Anaya", 440);
		
		//Cargado de datos en el ArrayList<Libro> libros
		libros.add(libro1);
		libros.add(libro2);
		libros.add(libro3);
		
		//Creación de el objeto Marshaller (recibe por parámetro "libros" (ArrayList<Libro>))
		Marshaller marshaller = new Marshaller(libros);
		//Llamada al método crearDocumento() del objeto Marshaller
		marshaller.crearDocumento();
		//Llamada al método crearArbolDOM() del objeto Marshaller
		marshaller.createArbolDOM();
		
		//Creación de un nuevo objeto File llamado "libros.xml"
		File file = new File("libros.xml");
		
		//Llamada al método documentToXML() del objeto Marshaller
		marshaller.documentToXML(file);
	}

}
