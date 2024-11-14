package warehouse_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Supplier {
	  private String name;
	  private String contact_name;
	  private String Contactno;
	  private String address;
	  
	  private Connection con;
	  
  public Supplier(String name, String contact_name, String contactno, String address) {
		this.name = name;
		this.contact_name = contact_name;
		Contactno = contactno;
		this.address = address;
		
		try{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Warehouse_Management_System","root","Ramya@25");
		}
			catch(SQLException e) {
			e.printStackTrace();
		}
	}
 public void addSupplier(String name, String contact_name, String contactno, String address) {
	 String query="insert into Suppliers(supplier_name,contact_name,contact_number,address) values(?,?,?,?)";
	 try{
		 PreparedStatement pstmt=con.prepareStatement(query);
		 pstmt.setString(1,name);
		 pstmt.setString(2,contact_name);
		 pstmt.setString(3,contactno);
		 pstmt.setString(4,address);
		 pstmt.executeUpdate();
	 }catch(SQLException e) {
		e.printStackTrace();
	 }
	 System.out.println("Supplier signup Successfull!!!");
 }
  
}
