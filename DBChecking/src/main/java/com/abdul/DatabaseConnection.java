
package com.abdul;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DatabaseConnection {
	 

public static void main(String[] args) throws SQLException {
String jdbcUrl = "jdbc:sqlserver://localhost:1433;databaseName=DB_checking;instanceName=SQLEXPRESS ";
String username = "sa";
String password = "root";

Connection conn = null;
Statement stmt = null;

try {

conn = DriverManager.getConnection(jdbcUrl, username, password);
stmt = conn.createStatement();

//stmt.executeUpdate(CREATE_TABLE_SQL);



Scanner scanner = new Scanner(System.in);

             System.out.println("Enter Empolyee ID");
String Empolyee_ID=scanner.nextLine();

             System.out.println("Enter Empolyee Name");
String Empolyee_Name=scanner.nextLine();


String sql="insert into Empolyee values('" + Empolyee_ID + "','" + Empolyee_Name + "')";
stmt.executeUpdate(sql);

System.out.println("inserted sucessfully");





ResultSet rs=stmt.executeQuery("select * from Empolyee");  
System.out.println("Empolye_ID   Empolye_Name");
while(rs.next())  
	
System.out.println(rs.getInt(1)+"            "+rs.getString(2)+"");  
conn.close();
} 

catch (SQLException e)
{
	 String CREATE_TABLE="CREATE TABLE Empolyee ("
            + "EMPOLYE_ID INT NOT NULL,"
            + "EMPOLYENAME VARCHAR(45))";


	stmt.executeUpdate(CREATE_TABLE);
	
	System.out.println("Table created");
     
	e.printStackTrace();
} 
finally
{
try {
 // Close connection
 if (stmt != null) {
   stmt.close();
 }
 if (conn != null) {
   conn.close();
 }
} catch (Exception e) {
 e.printStackTrace();
}
}
}
}