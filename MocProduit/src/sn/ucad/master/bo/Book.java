package sn.ucad.master.bo;

public class Book extends Produit {
	
	private long id;
	private String isbn;
	private String author;
	
	public Book() {
		
	}

	public Book(long id, String isbn, String author) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	

}
