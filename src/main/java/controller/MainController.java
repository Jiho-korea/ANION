package controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import petProject.service.PetListService;
import petProject.vo.Owner;
import petProject.vo.Pet;

@Controller
@RequestMapping("/main")
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Resource(name = "petNameListService")
	PetListService petListService;

	@GetMapping("/list")
	public String listPet(HttpSession session, Model model) {
		Owner owner = (Owner) session.getAttribute("login");
		try {
			List<Pet> petList = petListService.selectPetList(owner.getOwnerId());
			model.addAttribute("petList", petList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/main/list";
	}

}
