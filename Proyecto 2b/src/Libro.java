import java.io.Serializable;


public class Libro implements Serializable{
	//Atributos de la clase Libro
	private String titulo;
	private String autor;
	private int publicacion;
	private String editor;
	private int paginas;
	
	//Parametros que recibe el constructor de la clase libro
	public Libro(String t, String a, int pu, String e, int pa) {
		// TODO Auto-generated constructor stub
		titulo = t;
		autor = a;
		publicacion = pu;
		editor = e;
		paginas = pa;
	}

	//Getters y Setters de los atributos de la clase Libro
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(int publicacion) {
		this.publicacion = publicacion;
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
	
	//Método cuya función es imprimir por consola el título del objeto Libro
	public void print(){
		System.out.println("Titulo: "+this.getTitulo());
	}

}
