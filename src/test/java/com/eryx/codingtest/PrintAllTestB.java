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
 * Print All Test Case B
 * @author Eryx
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PrintAllTestB {
	@Autowired
    private IPrintService printService;
	
	@Before
	public void before() {
		//init the dictionary value
		DictParam.initDictParam();
	}
	
	@Test
	public void contextLoads() {
		String expect = "[[Buzz], [51], [52], [Fizz], [54], [Buzz], [56], [57], [58], [59], [Buzz]]";
		PrintVo pv = new PrintVo();
		pv.setStartNum(50);
		pv.setEndNum(60);
		pv.setRules("3I,5M");
		String result = printService.printAll(pv).toString();
		System.out.println("result="+result);
		System.out.println("expect="+expect);
		assertTrue(expect.equals(result));
	}

}
