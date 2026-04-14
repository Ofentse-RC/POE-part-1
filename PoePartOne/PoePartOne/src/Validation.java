public class Validation {
    public static boolean checkUsername(String userName) {
        return userName.contains("_") && userName.length() <= 5;
    }

    public static boolean checkPassword(String password) {
        boolean hasUpper = false;
        boolean hasNumber = false;
        boolean hasSpecialCharacter = false;

        for(char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isDigit(c)) hasNumber = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecialCharacter = true;
        }

        return password.length() >= 8 && hasUpper && hasNumber && hasSpecialCharacter;
    }

    public static boolean checkCellPhone(String phone) {
        return phone.matches("^\\+27\\d{9}$");
    }
}
