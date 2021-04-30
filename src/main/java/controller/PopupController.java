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
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/popup")
public class PopupController {

	@GetMapping("")
	public String validForm() {

		return "popup/popup1";
	}

	@GetMapping("/1")
	public String valid() throws Exception {
		/*
		 * 
		 * 처리 로직 구현
		 */

		return "popup/popup1";
	}
}
