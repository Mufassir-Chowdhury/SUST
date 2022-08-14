package Common.login;

import java.util.Arrays;

import Constants.Values;

public class FieldValidity {
    private String email, identity;
    private boolean condition = false;
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
        condition = Arrays.equals(password, Values.PASSWORD_PLACEHOLDER_CHAR);
        return !condition;

    }

    public boolean checkThisEmail(String email, String mode)
    {
        this.email = email;
        condition = email.split("@").length == 2;
        if (mode == "Administrator")
        {
            condition = email.equals("admin");
        }
        else
        {
            if(condition)
            condition = isValidInput(mode);
        }
        
        return condition;
    }

    private boolean isValidInput(String mode)
    {
        String[] parts = email.split("@");
        if(mode.equals("Student"))
        {
            condition = parts[1].endsWith(Values.STUDENT_EMAIL_DOMAIN);
            if (condition) {
                condition = checkUsernameForStudent(parts[0]);
            }
        }
        if(mode.equals("Teacher"))
        {
            condition = parts[1].endsWith(Values.OFFICIALS_EMAIL_DOMAIN);
            if (condition)
                condition = checkUsernameForOfficial(parts[0]);
        }
        return condition;
    }
    
    private boolean checkUsernameForStudent(String username)
    {
        condition = username.length() > 4;
        if (condition) {
            int namePartLength = username.length() - 2;
            String regPart = username.substring(namePartLength);
            condition = regPart.matches(Values.ValidationHints.ONLY_NUMBERS);

            if (condition) {
                String namePart = username.substring(0, namePartLength);
                condition = namePart.matches(Values.ValidationHints.ONLY_LOWERCASE_LETTERS);
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
                condition = (parts[0].matches(Values.ValidationHints.ONLY_LOWERCASE_LETTERS)
                        & parts[1].matches(Values.ValidationHints.ONLY_LOWERCASE_LETTERS));
            }
        }
        return condition;
    }
    
}
