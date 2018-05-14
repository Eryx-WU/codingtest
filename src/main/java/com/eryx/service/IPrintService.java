package com.eryx.service;
/**
 * Print Service
 * @author Eryx
 */
import java.util.List;

import com.eryx.vo.PrintVo;

public interface IPrintService {
	/**
	 * Print one number with Multiple rule
	 * @param countNum : the current number to count 
	 * @param ruleNum : the rule number which rule base on
	 * @param str: the replace string
	 * @return
	 */
	public String printMultiple(int countNum, int ruleNum, String str);
	
	/**
	 * Print one number with Include rule
	 * @param countNum : the current number to count 
	 * @param ruleNum : the rule number which rule base on
	 * @param str: the replace string
	 * @return
	 */
	public String printInclude(int countNum, int ruleNum, String str);
	
	/**
	 * Print all number with the rules
	 * @Params PrintVo pv [int startNum, int endNum, String rules]
	 * startNum: the start number
	 * endNum: the end number
	 * rules:[num][method],[num][method]..
     * for exmaple: 3M,3I,5M,5I
     * 'M' means Multiple
     * 'I' means Include
	 * @return
	 */
	public List<String> printAll(PrintVo pv);
}
