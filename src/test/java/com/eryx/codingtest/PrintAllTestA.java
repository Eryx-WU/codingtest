package com.eryx.codingtest;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.eryx.common.DictParam;
import com.eryx.service.IPrintService;
import com.eryx.vo.PrintVo;
/**
 * Print All Test Case A
 * @author Eryx
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PrintAllTestA {
	@Autowired
    private IPrintService printService;
	
	@Before
	public void before() {
		//init the dictionary value
		DictParam.initDictParam();
	}
	
	@Test
	public void contextLoads() {
		String expect = "[[1], [2], [Fizz], [4], [Buzz], [Fizz], [7], [8], [Fizz], [Buzz], [11], [Fizz], [Fizz], [14], [Fizz, Buzz]]";
		PrintVo pv = new PrintVo();
		pv.setStartNum(1);
		pv.setEndNum(15);
		pv.setRules("3M,3I,5M,5I");
		String result = printService.printAll(pv).toString();
		System.out.println("result="+result);
		System.out.println("expect="+expect);
		assertTrue(expect.equals(result));
	}

}
