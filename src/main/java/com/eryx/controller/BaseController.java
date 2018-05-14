package com.eryx.controller;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
/**
 * Base Contorller
 * @author Eryx
 */
public class BaseController {

    protected String getErrorMsg(BindingResult br) {
		if(br.hasErrors()){
			String msg = "";
			for (int i = br.getFieldErrors().size() - 1; i >= 0; i--) {
				FieldError fe = br.getFieldErrors().get(i);
				msg += fe.getDefaultMessage() + "、";
			}
			msg = msg.substring(0,msg.length() -1);
			return msg;
		}else{
			return null;
		}
	}

    protected String listToString(List list, String separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(separator);
            }
        }
        return sb.toString();
    }
}
