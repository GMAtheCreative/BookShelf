package bookShelf.dtos.requests.book;

import lombok.Data;

@Data
public class UpdateBookRequest {
    private String title;
    private String author;
    private String Description;
}
