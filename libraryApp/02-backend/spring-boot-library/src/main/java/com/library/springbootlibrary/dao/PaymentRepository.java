package com.library.springbootlibrary.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.springbootlibrary.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    
    Payment findByUserEmail(String userEmail);
}
