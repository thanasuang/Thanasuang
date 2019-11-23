package th.co.cdgs.application;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import th.co.cdgs.bean.CustomerDto;

@Path("customer")
public class CustomerController {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomer() {
		List<CustomerDto> list = new ArrayList<>();
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
		conn = DriverManager.getConnection("jbc:msql://localhost:3306/workshop","root","root");
		pst = conn.prepareStatement("INSERT INTO customer (first_name,last_name,address,tel.email)"
				+"VALUES (?,?,?,?,?)");
		int index = 1;
		pst.setString(index++, customer.getFirstName());
		pst.setString(index++, customer.getLastName());
		pst.setString(index++, customer.getAddress());
		pst.setString(index++, customer.getTel());
		pst.setString(index++, customer.getEmail());
		pst.executeUpdate();
	/*	CustomerDto customerDto = null; 
		while(rs.next()) {
			customerDto = new CustomerDto();
			customerDto.setCustomerID(rs.getLong("customer_ID"));
			customerDto.setFullName(rs.getString("full_name"));
			customerDto.setAddress(rs.getString("address"));
			customerDto.setTel(rs.getString("tel"));
			customerDto.setEmail(rs.getString("email"));
			list.add(customerDto);
		}*/
	} 	catch (SQLException e) {
		e.printStackTrace();
	}
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pst != null)
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return Response.ok().entity(list).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCustomer{

}// class
