package book.reviews.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="book_review")
public class BookReview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookReviewId;
	
	@Column(value = "book_review_author")
	private String bookReviewAuthor;
	
	@ManyToOne
	@JoinColumn(name = "book_id", nullable = false)
	private Book book;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
}
