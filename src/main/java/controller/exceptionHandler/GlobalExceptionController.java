/*
========================================================================
파    일    명 : GlobalExceptionController.java
========================================================================
작    성    자 : 정세진
작    성    일 : 2021.07.19
작  성  내  용 : 팝업 컨트롤러 생성
========================================================================
*/
package controller.exceptionHandler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionController {
	
	//400
	@ExceptionHandler(RuntimeException.class)
	public String hnadle400(Model model){
		model.addAttribute("400","400");
		return "error/400error";
	}
	
	//500
	@ExceptionHandler(Exception.class)
	public String handleAll(Model model){
		model.addAttribute("500","500");
		return "error/500error";
	}

}

