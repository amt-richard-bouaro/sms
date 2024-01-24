DROP TABLE IF EXISTS "book";
DROP TABLE IF EXISTS "author";

CREATE TABLE author (
                        author_id SERIAL NOT NULL,
                        first_name VARCHAR(50) NOT NULL,
                        last_name VARCHAR(50) NOT NULL,
                        birth_date DATE,
                        nationality VARCHAR(50),
                        CONSTRAINT  "author_pkey" PRIMARY KEY("author_id")
);

CREATE TABLE book (
                      title VARCHAR(100) NOT NULL,
                      publication_date DATE,
                      isbn VARCHAR(13) ,
                      genre VARCHAR(50),
                        author_id SERIAL,
                      CONSTRAINT  "book_pkey" PRIMARY KEY("isbn"),
                      CONSTRAINT  "fk_author" FOREIGN KEY(author_id) REFERENCES author(author_id)
);
