package user;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class user_flow_testing {

	@BeforeTest
	public void set() throws InterruptedException {
		
		user_register.admin_login();
		
	}

	@Test
	public void user_log() throws InterruptedException {
		
		user_register.register();
		
		apply_event.event_apply();
		
	}
	
	@AfterTest
	public void close() throws InterruptedException {
		
		user_register.close();
		
	}

}
