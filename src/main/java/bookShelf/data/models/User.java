package bookShelf.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class User {
    private String UserName;
    @Id
    private String Email;
    private String Password;
    private String Username;
    @DBRef
    private List<Book> books;
}
