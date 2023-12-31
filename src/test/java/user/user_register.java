package user;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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

		options.addArguments("--window-size=1920,1080");
		
		options.addArguments("--allow-insecure-localhost");
		
		options.addArguments("--headless");
		
		options.addArguments("--disable-gpu");
		
		options.addArguments("--no-sandbox");

		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();

		driver.get(url);

		return driver;

	}

	public static void register() throws InterruptedException {

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@id='first-name']")));

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

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='first-name']")));

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

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//mat-option[@role='option']")));

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

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//mat-option[@role='option']")));

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

		Thread.sleep(10000);
		
		List<WebElement> gender = driver.findElements(By.xpath("//mat-option[@role='option']"));
		
		wait.until(ExpectedConditions.visibilityOfAllElements(gender));

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

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//mat-option[@role='option']")));

		List<WebElement> list_of_tech_skills = driver.findElements(By.xpath("//mat-option[@role='option']"));

		//get tech suggestions
		for (WebElement list_of_tech_skill : list_of_tech_skills) {

			String required_skill = list_of_tech_skill.getText();

			if (required_skill.equalsIgnoreCase("fortran")) {

				list_of_tech_skill.click();

				break;

			}

		}

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=' Create Your New Account ']")));

		//click create account
		driver.findElement(By.xpath("//span[text()=' Create Your New Account ']")).click();
		
		System.out.println("Account created");

		Thread.sleep(15000);

		//navigate to maininator for mail verifications
		driver.get("https://www.mailinator.com/");

		//enter registered mail
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys(nomail);

		driver.findElement(By.xpath("//button[text()='GO']")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='table-striped jambo_table']//tr//td[3]")));

		//click verification mail
		driver.findElement(By.xpath("//table[@class='table-striped jambo_table']//tr//td[3]")).click();

		//switch to frame
		WebElement verification_frame = driver.findElement(By.xpath("//iframe[@id='html_msg_body']"));

		Thread.sleep(10000);

		driver.switchTo().frame(verification_frame);

		JavascriptExecutor js = (JavascriptExecutor) driver;	

		WebElement verify = driver.findElement(By.xpath("//a[text()='Verify Account']"));

		//click to verify account
		js.executeScript("arguments[0].click();", verify);

		wait.until(ExpectedConditions.elementToBeClickable(verify));

		verify.click();

		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		//navigate to login page by using windowhandles
		String parent = driver.getWindowHandle();

		ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());

		for (String handle : windowHandles) {

			String str = handle.toString();

			if (!(str.equals(parent))) {

				driver.switchTo().window(handle);

				wait.until(ExpectedConditions.numberOfWindowsToBe(2));

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='email']")));

				//login by using registered credentials
				driver.findElement(By.xpath("//input[@id='email']")).sendKeys(user);
				
				System.out.println(user);

				driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=' Login ']")));

				driver.findElement(By.xpath("//span[text()=' Login ']")).click();
				
				System.out.println("account verified");

			}

		}

	}

	public static void close() throws InterruptedException {

		Thread.sleep(5000);

		driver.quit();

	} 
}