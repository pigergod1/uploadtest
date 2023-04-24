package team3.meowie.member.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

@Component
public class MatchedPasswordValidator implements ConstraintValidator<MatchedPassword, Object>{

	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context) {
		return false;
	}

}
