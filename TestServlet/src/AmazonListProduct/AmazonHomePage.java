package AmazonListProduct;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import POMPageFactory.GoogleSearchPage;
import org.testng.annotations.BeforeTest;
public class AmazonHomePage {

	public static void main(String[] args) throws InterruptedException, ClassNotFoundException, SQLException
	{
		// Create a new instance of a driver
				System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();	
		        // Navigate to amazon
		        driver.get("https://www.amazon.in/");
		        driver.manage().window().maximize();	
		        
		        //Create a new instance of the search page class
		        AmazonBookPage searchBook = new AmazonBookPage(driver);
		        
		     // And now do the search with 2 parameters
				searchBook.searchForCategory("Books", "Bestsellers");
				searchBook.printTitles();
	
}
}