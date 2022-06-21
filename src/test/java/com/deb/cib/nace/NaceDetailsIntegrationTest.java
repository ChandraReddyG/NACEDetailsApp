  package com.deb.cib.nace;

  import com.deb.cib.nace.domain.Order;
  import com.deb.cib.nace.service.NaceDetailsService;
  import com.deb.cib.nace.util.OrderUtil;
  import com.fasterxml.jackson.databind.ObjectMapper;
  import org.junit.jupiter.api.Test;
  import org.junit.jupiter.api.extension.ExtendWith;
  import org.mockito.Mockito;
  import org.mockito.junit.jupiter.MockitoExtension;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
  import org.springframework.boot.test.mock.mockito.MockBean;
  import org.springframework.http.HttpHeaders;
  import org.springframework.http.MediaType;
  import org.springframework.test.web.servlet.MockMvc;
  import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
  import java.util.Optional;
  import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest
public class NaceDetailsIntegrationTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    NaceDetailsService naceDetailsService;
    public static Integer  FIRST_ORDER=12334;
    private static final ObjectMapper om = new ObjectMapper();

    @Test
    public void testGetNaceDetailsOrder() throws Exception {
        Order order = OrderUtil.getSampleOrder(FIRST_ORDER);
        Mockito.when(naceDetailsService.getNaceDetails(FIRST_ORDER)).thenReturn(Optional.of(order));
        mockMvc.perform(MockMvcRequestBuilders.get("/NACEDetails/order/{id}", FIRST_ORDER))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetNaceDetailsOrderWhenNotFound() throws Exception {
        Mockito.when(naceDetailsService.getNaceDetails(FIRST_ORDER)).thenReturn(Optional.empty());
        mockMvc.perform(MockMvcRequestBuilders.get("/NACEDetails/order/{id}", FIRST_ORDER))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testAddNaceDetails() throws Exception {
        Order order = OrderUtil.getSampleOrder(FIRST_ORDER);
        mockMvc.perform(MockMvcRequestBuilders.post("/NACEDetails/order/", order)
                .content(om.writeValueAsBytes(order))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}
