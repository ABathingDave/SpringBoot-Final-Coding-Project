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

//import book.reviews.controller.model.BookData.BookReviewData;
//import book.reviews.entity.Book;
import book.reviews.entity.BookReview;
import book.reviews.service.BookReviewsService;
//import book.reviews.service.BookReviewsServiceImpl;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/book_reviews/book_review")
@Slf4j
public class BookReviewController {

	@Autowired
	private BookReviewsService bookReviewsService;
	
	public BookReviewController(BookReviewsService bookReviewsService) {
		super();
		this.bookReviewsService = bookReviewsService;
	}
	
	@GetMapping
	public List<BookReview> getAllBookReviews() {
		return bookReviewsService.getAllBookReviews();
	}
	
	@GetMapping("{book_review_id}")
	public ResponseEntity<BookReview> getBookReviewById(@PathVariable("book_review_id") int BookReviewID) {
		return new ResponseEntity<BookReview>(bookReviewsService.getBookReviewById(BookReviewID), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<BookReview> saveBookReview(@RequestBody BookReview bookReview) {
		return new ResponseEntity<BookReview>(bookReviewsService.saveBookReview(bookReview), HttpStatus.CREATED);
	}
	
	@PutMapping("{book_review_id}")
	public ResponseEntity<BookReview> updateBookReview(@PathVariable("book_review_id") int bookId, @RequestBody BookReview bookReview) {
		return new ResponseEntity<BookReview>(bookReviewsService.updateBookReview(bookReview, bookId), HttpStatus.OK);
	}
	
	@DeleteMapping("{book_review_id}")
	public ResponseEntity<String> deleteBookReview(@PathVariable("book_review_id") int BookReviewID) {
		bookReviewsService.deleteBookReview(BookReviewID);
		return new ResponseEntity<String>("Book Review Gone!!!", HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	// Dr. Rob Version
//	@PostMapping("/book_review")
//	@ResponseStatus(code = HttpStatus.CREATED)
//	public BookReviewData createBookReview(@RequestBody BookReviewData bookReviewData) {
//		log.info("Creating book review {}", bookReviewData);
//		return bookReviewsService.saveBookReview(bookReviewData);
//	}
///	
//	@GetMapping("/book_review/{bookReviewId}")
//	public BookReviewData retrieveBookReview(@PathVariable Long bookReviewId) {
//		log.info("Retrieving book review with ID={}", bookReviewId);
//		return bookReviewsService.retrieveBookReviewById(bookReviewId);
//	}
}
