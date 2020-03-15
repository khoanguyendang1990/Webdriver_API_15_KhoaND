package seleniumAPI;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic10_Interactions {

	WebDriver driver;
	WebElement element;
	List<WebElement> elements;
	WebDriverWait waitExplicit;
	String rootFolder = System.getProperty("user.dir");
	
//	@Test
//	public void TC_01_Hover_To_Element() {
//		System.out.println("============TC_01_Hover_To_Element============");
//		driver.get("https://www.myntra.com/");
//		
//		Actions action= new Actions(driver);
//		element = driver.findElement(By.xpath("//a[contains(text(),'Discover')]"));
//		action.moveToElement(element).perform();
//		
//		driver.findElement(By.xpath("//a[contains(text(),'Tommy Hilfiger')]")).click();
//		
//		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='breadcrumbs-crumb' and contains(text(),'Tommy Hilfiger')]")));
//		System.out.println("driver.findElement(By.xpath(\"//span[@class='breadcrumbs-crumb' and contains(text(),'Tommy Hilfiger')]\")).getText()");
//		assertEquals(driver.findElement(By.xpath("//span[@class='breadcrumbs-crumb' and contains(text(),'Tommy Hilfiger')]")).getText(), "Tommy Hilfiger Clothing & Accessories");
//		
//		System.out.println("============Done TC_01_Hover_To_Element====================");
//		
//	}

	@Test
	public void TC_02_ClickAndHold_To_Element() {
		System.out.println("============TC_02_ClickAndHold_To_Element============");
		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");
		List<WebElement> elements = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		Actions moveItem = new Actions(driver);
		moveItem.clickAndHold(elements.get(0)).moveToElement(elements.get(3)).release().perform();

		List<WebElement> selectedElements = driver.findElements(
				By.xpath("//ol[@id='selectable']//li[@class='ui-state-default ui-selectee ui-selected']"));
		assertEquals(selectedElements.size(), 4);
		String[] list = { "1", "2", "3", "4" };
		for (int i = 0; i < list.length; i++) {
			System.out.println(selectedElements.get(i).getText());
			System.out.println(list[i].toString());
			assertEquals(selectedElements.get(i).getText(), list[i].toString());
		}
		System.out.println("============Done TC_02_ClickAndHold_To_Element====================");

	}

	@Test
	public void TC_03_ClickAndHold_To_Element() {
		System.out.println("============TC_03_ClickAndHold_To_Element============");
		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");
		List<WebElement> elements = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		Actions moveItem = new Actions(driver);
		moveItem.keyDown(Keys.CONTROL).perform();
		moveItem.click(elements.get(0))
		.click(elements.get(2))
		.click(elements.get(4))
		.click(elements.get(6))
		.click(elements.get(9)).perform();
		moveItem.keyUp(Keys.CONTROL).perform();
		

		List<WebElement> selectedElements = driver.findElements(
				By.xpath("//ol[@id='selectable']//li[@class='ui-state-default ui-selectee ui-selected']"));
		assertEquals(selectedElements.size(), 5);
		String[] list= { "1", "3", "5", "7", "10"};
		for (int i = 0; i < list.length; i++) {
			System.out.println(selectedElements.get(i).getText());
			System.out.println(list[i].toString());
			assertEquals(selectedElements.get(i).getText(), list[i].toString());
		}
		System.out.println("============Done TC_03_ClickAndHold_To_Element====================");

	}

//	@Test
//	public void TC_04_DoubleClick_To_Element() {
//		System.out.println("============TC_04_DoubleClick_To_Element============");
//		driver.get("https://automationfc.github.io/basic-form/index.html");
//
//		Actions action = new Actions(driver);
//		element = driver.findElement(By.xpath("//button[contains(text(),'Double click me')]"));
//		action.doubleClick(element).perform();
//
//		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='demo']")));
//		System.out.println(driver.findElement(By.xpath("//p[@id='demo']")).getText());
//		assertEquals(driver.findElement(By.xpath("//p[@id='demo']")).getText(), "Hello Automation Guys!");
//
//		System.out.println("============Done TC_04_DoubleClick_To_Element====================");
//
//	}
	
//	@Test
//	public void TC_05_RightClick_To_Element() throws InterruptedException {
//		System.out.println("============TC_04_DoubleClick_To_Element============");
//		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
//
//		Actions action = new Actions(driver);
//		element = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
//		action.contextClick(element).perform();
//
//		System.out.println("============Done TC_04_DoubleClick_To_Element====================");
//
//	}
	
//	@Test
//	public void TC_06_DrapAndDrop() throws InterruptedException {
//		System.out.println("============TC_06_DrapAndDrop============");
//		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/angular");
//
//		Actions action = new Actions(driver);
//		WebElement sourceElement = driver.findElement(By.xpath("//div[@id='draggable']"));
//		WebElement targetElement = driver.findElement(By.xpath("//div[@id='droptarget']"));
//		action.dragAndDrop(sourceElement, targetElement).build().perform();
//		assertEquals(driver.findElement(By.xpath("//div[@id='droptarget']")).getText(),"You did great!");
//		System.out.println("============Done TC_06_DrapAndDrop====================");
//
//	}

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
