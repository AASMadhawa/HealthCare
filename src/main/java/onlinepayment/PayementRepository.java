package onlinepayment;


import com.HelthCare.Database.DatabaseClass;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.HelthCare.Database.DatabaseClass;
public class PaymentRepository {
	
	Connection con =null;
	List<Payment> payments;
	public PaymentRepository() {
		
	/*	String url ="jdbc:mysql://localhost:3606/PaymentApiProject";
		String username = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		}catch(Exception e) {
			System.out.println(e);
		} */
		
		
		payments = new ArrayList<>();
		
		Payment P1 = new Payment();
		P1.setId (003);
		P1.setType("card");
		P1.setAmount (3000);	
		P1.setDate ("7/04/2020");
		P1.setDescription ("Only Chaneling Charges");
		P1.setEmail("madhawa@gmail.com");
		
		Payment P2 = new Payment();
		P2.setId (004);
		P2.setType("card");
		P2.setAmount (5000);	
		P2.setDate ("5/04/2020");
		P2.setDescription ("Chaneling and Report Charges");
		P2.setEmail("Rashmi@gmail.com");
		
		Payment P3 = new Payment();
		P3.setId (005);
		P3.setType("card");
		P3.setAmount (1000);	
		P3.setDate ("9/04/2020");
		P3.setDescription ("only Chaneling Charges");
		P3.setEmail("gihan@gmail.com");
		
		payments.add(P1);
		payments.add(P2);
		payments.add(P3);
		
	}
	
	public List<Payment> getAllPayments(){
		return payments;
	}
	
	public Payment createPayment(Payment P1) {
		String sql ="INSERT INTO `payment`(`id`, `Type`, `Amount`, `Date`, `Description`, `email`) VALUES (?,?,?,?,?,?))";
		try {
			PreparedStatement py = con.prepareStatement(sql);
			py.setInt(1,P1.id);
			py.setString(2,P1.type);
			py.setInt(3,P1.amount);
			py.setString(4,P1.date);
			py.setString(5,P1.description);
			py.setString(6,P1.email);
			
			py.executeUpdate();
		
			}catch(Exception e) {
				System.out.println(e);
			}
		payments.add(P1);
		System.out.println(payments);
		return P1;
	}
	
	public void updatePayment(Payment P1) {
		String sql = "Update Payment SET Amount = ? WHERE id = ?";
		
		try {
			PreparedStatement st = DatabaseClass.getDBconnetion().prepareStatement(sql);
			st.setInt(1,P1.getAmount());
			st.setString(2,P1.getDate());
			
			st.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void deletePayment(int id) {
		String sql = "DELETE FROM Payment WHERE id = ?";
		String output="";
		
		try {
			PreparedStatement st = DatabaseClass.getDBconnection().prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
			
			output = "Deleted Payment Succefully";
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}

