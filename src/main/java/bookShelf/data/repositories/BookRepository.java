package bookShelf.data.repositories;

import bookShelf.data.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface BookRepository extends MongoRepository<Book, Long> {
    List<Book> findByTitle(String title);
    Optional<Book> findByTitleAndAuthor(String title, String author);

}
