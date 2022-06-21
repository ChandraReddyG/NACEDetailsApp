package com.deb.cib.nace.controller;

import com.deb.cib.nace.domain.Order;
import com.deb.cib.nace.exception.ErrorMessage;
import com.deb.cib.nace.exception.NaceOrderException;
import com.deb.cib.nace.service.NaceDetailsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/NACEDetails")
@Slf4j
@AllArgsConstructor
public class NaceDetailsController {
    NaceDetailsService naceDetailsService;

    @PostMapping("/order")
    public ResponseEntity<Void> addNaceDetails(@RequestBody Order order) {
        naceDetailsService.addNaceDetails(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/order/{id}")
    @ResponseStatus( HttpStatus.OK)
    public Order getNaceDetails(@PathVariable Integer id) {
        log.info("Getting the Order details for the id {}", id);
        Optional<Order> order =  naceDetailsService.getNaceDetails(id);
        if (order.isPresent()) {
            return order.get();
            }
        else {
            log.info("Order not found for the id {}", id);
            throw new NaceOrderException("Order Not found");
        }
    }
    @ExceptionHandler(NaceOrderException.class)
    @ResponseStatus( HttpStatus.BAD_REQUEST)
    public ErrorMessage handler(NaceOrderException ex)   {
        return new ErrorMessage("404", ex.getMessage());
    }

}
