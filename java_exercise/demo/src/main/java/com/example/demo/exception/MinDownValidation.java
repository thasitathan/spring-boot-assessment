package com.example.demo.exception;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = MinDownValidator.class)
public @interface MinDownValidation {
    // annotation used to determine if downpayment is atleast 5% of purchase price
    public String message() default "Downpayment must be 5% of purchase price";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
