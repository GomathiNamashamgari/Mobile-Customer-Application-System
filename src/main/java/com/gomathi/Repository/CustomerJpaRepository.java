package com.gomathi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gomathi.Model.Customer;

public interface CustomerJpaRepository extends JpaRepository<Customer,Integer> {
}

