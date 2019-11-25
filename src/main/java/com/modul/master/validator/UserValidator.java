package com.modul.master.validator;

import com.modul.master.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.name.empty", "Apa?!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "error.age.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.email.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.username.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password.empty");

        User user = (User) o;

        Pattern patternEmail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                Pattern.CASE_INSENSITIVE);
        if (!(patternEmail.matcher(user.getEmail()).matches())) {
            errors.rejectValue("email", "error.email.invalid");
        }

        Pattern patternPassword = Pattern.compile(".{8,}");
        if (!(patternPassword.matcher(user.getPassword()).matches())) {
            errors.rejectValue("password", "error.password.invalid");
        }

    }
}
