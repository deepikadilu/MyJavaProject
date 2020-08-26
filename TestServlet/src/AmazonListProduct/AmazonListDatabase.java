package AmazonListProduct;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.net.URL;
import java.net.URLClassLoader;

public class AmazonListDatabase {
	WebDriver driver;
	private static Statement stmt;
	private static ResultSet rs;
	private static PreparedStatement pstmt;
	private static Connection con;
	
	public AmazonListDatabase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void insertDatabase(String BestsellersTitle) throws ClassNotFoundException, SQLException {
		
		String query1 = "insert into AmazonSearch values(?) ";
		
		try {
			con = DatabaseConnection.initializeDatabase(); 
			
			pstmt = con.prepareStatement(query1);
			pstmt.setString(1, BestsellersTitle); 
			pstmt.executeUpdate();	
			}
			catch (SQLException e1) 
			{
			e1.printStackTrace();
			}
		finally 
		{
			try {
			con.close();
			pstmt.close();
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
	}
}
	