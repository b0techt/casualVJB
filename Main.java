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
	static boolean activeMain = false;
	private static int att;
	static AccCreation creator = new AccCreation();
	static AccBalance balance = new AccBalance();
	static MainMenu menu = new MainMenu();

	public static void main(String[] args) {
		try {
			System.out.println("Welcome to the Virtual Java Bank. \n");

			while (!activeMain) {
				System.out.print("Do you have an account? Y or N: ");
				String opt = scan.nextLine();
				if (opt.equals("Y") || opt.equals("y")) {

					while (att != 3) {
						System.out.print("Username of account please: ");
						logName = scan.nextLine();

						if (new File(logName + ".txt").exists()) {
							login = true;
							menu.welcome_screen();
							menu.main_menu();

						} else {
							att++;
							System.out.print("\nAccount does not exists. \n" + "Please try again \n" + "Attempts " + att
									+ "/3. \n\n");

							if (att == 3) {
								activeMain = true;
								while (activeMain) {
									System.out.print("\nWould you like to create an account? Y or N: ");
									String opt1 = scan.nextLine();
									if (opt1.equals("Y") || opt1.equals("y")) {
										System.out.println();
										System.out.println("Please wait... ");
										System.out.println("Page is being redirected.");
										System.out.println();
										System.out.println("...");
										TimeUnit.SECONDS.sleep(2);
										System.out.println("...");
										TimeUnit.SECONDS.sleep(2);
										System.out.println("...");
										TimeUnit.SECONDS.sleep(2);

										creator.account_making();
										menu.welcome_screen();
										menu.main_menu();
									} else if (opt1.equals("N") || opt1.equals("n")) {
										System.out.println("\nGoodbye user.");
										System.exit(0);
									} else {
										System.out.print("\nPlease enter a correct option. \n");
									}
								}
							}

						}
					}

				} else if (opt.equals("N") || opt.equals("n")) {
					activeMain = true;
					while (activeMain) {
						System.out.print("\nWould you like to create an account? Y or N: ");
						String confirm = scan.nextLine();
						if (confirm.equals("Y") || confirm.equals("y")) {
							creator.account_making();
							menu.welcome_screen();
							menu.main_menu();
						} else if (confirm.equals("N") || confirm.equals("n")) {
							System.out.println("\nGoodbye user. ");
							System.exit(0);
						} else {
							System.out.print("\nPlease enter a correct option. \n");
						}
					}

				} else {
					System.out.print("\nPlease enter a correct option. \n\n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
