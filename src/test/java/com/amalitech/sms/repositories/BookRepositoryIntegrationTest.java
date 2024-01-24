package com.amalitech.sms.repositories;

import com.amalitech.sms.models.Author;
import com.amalitech.sms.models.Book;
import com.amalitech.sms.utils.AuthorTestUtils;
import com.amalitech.sms.utils.BookTestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookRepositoryIntegrationTest {

    private final BookRepository underTest;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookRepositoryIntegrationTest(BookRepository underTest, AuthorRepository authorRepository) {
        this.underTest = underTest;
        this.authorRepository = authorRepository;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled(){
        Author author = AuthorTestUtils.createTestAuthorA();

        Book book = BookTestUtils.createTestBookA(author);

        underTest.save(book);
        Optional<Book> result = underTest.findById(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get().getIsbn()).isEqualTo(book.getIsbn());
    }


    @Test
    public void testThatManyBooksCanBeCreatedAndRecalled(){
        Author author = AuthorTestUtils.createTestAuthorA();

        Book bookA = BookTestUtils.createTestBookA(author);
        Book bookB = BookTestUtils.createTestBookB(author);
        Book bookC = BookTestUtils.createTestBookC(author);

        underTest.save(bookA);
        underTest.save(bookB);
        underTest.save(bookC);

        Iterable<Book> result = underTest.findAll();
        assertThat(result).hasSize(3);
    }
//
}
