package com.java38.spring_framework.exercises.task10;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByTitle(String title);
    Book findFirstByISBN(String isbn);
    Book findByAuthorAndISBN(String author, String isbn);
    List<Book> findTop3ByAuthorOrderByPagesNumDesc(String author);
    List<Book> findAllByTitleStartingWith(String title);
    List<Book> findAllByPagesNumBetween(int start, int end);

    @Query("SELECT b FROM books b WHERE b.pagesNum >= :pagesNum")
    List<Book> findWherePagesNumIsGreaterThanX(@Param("pagesNum")Integer pagesNum);

}