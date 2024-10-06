DROP TABLE IF EXISTS book_genre;
DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS book_review;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS book;

CREATE TABLE book (
  book_id int NOT NULL AUTO_INCREMENT,
  author varchar(60) NOT NULL,
  title varchar(60) NOT NULL,
  genre varchar(60) NOT NULL,
  PRIMARY KEY(book_id)
);

CREATE TABLE user (
  user_id int NOT NULL AUTO_INCREMENT,
  username varchar(60) NOT NULL,
  PRIMARY KEY(user_id)
);

CREATE TABLE book_review (
  book_review_id int NOT NULL AUTO_INCREMENT,
  book_id int NOT NULL,
  user_id int NOT NULL,
  bookReviewAuthor varchar(60) NOT NULL,
  PRIMARY KEY(book_review_id),
  FOREIGN KEY (book_id) REFERENCES location (book_id) ON DELETE CASCADE,
  FOREIGN KEY (user_id) REFERENCES location (user_id) ON DELETE CASCADE
);

CREATE TABLE genre (
  genre_id int NOT NULL AUTO_INCREMENT,
  name varchar(60) NOT NULL,
  PRIMARY KEY(genre_id)
);

CREATE TABLE book_genre (
  book_id int NOT NULL,
  genre_id int NOT NULL,
  FOREIGN KEY (book_id) REFERENCES dog (book_id) ON DELETE CASCADE,
  FOREIGN KEY (genre_id) REFERENCES breed (genre_id) ON DELETE CASCADE
);