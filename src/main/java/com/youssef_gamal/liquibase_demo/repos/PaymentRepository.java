package com.youssef_gamal.liquibase_demo.repos;

import com.youssef_gamal.liquibase_demo.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
