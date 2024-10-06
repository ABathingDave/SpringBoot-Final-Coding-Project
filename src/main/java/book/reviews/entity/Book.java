package book.reviews.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;
	
	@Column(value = "author")
	private String author;
	
	@Column(value = "title")
	private String title;
	
	@Column(value = "genre")
	private String genre;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<BookReview> bookReviews = new HashSet<>();
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "book_genre",
			joinColumns = @JoinColumn(name = "book_id"),
			inverseJoinColumns = @JoinColumn(name = "genre_id")
	)
	private Set<Genre> genres = new HashSet<>();
}
