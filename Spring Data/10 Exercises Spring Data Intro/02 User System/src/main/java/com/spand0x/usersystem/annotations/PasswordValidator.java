package com.spand0x.usersystem.annotations;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;


@Component
public class PasswordValidator implements ConstraintValidator<Password, CharSequence> {
    private static final Pattern PATTERN_LOWER = Pattern.compile("[a-z]");
    private static final Pattern PATTERN_UPPER = Pattern.compile("[A-Z]");
    private static final Pattern PATTERN_DIGIT = Pattern.compile("[0-9]");
    private static final Pattern PATTERN_SYMBOL = Pattern.compile("[!@#$%^&*()_+<>?]");

    private int minLength;
    private int maxLength;
    private boolean hasUpper;
    private boolean hasLower;
    private boolean hasDigit;
    private boolean hasSpecialSymbol;

    @Override
    public void initialize(Password password) {
        this.minLength = password.minLength();
        this.maxLength = password.maxLength();
        this.hasUpper = password.containsUpperCase();
        this.hasLower = password.containsLowerCase();
        this.hasDigit = password.containsDigit();
        this.hasSpecialSymbol = password.containsSpecialSymbols();
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if(value == null){
            return false;
        }
        if(value.length() < this.minLength || value.length() > this.maxLength){
            return false;
        }
        String password = value.toString();

        if(!PATTERN_LOWER.matcher(password).find() && this.hasLower){
            return false;
        }

        if(!PATTERN_UPPER.matcher(password).find() && this.hasUpper){
            return false;
        }

        if(!PATTERN_DIGIT.matcher(password).find() && this.hasDigit){
            return false;
        }

        return PATTERN_SYMBOL.matcher(password).find() || !this.hasSpecialSymbol;

    }
}
