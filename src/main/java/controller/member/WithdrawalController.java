package controller.member;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import petProject.exception.WithdrawalException;
import petProject.service.member.WithdrawalService;
import petProject.vo.request.WithdrawalRequest;

@Controller
@RequestMapping("/withdrawal")
public class WithdrawalController {

	@Resource(name = "withdrawalService")
	WithdrawalService withdrawalService;

	@GetMapping
	public String withdrawalPage(WithdrawalRequest withdrawalRequest) {
		return "member/profile/withdrawal";
	}

	@PostMapping
	public String withdrawalDone(@RequestParam("check") boolean check, WithdrawalRequest withdrawalRequest) {
		try {
			withdrawalService.insertComment(withdrawalRequest);
		} catch (WithdrawalException e) {
			e.printStackTrace();
			return "home/main";
		}
		return "home/main";
	}
}
