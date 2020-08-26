package AmazonListProduct;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonBookPage {
		WebDriver driver;
	
		@FindBy(xpath="//*[@id='searchDropdownBox']")
	    WebElement drpCategory;
		
		
		//Constructor with PageFactory instance
		public AmazonBookPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			}
		@Test(priority = 1)
		// Function to select user search - Category
		public void searchForCategory(String text, String userSearch) throws InterruptedException
		{
			// We continue using the element just as before
			 Select select = new Select(drpCategory);
			 select.selectByVisibleText(text);
			// Thread.sleep(3000);
			 driver.findElement(By.className("nav-input")).click();
			 
			 //Functionality to Select Bestsellers from the subnav section
			 Actions actions=new Actions(driver);
		        //Retrieve WebElement 'bestseller' to perform mouse hover 
			 WebElement mainmenu=driver.findElement(By.xpath("//*[@id=\"nav-subnav\"]/a[4]/span[1]"));
		    	//Mouse hover menuOption 'bestseller'
			 actions.moveToElement(mainmenu);
			 actions.click().build().perform();
			 System.out.println("Done Mouse hover on 'best seller' from Menu and is selected");	
			 
		    // To check assertion of text in the webpage with the user provided one.
			 WebElement webpageText=driver.findElement(By.tagName("h1"));
			 String strng = webpageText.getText();
			 System.out.println(strng);
			 Assert.assertTrue(strng.contains(userSearch), strng + " doesn't contains"+ userSearch);
			 		 
		}	
		// to print all the titles of books
		@Test(priority = 2)
		public void printTitles() throws InterruptedException, ClassNotFoundException, SQLException {

		    // print the books title details
		    List<WebElement> products = driver.findElements(By.className("p13n-sc-truncated"));
		    System.out.println("List size : "+products.size());
		   // for(WebElement product:products)
		    //create and instance of the amazonDB
		    AmazonListDatabase amazonDB= new AmazonListDatabase(driver);
		    for(int i=0;i<10;i++){
		    String BestsellersTitle = products.get(i).getText();
		    System.out.println(products.get(i).getText());
		    amazonDB.insertDatabase(BestsellersTitle);
		    }
		    Thread.sleep(2000);
		    
		    // add title details to database
		   //AmazonListDatabase amazonDB= new AmazonListDatabase(driver);
		  // amazonDB.updateDatabase();
		  // driver.close();
		    
		    
		    }  
		 
		}
			
	


