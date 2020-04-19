package onlinepayment;




import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Payments")
public class PaymentResource {
	
	PaymentRepository pr =new PaymentRepository();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Payment> getAllPayment(){
		return  pr.getAllPayments();
	}
	
	@POST
	@Path("/Payment")
	@Consumes(MediaType.APPLICATION_JSON)
	public Payment createPayment(Payment P1) {
		
		return pr.createPayment(P1);
	}
	
	@PUT
	@Path("/Payments")
	@Consumes(MediaType.APPLICATION_JSON)
	public Payment updatePayment(Payment P1) {
		System.out.println(P1);
		pr.updatePayment(P1);
		return P1;
	}
	
	@DELETE
	@Path("/Payments")
	@Consumes(MediaType.APPLICATION_JSON)
	public String deletePayment(@PathParam("id")int id)
	{
		pr.deletePayment(id);
		return "Succefully Deleted Payment";
	}
	
	
}
