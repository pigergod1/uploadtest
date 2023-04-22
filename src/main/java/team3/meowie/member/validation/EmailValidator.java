package team3.meowie.member.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import team3.meowie.member.service.UserService;

@Component
public class EmailValidator implements ConstraintValidator<ValidEmail, String>{

	@Autowired
	private UserService userService;
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		return false;
//		return (userService.findUserByEmail(email) == null);
	}

}
