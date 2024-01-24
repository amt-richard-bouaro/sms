package com.amalitech.sms.services.utils;

import com.amalitech.sms.models.Book;

import java.time.LocalDate;

public final class BookTestUtils {

    private BookTestUtils(){}
    public static Book createTestBookA(){
        Book book = Book.builder()
                .title("Journey To The West")
                .genre("Comic")
                .isbn("1903-4374-483")
                .publication_date(LocalDate.parse("2024-03-01"))
                .author_id(1L)
                .build();

        return book;
    }
    public static Book createTestBookB(){
        Book book = Book.builder()
                .title("The End")
                .genre("History")
                .isbn("3274-4749-493")
                .publication_date(LocalDate.parse("2000-09-09"))
                .author_id(1L)
                .build();

        return book;
    }
    public static Book createTestBookC(){
        Book book = Book.builder()
                .title("Financial Freedom")
                .genre("Life Style")
                .isbn("1903-4374-473")
                .publication_date(LocalDate.parse("2024-03-01"))
                .author_id(1L)
                .build();

        return book;
    }

}
