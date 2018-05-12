package mx.ipn.cic.biblioteca.AdminControl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="libro")
public class BookModel {

	// Propiedades
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="identificador")
	private Integer id;
	
	@Column(name="titulo")
	private String title;
	
	@Column(name="autor")
	private String author;
	
	@Column(name="editorial")
	private String editorial;
	
	@Column(name="paginas")
	private int pages;
	
	@Column(name="edicion")
	private String edition;

	// Constructores

	public BookModel() {
		super();

	}

	public BookModel(int id, String title, String author, String editorial, int pages, String edition) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.editorial = editorial;
		this.pages = pages;
		this.edition = edition;
	}

	public BookModel(String title, String author, String editorial, int pages, String edition) {
		super();
		this.title = title;
		this.author = author;
		this.editorial = editorial;
		this.pages = pages;
		this.edition = edition;
	}

	// Métodos de acceso

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	// Método toString optimizado

	@Override
	public String toString() {
		return String.format("BookModel [id=%s, title=%s, author=%s, editorial=%s, pages=%s, edition=%s]", id, title,
				author, editorial, pages, edition);
	}

}
