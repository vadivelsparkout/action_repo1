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


public class register {
	static WebDriver driver;
	static Faker faker = new Faker();
	static String firstName = faker.name().firstName();
	static String lastName = faker.name().lastName();
	static String Nemail=firstName+lastName;
	static String nomail=Nemail;
	static String Email=Nemail+"@mailinator.com";
	static String user=Email;
	static String phoneNumber = faker.phoneNumber().phoneNumber();
	static String password="test@123";
	static String url="https://www.codespotfoundation.org/app/user-sign-up";
	static String college="psg";
	static String Department="CSE";
	static String tech="fortran";


	public static Object admin_login() throws InterruptedException  {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-allow-origins", "http://127.0.0.1:45411/");
		//options.addArguments("--headless");
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.get(url);
		Thread.sleep(5000);
		return null;
	}


	public static Object register() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Email);
		driver.findElement(By.xpath("//input[@id='mat-input-3']")).sendKeys(phoneNumber);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		//driver.findElement(By.xpath("//input[@data-placeholder=\"Search your College\"]")).sendKeys("PSG College of Technology");
		driver.findElement(By.xpath("//input[@data-placeholder='Enter your study']")).sendKeys(Department);

		driver.findElement(By.xpath("//input[@id='mat-input-5']")).sendKeys(college);
		List<WebElement> csg=driver.findElements(By.xpath("//mat-option[@role='option']"));
		for (WebElement cdp : csg) {
			String cname=cdp.getText();
			System.out.println(cname);
			if(cname.equalsIgnoreCase("PSG College of Technology")) {
				System.out.println("pass");
				cdp.click();
				break;
			}

		}

		driver.findElement(By.xpath("//mat-select[@id='mat-select-4']")).click();
		Thread.sleep(3000);

		List<WebElement> drop=driver.findElements(By.xpath("//mat-option[@role='option']"));
		for (WebElement dp : drop) {
			String start_year=dp.getText();
			System.out.println(start_year);
			if(start_year.equalsIgnoreCase("2018")) {
				System.out.println("pass");
				dp.click();
				break;
			}

		}

		driver.findElement(By.xpath("//mat-select[@id='mat-select-6']")).click();
		Thread.sleep(3000);

		List<WebElement> down=driver.findElements(By.xpath("//mat-option[@role='option']"));
		for (WebElement dm : down) {
			String End_year=dm.getText();
			System.out.println(End_year);
			if (End_year.equalsIgnoreCase("2022")) {
				System.out.println("pass");
				dm.click();
				break;

			}
		}
		driver.findElement(By.xpath("//mat-select[@id='mat-select-8']")).click();
		List<WebElement> gender=driver.findElements(By.xpath("//mat-option[@role='option']"));
		for (WebElement male : gender) {
			String gm=male.getText();
			if (gm.equalsIgnoreCase("male")) {
				male.click();
				break;

			}

		}

		WebElement tech1=driver.findElement(By.xpath("//input[@id='mat-chip-list-input-0']"));
		tech1.sendKeys(tech);
		Thread.sleep(3000);
		List<WebElement> techdrop=driver.findElements(By.xpath("//mat-option[@role='option']"));

		for (WebElement dmm : techdrop) {
			String gm1=dmm.getText();
			if (gm1.equalsIgnoreCase("fortran")) {
				dmm.click();
				break;

			}

		}


		driver.findElement(By.xpath("//span[text()=' Create Your New Account ']")).click();
		Thread.sleep(15000);

		driver.get("https://www.mailinator.com/");
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys(nomail);
		driver.findElement(By.xpath("//button[text()='GO']")).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath("//table[@class='table-striped jambo_table']//tr//td[3]")).click();

		WebElement frame=driver.findElement(By.xpath("//iframe[@id='html_msg_body']"));
		Thread.sleep(5000);

		driver.switchTo().frame(frame);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement verify=driver.findElement(By.xpath("//a[text()='Verify Account']"));

		js.executeScript("arguments[0].click();", verify);

		String parent=driver.getWindowHandle();
		ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		for (String handle : windowHandles) {
			String str=handle.toString();
			if(!(str.equals(parent))) {

				driver.switchTo().window(handle);
				Thread.sleep(30000);
				driver.findElement(By.xpath("//input[@id='email']")).sendKeys(user);
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
				Thread.sleep(4000);
				driver.findElement(By.xpath("//span[text()=' Login ']")).click();


			}

		}

		return null;

	}

	public static Object close() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		return null;
	}


}