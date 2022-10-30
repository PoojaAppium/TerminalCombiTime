package POM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard {

WebDriver Driver;
	
	By ClockINIcon = By.xpath("//mat-icon[@data-mat-icon-name = 'shopfloor_clockin']");
	By BreakIcon = By.xpath("//mat-icon[@data-mat-icon-name = 'shopfloor_break']");
	By JobIcon = By.xpath("//mat-icon[@data-mat-icon-name = 'shopfloor_jobs']");
	By Header = By.xpath("(//h3)[3]");
	

	
	public Dashboard(WebDriver Driver) {
        this.Driver = Driver;
    }
	
	
	public void Wait(WebElement Element) {
		WebDriverWait WW = new WebDriverWait(Driver , 25);
		WW.until(ExpectedConditions.visibilityOf(Element));
	}
	

	

	
}
