package com.amalitech.sms.interfaces;

import com.amalitech.sms.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookInterface {
    public void create(Book book);
    public Optional<Book> findSingleBook(String isbn);
    public List<Book> findMany();
}
