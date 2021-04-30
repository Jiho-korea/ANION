
package controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.NoHandlerFoundException;

import petProject.exception.EmailcodeDeleteException;
import petProject.exception.EmailcodeNotMatchException;
import petProject.exception.EmailcodeNullException;
import petProject.exception.MemberAuthUpdateException;
import petProject.exception.MemberIdUpdateException;
import petProject.service.EmailValidService;
import petProject.vo.Emailcode;
import petProject.vo.ScriptWriter;

@ControllerAdvice
public class GlovalExceptionController {
	
	//400
	@ExceptionHandler(RuntimeException.class)
	public String handle400(){
		return "error/errorPage400";
	}
	
	//500
	@ExceptionHandler(Exception.class)
	public String handleAll(){
		return "error/errorPage500";
	}

}
