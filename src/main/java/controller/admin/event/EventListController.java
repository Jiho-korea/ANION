/*
========================================================================
파    일    명 : MemberListContoller.java
========================================================================
작    성    자 : 강지호, 임원석
작    성    일 : 2020.xx.xx
작  성  내  용 : 멤버 리스트 Controller
========================================================================
=============================== 함  수  설  명  ===============================
listPet : 세션에 저장되어있는 회원의 펫 목록 출력하는 함수
========================================================================
*/
package controller.admin.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/event")
public class EventListController {

	private static final Logger logger = LoggerFactory.getLogger(EventListController.class);

	@GetMapping("/list")
	public String listEvent() {

		return "/admin/event/list";
	}

	@GetMapping("/event")
	public String listEvent1() {

		return "/admin/event/event";
	}

}
