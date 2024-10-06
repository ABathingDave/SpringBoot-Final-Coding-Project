package book.reviews.controller.model;

import java.util.HashSet;
import java.util.Set;

import book.reviews.entity.Book;
import book.reviews.entity.BookReview;
import book.reviews.entity.Genre;
import book.reviews.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookData {

	private Long bookId;
	private String author;
	private String title;
	private String genre;
	private Set<BookReviewData> bookReviews = new HashSet<>();
	private Set<GenreData> genres = new HashSet<>();
	
	public BookData(Book book) {
		this.bookId = book.getBookId();
		this.author = book.getAuthor();
		this.title = book.getTitle();
		this.genre = book.getGenre();
		
		for(BookReview bookReview : book.getBookReviews()) {
			this.bookReviews.add(new BookReviewData(bookReview));
		}
		
		for(Genre genre : book.getGenres()) {
			this.genres.add(new GenreData(genre));
		}
		
	}
	
	public BookData(Long bookId, String author, String title, String genre) {
		this.bookId = bookId;
		this.author = author;
		this.title = title;
		this.genre = genre;
	}
	
	public Book toBook() {
		Book book = new Book();
		
		book.setBookId(bookId);
		book.setAuthor(author);
		book.setTitle(title);
		book.setGenre(genre);
		
		for(BookReviewData bookReviewData : bookReviews) {
			book.getBookReviews().add(BookReviewData.toBookReview());
		}
		
		for(GenreData genreData : genres) {
			book.getGenres().add(GenreData.toGenre());
		}
		
		return book;
	}
	
	@Data
	@NoArgsConstructor
	public class BookReviewData {
		
		private Long bookReviewId;
		private String bookReviewAuthor;
		
		public BookReviewData(BookReview bookReview) {
			this.bookReviewId = bookReview.getBookReviewId();
			this.bookReviewAuthor = bookReview.getBookReviewAuthor();
		}

		public BookReview toBookReview() {
			BookReview bookReview = new BookReview();
			
			bookReview.setBookReviewId(bookReviewId);
			bookReview.setBookReviewAuthor(bookReviewAuthor);
			
			return bookReview;
		}
	}
	
	@Data
	@NoArgsConstructor
	public class GenreData {
		
		private Long genreId;
		private String name;
		private Set<BookData> books = new HashSet<>();
		
		public GenreData(Genre genre) {
			this.genreId = genre.getGenreId();
			this.name = genre.getName();
			
			for(Book book : genre.getBooks()) {
				this.books.add(new BookData(book));
			}
		}

		public Genre toGenre() {
			Genre genre = new Genre();
			
			genre.setGenreId(genreId);
			genre.setName(name);
			
			for(BookData bookData : books) {
				genre.getBooks().add(BookData.toBook());
			}
			
			return genre;
		}
	}
	
	@Data
	@NoArgsConstructor
	public class UserData {
		
		private Long userId;
		private String username;
		private Set<BookReviewData> bookReviews = new HashSet<>();
		
		public UserData(User user) {
			this.userId = user.getUserId();
			this.username = user.getUsername();
			
			for(BookReview bookReview : user.getBookReviews()) {
				this.bookReviews.add(new BookReviewData(bookReview));
			}
		}
		
		public User toUser() {
			User user = new User();
			
			user.setUserId(userId);
			user.setUsername(username);
			
			for(BookReviewData bookReviewData : bookReviews) {
				user.getBookReviews().add(BookReviewData.toBookReview());
			}
			
			return user;
		}
		
	}
}
