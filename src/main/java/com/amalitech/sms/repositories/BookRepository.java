package com.amalitech.sms.repositories;

import com.amalitech.sms.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository  extends CrudRepository<Book, String> {
}
