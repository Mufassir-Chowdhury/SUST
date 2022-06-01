package login;

import java.util.Arrays;

import Constants.Values;

public class FieldValidity {
    private String email, identity;
    private boolean condition;
    private String STUDENT = "student", OFFICIAL = "official";

    FieldValidity()
    {

    }

    public boolean isEmailFieldFilled(String email)
    {
        condition = email.equals(Values.EMAIL_PLACEHOLDER);
        return !condition;
    }

    public boolean isPasswordFieldFilled(char[] password)
    {
        condition = Arrays.equals(password, Values.DEFAULT_PASSWORD);
        return !condition;

    }

    public boolean checkThisEmail(String email)
    {
        this.email = email;
        condition = email.split("@").length == 2;
        if(condition)
            condition = isValidInput();
        
        return condition;
    }

    private boolean isValidInput()
    {
        String[] parts = email.split("@");
        condition = checkDomain(parts[1]);
        if (condition) {

            if (identity == STUDENT)
                condition = checkUsernameForStudent(parts[0]);
            if (identity == OFFICIAL)
                condition = checkUsernameForOfficial(parts[0]);
        }
        return condition;
    }

    private boolean checkDomain(String domain)
    {
        condition = domain.endsWith(Values.STUDENT_EMAIL_DOMAIN);
        if (condition)
            identity = STUDENT;
        else {
            condition = domain.endsWith(Values.OFFICIALS_EMAIL_DOMAIN);
            if (condition)
                identity = OFFICIAL;
        }
        return condition;
    }
    
    private boolean checkUsernameForStudent(String username)
    {
        condition = username.length() > 4;
        if (condition) {
            int namePartLength = username.length() - 2;
            String regPart = username.substring(namePartLength);
            condition = regPart.matches(Values.ONLY_NUMBERS);

            if (condition) {
                String namePart = username.substring(0, namePartLength);
                condition = namePart.matches(Values.ONLY_LOWERCASE_LETTERS);
            }
        }
        return condition;
    }
    
    private boolean checkUsernameForOfficial(String username)
    {
        condition = username.length() > 2;
        if (condition) {
            String[] parts = username.split("-");
            int partsLength = parts.length;
            condition = (partsLength == 0 | partsLength == 2);

            if (condition) {
                condition = (parts[0].matches(Values.ONLY_LOWERCASE_LETTERS)
                        & parts[1].matches(Values.ONLY_LOWERCASE_LETTERS));
            }
        }
        return condition;
    }
    
}
