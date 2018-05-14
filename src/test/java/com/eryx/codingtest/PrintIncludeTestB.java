package com.eryx.codingtest;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.eryx.service.IPrintService;
/**
 * Print Include Test Case B
 * @author Eryx
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PrintIncludeTestB {
	@Autowired
    private IPrintService printService;
	
	@Test
	public void contextLoads() {
		String result="";
		result = printService.printInclude(503, 5, "Buzz");
		assertTrue(result.equals("Buzz"));
	}

}
