package com.youssef_gamal.liquibase_demo.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youssef_gamal.liquibase_demo.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
