package user;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class user_test {
	
	@BeforeTest
	public void set() throws InterruptedException {
		register.admin_login();
	}
	
	
	@Test
	public void user_log() throws InterruptedException {
		register.register();
	}

}
