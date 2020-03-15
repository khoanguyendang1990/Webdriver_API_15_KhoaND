package seleniumAPI;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic11_PopUp_Iframe {

	WebDriver driver;
	WebElement element;
	List<WebElement> elements;
	WebDriverWait waitExplicit;
	String rootFolder = System.getProperty("user.dir");
//	@Test
//	public void TC_01_Close_Popup() {
//		System.out.println("============TC_01_Close_Popup============");
//		driver.get("https://www.javacodegeeks.com/");
//
//		waitExplicit
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Close Popup')]")));
//
//		if (driver.findElement(By.xpath("//a[contains(text(),'Close Popup')]")).isDisplayed()) {
//			driver.findElement(By.xpath("//a[contains(text(),'Close Popup')]")).click();
//		}
//
//		System.out.println("============Done TC_01_Close_Popup====================");
//
//	}

//	@Test
//	public void TC_02_Verify_iFrame() {
//		System.out.println("============TC_02_Verify_iFrame============");
//		driver.get("https://kyna.vn/");
//
//		
//		System.out.println("Step 2");
//		WebElement iframe = driver.findElement(By.xpath("//div[@class='face-content']//iframe"));
//		assertTrue(iframe.isDisplayed());
//		driver.switchTo().frame(iframe);
//		System.out.println("Step 3");
//		assertTrue(driver.findElement(By.xpath("//div[contains(text(),'170K')]")).getText().contains("170K likes"));
//
//		System.out.println("Step 4");
//		driver.switchTo().defaultContent();
//		assertTrue(driver.findElement(By.xpath("//iframe[@id='cs_chat_iframe']")).isDisplayed());
//		
//		System.out.println("Step 6");
//		driver.findElement(By.xpath("//input[@id='live-search-bar']")).sendKeys("Java");
//		driver.findElement(By.xpath("//button[@class='btn btn-secondary search-button']")).click();
//		
//		assertTrue(driver.findElement(By.xpath("//span[@class='menu-heading']/h1")).getText().contains("Java"));
//		System.out.println("============Done TC_02_Verify_iFrame====================");
//
//	}

	@Test
	public void TC_04_Windows_Tab() throws InterruptedException {
		System.out.println("============TC_04_Windows_Tab============");
		driver.get("https://automationfc.github.io/basic-form/index.html");

		String parentWindow = driver.getWindowHandle();
		
		System.out.println("Step 2");
		driver.findElement(By.xpath("//a[contains(text(),'GOOGLE')]")).click();
		switchToWindowsByTitle("Google");
		Thread.sleep(2000);
		driver.switchTo().window(parentWindow);

		System.out.println("Step 5");
		driver.findElement(By.xpath("//a[contains(text(),'FACEBOOK')]")).click();
		switchToWindowsByTitle("Facebook - Đăng nhập hoặc đăng ký");
		Thread.sleep(2000);
		driver.switchTo().window(parentWindow);
		
		System.out.println("Step 8");
		driver.findElement(By.xpath("//a[contains(text(),'TIKI')]")).click();
		switchToWindowsByTitle("Mua Hàng Trực Tuyến Uy Tín với Giá Rẻ Hơn tại Tiki.vn");
		Thread.sleep(2000);
		driver.switchTo().window(parentWindow);

		System.out.println("Step 10");
		assertTrue(closeAllWindowWithoutParent(parentWindow));
		assertEquals(driver.getTitle(), "SELENIUM WEBDRIVER FORM DEMO");
		System.out.println("============Done TC_04_Windows_Tab====================");

	}
	
//	@Test
//	public void TC_06_Windows_Tab() throws InterruptedException {
//		System.out.println("============TC_06_Windows_Tab============");
//		driver.get("http://live.demoguru99.com/index.php/");
//		String parentWindow = driver.getWindowHandle();
//		driver.findElement(By.xpath("//a[contains(text(),'Mobile')]")).click();
//		
//		driver.findElement(By.xpath("//a[contains(text(),'Sony Xperia')]/ancestor::div[@class='product-info']//a[contains(text(),'Add to Compare')]")).click();
//		driver.findElement(By.xpath("//a[contains(text(),'IPhone')]/ancestor::div[@class='product-info']//a[contains(text(),'Add to Compare')]")).click();
//		driver.findElement(By.xpath("//span[text()='Compare']")).click();
//		
//		switchToWindowsByTitle("Products Comparison List - Magento Commerce");
//		assertTrue(closeAllWindowWithoutParent(parentWindow));
//		
//		driver.switchTo().window(parentWindow);
//		assertEquals(driver.getTitle(), "Mobile");
//		System.out.println("============Done TC_06_Windows_Tab====================");
//
//	}

	public void switchToWindowsByTitle(String title) {
		Set<String> allWindows = driver.getWindowHandles();

		for (String currentWin : allWindows) {
			driver.switchTo().window(currentWin);
			if (driver.getTitle().equals(title)) {
				break;
			}
		}
	}

	public boolean closeAllWindowWithoutParent(String parentID) {
		Set<String> allWindows = driver.getWindowHandles();

		for (String currentWin : allWindows) {
			if(!currentWin.equals(parentID)) {
				driver.switchTo().window(currentWin);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
		if(driver.getWindowHandles().size()==1) {
			return true;
		}else {
			return false;
		}
	}

	protected synchronized WebDriver getBrowserDriver(String browserName) {
		if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", rootFolder + "/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", rootFolder + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", rootFolder + "/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (browserName.equalsIgnoreCase("chrome_headless")) {
			System.setProperty("webdriver.chrome.driver", rootFolder + "/drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1366x768");
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("firefox_headless")) {
			System.setProperty("webdriver.gecko.driver", rootFolder + "/drivers/geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);
			driver = new FirefoxDriver(options);
		} else {
			System.out.println("Input browser");
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
//	@BeforeClass
//	public void beforeClass() {
//		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		waitExplicit = new WebDriverWait(driver, 30);
//	}
	
	@BeforeClass
	@Parameters({"browserName"})
	public void beforeClass(String browserName) {
//		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
//		driver = new ChromeDriver();
		driver = getBrowserDriver(browserName);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		waitExplicit = new WebDriverWait(driver, 30);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
