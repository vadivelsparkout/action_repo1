package admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	static String description = "RevolutionizeTech: Inspiring Minds, Empowering Innovators";
	static String agenda = "TechXpo: Explore the Future of Technology, Robotics, Artificial Intelligence, Cybersecurity, and Data Science";

	public static WebDriver admin_login() throws InterruptedException {

		System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-allow-origins", "http://127.0.0.1:45411/");
		driver.manage().window().maximize();
		driver.get("https://www.codespotfoundation.org/app/sign-in");
		Thread.sleep(5000);
		return driver;

	}

	public static void login() throws InterruptedException {

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Super@mailinator.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("test@123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),' Login ')]")).click();
		Thread.sleep(10000);
	

	}

	public static void create_event() throws InterruptedException {

		// click event management
		driver.findElement(By.xpath(" //span[contains(text(),' Event Management ')]")).click();
		// click create event
		driver.findElement(By.xpath("//span[contains(text(),' Create Event ')]")).click();
		// create event title
		driver.findElement(By.xpath("//input[@id='event-title']")).sendKeys("test event");
		// click session or workshop
		driver.findElement(By.xpath("//span[contains(text(),'Workshop ')]")).click();
		Thread.sleep(3000);
		// add banner
		WebElement banner = driver.findElement(By.xpath("(//input[@type='file'])[1]"));
		System.out.println(banner.isEnabled());
		banner.sendKeys("/home/sparkout/eclipse-workspace/codespot/src/main/resources/banner.jpeg");
		Thread.sleep(6000);
		// banner description
		driver.findElement(By.xpath("(//div[@data-placeholder='Insert text here ...'])[1]")).sendKeys(description);
		// event agenda
		driver.findElement(By.xpath("(//div[@data-placeholder='Insert text here ...'])[2]")).sendKeys(agenda);
		// add tags
		List<String> tags = new ArrayList<String>();
		tags.add("new");
		tags.add("event");
		WebElement new_tag = driver.findElement(By.xpath("//input[@id='mat-chip-list-input-0']"));
		for (String tag : tags) {
			new_tag.sendKeys(tag);
			new_tag.sendKeys(Keys.ENTER);
			new_tag.sendKeys(Keys.TAB);
		}
		driver.findElement(By.xpath("(//button[@type='button'])[17]")).click();
		driver.findElement(By.xpath("//button[@cdkarialive='polite']")).click();
		Thread.sleep(5000);
		// year selected
		List<WebElement> years = driver.findElements(By.xpath("//table[@class='mat-calendar-table']//tbody//tr//td"));
		for (WebElement year : years) {
			String yname = year.getText();
			if (yname.equalsIgnoreCase("2024")) {
				year.click();
				break;
			}
		}
		// month selected
		Thread.sleep(5000);
		List<WebElement> Months = driver.findElements(By.xpath("//table[@class='mat-calendar-table']//tbody//tr//td"));
		for (WebElement month : Months) {
			String mname = month.getText();
			if (mname.equalsIgnoreCase("JUL")) {
				month.click();
				break;
			}
		}
		// day selected
		Thread.sleep(4000);
		List<WebElement> days = driver.findElements(By.xpath("//table[@class='mat-calendar-table']//tbody//tr//td"));

		for (WebElement day : days) {
			String dname = day.getText();
			if (dname.equalsIgnoreCase("12")) {
				day.click();
				break;
			}
		}
		// s1 selected
		driver.findElement(By.xpath("//mat-select[@id='mat-select-0']")).click();
		List<WebElement> stime1 = driver.findElements(By.xpath("//mat-option[@role='option']"));
		for (WebElement stimea : stime1) {
			String n1 = stimea.getText();
			if (n1.equalsIgnoreCase("03")) {
				stimea.click();
				break;
			}
		}
		// s2 selected
		Thread.sleep(4000);
		driver.findElement(By.xpath("//mat-select[@id='mat-select-2']")).click();
		List<WebElement> stime2 = driver.findElements(By.xpath("//mat-option[@role='option']"));
		for (WebElement stimeb : stime2) {
			String n2 = stimeb.getText();
			if (n2.equalsIgnoreCase("40")) {
				stimeb.click();
				break;
			}
		}
		// s3 selected
		Thread.sleep(4000);
		driver.findElement(By.xpath("//mat-select[@id='mat-select-4']")).click();
		List<WebElement> stime3 = driver.findElements(By.xpath("//mat-option[@aria-disabled='false']"));
		for (WebElement stimec : stime3) {
			String n3 = stimec.getText();
			if (n3.equalsIgnoreCase("20")) {
				stimec.click();
				break;
			}
		}
		// s4 selectetd
		Thread.sleep(3000);
		driver.findElement(By.xpath("//mat-select[@id='mat-select-6']")).click();
		List<WebElement> stime4 = driver.findElements(By.xpath("//mat-option[@role='option']"));
		for (WebElement stimed : stime4) {
			String n4 = stimed.getText();
			if (n4.equalsIgnoreCase("15")) {
				stimed.click();
				break;
			}
		}
		WebElement vn = driver.findElement(By.xpath("//input[@id='venue']"));
		// click venue
		vn.sendKeys("North Coimbatore, Coimbatore, Tamil Nadu, India");
		Thread.sleep(10000);
		List<WebElement> gsuggestions = driver.findElements(By.xpath("//div[@class='pac-item']"));
		// Get the size of the list
		int size = gsuggestions.size();
		// Generate a random index
		Random random = new Random();
		int randomIndex = random.nextInt(size);
		// Select the random element
		WebElement randomElement = gsuggestions.get(randomIndex);
		// Perform actions with the random element
		randomElement.click();
		// add speaker name
		driver.findElement(By.xpath("//input[@id='speaker-name']")).sendKeys("test speaker");
		// add speaker image
		WebElement profile = driver.findElement(By.xpath("(//input[@type='file'])[2]"));
		System.out.println(profile.isEnabled());
		profile.sendKeys("/home/sparkout/eclipse-workspace/codespot/src/main/resources/banner.jpeg");
		Thread.sleep(6000);
		// add link
		driver.findElement(By.xpath("//input[@id='link']")).sendKeys("https://www.linkedin.com/login");
		// add designation
		driver.findElement(By.xpath("//input[@id='designation']")).sendKeys("CEO");
		Thread.sleep(4000);
		// save
		driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();

	}



	@AfterClass
	public void close() throws InterruptedException {

		Thread.sleep(3000);
		System.out.println("event created");
		driver.quit();

	}
}
