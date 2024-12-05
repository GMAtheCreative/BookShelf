package bookShelf.services;

import bookShelf.data.repositories.BookRepository;
import bookShelf.dtos.requests.book.AddBookRequest;
import bookShelf.dtos.requests.book.GetBookRequest;
import bookShelf.dtos.requests.book.UpdateBookRequest;
import bookShelf.dtos.responses.book.AddBookResponse;
import bookShelf.dtos.responses.book.GetBookResponse;
import bookShelf.dtos.responses.book.UpdateBookResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServicesImplTest {

    @Autowired
    private BookServices bookServices;
    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    public void setUp(){
        bookRepository.deleteAll();
    }

    private static AddBookRequest buildBookRequest(AddBookRequest bookRequest) {
        bookRequest.setTitle("Jesus is lord");
        bookRequest.setAuthor("danjuma");
        bookRequest.setDescription("book description");
        bookRequest.setIsbn("1234566789");
        return bookRequest;
    }
    private static AddBookRequest buildBookRequest2(AddBookRequest bookRequest) {
        bookRequest.setIsbn("1234566789");
        bookRequest.setAuthor("chibuzo");
        bookRequest.setTitle("new title");
        bookRequest.setDescription("new description");
        return bookRequest;
    }



    @Test
    public void addBook() {
        AddBookRequest bookRequest = new AddBookRequest();
        AddBookRequest addBook = buildBookRequest(bookRequest);
        AddBookResponse bookResponse = bookServices.addBook(addBook);

        assertNotNull(bookResponse);
        assertEquals("Book Added successfully",bookResponse.getMessage());
    }
    @Test
    void getBookByTitle() {
        AddBookRequest bookRequest = new AddBookRequest();
        AddBookRequest addBook = buildBookRequest(bookRequest);
        AddBookResponse addBookResponse = bookServices.addBook(addBook);
        assertNotNull(addBookResponse);

        GetBookRequest getBookRequest = new GetBookRequest();
        getBookRequest.setTitle(addBook.getTitle());
        getBookRequest.setAuthor(addBook.getAuthor());
        GetBookResponse getBookResponse = bookServices.getBookByTitle(getBookRequest);
        assertNotNull(getBookResponse);
        assertEquals(getBookResponse.getBooks().get(0).getTitle(),addBook.getTitle());
        assertEquals("1 Book(s) Found", getBookResponse.getMessage());
    }

    @Test
    void updateBook() {
        AddBookRequest bookRequest = buildBookRequest(new AddBookRequest());
        AddBookResponse bookResponse = bookServices.addBook(bookRequest);
        assertNotNull(bookResponse);

        AddBookRequest bookRequest2 = buildBookRequest(new AddBookRequest());
        bookRequest2.setTitle("Different Title");
        AddBookResponse bookResponse2 = bookServices.addBook(bookRequest2);
        assertNotNull(bookResponse2);

        UpdateBookRequest updateBookRequest = new UpdateBookRequest();
        updateBookRequest.setTitle("updated title");
        updateBookRequest.setAuthor("Updated Author");
        updateBookRequest.setDescription("Updated Description");
        UpdateBookResponse updateBookResponse = bookServices.updateBook(updateBookRequest);
        assertNotNull(updateBookResponse);

        assertEquals("Update Successful", updateBookResponse.getMessage());
        assertEquals("Updated Author", updateBookResponse.getAuthor());
        assertEquals("Updated Description", updateBookResponse.getDescription());
    }

    @Test
    void getAllBooks() {
    }


    @Test
    void deleteBook() {
    }

    @Test
    void searchBooks() {
    }
}