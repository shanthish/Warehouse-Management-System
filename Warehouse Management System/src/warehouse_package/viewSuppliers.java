package warehouse_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class viewSuppliers {
	private Connection con;
	public viewSuppliers() {
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Warehouse_Management_System","root","Ramya@25");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
//	public void viewSuppliers() {
//		ArrayList<Integer>al=new ArrayList<>();
//		try {
//			String query="select* from Suppliers";
//	        PreparedStatement pstmt = con.prepareStatement(query);
//	        ResultSet rs=pstmt.executeQuery();
//	        while(rs.next()) {
//	        	int id=rs.getInt("supplier_id");
//	        	String name=rs.getString("supplier_name");
//	        	String cname=rs.getString("contact_name");
//	        	String pno=rs.getString("contact_number");
//	        	String add=rs.getString("address");
//	        	al.add(id,name,cname,pno,add);
//	        }
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		for(auto i:al) {
//			System.out.println(i);
//		}
//	}
	
//	Supplier(int id, String name, String contactName, String contactNumber, String address) {
//        this.id = id;
//        this.name = name;
//        this.contactName = contactName;
//        this.contactNumber = contactNumber;
//        this.address = address;
//    }

//    @Override
//    public String toString() {
//        return "Supplier ID: " + id + ", Name: " + name + ", Contact Name: " + contactName + 
//               ", Contact Number: " + contactNumber + ", Address: " + address;
//    }
//}

// The viewSuppliers method
public void viewSuppliersfun() {
    ArrayList<supplierops> al = new ArrayList<>();
    try {
        String query = "SELECT * FROM Suppliers";
        PreparedStatement pstmt = con.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("supplier_id");
            String name = rs.getString("supplier_name");
            String cname = rs.getString("contact_name");
            String pno = rs.getString("contact_number");
            String add = rs.getString("address");

            // Add a new Supplier object to the ArrayList
            al.add(new supplierops(id,name,cname,pno,add));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // Display each supplier's information
    for (supplierops supplier : al) {
        System.out.println(supplier);
    }
}

}
