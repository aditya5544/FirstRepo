package CSM.MavenPizzMS;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Events 
{
	Scanner sc=new Scanner(System.in);
	static String[] columns = {"ID", "OrderName", "QTY", "Price","Total"};
	String id,name;
	int Qty,Rupees,Total;
	  public Customer TakeOrder()
	{
		 try
		 {
			 	System.out.println("Enter Customer Id");
				String id=sc.next();
				System.out.println("Enter Name ");
				String name=sc.next();
				System.out.println("Enter Quantity");
				int  qnt=sc.nextInt();
				System.out.println("Enter Price");
				int  price=sc.nextInt();
				int  total=price*qnt;
				Customer c = new Customer();
				c.setId(id);
				c.setName(name);
				c.setPrice(price);
				c.setQty(total);
				c.setTotal(total);
				return c;
			 
		 }
		 catch(Exception e)
		 {
			 System.out.println("Invalid ");
		 }
		return null;

	}
	  
	  
	  public void update(ArrayList<Customer> a1) throws IOException {
			// TODO Auto-generated method stub
			Workbook workbook = new XSSFWorkbook(); 
	        CreationHelper createHelper = workbook.getCreationHelper();
	        // Create a Sheet
	        Sheet sheet = (Sheet) workbook.createSheet("Pizza");
	        // Create a Row
	        Row headerRow = sheet.createRow(0);
	        // Create cells
	        for(int i = 0; i < columns.length; i++) {
	            Cell cell = headerRow.createCell(i);
	            cell.setCellValue(columns[i]);
	        }
	        // Create Cell Style for formatting Date
	        CellStyle dateCellStyle = workbook.createCellStyle();
	        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
	        // Create Other rows and cells with employees data
	        int rowNum = 1;
	        for(Customer co: a1) {
	            Row row = sheet.createRow(rowNum++);
	            row.createCell(0)
	                    .setCellValue(co.getId());
	            row.createCell(1)
	                    .setCellValue(co.getName());
	            row.createCell(2)
	            .setCellValue(co.getQty());
	            row.createCell(3)
	            .setCellValue(co.getPrice());
	            row.createCell(4)
	            .setCellValue(co.getTotal());
	        }
			// Resize all columns to fit the content size
	        for(int i = 0; i < columns.length; i++) {
	            sheet.autoSizeColumn(i);
	        }
	        // Write the output to a file
	        FileOutputStream fileOut = new FileOutputStream("src/main/resources/file.xls");
	        workbook.write(fileOut);
	        fileOut.close();
	        // Closing the workbook
	        workbook.close();
		}
	  
	  
	  
	  
	  public void display(ArrayList<Customer> a1) {
			if (a1.size()==0) {
				System.out.println("No Records Found !!");
			}
			else
			{
				System.out.println();
				System.out.println("Order_ID"+"\t "+"Order_Name"+"\t"+"QTY"+"\t"+"\t"+"Price"+"\t"+"\t"+"Total");
				System.out.println();
				for (Customer co : a1) {
					System.out.println(co.getId()+"\t "+"\t "+co.getName()+"\t"+"\t "+co.getQty()+"\t"+"\t "+co.getPrice()+"\t"+"\t "+co.getTotal());
				}
				System.out.println();
			}
		}

}
