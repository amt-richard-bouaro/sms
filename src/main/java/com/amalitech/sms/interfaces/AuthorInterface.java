package com.amalitech.sms.interfaces;

import com.amalitech.sms.models.Author;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface AuthorInterface {
    public void create(Author author);
    public Optional<Author> findSingleAuthor(Long id);
    public List<Author> findMany();

    public void updateAuthor(Long newAuthor_id,Author author);

}
