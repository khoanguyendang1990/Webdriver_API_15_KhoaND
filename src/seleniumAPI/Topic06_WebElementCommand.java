package seleniumAPI;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic06_WebElementCommand {
	WebDriver driver;

	@Test
	public void TC_01_VerifyElementIsDisplayed() {
		System.out.println("============TC_01_VerifyElementIsDisplayed============");
		System.out.println("Step 1: Truy cập vào trang https://automationfc.github.io/basic-form/index.html");
		driver.get("https://automationfc.github.io/basic-form/index.html");

		System.out.println("Step 2: Kiểm tra các phần tử Email, Age under 18, Education hiển thị trên trang");
		assertTrue(driver.findElement(By.xpath("//input[@id='mail']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//input[@id='under_18']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//textarea[@id='edu']")).isDisplayed());
		
		System.out.println("Step 3: Nhập giá trị");
		driver.findElement(By.xpath("//input[@id='mail']")).sendKeys("Automation Testing");
		driver.findElement(By.xpath("//textarea[@id='edu']")).sendKeys("Automation Testing");
		driver.findElement(By.xpath("//input[@id='under_18']")).click();
		System.out.println("============Done TC_01_VerifyElementIsDisplayed====================");
	}

	@Test
	public void TC_02_VerifyElementIsEnabledOrDisabled() {
		System.out.println("============TC_02_VerifyElementIsEnabledOrDisabled============");
		System.out.println("Step 1: Truy cập vào trang https://automationfc.github.io/basic-form/index.html");
		driver.get("https://automationfc.github.io/basic-form/index.html");

		System.out.println("Step 2: Kiểm tra các phần tử enable trên trang");
		assertTrue(driver.findElement(By.xpath("//input[@id='mail']")).isEnabled());
		assertTrue(driver.findElement(By.xpath("//input[@id='under_18']")).isEnabled());
		assertTrue(driver.findElement(By.xpath("//textarea[@id='edu']")).isEnabled());
		assertTrue(driver.findElement(By.xpath("//select[@id='job1']")).isEnabled());
		assertTrue(driver.findElement(By.xpath("//input[@id='development']")).isEnabled());
		assertTrue(driver.findElement(By.xpath("//input[@id='slider-1']")).isEnabled());
		
		System.out.println("Step 3: Kiểm tra các phần tử disable trên trang");
		assertFalse(driver.findElement(By.xpath("//input[@id='password']")).isEnabled());
		assertFalse(driver.findElement(By.xpath("//input[@id='radio-disabled']")).isEnabled());
		assertFalse(driver.findElement(By.xpath("//textarea[@id='bio']")).isEnabled());
//		assertFalse(driver.findElement(By.xpath("//select[@id='job2']")).isEnabled());
		assertFalse(driver.findElement(By.xpath("//input[@id='check-disbaled']")).isEnabled());
		assertFalse(driver.findElement(By.xpath("//input[@id='slider-2']")).isEnabled());
		System.out.println("============Done TC_02_VerifyElementIsEnabledOrDisabled====================");
	}

	@Test
	public void TC_03_VerifyElementIsSelected() {
		System.out.println("============TC_03_VerifyElementIsSelected============");
		System.out.println("Step 1: Truy cập vào trang https://automationfc.github.io/basic-form/index.html");
		driver.get("https://automationfc.github.io/basic-form/index.html");

		System.out.println("Step 2: Click Age under 18, Interest DEvelopment hiển thị trên trang");
		driver.findElement(By.xpath("//input[@id='under_18']")).click();
		driver.findElement(By.xpath("//input[@id='development']")).click();
		
		System.out.println("Step 3: check Element step 2 is selected");
		assertTrue(driver.findElement(By.xpath("//input[@id='under_18']")).isSelected());
		assertTrue(driver.findElement(By.xpath("//input[@id='development']")).isSelected());
		
		System.out.println("Step 4: Click Interest DEvelopment hiển thị trên trang");
		driver.findElement(By.xpath("//input[@id='development']")).click();
		
		
		System.out.println("Step 5: check Element step 2 is selected");
		assertFalse(driver.findElement(By.xpath("//input[@id='development']")).isSelected());
		System.out.println("============Done TC_03_VerifyElementIsSelected====================");
	}


	@BeforeClass
	public void beforeClass() {
		String rootfolder = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, rootfolder + "\\firefoxlogs.txt");
		driver = new FirefoxDriver();
//		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
//		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
