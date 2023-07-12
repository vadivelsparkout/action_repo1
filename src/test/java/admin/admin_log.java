package admin;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class admin_log {
	
	WebDriver driver;
	String description="RevolutionizeTech: Inspiring Minds, Empowering Innovators";
	String agenda="TechXpo: Explore the Future of Technology, Robotics, Artificial Intelligence, Cybersecurity, and Data Science";
	@BeforeClass
	public void admin_login() throws InterruptedException {

		System.setProperty("webdriver.http.factory", "jdk-http-client");
	    driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-allow-origins", "http://127.0.0.1:45411/");
		driver.get("https://www.codespotfoundation.org/app/sign-in");
		Thread.sleep(5000);

	}
	@Test(priority = 1)
	public void login() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("Super@mailinator.com");
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("test@123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),' Login ')]")).click();
		Thread.sleep(10000);
		

	}
	
	@Test(priority = 2)
	public void create_event() throws InterruptedException {
		driver.findElement(By.xpath(" //span[contains(text(),' Event Management ')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),' Create Event ')]")).click();
		
		//create event
		driver.findElement(By.xpath("//input[@id=\"event-title\"]")).sendKeys("test event");
		//click session or workshop
		driver.findElement(By.xpath("//span[contains(text(),'Workshop ')]")).click();
		
		//banner image
		WebElement bann=driver.findElement(By.xpath("(//input[@id=\"fileInput\"])[1]"));
		bann.sendKeys("/home/sparkout/eclipse-workspace/codespot/src/main/resources/banner.jpeg");
		System.out.println("banner uploaded'");
		
		//banner description
		driver.findElement(By.xpath("(//div[@data-placeholder=\"Insert text here ...\"])[1]"))
		.sendKeys(description);
		
		//event agenta
		driver.findElement(By.xpath("(//div[@data-placeholder=\"Insert text here ...\"])[2]"))
		.sendKeys(agenda);
		
		List<String>tags=new  ArrayList<String>();  
		tags.add("new");
		tags.add("event");
		
		for (String tag : tags) {
			WebElement new_tag=	driver.findElement(By.xpath("//input[@id=\"mat-chip-list-input-0\"]"));
			new_tag.sendKeys(tag);
			new_tag.sendKeys(Keys.ENTER);
			}
		
		driver.findElement(By.xpath("//div[@id=\"mat-select-value-1\"]")).click();
		List<WebElement> stimes=driver.findElements(By.xpath("//div[@role=\"listbox\"]//mat-option"));
		for (WebElement stime : stimes) {
			String num1=stime.getText();
			if(num1.equalsIgnoreCase("23")) {
				stime.click();
			}
			}
		driver.findElement(By.xpath("//div[@id=\"mat-select-value-3\"]")).click();
		//div[@role="listbox"]//mat-option
		List<WebElement> stimeends=driver.findElements(By.xpath("//div[@role=\"listbox\"]//mat-option"));
		for (WebElement stimeend : stimeends) {
			String num1=stimeend.getText();
			if(num1.equalsIgnoreCase("23")) {
				stimeend.click();
				
				
				
			}
		}
		driver.findElement(By.xpath("//div[@id=\"mat-select-value-5\"]")).click();
		List<WebElement> etimeends=driver.findElements(By.xpath("//div[@role=\"listbox\"]//mat-option"));
		for (WebElement etimeend : etimeends) {
			String num1=etimeend.getText();
			if(num1.equalsIgnoreCase("17")) {
				etimeend.click();
			}
		}
		
		
		
		
		
		driver.findElement(By.xpath("//input[@id=\"venue\"]")).sendKeys("North Coimbatore, Coimbatore, Tamil Nadu, India");
		
	    driver.findElement(By.xpath("//input[@id=\"speaker-name\"]")).sendKeys("test speaker");
		
	    
	    
	    
	    WebElement fileup=driver.findElement(By.xpath("//input[@id=\"fileInput\"]"));
	
	    fileup.sendKeys("/home/sparkout/eclipse-workspace/codespot/src/main/resources/banner.jpeg");
	    driver.findElement(By.xpath("//input[@id=\"link\"]")).sendKeys("https://www.linkedin.com/login");
	    driver.findElement(By.xpath("//input[@id=\"designation\"]")).sendKeys("CEO");
		
		
		

			
		
				
			}
	
	
	@AfterClass
	public void close() throws InterruptedException {
	
		
		System.out.println("event created");
	}
}
