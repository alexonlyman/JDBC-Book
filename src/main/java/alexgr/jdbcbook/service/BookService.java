package alexgr.jdbcbook.service;

import alexgr.jdbcbook.model.Book;
import alexgr.jdbcbook.repo.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepo bookRepo;

    public void createBook(Book book) {
        bookRepo.createBook(book);
    }

    public void updateBook(Book book) {
        bookRepo.updateBook(book);
    }

    public void deleteBook(Integer id) {
        bookRepo.deleteBook(id);
    }

    public Book getBookById(Integer id) {
        return bookRepo.getBookById(id);
    }

    public List<Book> getAllBooks() {
        return bookRepo.getAllBooks();
    }
}
