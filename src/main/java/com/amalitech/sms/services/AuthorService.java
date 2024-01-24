package com.amalitech.sms.services;

import com.amalitech.sms.interfaces.AuthorInterface;
import com.amalitech.sms.models.Author;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements AuthorInterface {

    private final JdbcTemplate jdbcTemplate;

    public AuthorService(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Author author) {
    jdbcTemplate.update("INSERT INTO author(author_id, first_name,last_name,birth_date,nationality) VALUES (?,?, ?, ?, ?)",
            author.getAuthor_id(),
            author.getFirst_name(),
            author.getLast_name(),
            author.getBirth_date(),
            author.getNationality()
    );
    }

    @Override
    public Optional<Author> findSingleAuthor(Long author_id){
        List<Author>  results =  jdbcTemplate.query("SELECT * FROM author WHERE author_id = ? LIMIT 1",
                new AuthorRowMapper(),
                author_id);
        return results.stream().findFirst();
    };

    @Override
    public List<Author> findMany() {
        List<Author>  results =  jdbcTemplate.query("SELECT * FROM author",
                new AuthorRowMapper());
        return results.stream().toList();
    }

    @Override
    public void updateAuthor(Long newAuthor_id, Author author) {
        jdbcTemplate.update("UPDATE author SET author_id = ?, first_name = ?, last_name = ?, birth_date = ?, nationality = ? WHERE author_id = ?",
                author.getAuthor_id(),
                author.getFirst_name(),
                author.getLast_name(),
                author.getBirth_date(),
                author.getNationality(),
                newAuthor_id

        );
    }

    public static class AuthorRowMapper implements RowMapper<Author>{

        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Author.builder()
                    .author_id(rs.getLong("author_id"))
                    .first_name(rs.getString("first_name"))
                    .last_name(rs.getString("last_name"))
                    .birth_date(rs.getDate("birth_date").toLocalDate())
                    .nationality(rs.getString("nationality"))
                    .build();
        }
    }
}
