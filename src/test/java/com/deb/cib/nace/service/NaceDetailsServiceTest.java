package com.deb.cib.nace.service;


import com.deb.cib.nace.domain.Order;
import com.deb.cib.nace.repository.NaceDetailsRepository;
import com.deb.cib.nace.util.OrderUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class NaceDetailsServiceTest {

    public static Integer  FIRST_ORDER=12334;

    @InjectMocks
    NaceDetailsService naceDetailsService;
    @Mock
    NaceDetailsRepository naceDetailsRepository;

    @Test
    public void testGetNaceDetails() {
        Order order = OrderUtil.getSampleOrder(FIRST_ORDER);
        Mockito.when(naceDetailsRepository.findById(FIRST_ORDER)).thenReturn(Optional.of(order));
        Optional<Order> orderDetails =  naceDetailsService.getNaceDetails(FIRST_ORDER);
        assertThat(orderDetails.isPresent()).isTrue();
    }

    @Test
    public void testAddNaceDetails() {
        Order order = OrderUtil.getSampleOrder(FIRST_ORDER);
        naceDetailsService.addNaceDetails(order);
        Mockito.verify(naceDetailsRepository, Mockito.times(1)).saveAndFlush(order);
    }
}