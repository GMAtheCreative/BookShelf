package bookShelf.dtos.responses.book;

import lombok.Data;

@Data
public class UpdateBookResponse {
    private String title;
    private String author;
    private String Description;
    private String message;
}
