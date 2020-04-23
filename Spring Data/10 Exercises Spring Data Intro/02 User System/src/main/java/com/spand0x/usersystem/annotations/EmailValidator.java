package com.spand0x.usersystem.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<Email,CharSequence> {
    private int minUserNameLength;
    private int maxUserNameLength;
    private int maxHostNameLength;
    private Pattern pattern;

    @Override
    public void initialize(Email email) {
        this.minUserNameLength = email.minUserNameLength();
        this.maxUserNameLength = email.maxUserNameLength();
        this.maxHostNameLength = email.maxHostNameLength();
        this.pattern = Pattern.compile(email.regex());
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if(value == null){
            return false;
        }

        String email = value.toString();
        int userNameLength = email.indexOf('@');
        int hostNameLength = email.length() - email.lastIndexOf('@') - 1;

        if(userNameLength < this.minUserNameLength || userNameLength > this.maxUserNameLength){
            return false;
        }

        if(hostNameLength > this.maxHostNameLength){
            return false;
        }

        return this.pattern.matcher(email).matches();
    }
}
