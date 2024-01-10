package com.github.bearboy.spring.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * 针对User做ValidationUser
 */
public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Person.class);
    }

    /**
     * @param target the object that is to be validated
     * @param errors contextual state about the validation process
     */
    @Override
    public void validate(Object target, Errors errors) {
        //针对user字段age、name不为空验证
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "user.age");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "user.name");
        Person user = (Person) target;
        if (user.getAge() <= 0) {
            errors.rejectValue("age", "user.age.negative");
        } else if (user.getAge() > 110) {
            errors.rejectValue("age", "too.darn.old");
        }
    }
}
