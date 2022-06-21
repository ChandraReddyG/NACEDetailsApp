package com.deb.cib.nace;

import com.deb.cib.nace.controller.NaceDetailsController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class NaceDetailsAppApplicationTests {

	@Autowired
	NaceDetailsController naceDetailsController;

	@Test
	void contextLoads() {
		assertThat(naceDetailsController).isNotNull();
	}

}
