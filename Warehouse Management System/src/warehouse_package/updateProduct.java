package warehouse_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateProduct {
	private Connection con;
	public updateProduct() {
		try{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Warehouse_Management_System","root","Ramya@25");
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	public void updateStock(int productId, int quantityChange) {
	    String query = "UPDATE Products SET quantity = quantity + ? WHERE product_id = ?";
	    try {
	        PreparedStatement pstmt = con.prepareStatement(query);
	        pstmt.setInt(1, quantityChange);  // This can be positive or negative depending on the action
	        pstmt.setInt(2, productId);       // Specify the product ID whose stock you're updating
	        pstmt.executeUpdate();
	        System.out.println("Stock updated successfully!");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
