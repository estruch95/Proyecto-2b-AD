import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;


public class Marshaller {
	//Atributos de la clase
	private Document dom = null;
	private ArrayList<Libro> libros = null;
	
	//Constructor
	public Marshaller(ArrayList<Libro> l) {
		//Almacenamos el array que recibe este objeto(Marshaller.java) al ser creado en "libros"
		this.libros = l;
	}
	
	/* Método cuya función es generar la instancia para "dom" (Crear objeto Document sobre el cual trabajar) */
	public void crearDocumento(){
		//Creamos un objeto DocumentBuilderFactory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		//Captura de errores mediante cápsula try/catch
		try {
			//Creación de DocumentBuilder
			DocumentBuilder db = dbf.newDocumentBuilder();
			//Creamos una instancia de dom
			dom = db.newDocument();
		}
		catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Información en caso de error en la creación del documento
			System.err.println("Error en la creación del documento.");
		}
	}
	
	/* Método cuya función es crear un árbol de elementos sobre el documento */
	public void createArbolDOM(){
		//Creación del elemento raiz "libros"
		Element docElemento = dom.createElement("libros");
		//Añadido del mismo al documento "dom"
		dom.appendChild(docElemento);
		
		//Recorremos o iteramos el ArrayList<Libro> llamado libros
		Iterator iterator =  libros.iterator();
		
		while(iterator.hasNext()){
			//Obtención del objeto Libro
			Libro libroObtenido = (Libro) iterator.next();
			//Para cada objeto Libro obtenido creamos el elemento <libro>
			Element elementoLibro = setLibro(libroObtenido);
			//Añadido al elemento raiz
			docElemento.appendChild(elementoLibro);
		}
	}
	
	/* Método encargado de recoger en elementos y añadirlos al raíz todos y cada uno de los atributos de un objeto Libro */
	public Element setLibro(Libro l){
		//Creamos el elemento "libro" que posteriormente devolverá el método
		Element elementoLibro = dom.createElement("libro");
		
		//TÍTULO
		//Creamos elemento titulo
		Element tituloEle = dom.createElement("titulo");
		//Creamos nodo de texto para el título y lo guardamos en "titulo"
		Text titulo = dom.createTextNode(l.getTitulo());
		//Añadimos al elemento titulo el nodo de texto "titulo" creado anteriormente
		tituloEle.appendChild(titulo);
		//Añadido al elemento libro el elemento título
		elementoLibro.appendChild(tituloEle);
		
		//AUTOR (Pasos explicados anteriormente)
		Element autorEle = dom.createElement("autor");
		Text nombre = dom.createTextNode(l.getAutor());
		autorEle.appendChild(nombre);
		elementoLibro.appendChild(autorEle);
		
		//PUBLICACIÓN
		Element publicacionEle = dom.createElement("publicacion");
		Text publicacion = dom.createTextNode(String.valueOf(l.getPublicacion()));
		publicacionEle.appendChild(publicacion);
		elementoLibro.appendChild(publicacionEle);
		
		//EDITOR
		Element editorEle = dom.createElement("editor");
		Text editor = dom.createTextNode(l.getEditor());
		editorEle.appendChild(editor);
		elementoLibro.appendChild(editorEle);
		
		//PÁGINAS
		Element paginasEle = dom.createElement("paginas");
		Text paginas = dom.createTextNode(String.valueOf(l.getPaginas()));
		paginasEle.appendChild(paginas);
		elementoLibro.appendChild(paginasEle);
		
		//Devuelve el elemento libro actualizado
		return elementoLibro;
	}
	//Método cuya finalidad es transformar el documento "dom" a un fichero XML de salida
	public void documentToXML(File f){
		try {
			//Creamos la instancia para poder realizar la escritura del resultado
			Transformer t;
			t = TransformerFactory.newInstance().newTransformer();
			//Añadido al objeto Transformer una propiedad que permite los saltos de linea
			//En caso de no asignarla, se mostraría todo el XML sin saltos de linea
			t.setOutputProperty(OutputKeys.INDENT, "Yes");
			
			//Indicamos donde vamos a realizar la escritura así como la fuente de datos (Escribiremos sobre "f")
			StreamResult resultado = new StreamResult(f);
			//Documento origen "dom"
			DOMSource docOrigen = new DOMSource(dom);
			//Realizamos la escritura y crea fichero
			t.transform(docOrigen, resultado);
			//Información por consola 
			System.out.println("Se ha generado correctamente el fichero XML");
		}
		catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
