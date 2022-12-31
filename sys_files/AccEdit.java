import java.util.*;
import java.util.concurrent.TimeUnit;

public class AccEdit {
	static Scanner read = new Scanner(System.in);
	static int op;
	static int confirm;
	static boolean conChoice = false;
	static String newDeets;

	static void welcome_screen() {
		System.out.println("\nWelcome to the VJB Rectification Page");
	}

	static void account_edit() {
		conChoice = false;
		System.out.print("\nPlease choose what personal detail you would like to edit\n" + "1. Firstname\n" + "2. Surname\n" + "3. Age\n" + "4. Main Menu\n"
				+ "\nEnter option: ");

		op = Main.scan.nextInt();

		try {
			while (MainMenu.active) {
				switch (op) {
				case 1:
					System.out.print("Enter new name: ");
					newDeets = Main.scan.next();

					while (!conChoice) {
						System.out.print(
								"\nWould you like to confirm your choice" + "\n --> 1. Yes 2.No" + "\nEnter option: ");
						confirm = Main.scan.nextInt();
						if (confirm == 1) {
							conChoice = true;
							StoreConnect.editFile(op, newDeets);
							System.out.print("Name has been updated\n");

							while (conChoice) {
								System.out.print("\nContiue or Exit to Main Menu\n --> 1. Continue 2. Exit"
										+ "\nEnter option: ");
								confirm = Main.scan.nextInt();
								if (confirm == 1) {
									account_edit();
								} else if (confirm == 2) {
									MainMenu.main_menu();
								}else {
									System.out.print("\nPlease enter correct option from available list!\n");
								}
							}

						} else if (confirm == 2) {
							System.out.print("\nRedirecting to Rectification Page\n");
							System.out.println("...");
							TimeUnit.SECONDS.sleep(2);
							System.out.println("...");
							TimeUnit.SECONDS.sleep(2);
							System.out.println("...");
							TimeUnit.SECONDS.sleep(2);
							account_edit();
						} else {
							System.out.print("\nPlease enter correct option from available list!\n");
						}

					}
					break;
				case 2:
					System.out.print("Enter new surname: ");
					newDeets = Main.scan.next();

					while (!conChoice) {
						System.out.print(
								"\nWould you like to confirm your choice" + "\n --> 1. Yes 2.No" + "\nEnter option: ");
						confirm = Main.scan.nextInt();
						if (confirm == 1) {
							conChoice = true;
							StoreConnect.editFile(op, newDeets);
							System.out.print("Surname has been updated\n");

							while (conChoice) {
								System.out.print("\nContiue or Exit to Main Menu\n --> 1. Continue 2. Exit"
										+ "\nEnter option: ");
								confirm = Main.scan.nextInt();
								if (confirm == 1) {
									account_edit();
								} else if (confirm == 2) {
									MainMenu.main_menu();
								}else {
									System.out.print("\nPlease enter correct option from available list!\n");
								}
							}

						} else if (confirm == 2) {
							System.out.print("\nRedirecting to Rectification Page\n");
							System.out.println("...");
							TimeUnit.SECONDS.sleep(2);
							System.out.println("...");
							TimeUnit.SECONDS.sleep(2);
							System.out.println("...");
							TimeUnit.SECONDS.sleep(2);
							account_edit();
						} else {
							System.out.print("\nPlease enter correct option from available list!\n");
						}

					}
					break;
				case 3:
					System.out.print("Enter new age: ");
					newDeets = Main.scan.next();

					while (!conChoice) {
						System.out.print(
								"\nWould you like to confirm your choice" + "\n --> 1. Yes 2.No" + "\nEnter option: ");
						confirm = Main.scan.nextInt();
						if (confirm == 1) {
							conChoice = true;
							StoreConnect.editFile(op, newDeets);
							System.out.print("Age has been updated\n");

							while (conChoice) {
								System.out.print("\nContiue or Exit to Main Menu\n --> 1. Continue 2. Exit"
										+ "\nEnter option: ");
								confirm = Main.scan.nextInt();
								if (confirm == 1) {
									account_edit();
								} else if (confirm == 2) {
									MainMenu.main_menu();
								}else {
									System.out.print("\nPlease enter correct option from available list!\n");
								}
							}

						} else if (confirm == 2) {
							System.out.print("\nRedirecting to Rectification Page\n");
							System.out.println("...");
							TimeUnit.SECONDS.sleep(2);
							System.out.println("...");
							TimeUnit.SECONDS.sleep(2);
							System.out.println("...");
							TimeUnit.SECONDS.sleep(2);
							account_edit();
						} else {
							System.out.print("\nPlease enter correct option from available list!\n");
						}

					}
					break;
					
				case 4:
					System.out.print("\nRedirecting to Main Menu \n");
					System.out.println("...");
					TimeUnit.SECONDS.sleep(2);
					System.out.println("...");
					TimeUnit.SECONDS.sleep(2);
					System.out.println("...\n");
					TimeUnit.SECONDS.sleep(2);
					MainMenu.main_menu();
				default:
					System.out.print("\nPlease enter correct option from available list!\n");
					account_edit();
				}
			}

		} catch (Exception e) {
			System.out.print("Sorry couldn't edit chosen detail\n");
		}

	}
}
