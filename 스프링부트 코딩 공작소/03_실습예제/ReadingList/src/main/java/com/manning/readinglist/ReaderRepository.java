package com.manning.readinglist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReaderRepository extends JpaRepository<Reader, String> {
    List<Book> findByReader(Reader reader);
}
