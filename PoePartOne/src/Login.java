import java.util.Scanner;

public class Login {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String phoneNumber;

    public Login() {
    }

    public Login(String firstName, String lastName, String userName, String password, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public boolean checkUserName() {
        return userName.contains("_") && userName.length() <= 5;
    }

    public boolean checkCellPhone(String phone) {
        // Checks for South African international format: +27 followed by 9 digits.
        return phone.matches("^\\+27\\d{9}$");
    }

    // Stores the user that has completed registration.
    User registeredUser;

    // Handles user registration input and saves the new user.
    public String registerUser() {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        System.out.print("Enter userName: ");
        String username = input.nextLine();

        if (Validation.checkUsername(username)) {
            System.out.println("Username successfully captured. ");
        } else {
            System.out.println("Username is not correctly formatted; please ensure that your userName contains an underscore and is no more than five characters in length. ");
        }

        System.out.print("Enter password: ");
        String password = input.nextLine();

        if (Validation.checkPassword(password)) {
            System.out.println("Password successfully captured. ");
        } else {
            System.out.println("Password is not correctly formatted; please ensure that your password contains at at least eight characters, a capital letter, a number, and a special character. ");
        }

        System.out.println("Enter SA cellphone number: ");
        String phone = input.nextLine();

        if (Validation.checkCellPhone(phone)) {
            System.out.println("Cell phone number successfully added. ");
        } else {
             System.out.println("Cell phone number incorrectly formatted or does not contain international code. ");
        }

        registeredUser = new User(firstName, lastName, username, password, phone);
        return " User has been registered successfully.";
    }

    // Checks whether the entered login details match the registered user.
    public boolean loginUser(String enteredUserName, String enteredPassword) {
        if (registeredUser == null) {
            return false;
        }

        return enteredUserName.equals(registeredUser.getUserName())
                && enteredPassword.equals(registeredUser.getPassword());
    }

    // Handles login input directly from the console.
    public void loginUser(Scanner input) {
        System.out.print("Enter userName to login: ");
        String loginUsername = input.nextLine();

        System.out.print("Enter password to login: ");
        String loginPassword = input.nextLine();

        if (loginUsername.equals(registeredUser.getUserName()) &&
                loginPassword.equals(registeredUser.getPassword())) {

            System.out.println("Welcome" + registeredUser.getFirstName() + ", " +
                    "it is great to see you again. ");
        } else {
            System.out.println("Username or password incorrect, please try again. ");
        }

    }

    // Setters used by the test class.
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setRegisteredUser(User registeredUser) {
        this.registeredUser = registeredUser;
    }

    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome" + " " + registeredUser.getFirstName() + " " + registeredUser.getLastName() + ", " +
                    "it is great to see you again. ";
        } else {
            return "Username or password incorrect, please try again.";

        }
    }
    public boolean checkpassword() {
        return Validation.checkPassword(password);
    }
}


