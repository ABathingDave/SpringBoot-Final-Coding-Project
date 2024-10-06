package book.reviews.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import book.reviews.entity.Book;
import book.reviews.entity.BookReview;

public interface BookReviewDao extends JpaRepository<BookReview, Long> {

	Optional<Book> findById(int id);

	void deleteById(int id);

}
