package admin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class certificate_generation extends admin_log {
	public static String certificate_event = "test event";

	public static void certificate_creation() throws InterruptedException {
		//click event staus
		driver.findElement(By.xpath("//span[contains(text(),' Event Status ')]")).click();
		//get event names
		List<WebElement> names = driver.findElements(By.xpath("//table[@role='table']//tr//td[2]"));
		for (WebElement name : names) {
			String event_name = name.getText();
			Thread.sleep(5000);
			if ((event_name).equalsIgnoreCase(certificate_event)) {
				Thread.sleep(5000);
				name.findElement(By.xpath("//table[@role='table']//tr//td[5]")).click();
			}
		}	
	}
}
