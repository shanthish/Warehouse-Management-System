package warehouse_package;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class viewProducts {
	private Connection con;
	public viewProducts() {
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Warehouse_Management_System","root","Ramya@25");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
public void historycheck() throws SQLException,IOException {
	String query="select product_id,change_type,quantity_change,change_date,notes from products";
	try {
		PreparedStatement pstmt=con.prepareStatement(query);
		ResultSet rs=pstmt.executeQuery();
		FileWriter write=new FileWriter("productsHistory.txt",false);
		while(rs.next()) {
			int pid=rs.getInt("product_id");
			String change=rs.getString("change_type");
			int qchange=rs.getInt("quantity_change");
			String date=rs.getString("change_date");
			String note=rs.getString("notes");
			String data=String.format("Product ID: "+pid+"\nchange_type: "+change+"\nquantity_change: "+qchange+"\nchange_date: "+date+"\nnotes: "+note+"\n");
    		write.write(data);
		}
		write.close();
		System.out.println("The history has been generated successfully!!!");
	}catch(SQLException e) {
		e.printStackTrace();
	}
}


public void viewProducts() throws SQLException, IOException {
    HashMap<Integer, String> hm = new HashMap<>();
    String query = "SELECT product_id, product_name, product_type, quantity, price, storage_requirements FROM products";
    try {
        PreparedStatement pstmt = con.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            int pid = rs.getInt("product_id");
            String name = rs.getString("product_name");
            String type = rs.getString("product_type");
            int quantity = rs.getInt("quantity");  // Corrected to "quantity"
            int price = rs.getInt("price");
            String sr = rs.getString("storage_requirements");
            hm.put(pid, name + ", " + type + ", " + quantity + ", " + price + ", " + sr);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    for (int i : hm.keySet()) {  // Corrected iteration over HashMap
        System.out.println("Product ID: " + i + " - Details: " + hm.get(i));
    }
}

}