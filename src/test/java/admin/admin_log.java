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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class admin_log {

	static WebDriver driver;
	static String description="RevolutionizeTech: Inspiring Minds, Empowering Innovators";
	static String agenda="TechXpo: Explore the Future of Technology, Robotics, Artificial Intelligence, Cybersecurity, and Data Science";
	
	
	@BeforeTest
	public static Object admin_login() throws InterruptedException {

		System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-allow-origins", "http://127.0.0.1:45411/");
		driver.get("https://www.codespotfoundation.org/app/sign-in");
		Thread.sleep(5000);
		return null;

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
	public static Object create_event() throws InterruptedException {
		driver.findElement(By.xpath(" //span[contains(text(),' Event Management ')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),' Create Event ')]")).click();

		//create event
		driver.findElement(By.xpath("//input[@id=\"event-title\"]")).sendKeys("test event");
		//click session or workshop
		driver.findElement(By.xpath("//span[contains(text(),'Workshop ')]")).click();
		Thread.sleep(3000);



		//banner description
		driver.findElement(By.xpath("(//div[@data-placeholder=\"Insert text here ...\"])[1]"))
		.sendKeys(description);

		//event agenta
		driver.findElement(By.xpath("(//div[@data-placeholder=\"Insert text here ...\"])[2]"))
		.sendKeys(agenda);




		WebElement vn=driver.findElement(By.xpath("//input[@id=\"venue\"]"));
		vn.sendKeys("North Coimbatore, Coimbatore, Tamil Nadu, India");

		driver.findElement(By.xpath("//input[@id=\"speaker-name\"]")).sendKeys("test speaker");

		driver.findElement(By.xpath("//input[@id=\"link\"]")).sendKeys("https://www.linkedin.com/login");
		driver.findElement(By.xpath("//input[@id=\"designation\"]")).sendKeys("CEO");



		List<String>tags=new  ArrayList<String>();  
		tags.add("new");
		tags.add("event");

		WebElement new_tag=	driver.findElement(By.xpath("//input[@id=\"mat-chip-list-input-0\"]"));

		for (String tag : tags) {
			new_tag.sendKeys(tag);
			new_tag.sendKeys(Keys.ENTER);
			new_tag.sendKeys(Keys.TAB);
		}
		WebElement date=driver.findElement(By.xpath("//button[@aria-label=\"Open calendar\"]"));
		date.click();
		List<WebElement> month=driver.findElements(By.xpath("//table[@class=\"mat-calendar-table\"]//tbody//tr//td"));
		for (WebElement mon : month) {
			String n2=mon.getText();
			System.out.println(n2);
			if (n2.equalsIgnoreCase("24")) {
				mon.click();
				//table[@class="mat-calendar-table"]//tbody//tr//td
			}
			List<WebElement> year=driver.findElements(By.xpath("//table[@class=\"mat-calendar-table\"]//tbody//tr//td"));
			for (WebElement yer : year) {
				String n1= yer.getText();
				System.out.println(n1);
				if (n1.equalsIgnoreCase("2024")) {
					yer.click();
				}	
			}
			//		 WebElement d= driver.findElement(By.xpath("//table//tbody//tr//td[@aria-label=\"January 2024\"]"));
			//		 System.out.println(d.getText());
			List<WebElement> month1=driver.findElements(By.xpath("//table[@class=\"mat-calendar-table\"]//tbody//td//div[2]"));
			Thread.sleep(3000);
			for (WebElement mon1: month1) {
				String n21=mon.getText();
				System.out.println(n2);
				if (n2.equalsIgnoreCase("JUL")) {
					mon.click();
					//table[@class="mat-calendar-table"]//tbody//tr//td
				}
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
			List<WebElement> stimeends=driver.findElements(By.xpath("//div[@id=\"mat-select-2-panel\"]//mat-option"));
			for (WebElement stimeend : stimeends) {
				String num1=stimeend.getText();
				if(num1.equalsIgnoreCase("12")) {
					stimeend.click();
					Thread.sleep(3000);
				}
			}
		}
		return null;
	}



	@AfterClass
	public void close() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("event created");
	}
}
