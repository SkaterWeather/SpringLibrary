package libraryapp.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import libraryapp.service.UserService;
import libraryapp.validation.annotation.ExistedEmail;

import org.springframework.beans.factory.annotation.Autowired;

public class ExistedEmailValidator implements ConstraintValidator<ExistedEmail, String> {

    @Autowired
    private UserService userService;

    @Override
    public void initialize(ExistedEmail constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return userService.getByEmail(email).isEmpty();
    }
}
