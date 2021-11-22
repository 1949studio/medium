package me.mrtoke.fbook.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import me.mrtoke.fbook.entities.Member;
import me.mrtoke.fbook.services.MemberServices;

public class UniqueValidator implements ConstraintValidator<UniqueValue, String> {
	
	@Autowired
	MemberServices memberService;
	
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Member member = memberService.findByEmail(value);
		if(member != null)
			return false;
		return true;
	}

}
