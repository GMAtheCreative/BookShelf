package bookShelf.services;

import bookShelf.data.models.Book;
import bookShelf.data.repositories.BookRepository;
import bookShelf.dtos.requests.book.*;
import bookShelf.dtos.responses.book.*;
import bookShelf.exception.bookException.BookNotFound;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServicesImpl implements BookServices {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

//    @Override
//    public AddBookResponse addBook(AddBookRequest addBookRequest) {
//        Book newBook = modelMapper.map(addBookRequest, Book.class);
//        bookRepository.save(newBook);
//        AddBookResponse response = new AddBookResponse();
//        response.setMessage("Added book successfully");
//        return response;
//    }


    @Override
    public AddBookResponse addBook(AddBookRequest addBookRequest) {
        Book book = new Book();
        book.setAuthor(addBookRequest.getAuthor());
        book.setIsbn(addBookRequest.getIsbn());
        book.setDescription(addBookRequest.getDescription());
        book.setTitle(addBookRequest.getTitle());
        bookRepository.save(book);
        AddBookResponse response = new AddBookResponse();
        response.setMessage("Book Added successfully");
        return response;
    }

    @Override
    public GetBookResponse getBookByTitle(GetBookRequest getBookRequest) {
        List<Book> books = bookRepository.findByTitle(getBookRequest.getTitle());
        if (books.isEmpty()) {
            throw new BookNotFound("Book not found");
        }
        GetBookResponse response = new GetBookResponse();
        response.setBooks(books);
        int numberOfBooks = response.getBooks().size();
        response.setMessage(numberOfBooks + " Book(s) Found");
        return response;
    }

    @Override
    public GetAllBooksResponse getAllBooks() {
        return null;
    }



    @Override
    public UpdateBookResponse updateBook(UpdateBookRequest updateBookRequest) {
        Book existingBook = bookRepository.findByTitleAndAuthor(
                        updateBookRequest.getTitle(),
                        updateBookRequest.getAuthor())
                .orElseThrow(() -> new BookNotFound("Book not found"));

        existingBook.setAuthor(updateBookRequest.getAuthor());
        existingBook.setDescription(updateBookRequest.getDescription());
        existingBook.setTitle(updateBookRequest.getTitle());

        Book updatedBook = bookRepository.save(existingBook);

        UpdateBookResponse response = new UpdateBookResponse();
        response.setTitle(updatedBook.getTitle());
        response.setAuthor(updatedBook.getAuthor());
        response.setDescription(updatedBook.getDescription());
        response.setMessage("Update Successful");

        return response;
    }


    @Override
    public DeleteBookResponse deleteBook(DeleteBookRequest deleteBookRequest) {
        return null;
    }

    @Override
    public SearchBooksResponse searchBooks(SearchBooksRequest searchBooksRequest) {
        return null;
    }
}
