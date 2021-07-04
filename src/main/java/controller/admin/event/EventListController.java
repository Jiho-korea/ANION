/*
========================================================================
파    일    명 : EventListController.java
========================================================================
작    성    자 : 임원석
작    성    일 : 2021.07.04
작  성  내  용 : 이벤트 목록을 위한 Controller
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
