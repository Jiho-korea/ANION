/*
========================================================================
파    일    명 : NoseprintImageEventGuidanceController.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.07.04
작  성  내  용 : 비문 사진 등록 안내 컨트롤러
========================================================================
*/
package controller.event.noseprint.image;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoseprintImageEventGuidanceController {

	private static final Logger logger = LoggerFactory.getLogger(NoseprintImageEventGuidanceController.class);

	@RequestMapping("/guidance/npevent")
	public String getNoseprintEventGuidance(HttpSession session, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Cookie cookie_check_event_guidance = new Cookie("checkEventGuidance", "check");
		cookie_check_event_guidance.setPath("/");
		cookie_check_event_guidance.setMaxAge(60 * 60 * 24 * 1);

		response.addCookie(cookie_check_event_guidance);

		return "event/noseprint/pet/image/eventGuidance";
	}
}