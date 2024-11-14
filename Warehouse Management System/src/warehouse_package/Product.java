package warehouse_package;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Product {
//    private int productId;
    private String productName;
    private String productType;
    private int quantity;
    private int price;
    private String storageRequirements;
    private String changetype;
    private int quantitychange;
    private String notes;

    private Connection con;
	private String change;
    public Product(String productName, String productType, int quantity, int price, String storageRequirements,String changetype,int quantitychange,String notes) {
//        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
        this.quantity = quantity;
        this.price = price;
        this.storageRequirements = storageRequirements;
        this.changetype=changetype;
        this.quantitychange=quantitychange;
        this.notes=notes;
        try{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Warehouse_Management_System","root","Ramya@25");
		}
			catch(SQLException e) {
			e.printStackTrace();
		}
    }
  

	public void addProducts(String productName, String productType, int quantity, int price, String storageRequirements,String Changetype,int quantitychange,String notes) {
   	 String query="insert into products(product_name,product_type,quantity,price,storage_requirements,change_type,quantity_change,notes)values(?,?,?,?,?,?,?,?)";
   	 try{
   		 PreparedStatement pstmt=con.prepareStatement(query);
   		 pstmt.setString(1,productName);
   		 pstmt.setString(2,productType);
   		 pstmt.setInt(3,quantity);
   		 pstmt.setInt(4,price);
   		 pstmt.setString(5,storageRequirements);
   		 pstmt.setString(6, Changetype);
   		 pstmt.setInt(7, quantitychange);
   		 pstmt.setString(8, notes);
   		 pstmt.executeUpdate();
   	 }catch(SQLException e) {
   		e.printStackTrace();
   	 }
   	 System.out.println("product added Successfull!!!");
    }
		
	}

