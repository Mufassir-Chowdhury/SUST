package Constants;

/**
 * This class contains all the hardcoded values used in the application.
 */
public class Values {
    /**
     * This is the placeholder for password fields.
     */
    public static final char[] PASSWORD_PLACEHOLDER = new char[]{' ', 'P','a','s','s','w','o','r','d'};
    /**
     * This is the placeholder for email fields.
     */
    public static final String EMAIL_PLACEHOLDER = " Email Address ( Academic )";

    /**
     * This is the echo character to show when the show password check box is not selected.
     */
    public static final char PASSWORD_ECHO_CHAR = '\u25cf';
    /**
     * This is the echo character to show when the show password check box is selected.
     */
    public static final char PASSWORD_PLAIN_ECHO_CHAR = '\u0000';

    /**
     * This is used to check if the given email is a student email.
     */
    public static final String STUDENT_EMAIL_DOMAIN = "student.sust.edu";
    /**
     * This is used to check if the given email is an official email.
     */
    public static final String OFFICIALS_EMAIL_DOMAIN = "sust.edu";

    /**
     * These values are used to check validity of inputs and show messages accordingly.
     */
    public static class ValidationHints{
        public static final String ONLY_NUMBERS = "[0-9]+";
        public static final String ONLY_LOWERCASE_LETTERS = "[a-z]+";
        public static final String AT_LEAST_ONE_NUMBER = "\\.*[0-9]\\.*";
        public static final String AT_LEAST_ONE_UPPERCASE_LETTER = "\\.*[A-Z]\\.*";
        
    
        public static final String WRONG_EMAIL = "Wrong Email";
        public static final String WRONG_PASSWORD = "Wrong Password";
    
        public static final String PASSED = "Passed";
    
        public static final String SHORT_PASSWORD = "Short password";
        public static final String MISSING_CHARACTERS = "Some characters are missing";
    }
}
