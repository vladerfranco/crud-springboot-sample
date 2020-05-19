CREATE SCHEMA spring;

CREATE SEQUENCE hibernate_sequence INCREMENT 1;

CREATE TABLE spring.movie (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    title VARCHAR(255) NOT NULL,
    synopsis VARCHAR(255),
    release_year NUMERIC(4,0) NOT NULL,
    producer_name VARCHAR(255),
    protagonist_name VARCHAR(255)
);

CREATE TABLE spring.rating (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    rater VARCHAR(255) NOT NULL,
    comment VARCHAR(255),
    note DECIMAL NOT NULL,
    movie_id BIGINT NOT NULL,
    FOREIGN KEY (movie_id) REFERENCES spring.movie (id)
);