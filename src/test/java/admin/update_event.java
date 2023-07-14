package admin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;
import com.github.javafaker.Lorem;

public class update_event {
	static WebDriver driver;
	 Faker faker = new Faker();
     Lorem lorem = faker.lorem();
     List<String> description = lorem.paragraphs(1); 
     List<String> description1 = lorem.paragraphs(1); 
	
	
	public static void update_event() throws InterruptedException {
		
		//click create event
		driver.findElement(By.xpath("//span[contains(text(),' Event Listing ')]")).click();
		driver.findElement(By.xpath("//table[@role='table']//tbody//tr//td[2]")).click();
		
		Thread.sleep(5000);
		
		
		
		
	}

}
