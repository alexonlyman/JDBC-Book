package alexgr.jdbcbook.repo;

import alexgr.jdbcbook.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepoImpl implements BookRepo {

    private final JdbcTemplate template;

    @Override
    public void createBook(Book book) {
        String sql = "INSERT INTO book (title, author, year_published) VALUES (?, ?, ?)";
        template.update(sql, book.getTitle(), book.getAuthor(), book.getYearPublished());
    }

    @Override
    public void updateBook(Book book) {
        String sql = "UPDATE book SET title = ?, author = ?, year_published = ? WHERE id = ?";
        template.update(sql, book.getTitle(), book.getAuthor(), book.getYearPublished(), book.getId());

    }

    @Override
    public void deleteBook(Integer id) {
        String sql = "DELETE FROM book WHERE id = ?";
        template.update(sql, id);

    }

    @Override
    public Book getBookById(Integer id) {
        String sql = "SELECT book WHERE id = ?";
        return template.query(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            return ps;
        }, (rs, rowNum) -> new Book(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getInt("year_published")
        )).stream().findAny().orElse(null);
    }

    @Override
    public List<Book> getAllBooks() {
        String sql = "SELECT * FROM book";
        return template.query(sql, ((rs, rowNum) -> new Book(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getInt("yearPublished")
        )));
    }
}
