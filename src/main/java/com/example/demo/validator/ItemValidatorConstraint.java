package com.example.demo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ItemValidator.class)
@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ItemValidatorConstraint {
    String message() default "One of the Validations failed!!!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
