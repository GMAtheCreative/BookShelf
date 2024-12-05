package bookShelf.dtos.requests.book;

import lombok.Data;

@Data
public class AddBookRequest {
    private String title;
    private String author;
    private String description;
    private String isbn;
}
