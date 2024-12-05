package bookShelf.services;

import bookShelf.dtos.requests.book.*;
import bookShelf.dtos.responses.book.*;


public interface BookServices {

    AddBookResponse addBook(AddBookRequest addBookRequest);

    GetBookResponse getBookByTitle(GetBookRequest getBookRequest);

    GetAllBooksResponse getAllBooks();

    UpdateBookResponse updateBook(UpdateBookRequest updateBookRequest);

    DeleteBookResponse deleteBook(DeleteBookRequest deleteBookRequest);

    SearchBooksResponse searchBooks(SearchBooksRequest searchBooksRequest);

}
