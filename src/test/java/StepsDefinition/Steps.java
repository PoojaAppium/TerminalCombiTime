package StepsDefinition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import POM.LoginPage;
import POM.ResourceLogin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {

	WebDriver Driver;
	LoginPage LP;
	ResourceLogin RL ;
	
	
	@Given("Chrome Launch")
	public void chrome_Launch() {
			System.setProperty("webdriver.chrome.driver" , "./src/test/resources/Driver/chromedriver.exe");
			Driver = new ChromeDriver();
	}

	@When("Navigate to URL {string}")
	public void navigate_to_URL(String string) {
	  
		Driver.navigate().to("https://combitimedevapp.z16.web.core.windows.net/login");
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
	}
	
	
	@When("Choose Terminal in Select Login type dropdown")
	public void choose_Terminal_in_Select_Login_type_dropdown() {
	   LP = new LoginPage(Driver);
	   LP.SelectTerminalLogin();
	}

	@When("Click on Continue")
	public void click_on_Continue() {
		 LP = new LoginPage(Driver);
		   LP.ClickOnContinueButton();
	}

	@Then("Validate Page Title {string}")
	public void validate_Page_Title(String string) throws InterruptedException {
		 LP = new LoginPage(Driver);
		   LP.ValidatePageTitle(string);
	}

	@When("Login By Email as {string}")
	public void login_By_Email_as(String string) {
		 LP = new LoginPage(Driver);
		   LP.FillTerminalID(string);
	}

	@When("Login By Password as {string}")
	public void login_By_Password_as(String string) {
		 LP = new LoginPage(Driver);
		   LP.FillPassword(string);
	}

	@When("Click on Submit button")
	public void click_on_Submit_button() {
		 LP = new LoginPage(Driver);
		   LP.Submit();
	}
	
	@Then("Quit Window")
	public void quit_Window() throws InterruptedException {
		Thread.sleep(3000);
	  Driver.quit();
	}
	
	@When("Move in new tab")
	public void move_in_new_tab() {
	  
	Set<String> SessionID = Driver.getWindowHandles();
	Iterator<String> itr = SessionID.iterator();
	String parentID = itr.next();
	String ChildID = itr.next();
	System.out.println(parentID);
	System.out.println(ChildID);
	Driver.switchTo().window(ChildID);
	
	}
	
	@When("Fill Resource ID {string}")
	public void fill_Resource_ID(String string) throws InterruptedException {
	   RL = new ResourceLogin(Driver);
	   RL.FillBadgeID(string);
	}

	@When("Click On Submit Icon")
	public void click_On_Submit_Icon() {
		   RL = new ResourceLogin(Driver);
		   RL.SubmitResource();
	}

	@Then("Validate Toast Message {string}")
	public void validate_Toast_Message(String string) {
		WebDriverWait WW = new WebDriverWait(Driver , 40);
		WebElement Alert = Driver.findElement(By.xpath("//combitime-notification"));
		WW.until(ExpectedConditions.visibilityOf(Alert));
		System.out.println (Alert.getText());
	    Assert.assertEquals(Alert.getText(), string);
	}

	@Then("Validate Page Header {string}")
	public void validate_Page_Header(String string) throws InterruptedException {
		Thread.sleep(3000);
		WebElement HeaderEle = Driver.findElement(By.xpath("(//h3)[3]"));
		String ExpectedHeader = HeaderEle.getText();
		System.out.println(ExpectedHeader);
		Assert.assertEquals(ExpectedHeader , string);
	}
	@Then("Validate Error Message in TerminalID {string}")
	public void validate_Error_Message_in_TerminalID(String string) {
	   LP = new LoginPage(Driver);
	   LP.ValidateErrorMessage_InTerminalID(string);
	}

	@Then("Validate Error Message in Password {string}")
	public void validate_Error_Message_in_Password(String string) {
		LP = new LoginPage(Driver);
		   LP.ValidateErrorMessage_InPassword(string);
	}
	
	@Then("Validate Error Message in Email_Required {string}")
	public void validate_Error_Message_in_Email_Required(String string) {
		LP = new LoginPage(Driver);
		   LP.ValidateError_EmailRequired(string);
	}

	
}