package in.apcfss.controller;

import in.apcfss.dbplugin.DbPlugin;
import in.apcfss.dto.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeReportsDao {
	//private static Singleton single_instance = null;
	private static EmployeeReportsDao obj=new EmployeeReportsDao();//Early, instance will be created at load time  
	 private EmployeeReportsDao(){}  
	   
	 public static EmployeeReportsDao getempagelist(){  
	  return obj;  
	 }  
	 private List<Employee> empagelist(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<Employee> ageemployeesList = new ArrayList<Employee>();
		String sql = null;
		ResultSet rs = null;
		Employee employee=null;
		try
		{
		
			conn = DbPlugin.getConnection();
			String[] age= (req.getParameter("dob1")+"").split("-");
			System.out.println("---age---------"+req.getParameter("dob")+" "+age[0]+" "+age[1]);
			sql="SELECT  * FROM public.employeedetailsform where ((EXTRACT(YEAR from AGE(dob))) between '"+age[0]+"' and '"+age[1]+"' )";
			System.out.println(sql);
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();		
			while(rs.next())
			{
				employee = new Employee();
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
				employee.setQualification(rs.getString("Qualification"));
				employee.setGender(rs.getString("gender"));
				employee.setDoj(rs.getString("dateofjoining"));
				employee.setPancard(rs.getString("pancard"));
				employee.setDob(rs.getDate("dob"));
				employee.setSalary(rs.getFloat("salary"));
				ageemployeesList.add(employee);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("age of view employee error..");
			throw new Exception();
		}
		finally
		{
			pstmt.close();
			conn.close();
		}
		System.out.println(ageemployeesList);
		return ageemployeesList;
		
	}

}
