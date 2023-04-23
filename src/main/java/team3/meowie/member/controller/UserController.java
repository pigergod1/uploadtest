package team3.meowie.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import team3.meowie.member.dto.UserDto;
import team3.meowie.member.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/registration")
	public String showRegistrationForm(Model model) {
		UserDto userDto = new UserDto();
		model.addAttribute("user", userDto);
		return "member/registration";
	}
	
	@PostMapping("/registration/post")
	public String showRegistrationForm(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, RedirectAttributes redirect) {
		if(result.hasErrors()) {
			Map<String, String> errors = new HashMap<>();
			List<FieldError> errorList = result.getFieldErrors();
			FieldError error = null;
			for(int i = 0; i < errorList.size(); i++) {
				error = errorList.get(i);
				errors.put(error.getField(), error.getDefaultMessage());
			}
			redirect.addFlashAttribute("error", errors);
			return "redirect:/registration";
		}
		userService.registerNewUser(userDto);
		return "member/registration";
	}
}
