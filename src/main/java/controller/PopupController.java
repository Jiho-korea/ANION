/*
========================================================================
파    일    명 : PopupController.java
========================================================================
작    성    자 : 임원석
작    성    일 : 2021.04.30
작  성  내  용 : 팝업 컨트롤러 생성
========================================================================
*/
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/popup")
public class PopupController {

	@GetMapping("/popup")
	public String validForm() {

		return "popup/popup";
	}

	@PostMapping("/popup")
	public String valid() throws Exception {

		return "popup/popup";
	}
}
