package CSM.MavenPizzMS;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class App {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int EventChoice;
		char choice;
		Events e = new Events();
		ArrayList<Customer> custlist = new ArrayList<Customer>();

		// DoWhile
		do {
			System.out.println("1.Add Order\n2.View Order\n3.Search Order\n4.Delete Order");
			System.out.println("Enter Your Choice");
			EventChoice = sc.nextInt();

			// Switch
			switch (EventChoice) {
			case 1:
				Customer data = e.TakeOrder();
				custlist.add(data);
				e.update(custlist);
				break;

			case 2:
				e.display(custlist);
				break;

			case 3:
				int count = 0;
				System.out.println("Enter Order Number");
				String in = sc.next();
				for (Customer pi : custlist) {
					if (pi.getId().equals(in)) {
						System.out.println("Order_ID" + "\t " + "Order_Name" + "\t" + "QTY" + "\t" + "\t" + "Price"
								+ "\t" + "\t" + "Total");
						break;
					}
				}
				for (Customer pi : custlist) {
					if (pi.getId().equals(in)) {
						System.out.println(pi.getId() + "\t " + "\t " + pi.getName() + "\t" + "\t " + pi.getQty() + "\t"
								+ "\t " + pi.getPrice() + "\t" + "\t " + pi.getTotal());
						count++;
					}
				}
				break;

			case 4:
				System.out.println("Enter order number you want to delete");
				String input = sc.next();
				int count1 = 0;
				for (Customer po : custlist) {
					if (po.getId().equals(input)) {
						custlist.remove(po);
						System.out.println("Order Deleted Succesfully !!");
						count1++;
						break;
					}
				}
				e.update(custlist);
				break;

			case 0:
				System.out.println("Thank You!!Have a Good Day");
				System.exit(EventChoice);
				break;

			}
			// For While
			System.out.println("Do you Want to perform again(y/n)");
			choice = sc.next().charAt(0);
		} while (choice == 'y');
	}
}
