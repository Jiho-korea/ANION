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

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {
	
	//400
	@ExceptionHandler(RuntimeException.class)
	public String handle400(Model model, RuntimeException e){
		e.printStackTrace();
		model.addAttribute("errorCode","400");
		return "error/errorPage";
	}
	
	//500
	@ExceptionHandler({Exception.class, NullPointerException.class})
	public String handleAll(Model model, Exception e){
		e.printStackTrace();
		model.addAttribute("errorCode","500");
		return "error/errorPage";
	}

}