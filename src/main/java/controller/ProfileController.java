package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import petProject.vo.AuthInfo;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	@GetMapping
	public String profile(HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");
		
		model.addAttribute("authInfo", authInfo);
		
		return "info/profile";
	}
}
