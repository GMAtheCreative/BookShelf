package bookShelf.services;

import bookShelf.dtos.requests.*;
import bookShelf.dtos.responses.*;


public interface BookServices {

    AddBookResponse addBook(AddBookRequest addBookRequest);

    GetBookResponse getBookById(GetBookRequest getBookRequest);

    GetAllBooksResponse getAllBooks();

    UpdateBookResponse updateBook(UpdateBookRequest updateBookRequest);

    DeleteBookResponse deleteBook(DeleteBookRequest deleteBookRequest);

    SearchBooksResponse searchBooks(SearchBooksRequest searchBooksRequest);

}
