package admin;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class admin_log {

	static WebDriver driver;

	static String description = "RevolutionizeTech: Inspiring Minds, Empowering Innovators";

	static String agenda = "TechXpo: Explore the Future of Technology, Robotics, Artificial Intelligence,Cybersecurity, and Data Science";

	static String certificate_event = "Testing";

	public static WebDriver admin_login() throws InterruptedException {

		System.setProperty("webdriver.http.factory", "jdk-http-client");

		//driver = new ChromeDriver();

		ChromeOptions options = new ChromeOptions();

		options.addArguments("-allow-origins", "http://127.0.0.1:45411/");

		options.addArguments("--window-size=1920,1080");

		options.addArguments("--allow-insecure-localhost");

		options.addArguments("--headless");

		options.addArguments("--disable-gpu");

		options.addArguments("--no-sandbox");

		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://www.codespotfoundation.org/app/sign-in");

		return driver;

	}



	public static void login() throws InterruptedException {

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@id='email']")));

		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));

		email.sendKeys("Super@mailinator.com");

		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));

		password.sendKeys("test@123");

		WebElement login=driver.findElement(By.xpath("//span[contains(text(),' Login ')]"));

		wait.until(ExpectedConditions.elementToBeClickable(login));

		login.click();

		System.out.println("login sucessfull");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //span[contains(text(),' Event Management ')]")));

		// click event management
		WebElement Event_Management=driver.findElement(By.xpath(" //span[contains(text(),' Event Management ')]"));

		Event_Management.click();

		System.out.println("event management clicked");

	}


	public static void create_event() throws InterruptedException {

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));

		// click create event
		WebElement create_event=driver.findElement(By.xpath("//span[contains(text(),' Create Event ')]"));

		create_event.click();

		// create event title
		WebElement event_title=driver.findElement(By.xpath("//input[@id='event-title']"));

		event_title.sendKeys("test event");

		// click session or workshop
		WebElement event_type=driver.findElement(By.xpath("//span[contains(text(),'Workshop ')]"));

		event_type.click();

		// add banner
		WebElement banner = driver.findElement(By.xpath("(//input[@type='file'])[1]"));

		banner.sendKeys("/home/sparkout/eclipse-workspace/codespot/src/main/resources/banner.jpeg");

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//div[@data-placeholder='Insert text here ...'])[1]")));

		// banner description
		WebElement banner_description=driver.findElement(By.xpath("(//div[@data-placeholder='Insert text here ...'])[1]"));


		banner_description.sendKeys(description);

		// event agenda
		WebElement event_agenda=driver.findElement(By.xpath("(//div[@data-placeholder='Insert text here ...'])[2]"));

		event_agenda.sendKeys(agenda);

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

		List<WebElement> Months = driver.findElements(By.xpath("//table[@class='mat-calendar-table']//tbody//tr//td"));

		for (WebElement month : Months) {

			String mname = month.getText();

			if (mname.equalsIgnoreCase("JUL")) {

				month.click();

				break;

			}

		}

		// day selected

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
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//mat-option[@role='option']")));

		List<WebElement> stime1 = driver.findElements(By.xpath("//mat-option[@role='option']"));

		for (WebElement stimea : stime1) {

			String n1 = stimea.getText();

			if (n1.equalsIgnoreCase("03")) {

				stimea.click();

				break;

			}

		}

		// s2 selected

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-select[@id='mat-select-2']")));

		driver.findElement(By.xpath("//mat-select[@id='mat-select-2']")).click();
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//mat-option[@role='option']")));

		List<WebElement> stime2 = driver.findElements(By.xpath("//mat-option[@role='option']"));

		for (WebElement stimeb : stime2) {

			String n2 = stimeb.getText();

			if (n2.equalsIgnoreCase("40")) {

				stimeb.click();

				break;

			}

		}

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-select[@id='mat-select-4']")));

		// s3 selected

		driver.findElement(By.xpath("//mat-select[@id='mat-select-4']")).click();
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//mat-option[@aria-disabled='false']")));

		List<WebElement> stime3 = driver.findElements(By.xpath("//mat-option[@aria-disabled='false']"));

		for (WebElement stimec : stime3) {

			String n3 = stimec.getText();

			if (n3.equalsIgnoreCase("20")) {

				stimec.click();

				break;

			}

		}

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-select[@id='mat-select-6']")));

		// s4 selectetd

		driver.findElement(By.xpath("//mat-select[@id='mat-select-6']")).click();
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//mat-option[@role='option']")));


		List<WebElement> stime4 = driver.findElements(By.xpath("//mat-option[@role='option']"));

		for (WebElement stimed : stime4) {

			String n4 = stimed.getText();

			if (n4.equalsIgnoreCase("15")) {

				stimed.click();

				break;

			}

		}

		// select venue
		WebElement venue = driver.findElement(By.xpath("//input[@id='venue']"));

		venue.sendKeys("North Coimbatore, Coimbatore, Tamil Nadu, India");

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='pac-item']")));

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
		WebElement speaker_name=driver.findElement(By.xpath("//input[@id='speaker-name']"));

		speaker_name.sendKeys("test speaker");

		// add speaker image
		WebElement profile = driver.findElement(By.xpath("(//input[@type='file'])[2]"));

		profile.sendKeys("/home/sparkout/eclipse-workspace/codespot/src/main/resources/banner.jpeg");

		// add link
		WebElement link=driver.findElement(By.xpath("//input[@id='link']"));

		link.sendKeys("https://www.linkedin.com/login");

		// add designation
		WebElement designation=driver.findElement(By.xpath("//input[@id='designation']"));

		designation.sendKeys("CEO");

		// save
		WebElement save=driver.findElement(By.xpath("//span[contains(text(),'Save')]"));
		
		wait.until(ExpectedConditions.elementToBeClickable(save));
		
		save.click();

	}


	public static void certificate_creation() throws InterruptedException {

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[contains(text(),' Event Status ')]")));

		String eventStatus = null;

		// click event staus
		driver.findElement(By.xpath("//span[contains(text(),' Event Status ')]")).click();

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@role='table']//tr//td[2]")));

		// get event names
		List<WebElement> names = driver.findElements(By.xpath("//table[@role='table']//tr//td[2]"));

		String[] textArray = new String[names.size()];

		for (int i = 0; i < names.size(); i++) {

			textArray[i] = names.get(i).getText();

		}

		String targetString = "Test 22";

		int targetIndex = 0;

		for (int i = 0; i < textArray.length; i++) {

			String text = textArray[i];
			
			System.out.println(text);

			if (text.matches(targetString)) {

				targetIndex = i + 1;

				System.out.println(targetIndex);

				String targetIndexString = String.valueOf(targetIndex);

				String xpath = "(//table[@role='table']//tr//td[5])[" + targetIndexString + "]";

				WebElement Status = driver.findElement(By.xpath(xpath));
				
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));

				eventStatus	 = Status.getText();

				System.out.println(eventStatus);


				switch (eventStatus) {

				case "Event Not Complete":

					System.out.println("sorry your event status is :"+eventStatus);

					break;

				case "Issued":

					System.out.println("sorry your event status is :"+eventStatus);

					break;

				case "Generate":

					Status.click();

					driver.findElement(By.xpath("(//button[text()='Ok'])[1]")).click();

					// driver.findElement(By.xpath("(//button[text()='Cancel'])[1]")).click();

					break;

				default:

					System.out.println("Unknown event status: " + eventStatus);

					break;

				}	
                    break;
			}

		}

	}

	public static void close() throws InterruptedException {

		Thread.sleep(3000);

		driver.quit();

	}
}
