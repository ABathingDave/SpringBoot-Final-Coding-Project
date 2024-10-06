package book.reviews.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import book.reviews.entity.Book;

public interface BookDao extends JpaRepository<Book, Long> {

	Optional<Book> findById(int id);

	void deleteById(int id);

}
