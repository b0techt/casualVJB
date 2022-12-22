import java.text.DecimalFormat;

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
	static StoreConnect update = new StoreConnect();

	static void new_balance() {
		try {
			if(Main.login) {
				name = Main.logName;
				cBala = update.current_balanceNlog(name);
				System.out.println("Welcome to your account!");
				System.out.println();
				System.out.println("Current Balance: £" + df2.format(cBala));
			}else {
				name = Main.creator.idname();
				cBala = update.current_balanceNlog(name);
				System.out.println("Welcome to your account!");
				System.out.println();
				System.out.println("Current Balance: £" + df2.format(cBala));
			}
			System.out.println();
			System.out.println("Select from the menu of what you would like to do?");
			System.out.println();
			System.out.println("1. Withdraw Money");
			System.out.println("2. Deposit Money");
			System.out.println("3. Back to Main Menu");
			System.out.print("Enter displayed numbers to continue: ");

			int menu = Main.scan.nextInt();
			switch (menu) {
			case 1:
				System.out.println();
				System.out.println("How much would you like to Withdraw");
				System.out.println();
				System.out.println("Current Balance: £" + df2.format(cBala));
				if (cBala > 0) {
					System.out.println("You are allowed to withdraw");
					System.out.println();
					int access = 0;
					while (access != 1) {
						System.out.print("Enter amount you would like to withdraw: ");
						withdraw = Main.scan.nextDouble();
						up = cBala - withdraw;
						if (up < 0) {
							System.out.println();
							System.out.println("INSUFFICIENT FUNDS");
							System.out.println("Try again please");
							System.out.println();
						} else {
							access = 1;
							fileB = df2.format(up);
							System.out.println("Current Balance: £" + fileB);
							update.balance_updates(name, fileB);
						}
					}
				} else {
					System.out.println("Sorry insufficient funds");
					System.out.println("You owe the bank money");
				}
				Main.menu.main_menu();
				break;
			case 2:
				System.out.print("Please enter the amount of money you would like to add: ");

				nBala = Main.scan.nextDouble();
				nBala = nBala + cBala;
				fileB = df2.format(nBala);

				System.out.println("\nBalance: £" + fileB);

				update.balance_updates(name, fileB);
				
				Main.menu.main_menu();
				break;
			case 3:
				Main.menu.main_menu();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
