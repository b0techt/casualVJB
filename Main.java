import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("static-access")

class Main {
	/*
	 * public static info(){ return scan; }
	 */
	static Scanner scan = new Scanner(System.in);
	static boolean login = false;
	static String logName = null;
	static AccCreation creator = new AccCreation();
	static AccBalance balance = new AccBalance();
	static MainMenu menu = new MainMenu();

	public static void main(String[] args) {
		try {
			System.out.println("Welcome to the Virtual Java Bank");
			System.out.println();
			System.out.print("Do you have an account? Y or N: ");
			String opt = scan.nextLine();
			if (opt.equals("Y") || opt.equals("y")) {
				System.out.print("Username of account please: ");
				logName = scan.nextLine();

				if (new File(logName + ".txt").exists()) {
					login = true;
					menu.main_menu();
				} else {
					System.out.print("\nAccount does not exists");
					System.out.println();
					System.out.print("Would you like to create an account? Y or N: ");
					String opt1 = scan.nextLine();
					if (opt1.equals("Y") || opt1.equals("y")) {
						System.out.println();
						System.out.println("Please wait... ");
						System.out.println("Page is being redirected");
						System.out.println();
						System.out.println("...");
						TimeUnit.SECONDS.sleep(2);
						System.out.println("...");
						TimeUnit.SECONDS.sleep(2);
						System.out.println("...");
						TimeUnit.SECONDS.sleep(2);

						creator.account_making();
						menu.main_menu();
					} else {
						System.out.println("\nGoodbye user");
						System.exit(0);
					}
				}

			} else if (opt.equals("N") || opt.equals("n")) {
				System.out.println();
				System.out.print("Would you like to create an account? Y or N: ");
				String confirm = scan.nextLine();
				if (confirm.equals("Y") || confirm.equals("y") || confirm.equals("Yes") || confirm.equals("yes")) {
					creator.account_making();
					menu.main_menu();
				} else {
					System.out.println("\nGoodbye user");
					System.exit(0);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
