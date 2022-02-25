package com.sddevops.DevOpsProject;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {
  //declare Selenium WebDriver
  private WebDriver webDriver; 	
  private String Name;
  
  public String generateRandomName(int length) {
      char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
              .toCharArray();
      StringBuilder sb = new StringBuilder();
      Random random = new Random();
      for (int i = 0; i < length; i++) {
          char c = chars[random.nextInt(chars.length)];
          sb.append(c);
      }
      String randomString = sb.toString();
      return randomString;
  }
  
  @Test
  public void checkTitle() {
	  //Load website as a new page
	  webDriver.navigate().to("http://localhost:8090/DevOpsProject/UserServlet/dashboard");
	  
	  //Assert the title to check that we are indeed in the correct website
	  Assert.assertEquals(webDriver.getTitle(), "User Management");
	  
	  System.out.println("title: "+webDriver.getTitle());
	  
	  //Retrieve link using it's class name and click on it
	  webDriver.findElement(By.className("btnbtnsuccess")).click();

	  //Assert the new title to check that the title contain Wikipedia and the button had successfully bring us to the new page
	  Assert.assertTrue(webDriver.getTitle().contains("User Registration"));
	  System.out.println("new title: "+webDriver.getTitle());
	  
	   
  }
  @Test
  // Create a registration function to test it out
  public void Registration() {
	  
	  // Go to this page 
	  
	  webDriver.navigate().to("http://localhost:8090/DevOpsProject/register.jsp");
	  
	  // Go to this page with a title called 'User Registration'
	  
	  Assert.assertEquals(webDriver.getTitle(), "User Registration");
	  
	  System.out.println("title: "+webDriver.getTitle());
	  
	  // Go to the 1st input
	  
	  WebElement name =  webDriver.findElement(By.xpath("/html/body/form/input[1]"));
	  
	  // Input
	  
	  name.sendKeys("Moho");
	  
	// Go to the 2nd input
	  
	  WebElement password =  webDriver.findElement(By.xpath("/html/body/form/input[2]"));
	  
	  // Input
	  
	  password.sendKeys("1234");
	  
	// Go to the 3rd input
	   
	  WebElement email =  webDriver.findElement(By.xpath("/html/body/form/input[3]"));
	  
	  //input 
	  
	  email.sendKeys("Moho@gmail.com");
	  
	  // press the button with class name 'register'
	  
	  webDriver.findElement(By.className("register")).click();
	  
	  // press the button with class name 'afterregister'
	  
	  webDriver.findElement(By.className("SuccessRegister")).click();
	  
	  // Go to the page with the title named 'User Management'
	  
	  Assert.assertTrue(webDriver.getTitle().contains("User Management"));
	  System.out.println("new title: "+webDriver.getTitle());
	  
  }
	  @Test
	  public void Edit() {
		  webDriver.navigate().to("http://localhost:8090/DevOpsProject/UserServlet/dashboard");
		 
		  Name = generateRandomName(9);
		  
		  Assert.assertEquals(webDriver.getTitle(), "User Management");
		  
		  System.out.println("title: "+webDriver.getTitle());
		  
		  webDriver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[1]/td[4]/a[1]")).click();

		  
		  WebElement name2 =  webDriver.findElement(By.xpath("/html/body/div/div/div/form/fieldset[1]/input"));
		  
		  name2.sendKeys(Keys.chord(Keys.CONTROL, "a"), Name );
		  
		  WebElement password2 =  webDriver.findElement(By.xpath("/html/body/div/div/div/form/fieldset[2]/input"));
		  		  	  
		  password2.sendKeys(Keys.chord(Keys.CONTROL, "a"),Name);
		  
		  WebElement email2 =  webDriver.findElement(By.xpath("/html/body/div/div/div/form/fieldset[3]/input"));
		  
		  email2.sendKeys(Keys.chord(Keys.CONTROL, "a"), Name +"@gmail.com");
		  
		  webDriver.findElement(By.className("btnbtn-success")).click();
		  
		  Assert.assertTrue(webDriver.getTitle().contains("User Management"));
		  System.out.println("new title: "+webDriver.getTitle()); 
		  
		
	  }
	   
	  @Test
	  public void Delete() {
		  webDriver.navigate().to("http://localhost:8090/DevOpsProject/UserServlet/dashboard");
		  
		  Assert.assertEquals(webDriver.getTitle(), "User Management");
		  
		  webDriver.findElement(By.xpath("/html/body/div")).click();
		  
	  
	  }
	  
  
  @BeforeTest
  public void beforeTest() {
	  //Setting system properties of ChromeDriver
	  //to amend directory path base on your local file path
	  String chromeDriverDir = "C:\\Program Files\\Google\\Chrome\\chromedriver.exe";

	  System.setProperty("webdriver.chrome.driver", chromeDriverDir);

	  //initialize FirefoxDriver at the start of test
	  webDriver = new ChromeDriver();  
  }

  @AfterTest
  public void afterTest() {
	  //Quit the ChromeDriver and close all associated window at the end of test
	  webDriver.quit();			
  }
	// declare Selenium WebDriver
	private WebDriver webDriver1;

	@Test

	// shows all details of the users on dashboard
	public void checkTitle1() {
		// Load website as a new page
		webDriver1.navigate().to("http://localhost:8091/DevOpsProject/ProfileServlet/dashboard");

		// Assert the title to check that we are indeed in the correct website
		Assert.assertEquals(webDriver.getTitle(), "Profile Management");

		System.out.println("title: " + webDriver.getTitle());

		// Retrieve link using it's class name and click on it
		webDriver1.findElement(By.className("btnsuccess")).click();

		// Assert the new title to check that the title contain Wikipedia and the button
		// had successfully bring us to the new page
		Assert.assertTrue(webDriver1.getTitle().contains("Add Profile"));
		System.out.println("new title: " + webDriver1.getTitle());
	}

	@Test
	// add profile page form
	public void AddProfile() {
		webDriver1.navigate().to("http://localhost:8091/DevOpsProject/addprofile.jsp");

		Assert.assertEquals(webDriver.getTitle(), "Add Profile");

		System.out.println("title: " + webDriver1.getTitle());

		WebElement name = webDriver1.findElement(By.xpath("/html/body/form/input[1]"));

		name.sendKeys("john3edxample");

		WebElement password = webDriver1.findElement(By.xpath("/html/body/form/input[2]"));

		password.sendKeys("eclipseTdest3");

		webDriver1.findElement(By.className("addprofilebtn")).click();		
		webDriver1.findElement(By.className("nextpagebtn")).click();

		Assert.assertTrue(webDriver1.getTitle().contains("Profile Management"));
		System.out.println("new title: " + webDriver1.getTitle());

	}

	@Test
	public void Edit1() {
		webDriver1.navigate().to("http://localhost:8091/DevOpsProject/ProfileServlet/dashboard");

		Assert.assertEquals(webDriver1.getTitle(), "Profile Management");

		System.out.println("title: " + webDriver1.getTitle());

		webDriver1.findElement(By.xpath("/html/body/div/div/table/tbody/tr[1]/td[4]/a[1]")).click();

		WebElement name2 = webDriver1.findElement(By.xpath("/html/body/div/div/div/form/fieldset[1]/input"));

		name2.sendKeys(Keys.chord(Keys.CONTROL, "a"), "editname233");

		WebElement password2 = webDriver1.findElement(By.xpath("/html/body/div/div/div/form/fieldset[2]/input"));

		password2.sendKeys(Keys.chord(Keys.CONTROL, "a"), "editpassw2o3rd3");

		webDriver1.findElement(By.className("editbutton")).click();

		Assert.assertTrue(webDriver1.getTitle().contains("Profile Management"));
		System.out.println("new title: " + webDriver1.getTitle());

	}

	@Test
	public void Delete1() {
		webDriver.navigate().to("http://localhost:8091/DevOpsProject/ProfileServlet/dashboard");

		Assert.assertEquals(webDriver1.getTitle(), "Profile Management");

		webDriver1.findElement(By.xpath("/html/body/div")).click();

	}

	@BeforeTest
	public void beforeTest1() {
		// Setting system properties of ChromeDriver
		// to amend directory path base on your local file path
		String chromeDriverDir = "C:\\Program Files\\Google\\Chrome\\chromedriver.exe";

		System.setProperty("webdriver1.chrome.driver", chromeDriverDir);

		// initialize FirefoxDriver at the start of test
		webDriver1 = new ChromeDriver();
	}

	@AfterTest
	public void afterTest1() {
		// Quit the ChromeDriver and close all associated window at the end of test
		webDriver1.close();
	}

}