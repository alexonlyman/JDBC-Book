package alexgr.jdbcbook.repo;

import alexgr.jdbcbook.model.Book;

import java.util.List;

public interface BookRepo {
    void createBook(Book book);

    void updateBook(Book book);

    void deleteBook(Integer id);

    Book getBookById(Integer id);

    List<Book> getAllBooks();
}
