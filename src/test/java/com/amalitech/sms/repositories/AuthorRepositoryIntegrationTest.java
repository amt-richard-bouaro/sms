package com.amalitech.sms.repositories;

import com.amalitech.sms.models.Author;
import com.amalitech.sms.repositories.AuthorRepository;
import com.amalitech.sms.utils.AuthorTestUtils;
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
public class AuthorRepositoryIntegrationTest {


    private final AuthorRepository underTest;

    @Autowired
    public AuthorRepositoryIntegrationTest(final AuthorRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled(){
        Author author = AuthorTestUtils.createTestAuthorA();

        underTest.save(author);
        Optional<Author> result = underTest.findById(author.getAuthor_id());

        assertThat(result).isPresent();
        assertThat(result.get().getAuthor_id()).isEqualTo(author.getAuthor_id());


    }

    @Test
    public void testThatMultipleAuthorsCanBeCreatedAndRecalled(){
        Author authorA = AuthorTestUtils.createTestAuthorA();
        underTest.save(authorA);
        Author authorB = AuthorTestUtils.createTestAuthorB();
        underTest.save(authorB);
        Author authorC = AuthorTestUtils.createTestAuthorC();
        underTest.save(authorC);
        Iterable<Author> result = underTest.findAll();

        assertThat(result).hasSize(3);
//        assertThat(result).isEqualTo(authorA)


    }

}
