package user;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class apply_event extends user_register {

	public static void event_apply() throws InterruptedException {

		// choosing the event by getting all event in a list
		Thread.sleep(5000);
		List<WebElement> event_titles = driver.findElements(By.xpath("//div[@class='upcoming-event']//h4"));
		for (WebElement event_title : event_titles) {
			String t = event_title.getText();
			if (t.equalsIgnoreCase("Test24")) {
				// click the required event
				event_title.click();
				break;
			}
		}
		Thread.sleep(30000);
		// click apply event
		WebElement apply_event = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", apply_event);
		Thread.sleep(10000);
		apply_event.click();
		Thread.sleep(5000);
		System.out.println("Event applied ");

	}
}
