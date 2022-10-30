package POM;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResourceLogin {
WebDriver Driver;
	
	By Resource = By.id("resourceLoginForm");
	By Time = By.xpath("//div[@class = 'current-time-container flex column items-center']");
	By Date_Day = By.xpath("//div[@class = 'current-date-container flex column items-center']");
	By NoticeBoard = By.xpath("//div[@class = 'message']");
	By Submit = By.xpath("//div[@class = 'digit flex row items-center justify-center dark-bg-digit'][2]");
	

	
	public ResourceLogin(WebDriver Driver) {
        this.Driver = Driver;
    }
	
	
	public void Wait(WebElement Element) {
		WebDriverWait WW = new WebDriverWait(Driver , 25);
		WW.until(ExpectedConditions.elementToBeClickable(Element));
	}
	
	public void FillResource(String string) throws InterruptedException {
	   Thread.sleep(3000);
		WebElement ID = Driver.findElement(Resource);
		Wait(ID);
		ID.sendKeys(string);
		
//		JavascriptExecutor javascript = (JavascriptExecutor) driver;
//		javascript.executeScript("var element = document.querySelector('locator'); element.value = 'whatever';")
		
	}
	
	public void SubmitResource() {
		WebElement SubmitButton = Driver.findElement(Submit);
		Wait(SubmitButton);
		SubmitButton.click();
	}
	
	public void KeyPadNumber(char Num) {
		WebElement Ele = Driver.findElement(By.xpath("//div[contains(text(),'"+Num+"')]"));
		Wait(Ele);
		Ele.click();
	}
	
	public void FillBadgeID(String string) throws InterruptedException {
		
		int length = String.valueOf(string).length();
		for(int i=0 ; i<length ; i++) {
			char value = string.charAt(i);
			WebElement Ele = Driver.findElement(By.xpath("//div[contains(text(),'"+value+"')]"));
			Wait(Ele);
		 Actions A = new Actions(Driver);
		 A.moveToElement(Ele).click().build().perform();
			//Ele.click();
		}
		
	}
	
	
}
