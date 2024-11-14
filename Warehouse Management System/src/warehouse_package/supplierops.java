package warehouse_package;

import java.sql.Connection;

public class supplierops {
	      private int id;
		  private String name;
		  private String contact_name;
		  private String Contactno;
		  private String address;
		  
	 public supplierops(int id,String name, String contact_name, String contactno, String address) {
		    this.id=id;
			this.name = name;
			this.contact_name = contact_name;
			this.Contactno = contactno;
			this.address = address;
			}
	    public String toString() {
	        return "Supplier ID: " + id + ", Name: " + name + ", Contact Name: " + contact_name + 
	               ", Contact Number: " + Contactno + ", Address: " + address;
	    }
}
