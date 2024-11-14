package warehouse_package;
import java.io.IOException;
//import java.util.*;
import java.sql.*;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) throws Exception {
	boolean funny=true;
	Scanner sc=new Scanner(System.in);
	System.out.println("****************Welcome to warehouse Management System*******************");
	while(funny) {
		System.out.println("1.Signup\n2.Add products\n3.Stock Requests\n4.Update Products\n5.History\n6.View Products\n7.View Suppliers\n8.Exit");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("1.warehouse manager signup");
			int c=sc.nextInt();
			System.out.println("Enter your name: ");
			String supplier_name=sc.next();
			System.out.println("Enter contact person name: ");
			String contact_name=sc.next();
			System.out.println("Enter contact number: ");
			String phoneno=sc.next();
			System.out.println("Enter address: ");
			String address=sc.next();
			Supplier supplier=new Supplier(supplier_name,contact_name,phoneno,address);
			supplier.addSupplier(supplier_name, contact_name, contact_name, address);
			break;
		case 2:
			System.out.println("Enter the product name: ");
			String name=sc.next();
			System.out.println("Enter type (Perishable/nonPerishable)");
			String type=sc.next();
			System.out.println("Enter the quantity: ");
			int quantity=sc.nextInt();
			System.out.println("Enter the price: ");
			int price=sc.nextInt();
			System.out.println("Enter the storage requirements: ");
			String sr=sc.next();
			
			//product history
			System.out.println("Enter the change type: ");
			String changetype=sc.next();
			System.out.println("Enter the quantity changed: ");
			int quantitychange=sc.nextInt();
			System.out.println("Add description(notes): ");
			String des=sc.next();
			
			Product product=new Product(name,type,quantity,price,sr,changetype,quantitychange,des);
			product.addProducts(name, type, quantity, price, sr,changetype,quantitychange,des);
			break;
		case 3:
			System.out.println("Enter the productid : ");
			int pid=sc.nextInt();
			System.out.println("Enter the supplierid : ");
			int sid=sc.nextInt();
			System.out.println("Required Quantity: ");
			int quantity1=sc.nextInt();
			System.out.println("Enter the status : (pending,completed,shipped)");
			String status=sc.next();
			stockRequests sreq=new stockRequests(pid,sid,quantity1,status);
			sreq.addRequests(pid, sid, quantity1, status);
			break;
		case 4:
			System.out.println("Enter the product ID: ");
			int prid=sc.nextInt();
			System.out.println("Enter the change in quantity: ");
			int qchange=sc.nextInt();
			updateProduct p=new updateProduct();
			p.updateStock(prid, qchange);
			break;
		case 5:
			viewProducts vp=new viewProducts();
			vp.historycheck();
		    break;
		case 6:
			viewProducts v=new viewProducts();
		    v.viewProducts();
		    System.out.println("*****************These are the available products**************");
		    break;
		case 7:
			viewSuppliers vs=new viewSuppliers();
			vs.viewSuppliersfun();
			break;
		case 8:
			funny=false;
			System.out.println("Thanks for visiting!!!");
			break;
		}
	}
	}
}
