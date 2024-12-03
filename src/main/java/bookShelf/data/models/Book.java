package bookShelf.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Book {
    private String title;
    private String author;
    private String description;
    @Id
    private String isbn;

}
