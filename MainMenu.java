import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

@SuppressWarnings({"unused", "static-access"})
public class MainMenu {

	public static boolean active = true;
	static AccEdit edit = new AccEdit();

	static void main_menu() {
		if (Main.login) {
			System.out.println(
					"\nWelcome " + Main.logName + " to the Virtual Java Bank Menu");
		} else {
			System.out.println("\nWelcome " + Main.creator.idname()+ " to the Virtual Java Bank Menu");
		}

		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();

		while (active) {
			System.out.println("1. See details");
			System.out.println("2. Edit details");
			System.out.println("3. Check Balance");
			System.out.println("4. Exit Virtual Java Bank");
			System.out.print("Enter numbers to continue: ");
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
					edit.account_edit();
					break;
				case 3 :
					System.out.println();
					Main.balance.new_balance();
					break;
				case 4 :
					System.out.println();
					System.out.print("Goodbye");
					System.exit(0);
					break;
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
