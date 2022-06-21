package com.deb.cib.nace.service;

import com.deb.cib.nace.domain.Order;
import com.deb.cib.nace.repository.NaceDetailsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class NaceDetailsService {

    NaceDetailsRepository naceDetailsRepository;

    public void addNaceDetails(Order order) {
       naceDetailsRepository.saveAndFlush(order);
    }

    public Optional<Order> getNaceDetails(Integer orderId) {
        return naceDetailsRepository.findById(orderId);
    }
}
