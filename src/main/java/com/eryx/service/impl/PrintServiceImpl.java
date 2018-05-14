package com.eryx.service.impl;
/**
 * Print Service Implemention
 * @author Eryx
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.eryx.common.DictParam;
import com.eryx.service.IPrintService;
import com.eryx.vo.PrintVo;

@Service
public class PrintServiceImpl implements IPrintService {
	@Override
	public String printMultiple(int countNum, int ruleNum, String str){
		//if countNum is the Multiple of ruleNum return str
		if(countNum%ruleNum == 0){
			return str;
		}
		//else just return the number
		return countNum+"";
	}
	@Override
	public String printInclude(int countNum, int ruleNum, String str){
		//if countNum is including ruleNum return str
		if((countNum+"").indexOf(ruleNum+"")>-1){
			return str;
		}
		//else just return the number
		return countNum+"";
	}
	@Override
	public List<String> printAll(PrintVo pv){
		List<String> result = new ArrayList<>();	//result to print
		String[] ruleArray = pv.getRules().split(",");	//the rules
    	for(int i=pv.getStartNum(); i<pv.getEndNum()+1; i++){
    		Set<String> printSet = new HashSet<String>();	//to store one result which may be multi-value, use set to filter the repetitive value
    		int ruleNum;	//the rule number which rule base on
    		for(String rule : ruleArray){
    			ruleNum=Integer.parseInt(rule.substring(0,1));
    			if(rule.indexOf("M")>-1){
    				//the multiple rule
    				printSet.add(printMultiple(i, ruleNum, DictParam.getDictItemName(ruleNum)));
    			}else if(rule.indexOf("I")>-1){
    				//the include rule
    				printSet.add(printInclude(i, ruleNum, DictParam.getDictItemName(ruleNum)));
    			}
    		}
    		//if be multiple or be included, the number will be replaced, remove the number
    		if(printSet.size()>1){
    			printSet.remove(String.valueOf(i));
    		}
    		result.add(printSet.toString());
    	}
    	return result;
	}
}
