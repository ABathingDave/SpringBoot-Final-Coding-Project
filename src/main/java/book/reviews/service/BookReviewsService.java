package book.reviews.service;

import java.util.List;

import book.reviews.entity.Book;
import book.reviews.entity.BookReview;

public interface BookReviewsService {

	public List<Book> getAllBooks();
	public Book getBookById(int id);
	public Book saveBook(Book book);
	public Book updateBook(Book book, int id);
	public void deleteBook(int id);
	
	public List<BookReview> getAllBookReviews();
	public BookReview getBookReviewById(int id);
	public BookReview saveBookReview(BookReview bookReview);
	public BookReview updateBookReview(BookReview bookReview, int id);
	public void deleteBookReview(int id);
}
