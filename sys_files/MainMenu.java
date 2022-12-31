import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

@SuppressWarnings({"unused", "static-access"})
public class MainMenu {

	public static boolean active = true;
	static String menuName = null;
	static AccEdit edit = new AccEdit();
	
	static void welcome_screen() {
		if (Main.login) {
			menuName = Main.logName;
			System.out.println("\nWelcome " + menuName + " to the Virtual Java Bank Menu. \n");
		} else {
			menuName = Main.creator.idname();
			System.out.println("\nWelcome " + menuName + " to the Virtual Java Bank Menu.\n");
		}
	}

	static void main_menu() {
		System.out.println("What would you like to do?\n");

		while (active) {
			System.out.print("Username: " + menuName + "\n\n");
			System.out.println("1. See details");
			System.out.println("2. Edit details");
			System.out.println("3. Check Balance");
			System.out.println("4. Exit Virtual Java Bank");
			System.out.print("Enter option: ");
			// scan.next();
			int menu = Main.scan.nextInt();
			switch (menu) {
				case 1 :
					if (Main.login) {
						see_data(Main.logName);
					} else {
						see_data(Main.creator.idname());
					}

					System.out.println();
					break;
				case 2 :
					edit.welcome_screen();
					edit.account_edit();
					break;
				case 3 :
					System.out.println();
					Main.balance.new_balance();
					break;
				case 4 :
					System.out.println();
					System.out.print("Goodbye.");
					System.exit(0);
					break;
				default:
					System.out.print("\nPlease enter correct option from available list!\n");
					main_menu();
			}
			System.out.println();
		}
	}

	static void see_data(String idName) {
		try {
			System.out.println("\nReading user file");
			System.out.println("Please wait");
			System.out.println();
			System.out.println("...");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("...");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("...");
			TimeUnit.SECONDS.sleep(2);
			System.out.println();

			BufferedReader br = new BufferedReader(
					new FileReader(idName + ".txt"));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
