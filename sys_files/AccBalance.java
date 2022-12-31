import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("static-access")
public class AccBalance {

	static DecimalFormat df2 = new DecimalFormat("0.00");
	static double up;
	static double cBala;
	static double nBala;
	static double withdraw;
	static String fileB;
	static int depoNum;
	static String name;
	static boolean access = false;
	static StoreConnect update = new StoreConnect();


	static void new_balance() {
		try {
			if (Main.login) {
				name = Main.logName;
				cBala = update.current_balanceNlog(name);
				System.out.println("Current Balance: £" + df2.format(cBala) + "\n");
			} else {
				name = Main.creator.idname();
				cBala = update.current_balanceNlog(name);
				System.out.println("Current Balance: £" + df2.format(cBala) + "\n");
			}
			
			access = false;
			System.out.println("Select from the menu of what you would like to do?\n");
			System.out.println("1. Withdraw Money");
			System.out.println("2. Deposit Money");
			System.out.println("3. Back to Main Menu");
			System.out.print("Enter displayed numbers to continue: ");

			int menu = Main.scan.nextInt();
			// Main.scan.next();
			switch (menu) {
			case 1:
				System.out.println("\nHow much would you like to withdraw\n");
				System.out.println("Current Balance: £" + df2.format(cBala) + "\n");

				while (!access) {
					System.out.print("Enter amount you would like to withdraw: ");
					withdraw = Main.scan.nextDouble();
					up = cBala - withdraw;
					if (up < 0) {
						System.out.println("\nINSUFFICIENT FUNDS");
						System.out.println("Try again please\n");
						new_balance();
					} else {
						access = true;
						fileB = df2.format(up);
						System.out.println("Current Balance: £" + fileB);
						update.balance_updates(name, fileB);

						System.out
								.print("\nContiue or Exit to Main Menu\n --> 1. Continue 2. Exit" + "\nEnter option: ");
						int toCon = Main.scan.nextInt();
						if (toCon == 1) {
							access = true;
							System.out.print("\n");
							new_balance();
						} else if (toCon == 2) {
							access = true;
							System.out.print("\n");
							MainMenu.main_menu();
						} else {
							System.out.print("\nPlease enter correct options");
						}
					}
				}

				
				break;
			case 2:
				System.out.print("Please enter the amount of money you would like to add: ");

				nBala = Main.scan.nextDouble();
				nBala = nBala + cBala;
				fileB = df2.format(nBala);

				System.out.println("\nBalance: £" + fileB);

				update.balance_updates(name, fileB);

				while (!access) {
					System.out.print("\nContiue or Exit to Main Menu\n --> 1. Continue 2. Exit" + "\nEnter option: ");
					int toDepo = Main.scan.nextInt();

					if (toDepo == 1) {
						access = true;
						System.out.print("\n");
						new_balance();
					} else if (toDepo == 2) {
						access = true;
						System.out.print("\n");
						MainMenu.main_menu();
					} else {
						System.out.print("\nPlease enter correct options");
					}
				}
				break;
			case 3:
				System.out.print("\nRedirecting to Main Menu \n");
				System.out.println("...");
				TimeUnit.SECONDS.sleep(2);
				System.out.println("...");
				TimeUnit.SECONDS.sleep(2);
				System.out.println("...");
				TimeUnit.SECONDS.sleep(2);
				System.out.print("\n");
				Main.menu.main_menu();
				break;
			default:
				System.out.print("\nPlease enter option number from available list!\n");
				new_balance();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
