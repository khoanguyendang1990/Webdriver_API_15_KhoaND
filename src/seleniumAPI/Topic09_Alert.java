package seleniumAPI;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic09_Alert {

	WebDriver driver;
	WebElement element;
	List<WebElement> elements;
	WebDriverWait waitExplicit;

//	@Test
//	public void TC_04_Accept_Alert() {
//		System.out.println("============TC_04_Accept_Alert============");
//		System.out.println("Step 1: Truy cập vào trang");
//		driver.get("https://automationfc.github.io/basic-form/index.html");
//		
//		System.out.println("Step 2: Click vào button Click for JS Alert");
//		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
//		
//		System.out.println("Step 3: VErify message hiển thị trong Alert là I am a JS Alert");
//		Alert alert = driver.switchTo().alert();
//		System.out.println(alert.getText());
//		assertEquals(alert.getText(), "I am a JS Alert");
//		
//		System.out.println("Step 4: Accept Alert và verify message hiển thị tại result là: You clicked an alert successfully");
//		alert.accept();
//		assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You clicked an alert successfully");
//		System.out.println("============Done TC_04_Accept_Alert====================");
//		
//	}
	
//	@Test
//	public void TC_05_Confirm_Alert() {
//		System.out.println("============TC_05_Confirm_Alert============");
//		System.out.println("Step 1: Truy cập vào trang");
//		driver.get("https://automationfc.github.io/basic-form/index.html");
//		
//		System.out.println("Step 2: Click vào button Click for JS Confirm");
//		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
//		
//		System.out.println("Step 3: VErify message hiển thị trong Alert là I am a JS Confirm");
//		Alert alert = driver.switchTo().alert();
//		System.out.println(alert.getText());
//		assertEquals(alert.getText(), "I am a JS Confirm");
//		
//		System.out.println("Step 4: Cancel Alert và verify message hiển thị tại result là: You clicked: Cancel");
//		alert.dismiss();
//		assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You clicked: Cancel");
//		System.out.println("============Done TC_05_Confirm_Alert====================");
//		
//	}
	
//	@Test
//	public void TC_06_Prompt_Alert() {
//		System.out.println("============TC_06_Prompt_Alert============");
//		System.out.println("Step 1: Truy cập vào trang");
//		driver.get("https://automationfc.github.io/basic-form/index.html");
//		
//		System.out.println("Step 2: Click vào button Click for JS Prompt");
//		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
//		
//		System.out.println("Step 3: VErify message hiển thị trong Alert là Click for JS Prompt");
//		Alert alert = driver.switchTo().alert();
//		System.out.println(alert.getText());
//		assertEquals(alert.getText(), "I am a JS prompt");
//		
//		System.out.println("Step 4: input text to Alert và verify message hiển thị tại result là: You entered: khoanguyen");
//		alert.sendKeys("khoanguyen");
//		alert.accept();
//		assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You entered: khoanguyen");
//		System.out.println("============Done TC_06_Prompt_Alert====================");
//		
//	}
	
	@Test
	public void TC_07_Authentication_Alert() {
		System.out.println("============TC_07_Authentication_Alert============");
		String username="admin";
		String password="admin";
		driver.get("http://the-internet.herokuapp.com/");
		WebElement basicAuthenLink=driver.findElement(By.xpath("//a[text()='Basic Auth']"));
		
		String url=basicAuthenLink.getAttribute("href");
		
		driver.get(byPassAuthenticationAlert(url, username, password));
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());
		System.out.println("============Done TC_06_Prompt_Alert====================");
		
	}

	public String byPassAuthenticationAlert(String url,String username,String password) {
		System.out.println("Old URL:" + url);
		String[] splitUrl=url.split("//");
		url=splitUrl[0]+"//"+username+":"+password+"@"+splitUrl[1];
		System.out.println("New URL:" + url);
		return url;
	}
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		waitExplicit = new WebDriverWait(driver, 30);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
