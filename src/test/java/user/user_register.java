package user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class user_register {
	public static WebDriver driver;
	static Faker faker = new Faker();
	static String firstName = faker.name().firstName();
	static String lastName = faker.name().lastName();
	static String Nemail = firstName + lastName;
	static String nomail = Nemail;
	static String Email = Nemail + "@mailinator.com";
	static String user = Email;
	static String phoneNumber = faker.phoneNumber().phoneNumber();
	static String password = "test@123";
	static String url = "https://www.codespotfoundation.org/app/user-sign-up";
	static String college = "psg";
	static String Department = "CSE";
	static String tech = "fortran";

	public static WebDriver admin_login() throws InterruptedException {
		
		//launching browser	
		
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-allow-origins", "http://127.0.0.1:45411/");
		// options.addArguments("--headless");
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.get(url);
		Thread.sleep(5000);
		return driver;
	}

	public static void register() throws InterruptedException {
		//firstname
		driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys(firstName);
		//lastname
		driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(lastName);
		//Email
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Email);
		//Phonenumber
		driver.findElement(By.xpath("//input[@id='mat-input-3']")).sendKeys(phoneNumber);
		//password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		Thread.sleep(3000);
		//click continue
		driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		//entering department details
		driver.findElement(By.xpath("//input[@data-placeholder='Enter your study']")).sendKeys(Department);
		//Enterning college details
		driver.findElement(By.xpath("//input[@id='mat-input-5']")).sendKeys(college);
		//get all listed college
		List<WebElement> csgs = driver.findElements(By.xpath("//mat-option[@role='option']"));
		//Click right college
		for (WebElement clg : csgs) {
			String college_name = clg.getText();
			System.out.println(college_name);
			if (college_name.equalsIgnoreCase("PSG College of Technology")) {
				System.out.println("pass");
				clg.click();
				break;
			}
		}
		//select starting year
		driver.findElement(By.xpath("//mat-select[@id='mat-select-4']")).click();
		Thread.sleep(3000);
		List<WebElement> starting_year_clg = driver.findElements(By.xpath("//mat-option[@role='option']"));
		for (WebElement starting_year : starting_year_clg) {
			String start_year = starting_year.getText();
			System.out.println(start_year);
			if (start_year.equalsIgnoreCase("2018")) {
				System.out.println("pass");
				starting_year.click();
				break;
			}
		}
		//select ending year
		driver.findElement(By.xpath("//mat-select[@id='mat-select-6']")).click();
		Thread.sleep(3000);
		List<WebElement> ending_year_clg = driver.findElements(By.xpath("//mat-option[@role='option']"));
		for (WebElement ending_year : ending_year_clg) {
			String End_year = ending_year.getText();
			System.out.println(End_year);
			if (End_year.equalsIgnoreCase("2022")) {
				System.out.println("pass");
				ending_year.click();
				break;
			}
		}
		//choose gender
		driver.findElement(By.xpath("//mat-select[@id='mat-select-8']")).click();
		List<WebElement> gender = driver.findElements(By.xpath("//mat-option[@role='option']"));
		for (WebElement male : gender) {
			String gender_male = male.getText();
			if (gender_male.equalsIgnoreCase("male")) {
				male.click();
				break;
			}
		}
		//enter technical knowledge
		WebElement tech_skill = driver.findElement(By.xpath("//input[@id='mat-chip-list-input-0']"));
		tech_skill.sendKeys(tech);
		Thread.sleep(3000);
		List<WebElement> list_of_tech_skills = driver.findElements(By.xpath("//mat-option[@role='option']"));
        //get tech suggestions
		for (WebElement list_of_tech_skill : list_of_tech_skills) {
			String required_skill = list_of_tech_skill.getText();
			if (required_skill.equalsIgnoreCase("fortran")) {
				list_of_tech_skill.click();
				break;
			}
		}
		//click create account
		driver.findElement(By.xpath("//span[text()=' Create Your New Account ']")).click();
		Thread.sleep(15000);
		//navigate to maininator for mail verifications
		driver.get("https://www.mailinator.com/");
		//enter registered mail
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys(nomail);
		driver.findElement(By.xpath("//button[text()='GO']")).click();
		Thread.sleep(4000);
		//click verification mail
		driver.findElement(By.xpath("//table[@class='table-striped jambo_table']//tr//td[3]")).click();
		//switch to frame
		WebElement verification_frame = driver.findElement(By.xpath("//iframe[@id='html_msg_body']"));
		Thread.sleep(5000);
		driver.switchTo().frame(verification_frame);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement verify = driver.findElement(By.xpath("//a[text()='Verify Account']"));
		//click to verify account
		js.executeScript("arguments[0].click();", verify);
		//navigate to login page by using windowhandles
		String parent = driver.getWindowHandle();
		ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		for (String handle : windowHandles) {
			String str = handle.toString();
			if (!(str.equals(parent))) {
				driver.switchTo().window(handle);
				Thread.sleep(30000);
				//login by using registered credentials
				driver.findElement(By.xpath("//input[@id='email']")).sendKeys(user);
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
				Thread.sleep(4000);
				driver.findElement(By.xpath("//span[text()=' Login ']")).click();
	    	}
		}
	  Thread.sleep(5000);
   }

	public static void close() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();

	    } 
  }