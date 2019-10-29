package libraryapp.validation.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import libraryapp.validation.ExistedEmailValidator;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ExistedEmailValidator.class)
public @interface ExistedEmail {
    String message() default "That email already exists!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
