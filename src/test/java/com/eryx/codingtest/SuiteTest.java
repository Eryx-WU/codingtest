package com.eryx.codingtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(value = org.junit.runners.Suite.class)
@SpringBootTest
@SuiteClasses(value = {
		PrintMultipleTestA.class,
		PrintMultipleTestB.class,
		PrintIncludeTestA.class,
		PrintIncludeTestB.class,
        PrintAllTestA.class,
        PrintAllTestB.class
})
public class SuiteTest {

	@Test
	public void contextLoads() {
	}

}
