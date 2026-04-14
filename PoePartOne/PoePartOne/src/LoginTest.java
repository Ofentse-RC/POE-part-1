import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    // Username validation tests
    @Test
    public void testUserNameCorrectlyFormatted() {
        Login login = new Login();
        login.setUserName("kyl_1");
        assertTrue(login.checkUserName());
    }

    @Test
    public void testUserNameIncorrectlyFormatted() {
        Login login = new Login();
        login.setUserName("kyl!!!!!!!");
        assertFalse(login.checkUserName());
    }

    // Password complexity tests
    @Test
    public void testPasswordMeetsComplexity() {
        Login login = new Login();
        login.setPassword("Ch&&sec@ke99!");
        assertTrue(login.checkpassword());
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        Login login = new Login();
        login.setPassword("password");
        assertFalse(login.checkpassword());
    }

    // Cell phone number format tests
    @Test
    public void testCellPhoneNumberCorrectlyFormatted() {
        Login login = new Login();
        login.setPhoneNumber("+27838968977");
        assertTrue(login.checkCellPhone("+27838968977"));
    }

    @Test
    public void testCellPhoneNumberIncorrectlyFormatted() {
        Login login = new Login();
        login.setPhoneNumber("08966553");
        assertFalse(login.checkCellPhone("08966553"));
    }

    // Login result tests
    @Test
    public void testLoginSuccessful() {
        Login login = new Login();
        User user = new User("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968977");
        login.setRegisteredUser(user);

        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFail() {
        Login login = new Login();
        User user = new User("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968977");
        login.setRegisteredUser(user);
        assertFalse(login.loginUser("wrong", "wrong"));
    }

    // Login status message tests
    @Test
    public void testReturnLoginStatusSuccess() {
        Login login = new Login();
        User user = new User("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968977");
        login.setRegisteredUser(user);

        String expected = "Welcome Kyle Smith, it is great to see you again. ";
        assertEquals(expected, login.returnLoginStatus(true));
    }

    @Test
    public void testReturnLoginStatusFail() {
        Login login = new Login();
        String expected = "Username or password incorrect, please try again.";
        assertEquals(expected, login.returnLoginStatus(false));
    }
}
