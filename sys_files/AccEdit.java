import java.util.*;

public class AccEdit {
	static Scanner read = new Scanner(System.in);
	static int op;
	static String newDeets;

	static void account_edit() {
		System.out.print("\nWelcome to the VJB Recitification Page\n" + "1. Firstname\n" + "2. Surname\n" + "3. Age\n"
				+ "Please choose what personal detail to edit: ");

		op = Main.scan.nextInt();

		try {
			switch (op) {
			case 1:
				System.out.print("Enter new name: ");
				newDeets = Main.scan.next();
				StoreConnect.editFile(op, newDeets);
				System.out.print("Name has been updated\n");
				break;
			case 2:
				System.out.print("Enter new surname: ");
				newDeets = Main.scan.next();
				StoreConnect.editFile(op, newDeets);
				System.out.print("Surname has been updated\n");
				break;
			case 3:
				System.out.print("Enter new age: ");
				newDeets = Main.scan.next();
				StoreConnect.editFile(op, newDeets);
				System.out.print("Age has been updated\n");
				break;

			}

		} catch (Exception e) {
			System.out.print("Sorry couldn't edit chosen detail\n");
		}

	}
}
