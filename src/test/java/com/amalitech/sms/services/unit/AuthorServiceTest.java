package com.amalitech.sms.services.unit;

import com.amalitech.sms.models.Author;
import com.amalitech.sms.services.AuthorService;
import com.amalitech.sms.services.utils.AuthorTestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorService underTest;

    @Test
    public void testThatCreateAuthorGenerateCorrectSQL(){
        Author author = AuthorTestUtils.createTestAuthorA();

        underTest.create(author);

        verify(jdbcTemplate).update(
                eq("INSERT INTO author(author_id, first_name,last_name,birth_date,nationality) VALUES (?,?, ?, ?, ?)"),
                eq(1L),
                eq("Kwame"),
                eq("Bolt"),
                eq(LocalDate.parse("2024-01-09")),
                eq("Mali"));
    }


    @Test
    public void testThatFindSingleAuthorReturnsCorrectRecord(){
            underTest.findSingleAuthor(1L);

            verify(jdbcTemplate).query(
                    eq("SELECT * FROM author WHERE author_id = ? LIMIT 1"),
                    ArgumentMatchers.<AuthorService.AuthorRowMapper>any(),
                    eq(1L)  );
    }

    @Test
    public void testThatFindManyAuthorReturnsCorrectRecords(){
            underTest.findMany();

            verify(jdbcTemplate).query(
                    eq("SELECT * FROM author"),
                    ArgumentMatchers.<AuthorService.AuthorRowMapper>any());


    }

    @Test
    public void testThatUpdateAuthorReturnsCorrectQuery(){
            Author author = AuthorTestUtils.createTestAuthorA();
            author.setFirst_name("George");
            author.setNationality("USA");

            underTest.updateAuthor(122L, author);

            verify(jdbcTemplate).update(
                    eq("UPDATE author SET author_id = ?, first_name = ?, last_name = ?, birth_date = ?, nationality = ? WHERE author_id = ?"),
                    eq(author.getAuthor_id()),
                    eq(author.getFirst_name()),
                    eq(author.getLast_name()),
                    eq(author.getBirth_date()),
                    eq(author.getNationality()),
                    eq(122L));


    }


}
