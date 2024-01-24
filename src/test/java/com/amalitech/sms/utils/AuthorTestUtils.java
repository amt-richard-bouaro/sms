package com.amalitech.sms.utils;

import com.amalitech.sms.models.Author;

import java.time.LocalDate;

public final class AuthorTestUtils {
    private AuthorTestUtils(){}
    public static Author createTestAuthorA(){
        Author author = Author.builder()
                .author_id(1L)
                .birth_date(LocalDate.parse("2024-01-09"))
                .first_name("Kwame")
                .last_name("Bolt")
                .nationality("Mali")
                .build();
        return author;
    }
    public static Author createTestAuthorB(){
        Author author = Author.builder()
                .author_id(2L)
                .birth_date(LocalDate.parse("1994-02-22"))
                .first_name("Judith")
                .last_name("Hanson")
                .nationality("Germany")
                .build();
        return author;
    }
    public static Author createTestAuthorC(){
        Author author = Author.builder()
                .author_id(3L)
                .birth_date(LocalDate.parse("2016-11-19"))
                .first_name("Alice")
                .last_name("Arthur")
                .nationality("Japan")
                .build();
        return author;
    }
}
