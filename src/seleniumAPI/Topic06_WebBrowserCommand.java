package seleniumAPI;

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

public class Topic06_WebBrowserCommand {
	WebDriver driver;

	@Test
	public void TC_01_VerifyUrl() {
		System.out.println("============TC_01_VerifyUrl============");
		System.out.println("Step 1: Truy cập vào trang http://live.demoguru99.com/");
		driver.get("http://live.demoguru99.com");

		System.out.println("Step 2: Click vào My Account");
		driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My Account')]")).click();

		System.out.println(
				"Step 3: Verify url của Login Page = http://live.demoguru99.com/index.php/customer/account/login/");
		String loginPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(loginPageUrl, "http://live.demoguru99.com/index.php/customer/account/login/");

		System.out.println("Step 4: Click vào Create New Account");
		driver.findElement(By.xpath("//span[contains(text(),'Create an Account')]")).click();

		System.out.println("Step 5: Verify url của Register Page = http://live.demoguru99.com/index.php/customer/account/create/");
		String registerPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(registerPageUrl, "http://live.demoguru99.com/index.php/customer/account/create/");
		System.out.println("============Done TC_01_VerifyUrl====================");
	}

	@Test
	public void TC_02_VerfiyTitle() {
		System.out.println("============TC_02_VerfiyTitle============");
		System.out.println("Step 1: Truy cập vào trang http://live.demoguru99.com/");
		driver.get("http://live.demoguru99.com");

		System.out.println("Step 2: Click vào My Account");
		driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My Account')]")).click();

		System.out.println(
				"Step 3: Verify title của Login Page Customer Login");
		String loginPageTitle = driver.getTitle();
		Assert.assertEquals(loginPageTitle, "Customer Login");

		System.out.println("Step 4: Click vào Create New Account");
		driver.findElement(By.xpath("//span[contains(text(),'Create an Account')]")).click();

		System.out.println(
				"Step 5: Verify title của Register Page Create New Customer Account");
		String registerPageTitle = driver.getTitle();
		Assert.assertEquals(registerPageTitle, "Create New Customer Account");
		System.out.println("============Done TC_02_VerfiyTitle============");
	}

	@Test
	public void TC_03_NavigateFunction() {
		System.out.println("============TC_03_NavigateFunction============");
		System.out.println("Step 1: Truy cập vào trang http://live.demoguru99.com/");
		driver.get("http://live.demoguru99.com");

		System.out.println("Step 2: Click vào My Account");
		driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My Account')]")).click();

		System.out.println("Step 3: Click vào Create New Account");
		driver.findElement(By.xpath("//span[contains(text(),'Create an Account')]")).click();
		
		System.out.println("Step 4: Verify url của Register Page = http://live.demoguru99.com/index.php/customer/account/create/");
		String registerPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(registerPageUrl, "http://live.demoguru99.com/index.php/customer/account/create/");
		
		System.out.println("Step 5: Back to Login Page");
		driver.navigate().back();
		
		System.out.println(
				"Step 6: Verify url của Login Page = http://live.demoguru99.com/index.php/customer/account/login/");
		String loginPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(loginPageUrl, "http://live.demoguru99.com/index.php/customer/account/login/");

		System.out.println("Step 7: Forward to Register page");
		driver.navigate().forward();
		
		System.out.println(
				"Step 5: Verify title của Register Page Create New Customer Account");
		String registerPageTitle = driver.getTitle();
		Assert.assertEquals(registerPageTitle, "Create New Customer Account");
		System.out.println("============ Done TC_03_NavigateFunction============");
	}

	@Test
	public void TC_04_GetPageSource() {
		System.out.println("============TC_04_GetPageSource============");
		System.out.println("Step 1: Truy cập vào trang http://live.demoguru99.com/");
		driver.get("http://live.demoguru99.com");

		System.out.println("Step 2: Click vào My Account");
		driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My Account')]")).click();

		System.out.println(
				"Step 3: Verify Login Page chứa text Login or Create an Account");
		assertTrue(driver.getPageSource().contains("Login or Create an Account")); 
		

		System.out.println("Step 4: Click vào Create New Account");
		driver.findElement(By.xpath("//span[contains(text(),'Create an Account')]")).click();

		System.out.println(
				"Step 5: Verify Login Page chứa text Create an Account");
		assertTrue(driver.getPageSource().contains("Create an Account")); 
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
