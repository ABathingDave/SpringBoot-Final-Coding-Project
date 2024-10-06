package book.reviews.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import book.reviews.controller.model.BookData;
import book.reviews.controller.model.BookData.BookReviewData;
import book.reviews.dao.BookDao;
import book.reviews.dao.BookReviewDao;
import book.reviews.entity.Book;
import book.reviews.entity.BookReview;
import book.reviews.exception.ResourceNotFoundException;

@Service
public class BookReviewsServiceImpl implements BookReviewsService{
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private BookReviewDao bookReviewDao;
	
	@Autowired
	public BookReviewsServiceImpl(BookDao bookDao, BookReviewDao bookReviewDao) {
		this.bookDao = bookDao;
		this.bookReviewDao = bookReviewDao;
	}

//	@Transactional(readOnly = false)
//	public BookData saveBook(BookData bookData) {
//		Book book = bookData.toBook();
//		Book dbBook = BookDao.save(book);
//		
//		return new BookData(dbBook);
//	}
//
//	@Transactional(readOnly = false)
//	public BookReviewData saveBookReview(BookReviewData bookReviewData) {
//		BookReview bookReview = bookReviewData.toBookReview();
//		BookReview dbBookReview = BookReviewDao.save(bookReview);
//		
//		return new BookReviewData(dbBookReview);
//	}
//
//	@Transactional(readOnly = true)
//	public BookData retrieveBookById(Long bookId) {
//		Book book = findBookById(bookId);
//		return BookData(book);
//	}
//
//	private Book findBookById(Long bookId) {
//		
//		return bookDao.findById(bookId)
//				.orElseThrow(() -> new NoSuchElementException(
//						"Book with ID=" + bookId + " was not found."));
//	}
//
//	public BookReviewData retrieveBookReviewById(Long bookReviewId) {
//		BookReview bookReview = findBookReviewById(bookReviewId);
//		return BookReviewData(bookReview);
//	}
//
//	private BookReview findBookReviewById(Long bookReviewId) {
//		
//		return bookReviewDao.findById(bookReviewId)
//				.orElseThrow(() -> new NoSuchElementException(
//						"Book Review with ID=" + bookReviewId + " was not found."));
//	}

	@Override
	public List<Book> getAllBooks() {
		return bookDao.findAll();
	}

	@Override
	public Book getBookById(int id) {
		return bookDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book", "Id", id));
	}

	@Override
	public Book saveBook(Book book) {
		return bookDao.save(book);
	}

	@Override
	public Book updateBook(Book book, int id) {
		Book existingBook = bookDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book", "Id", id));
		
		existingBook.setTitle(book.getTitle());
		existingBook.setAuthor(book.getAuthor());
		existingBook.setGenre(book.getGenre());
		
		return existingBook;
	}

	@Override
	public void deleteBook(int id) {
		Book existingBook = bookDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book", "Id", id));
		bookDao.deleteById(id);
	}

	@Override
	public List<BookReview> getAllBookReviews() {
		return bookReviewDao.findAll();
	}

	@Override
	public BookReview getBookReviewById(int id) {
		return bookReviewDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("BookReview", "Id", id));
	}

	@Override
	public BookReview saveBookReview(BookReview bookReview) {
		return bookReviewDao.save(bookReview);
	}

	@Override
	public BookReview updateBookReview(BookReview bookReview, int id) {
		
		BookReview existingBookReview = bookReviewDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("BookReview", "Id", id));
		
		existingBookReview.setBookReviewAuthor(bookReview.getBookReviewAuthor());
		
		return existingBookReview;
	}

	@Override
	public void deleteBookReview(int id) {
		BookReview existingBookReview = bookReviewDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("BookReview", "Id", id));
		bookReviewDao.deleteById(id);
	}
	
}
