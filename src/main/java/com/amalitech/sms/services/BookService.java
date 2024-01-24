package com.amalitech.sms.services;

import com.amalitech.sms.interfaces.BookInterface;
import com.amalitech.sms.models.Author;
import com.amalitech.sms.models.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class BookService implements BookInterface {

    private final JdbcTemplate jdbcTemplate;

    public BookService(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update("INSERT INTO book(title, genre, isbn, publication_date, author_id) VALUES(?,?,?,?,?)",
                book.getTitle(),
                book.getGenre(),
                book.getIsbn(),
                book.getPublication_date(),
                book.getAuthor_id()
        );
    }

    @Override
    public Optional<Book> findSingleBook(String isbn){
        List<Book> results =  jdbcTemplate.query("SELECT * FROM book WHERE isbn = ? LIMIT 1",
                new BookService.BookRowMapper(),
                isbn);
        return results .stream().findFirst();
    };

    @Override
    public List<Book> findMany() {
        List<Book> results =  jdbcTemplate.query("SELECT * FROM book",
                new BookService.BookRowMapper());
        return results .stream().toList();
    }

    public static class BookRowMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Book.builder()
                    .title(rs.getString("title"))
                    .isbn(rs.getString("isbn"))
                    .genre(rs.getString("genre"))
                    .publication_date(rs.getDate("publication_date").toLocalDate())
                    .author_id(rs.getLong("author_id"))
                    .build();
        }
    }
}
