package bookShelf.data.repositories;

import bookShelf.data.models.ReadingProgress;
import bookShelf.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReadingProgressRepository extends MongoRepository<ReadingProgress, String> {
}
