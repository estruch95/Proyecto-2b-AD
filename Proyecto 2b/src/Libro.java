import java.io.Serializable;
import java.util.ArrayList;


public class Libro implements Serializable{
	//ATRIBUTOS DE LA CLASE
	private String titulo;
	private int anyo;
	private ArrayList<String> autor;
	private String editor;
	private int paginas;
	
	//CONSTRUCTOR
	public Libro(String titulo, int anyo, String nombre, String apellido, String editor, int paginas) {
		// TODO Auto-generated constructor stub
		this.titulo = titulo;
		this.anyo = anyo;
		this.autor.add(nombre);
		this.autor.add(apellido);
		this.editor = editor;
		this.paginas = paginas;
	}

	//GETTERS AND SETTERS
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public ArrayList<String> getAutor() {
		return autor;
	}

	public void setAutor(ArrayList<String> autor) {
		this.autor = autor;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
	//MÉTODO CUYA FUNCIÓN ES REALIZAR IMPRESO
	public void print(){
		System.out.println("Titulo: "+this.getTitulo());
	}

}
