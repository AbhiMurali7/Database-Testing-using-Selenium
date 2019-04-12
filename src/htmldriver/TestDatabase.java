package htmldriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDatabase {

	public static void main(String[] args) throws  ClassNotFoundException, SQLException {
		
		//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
        String dbUrl = "jdbc:mysql://localhost:3306/facebook";					

		//Database Username		
		String username = "root";	
        
		//Database Password		
		String password = "";				

		//Query to Execute		
		String query = "select *  from fname;";	
        
 	    //Load mysql jdbc driver		
   	    Class.forName("com.mysql.jdbc.Driver");			
   
   		//Create Connection to DB		
    	Connection con = DriverManager.getConnection(dbUrl,username,password);
  
  		//Create Statement Object		
	   Statement stmt = con.createStatement();					

			// Execute the SQL Query. Store results in ResultSet		
 		ResultSet rs= stmt.executeQuery(query);							
 
 		// While Loop to iterate through all data and print results		
		while (rs.next()){
			String uname=    rs.getString("uname");
			String pass=     rs.getString("pass");
			String email=    rs.getString("email");					                               
			System.out.println("Uname is "+uname+" password is "+pass+" email id is "+email);		
            }		
			 // closing DB Connection		
			con.close();	

	}

}