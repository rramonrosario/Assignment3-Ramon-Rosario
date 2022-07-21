import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
	// instance variables
	String username;
	String password;
	String name;

	public User(String username, String password, String name) {
		this.username = username;
		this.password = password;
		this.name = name;

	}

	public static void main(String[] args) {
		try {
// Create Scanner object
			Scanner input = new Scanner(new File("Data.txt"));
// Create Arraylist of users
			ArrayList<User> users = new ArrayList<>();
			while (input.hasNextLine()) {
				String data1 = input.nextLine();
				String data[] = data1.split(",");
// Create User object
				User user = new User(data[0], data[1], data[2]);
// add to list
				users.add(user);
			}

			Scanner login = new Scanner(System.in);
			int count = 0;
			while (true) {
// read input from user
				System.out.println("Enter your email:");
				String userN = login.next();
				System.out.println("Enter your password:");
				String passwordN = login.next();
				boolean flag = false;
				for (User user : users) {
// check username and password
					if (user.username.equalsIgnoreCase(userN) && user.password.equals(passwordN)) {
						System.out.println("Welcome: " + user.name);
						flag = true;
						break;
					}
				}
				if (!flag) {
					count++;
// check count
					if (count >= 5) {
						System.out.println("Too many failed login attempts, you are now locked out.");
						break;
					} else {
						System.out.println("Invalid login, please try again.");
					}
				} else {
					break;
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}