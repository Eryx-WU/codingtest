package com.eryx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eryx.common.DictParam;
import com.eryx.service.IPrintService;
import com.eryx.vo.PrintVo;
/**
 * Print Contorller
 * @author Eryx
 */
@RestController
public class PrintController extends BaseController{
	@Autowired
    private IPrintService printService;
	
	/**
	 * Print Method
	 * @Params PrintVo pv [int startNum, int endNum, String rules]
	 * rules:[num][method],[num][method]..
     * for exmaple: 3M,3I,5M,5I
     * 'M' means Multiple
     * 'I' means Include
	 * @Params BindingResult br
	 * @Params HttpServletRequest request
	 * @return String result
	 */
    @RequestMapping("/print")
    public String print(@Valid PrintVo pv,  BindingResult br, HttpServletRequest request) {
    	//to valid the input field
    	if(br.hasErrors()){
    		return getErrorMsg(br);
    	}
    	//init the dictionary value
    	DictParam.initDictParam();
    	
    	//get and print the result
    	StringBuilder result = new StringBuilder();
    	result.append("number: "+pv.getStartNum()+"~"+pv.getEndNum()+"<br>");
    	result.append("rule: "+pv.getRules()+"<br>");
    	result.append("result: <br>");
    	result.append(listToString(printService.printAll(pv),"<br>"));
        return result.toString();
    }
    
}