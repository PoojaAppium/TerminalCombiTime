package POM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

WebDriver Driver;
	
	By Arrow = By.xpath("//div[@class='mat-select-arrow-wrapper ng-tns-c108-1']");
	By TerminalButton = By.xpath("//span[contains(text(),' Terminal login ')]");
	By Continue = By.xpath("//button[@type = 'submit']");
	By Header = By.xpath("//h1[@class = 'login-type']");
	By Password = By.id("password");
	By UN = By.id("email");
	By Submit = By.id("login-button");
	By ErrorMessageInTerminalID = By.xpath("//div[@class ='error-message']");
	By PasswordRequiredError = By.id("password-required");
	By EmailRequired_ErrorMessage = By.id("email-required");
	


	
	public LoginPage(WebDriver Driver) {
        this.Driver = Driver;
    }
	
	
	public void Wait(WebElement Element) {
		WebDriverWait WW = new WebDriverWait(Driver , 25);
		WW.until(ExpectedConditions.visibilityOf(Element));
	}
	
	public void SelectTerminalLogin() {

	WebElement arrowicon = Driver.findElement(Arrow);
	Wait(arrowicon);
	arrowicon.click();
	WebElement TerminalOption = Driver.findElement(TerminalButton);
	Wait(TerminalOption);
	TerminalOption.click();
	
	
	}
	
	public void ClickOnContinueButton(){

	WebElement ContinueButton = Driver.findElement(Continue);
	Wait(ContinueButton);
	ContinueButton.click();
	}
	
	public void FillTerminalID(String string) {

	WebElement TerminalID = Driver.findElement(UN);
	Wait(TerminalID);
	TerminalID.sendKeys(string);
	}
	
	public void FillPassword(String string) {

	WebElement Pass = Driver.findElement(Password);
	Wait(Pass);
	Pass.sendKeys(string);
	}
	
	public void Submit(){

	WebElement Pass = Driver.findElement(Submit);
	Wait(Pass);
	Pass.click();
	}
	
	public void ValidatePageTitle(String ActualTitle) throws InterruptedException {
		Thread.sleep(3000);
		String TitlePage = Driver.getTitle();
		System.out.println(TitlePage);
		Assert.assertEquals(TitlePage , ActualTitle);
	}
	
	public void ValidateErrorMessage_InTerminalID(String TerminalErrorText) {
	
		WebElement Error = Driver.findElement(ErrorMessageInTerminalID);
		String ExpectedError = Error.getText();
		System.out.println(ExpectedError);
		Assert.assertEquals(ExpectedError , TerminalErrorText);
	}
	
	public void ValidateErrorMessage_InPassword(String PasswordErrorText) {
		
		WebElement Error = Driver.findElement(PasswordRequiredError);
		String ExpectedError = Error.getText();
		System.out.println(ExpectedError);
		Assert.assertEquals(ExpectedError , PasswordErrorText);
	}
	
	public void ValidateError_EmailRequired(String ActualError) {

		WebElement EmailRequiredErrorInTerminalTextBox = Driver.findElement(EmailRequired_ErrorMessage);
		Wait(EmailRequiredErrorInTerminalTextBox);
	    String ExpectedErrorMessage = EmailRequiredErrorInTerminalTextBox.getText();
	    System.out.println(ExpectedErrorMessage);
	    Assert.assertEquals(ExpectedErrorMessage , ActualError);
		}
	
	
	
	
	
}
