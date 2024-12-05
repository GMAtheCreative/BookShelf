package bookShelf.controllers;

import bookShelf.data.repositories.BookRepository;
import bookShelf.dtos.requests.book.AddBookRequest;
import bookShelf.dtos.responses.book.AddBookResponse;
import bookShelf.services.BookServices;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("api/addBook")
public class BookControllers {
        @Autowired
        private  BookServices bookServices;

        @PostMapping
        public ResponseEntity<AddBookResponse> addBook(@RequestBody AddBookRequest addBookRequest) {
            AddBookResponse addBookResponse = bookServices.addBook(addBookRequest);
            return new ResponseEntity<>(addBookResponse, HttpStatus.CREATED);
        }

}
