package controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import petProject.exception.OwnerNotFoundException;
import petProject.service.LoginService;
import petProject.vo.LoginRequest;
import petProject.vo.Owner;

@Controller
@RequestMapping("/login/login")
public class LoginController {

	@Resource(name = "loginService")
	LoginService loginService;

	public LoginController() {
		super();
	}

	@GetMapping
	public String loginForm(@ModelAttribute("loginRequest") LoginRequest loginRequest,
			@CookieValue(value = "memory", required = false) Cookie cookie) {
		// 荑좏궎瑜� �씠�슜�븳 �븘�씠�뵒 湲곗뼲�븯湲�
		if (cookie != null) {
			loginRequest.setId(cookie.getValue());
			loginRequest.setMemory(true);
		}
		return "login/loginFormPage";
	}

	@PostMapping
	public String login(@Valid LoginRequest loginRequest, Errors errors, HttpSession session,
			HttpServletResponse response) {
		if (errors.hasErrors()) {
			return "login/loginFormPage";
		}

		try {
			Owner owner = loginService.selectByIdPassword(loginRequest);

			session.setAttribute("login", owner);

			Cookie memoryCookie = new Cookie("memory", loginRequest.getId());
			memoryCookie.setPath("/");
			if (loginRequest.isMemory()) {
				memoryCookie.setMaxAge(60 * 60 * 24 * 30);
			} else {
				memoryCookie.setMaxAge(0);
			}
			response.addCookie(memoryCookie);

			return "redirect:/home";
		} catch (OwnerNotFoundException e) {
			errors.reject("notfound");
			return "login/loginFormPage";
		} catch (Exception e) {
			e.printStackTrace();
			return "login/loginFormPage";
		}
	}
}
