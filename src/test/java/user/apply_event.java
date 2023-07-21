package user;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class apply_event extends user_register {

	public static void event_apply() throws InterruptedException {
		
	    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));


		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='upcoming-event']//h4")));


		// choosing the event by getting all event in a list
		List<WebElement> event_titles = driver.findElements(By.xpath("//div[@class='upcoming-event']//h4"));

		for (WebElement event_title : event_titles) {

			String t = event_title.getText();

			if (t.equalsIgnoreCase("Test24")) {

				// click the required event
				event_title.click();

				break;

			}

		}

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[contains(text(),' Attend Event ')]")));

		// click apply event
		WebElement apply_event = driver.findElement(By.xpath("//button[contains(text(),' Attend Event ')]"));

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", apply_event);
		
		jsExecutor.executeScript("arguments[0].click();", apply_event);
		
		System.out.println("Event applied ");

	}
}
