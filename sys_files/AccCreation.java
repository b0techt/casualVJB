import java.util.*;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("static-access")
public class AccCreation {
	public String idname() {
		return idName;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public static String idName;
	public static String firstname;

	static void account_making() {
		try {
			System.out.println();
			System.out.println("Welcome to the Java Account Registry Page");
			System.out.println("Please fill in details");

			System.out.print("First name: ");
			firstname = Main.scan.nextLine();
			String fname = firstname.substring(0, 1).toUpperCase()
					+ firstname.substring(1);
			System.out.println();

			System.out.print("Surname: ");
			String surname = Main.scan.nextLine();
			String sname = surname.substring(0, 1).toUpperCase()
					+ surname.substring(1);
			System.out.println();

			System.out.print("Age: ");
			int age = Main.scan.nextInt();
			System.out.println();

			idName = firstname.substring(0, 1).toUpperCase() + surname;

			System.out.println("Thank you for entering your details");
			System.out.println(
					"We will now process your details and make your account with your given account number, \r\nPIN, card number and security number");
			System.out.println("Please wait");
			System.out.println();
			System.out.println("...");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("...");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("...");
			TimeUnit.SECONDS.sleep(2);

			// will improve number assignment, just needed something quick
			Random rand = new Random();
			int account_number = rand.nextInt(100000000);

			int card_number_1 = rand.nextInt(100000000);
			int card_number_2 = rand.nextInt(100000000);
			String card_number = Integer.toString(card_number_1)
					+ Integer.toString(card_number_2);

			int pin_number = rand.nextInt(1000) + 9000;
			int sec_number = rand.nextInt(100) + 900;

			// System.out.println("Your data will be saved to a database when I
			// have added and configured a database to use. So please be
			// patient!");

			System.out.println();

			System.out.println("Account Number: " + account_number);
			System.out.println("Card Number: "
					+ Arrays.toString(card_number.split("(?<=\\G.{4})")));
			System.out.println("PIN: " + pin_number);
			System.out.println("Security Number: " + sec_number);

			System.out.println();

			System.out.println("First name: " + fname);
			System.out.println("Surname: " + sname);
			System.out.println("Age: " + age);

			System.out.println();
			System.out.println("Saving Data now!");
			System.out.println();
			StoreConnect connect = new StoreConnect();
			connect.store_data(idName, fname, sname);
			connect.store_data(idName, age, account_number);
			connect.store_data(idName, card_number, pin_number, sec_number);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
