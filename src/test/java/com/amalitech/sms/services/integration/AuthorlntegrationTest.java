package com.amalitech.sms.services.integration;

import com.amalitech.sms.models.Author;
import com.amalitech.sms.services.AuthorService;
import com.amalitech.sms.services.utils.AuthorTestUtils;
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
public class AuthorlntegrationTest {


    private final AuthorService underTest;

    @Autowired
    public AuthorlntegrationTest(final AuthorService underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled(){
        Author author = AuthorTestUtils.createTestAuthorA();

        underTest.create(author);
        Optional<Author> result = underTest.findSingleAuthor(author.getAuthor_id());

        assertThat(result).isPresent();
        assertThat(result.get().getAuthor_id()).isEqualTo(author.getAuthor_id());


    }

    @Test
    public void testThatMultipleAuthorsCanBeCreatedAndRecalled(){
        Author authorA = AuthorTestUtils.createTestAuthorA();
        underTest.create(authorA);
        Author authorB = AuthorTestUtils.createTestAuthorB();
        underTest.create(authorB);
        Author authorC = AuthorTestUtils.createTestAuthorC();
        underTest.create(authorC);
        List<Author> result = underTest.findMany();

        assertThat(result).hasSize(3);
//        assertThat(result).isEqualTo(authorA)


    }

}
