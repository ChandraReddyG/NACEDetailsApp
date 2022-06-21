package com.deb.cib.nace.controller;

import com.deb.cib.nace.domain.Order;
import com.deb.cib.nace.service.NaceDetailsService;
import com.deb.cib.nace.util.OrderUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(MockitoExtension.class)
public class NaceDetailsControllerTest {

    @InjectMocks
    NaceDetailsController naceDetailsController;
    @Mock
    NaceDetailsService naceDetailsService;

    public static Integer  FIRST_ORDER=12334;

    @Test
    public void testGetNaceDetailsOrder() {
        Order expectedOrder = OrderUtil.getSampleOrder(FIRST_ORDER);
        Mockito.when(naceDetailsService.getNaceDetails(FIRST_ORDER)).thenReturn(Optional.of(expectedOrder));
        Order order = naceDetailsController.getNaceDetails(FIRST_ORDER);
        assertThat(order).isEqualTo(expectedOrder);
    }

    @Test
    public void testAddNaceDetails() {
        Order order = OrderUtil.getSampleOrder(FIRST_ORDER);
        ResponseEntity<Void> responseEntity = naceDetailsController.addNaceDetails(order);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
     }

}
