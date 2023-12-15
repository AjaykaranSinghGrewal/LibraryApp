package com.library.springbootlibrary.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.springbootlibrary.entity.Checkout;

public interface CheckoutRepository extends JpaRepository<Checkout,Long>{

    Checkout findByUserEmailAndBookId(String userEmail, Long bookId);

    List<Checkout> findBooksByUserEmail(String userEmail);

    //@Modifying
    //@Query("delete from Checkout where book_id in :book_id")
    //void deleteAllByBookId(@Param("book_id") Long bookId);
}
