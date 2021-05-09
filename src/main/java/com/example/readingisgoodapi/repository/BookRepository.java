package com.example.readingisgoodapi.repository;

import com.example.readingisgoodapi.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByBookIdAndActive(Long bookid, boolean isActive);

    List<Book> findByActive(boolean isActive);
}
