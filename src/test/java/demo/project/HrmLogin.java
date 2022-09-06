package demo.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HrmLogin extends Base{
	
	public WebElement getElement(String value) {
		WebElement ele = getDriver().findElement(By.xpath("//input[@name='"+ value +"']"));
		return ele;
	}
	
	@Test
	public void login() throws InterruptedException {
		
		getDriver().get("https://opensource-demo.orangehrmlive.com");
		getElement("username").sendKeys("Admin");
		
		Thread.sleep(4000);
		
		getElement("password").sendKeys("admin123");
		Thread.sleep(4000);
		
		getDriver().findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);
		
		String eleTxt =getDriver().findElement(By.xpath("//span[text()='Admin']/..")).getText();
		if(eleTxt.equals("Admin"))
			System.out.println("Succcessfully login to orangehrm app");
		else
			System.out.println("Error in login");
		
	}

}
