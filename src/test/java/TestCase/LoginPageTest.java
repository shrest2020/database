package TestCase;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Page.DatabasePage;
import Page.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	@BeforeMethod
	public void setUp() {
		initializeDriver();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		
	}

	@Test
	public void loginTest() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
	 loginPage.enterUserName(DatabasePage.GetData("username"));
	 Thread.sleep(2000);
	 loginPage.enterPassword(DatabasePage.GetData("password"));
	
	 loginPage.clickSignInButton();
	 Thread.sleep(2000);
	 takeScreenshotAtEndOfTest();

	}
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	
}
