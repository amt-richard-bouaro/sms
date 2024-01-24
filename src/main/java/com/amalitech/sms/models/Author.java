package com.amalitech.sms.models;

import lombok.Builder;

import java.time.LocalDate;


@Builder
public class Author {
        private Long author_id;
        private String first_name;
        private String last_name;
        private LocalDate birth_date;
        private String nationality;

    public Author(Long author_id, String first_name, String last_name, LocalDate birth_date, String nationality) {
        this.author_id = author_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.nationality = nationality;
    }

    public Author() {
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
