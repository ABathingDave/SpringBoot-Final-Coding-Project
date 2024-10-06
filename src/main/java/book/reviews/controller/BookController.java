package book.reviews.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//import book.reviews.controller.model.BookData;
import book.reviews.entity.Book;
//import book.reviews.entity.BookReview;
import book.reviews.service.BookReviewsService;
//import book.reviews.service.BookReviewsServiceImpl;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/book_reviews/book")
@Slf4j
public class BookController {

	@Autowired
	private BookReviewsService bookReviewsService;
	
	public BookController(BookReviewsService bookReviewsService) {
		super();
		this.bookReviewsService = bookReviewsService;
	}
	
	@GetMapping
	public List<Book> getAllBooks() {
		return bookReviewsService.getAllBooks();
	}
	
	@GetMapping("{book_id}")
	public ResponseEntity<Book> getBookById(@PathVariable("book_id") int BookID) {
		return new ResponseEntity<Book>(bookReviewsService.getBookById(BookID), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Book> saveBook(@RequestBody Book book) {
		return new ResponseEntity<Book>(bookReviewsService.saveBook(book), HttpStatus.CREATED);
	}
	
	@PutMapping("{book_id}")
	public ResponseEntity<Book> updateBook(@PathVariable("book_id") int bookReviewId, @RequestBody Book book) {
		return new ResponseEntity<Book>(bookReviewsService.updateBook(book, bookReviewId), HttpStatus.OK);
	}
	
	@DeleteMapping("{book_id}")
	public ResponseEntity<String> deleteBook(@PathVariable("book_id") int BookID) {
		bookReviewsService.deleteBook(BookID);
		return new ResponseEntity<String>("Book Gone!!!", HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Dr. Rob Version
//	@PostMapping("/book")
//	@ResponseStatus(code = HttpStatus.CREATED)
//	public BookData createBook(@RequestBody BookData bookData) {
//		log.info("Creating book {}", bookData);
//		return bookReviewsService.saveBook(bookData);
//	}
//	
//	@GetMapping("/book/{bookId}")
//	public BookData retrieveBook(@PathVariable Long bookId) {
//		log.info("Retrieving book with ID={}", bookId);
//		return bookReviewsService.retrieveBookById(bookId);
//	}
}
