package com.amalitech.sms.repositories;

import com.amalitech.sms.models.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    @Query("SELECT a Author a WHERE ")
    public Iterable<Author> findAuthorsWithDobLaterThan();

}
