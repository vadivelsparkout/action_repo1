package admin;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class admin_flow_test {
	
	@BeforeTest
	public void admin_setup() throws InterruptedException {
		admin_log.admin_login();
	}
	
	@Test
	public void event_create() throws InterruptedException {
		admin_log.login();
		admin_log.create_event();
		certificate_generation.certificate_creation();
	}

}
