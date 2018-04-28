package mx.ipn.cic.biblioteca.AdminControl.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.ipn.cic.biblioteca.AdminControl.model.BookModel;

@Service
public class BookService {

	private List<BookModel> books;
	private int count;

	public BookService() {
		this.books = new ArrayList<>();
		this.books.add(new BookModel(1, "La metamorfósis", "Franz Kafka", "Porrúa", 100, "Primera"));
		this.books.add(new BookModel(2, "El Principito", "Antoine de Saint-Exupéry", "Fondo de cultura económica", 150,
				"Segunda"));
		this.books.add(new BookModel(3, "Física", "Resnik", "Infiernito", 100, "Tercera"));

		this.count = this.books.size();
	}

	public BookModel register(BookModel newBook) {

		newBook.setId(++count);
		this.books.add(newBook);

		return newBook;

	}

	public BookModel findById(int id) {

		BookModel found = null;
		for (BookModel book : this.books) {
			if (book.getId() == id) {
				found = book;
				break;
			}
		}

		return found;
	}

	public List<BookModel> findAll() {
		return this.books;
	}

	public boolean delete(int idToDelete) {

		BookModel found = this.findById(idToDelete);
		if (found != null) {
			return this.books.remove(found);
		} else {
			return false;
		}

	}

	public BookModel edit(BookModel bookModel) {

		BookModel book = 
				this.findById(bookModel.getId());
		if (book != null) {
			book.setTitle(bookModel.getTitle());
			book.setAuthor(bookModel.getAuthor());
			book.setEdition(bookModel.getEdition());
			book.setEditorial(bookModel.getEditorial());
			book.setPages(bookModel.getPages());
		}

		return book;
	}

}
