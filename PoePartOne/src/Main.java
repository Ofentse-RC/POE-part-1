import java.util.Scanner;

void main() {
Login login = new Login();
Scanner scanner = new Scanner(System.in);

String registrationStatus = login.registerUser();
System.out.println(registrationStatus);

System.out.print("Enter username to login: ");
String userName = scanner.nextLine();

System.out.print("Enter password to login: ");
String password = scanner.nextLine();

boolean loginSuccess = login.loginUser(userName, password);
System.out.println(login.returnLoginStatus(loginSuccess));
} 