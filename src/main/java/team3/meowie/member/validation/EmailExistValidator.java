package team3.meowie.member.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import team3.meowie.member.service.UserService;

@Component
public class EmailExistValidator implements ConstraintValidator<ExistEmail, String>{

	@Autowired
	private UserService userService;
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		return userService.findUserByEmail(email) == null;
	}

}
