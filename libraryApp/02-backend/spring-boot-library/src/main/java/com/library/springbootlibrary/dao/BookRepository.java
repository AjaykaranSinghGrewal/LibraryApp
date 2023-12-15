package com.library.springbootlibrary.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;
import com.library.springbootlibrary.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

    //serch books by title method
    Page<Book> findByTitleContaining(@RequestParam("title") String title, Pageable pageable);

    //find all books based on BookIds
    //we're passing this function a list of book ids of type Long
    //when we pass a single argument spring knows how to search in the database but this time we're passing a list of IDs hence, we have to write a query for spring
    @Query("select o from Book o where id in :book_ids")
    List<Book> findBooksByBookIds(@Param("book_ids") List<Long> bookId);
}
