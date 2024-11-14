package warehouse_package;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//
//public class stockRequests {
//
//}
import java.util.Date;

public class stockRequests {
    private int requestId;
    private int productId;
    private int supplierId;
    private int requestedQuantity;
//    private Date requestDate;
    private String status;
    private Connection con;
    // Constructor
    public stockRequests(int productId, int supplierId, int requestedQuantity,String status) {
//        this.requestId = requestId;
        this.productId = productId;
        this.supplierId = supplierId;
        this.requestedQuantity = requestedQuantity;
//        this.requestDate = requestDate;
        this.status = status;
		try{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Warehouse_Management_System","root","Ramya@25");
		}
			catch(SQLException e) {
			e.printStackTrace();
		}
    }
    public void addRequests(int productId, int supplierId, int requestedQuantity,String status) {
    	String query="insert into StockRequests(product_id,supplier_id,requested_quantity,status) values(?,?,?,?)";
    	try{
   		 PreparedStatement pstmt=con.prepareStatement(query);
   		 pstmt.setInt(1,productId);
   		 pstmt.setInt(2,supplierId);
   		 pstmt.setInt(3,requestedQuantity);
   		 pstmt.setString(4,status);
   		 pstmt.executeUpdate();
   	 }catch(SQLException e) {
   		e.printStackTrace();
   	 }
    	System.out.println("The requested had been requested successfully");
    }


}
