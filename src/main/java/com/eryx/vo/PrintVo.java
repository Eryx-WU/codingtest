package com.eryx.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

public class PrintVo {
	/**the start number to count*/
	@NotNull(message = "start number should be filled!")
	@Range(min=1, max=9999,message = "start number should be 1~9999!")
    private Integer startNum=1;
	
	/**the end number to count*/
	@NotNull(message = "end number should be filled!")
	@Range(min=1, max=9999,message = "end number should be 1~9999!")
    private Integer endNum=100;
	
    /**
     * the rules:
     * [num][method],[num][method]..
     * for exmaple:3M,3I,5M,5I
     * 'M' means Multiple
     * 'I' means Include
     */
	@NotNull(message = "rules should be selected!")
    private String rules;
    
	public Integer getStartNum() {
		return startNum;
	}
	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}
	public Integer getEndNum() {
		return endNum;
	}
	public void setEndNum(Integer endNum) {
		this.endNum = endNum;
	}
	public String getRules() {
		return rules;
	}
	public void setRules(String rules) {
		this.rules = rules;
	}
    

}