package com.gm;

import com.gm.statistical.StatisticalServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StatisticalServiceApplication.class)
public class StatisticalServiceApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("test OK");
	}

}
