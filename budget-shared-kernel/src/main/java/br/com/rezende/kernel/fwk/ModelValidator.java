package br.com.rezende.kernel.fwk;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

import java.util.Set;

import static jakarta.validation.Validation.buildDefaultValidatorFactory;

public abstract class ModelValidator {

    private static Validator validator = buildDefaultValidatorFactory().getValidator();

    protected void validate(){
        Set<ConstraintViolation<ModelValidator>> violations = validator.validate(this);
        violations.forEach(constraint -> {throw new IllegalArgumentException(constraint.getMessage());});
    }

    protected void validateProperty(String property){
        Set<ConstraintViolation<ModelValidator>> violations = validator.validateProperty(this, property);
        violations.forEach(constraint -> {throw new IllegalArgumentException(constraint.getMessage());});
    }
}
