package com.github.bearboy.spring.validation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.Set;

/**
 * Hibernate Validator demo
 */
public class HibernateValidatorDemo {
    private Validator validator;

    public HibernateValidatorDemo(Validator validator) {
        this.validator = validator;
    }

    public void Validate(Person person){
        Set<ConstraintViolation<Person>> constraintViolations =
                validator.validate( person );
        if (!constraintViolations.isEmpty()){
            for (Iterator<ConstraintViolation<Person>> it = constraintViolations.iterator(); it.hasNext(); ) {
                ConstraintViolation constraintViolation =  it.next();
                System.out.println(constraintViolation.getPropertyPath() + constraintViolation.getMessage());
            }
        }
    }
    public static void main(String[] args) {
        Person person = new Person();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        HibernateValidatorDemo demo = new HibernateValidatorDemo(factory.getValidator());
        demo.Validate(person);
    }
}
