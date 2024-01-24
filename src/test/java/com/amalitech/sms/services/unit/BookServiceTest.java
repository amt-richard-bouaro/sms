package com.amalitech.sms.services.unit;

import com.amalitech.sms.models.Author;
import com.amalitech.sms.models.Book;
import com.amalitech.sms.services.AuthorService;
import com.amalitech.sms.services.BookService;
import com.amalitech.sms.services.utils.AuthorTestUtils;
import com.amalitech.sms.services.utils.BookTestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookService underTest;

    @Test
    public void testThatCreateBookGenerateCorrectSQL(){

        Book book = BookTestUtils.createTestBookA();

        underTest.create(book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO book(title, genre, isbn, publication_date, author_id) VALUES(?,?,?,?,?)"),
                eq(book.getTitle()),
                eq(book.getGenre()),
                eq(book.getIsbn()),
                eq(book.getPublication_date()),
                eq(book.getAuthor_id())
        );
    }

    @Test
    public void testThatFindSingleBookGenerateCorrectSQL(){

        underTest.findSingleBook("1903-4374-483");

        verify(jdbcTemplate).query(
                eq("SELECT * FROM book WHERE isbn = ? LIMIT 1"),
                ArgumentMatchers.<BookService.BookRowMapper>any(),
                eq("1903-4374-483")
        );
    }

    @Test
    public void testThatFindManyBookGenerateCorrectSQL(){
        underTest.findMany();

        verify(jdbcTemplate).query(
                eq("SELECT * FROM book"),
                ArgumentMatchers.<BookService.BookRowMapper>any()
        );
    }
}
