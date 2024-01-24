package com.amalitech.sms.services.integration;

import com.amalitech.sms.models.Author;
import com.amalitech.sms.models.Book;
import com.amalitech.sms.services.AuthorService;
import com.amalitech.sms.services.BookService;
import com.amalitech.sms.services.utils.AuthorTestUtils;
import com.amalitech.sms.services.utils.BookTestUtils;
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
public class BooklntegrationTest {

    private final BookService underTest;
    private final AuthorService authorService;

    @Autowired
    public BooklntegrationTest(BookService underTest, AuthorService authorService) {
        this.underTest = underTest;
        this.authorService = authorService;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled(){
        Book book = BookTestUtils.createTestBookA();

        Author author = AuthorTestUtils.createTestAuthorA();
        authorService.create(author);
        book.setAuthor_id(author.getAuthor_id());
        underTest.create(book);
        Optional<Book> result = underTest.findSingleBook(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get().getIsbn()).isEqualTo(book.getIsbn());
    }


    @Test
    public void testThatManyBooksCanBeCreatedAndRecalled(){
        Book bookA = BookTestUtils.createTestBookA();
        Book bookB = BookTestUtils.createTestBookB();
        Book bookC = BookTestUtils.createTestBookC();

        Author author = AuthorTestUtils.createTestAuthorA();
        authorService.create(author);

        bookA.setAuthor_id(author.getAuthor_id());
        bookB.setAuthor_id(author.getAuthor_id());
        bookC.setAuthor_id(author.getAuthor_id());

        underTest.create(bookA);
        underTest.create(bookB);
        underTest.create(bookC);

        List<Book> result = underTest.findMany();
        assertThat(result).hasSize(3);
    }

}
