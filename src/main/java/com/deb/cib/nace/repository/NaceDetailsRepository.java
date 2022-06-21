package com.deb.cib.nace.repository;

import com.deb.cib.nace.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaceDetailsRepository extends JpaRepository<Order, Integer> {
}
