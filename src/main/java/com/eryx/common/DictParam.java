package com.eryx.common;
/**
 * Dictionary common tool
 * @author Eryx
 */
import java.util.HashMap;
import java.util.Map;

public class DictParam {

	private static Map<Integer, String> dictParam = new HashMap<>();
	
	/**
	 * init the dictionary value
	 */
	public static void initDictParam(){
		dictParam.put(3, "Fizz");
		dictParam.put(5, "Buzz");
	}
	
	/**
	 * get the dictionary value
	 * @param dictID
	 * @return dictName
	 */
	public static String getDictItemName(Integer dictID){
		String dictName = dictParam.get(dictID);
		return dictName == null ? "":dictName;
	}
	
}
