package seleniumAPI;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic07_Dropdownlist {
	WebDriver driver;
	WebElement element;
	List<WebElement> elements;
	WebDriverWait waitExplicit;
	JavascriptExecutor jsExecutor;
	
//	@Test
//	public void TC_02_DropDownList() {
//		System.out.println("============TC_02_DropDownList============");
//		System.out.println("Step 1: Truy cập vào trang https://automationfc.github.io/basic-form/index.html");
//		driver.get("https://automationfc.github.io/basic-form/index.html");
//
//		System.out.println("Step 2: Kiểm tra Role Job 1 is single dropdown, không hỗ trợ multiple select");
//		WebElement element=driver.findElement(By.xpath("//select[@id='job1']"));
//		Select select = new Select(element);
//		Assert.assertFalse(select.isMultiple());
//		
//		System.out.println("Step 3: Select Mobile Testing");
//		select.selectByVisibleText("Mobile Testing");
//		Assert.assertEquals(select.getFirstSelectedOption().getText(),"Mobile Testing");
//		
//		System.out.println("Step 5");
//		select.selectByValue("manual");
//		Assert.assertEquals(select.getFirstSelectedOption().getText(),"Manual Testing");
//		
//		System.out.println("Step 7");
//		select.selectByIndex(9);
//		Assert.assertEquals(select.getFirstSelectedOption().getText(),"Functional UI Testing");
//		
//		System.out.println("Step 9");
//		Assert.assertEquals(select.getOptions().size(),10);
//		
//		System.out.println("Step 10: Kiểm tra Role Job 2 is multiple dropdown, có hỗ trợ multiple select");
//		WebElement element2=driver.findElement(By.xpath("//select[@id='job2']"));
//		Select select2 = new Select(element2);
//		Assert.assertTrue(select2.isMultiple());
//		
//		System.out.println("Step 11");
//		select2.selectByVisibleText("Automation");
//		select2.selectByVisibleText("Mobile");
//		select2.selectByVisibleText("Desktop");
//		
//		List<WebElement> selectJob2= select2.getAllSelectedOptions();
//		select2.getAllSelectedOptions().containsAll(selectJob2);
//		for (WebElement item : selectJob2) {
//			System.out.println(item.getText());
//		}
//		
//		select2.deselectAll();
//		Assert.assertEquals(0, select2.getAllSelectedOptions().size());
//		System.out.println("============Done TC_02_DropDownList====================");
//	}

	@Test
	public void TC_04_CustomerDropdownlist() throws InterruptedException {
		System.out.println("============TC_04_CustomerDropdownlist============");
		System.out.println("Step 1: Truy cập vào trang http://jqueryui.com/resources/demos/selectmenu/default.html");
		driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
		
		System.out.println("Step 2: select 19 in dropdownlist");
		selectItemInCustomDropdownJS("//span[@id='number-button']", "//ul[@id='number-menu']/li/div", "19");
		
		System.out.println("Step 3: Kiểm tra 19 được chọn thành công");
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text' and text()='19']")).isDisplayed());
		
		System.out.println("============Done TC_04_CustomerDropdownlist====================");
	}
//
//	@Test
//	public void TC_03_VerifyElementIsSelected() {
//		System.out.println("============TC_03_VerifyElementIsSelected============");
//		System.out.println("Step 1: Truy cập vào trang https://automationfc.github.io/basic-form/index.html");
//		driver.get("https://automationfc.github.io/basic-form/index.html");
//
//		System.out.println("Step 2: Click Age under 18, Interest DEvelopment hiển thị trên trang");
//		driver.findElement(By.xpath("//input[@id='under_18']")).click();
//		driver.findElement(By.xpath("//input[@id='development']")).click();
//		
//		System.out.println("Step 3: check Element step 2 is selected");
//		assertTrue(driver.findElement(By.xpath("//input[@id='under_18']")).isSelected());
//		assertTrue(driver.findElement(By.xpath("//input[@id='development']")).isSelected());
//		
//		System.out.println("Step 4: Click Interest DEvelopment hiển thị trên trang");
//		driver.findElement(By.xpath("//input[@id='development']")).click();
//		
//		
//		System.out.println("Step 5: check Element step 2 is selected");
//		assertFalse(driver.findElement(By.xpath("//input[@id='development']")).isSelected());
//		System.out.println("============Done TC_03_VerifyElementIsSelected====================");
//	}

	public void selectItemInCustomDropdownJS(String parentLocator, String allItemLocator, String expectedItem)
			throws InterruptedException {
		element = driver.findElement(By.xpath(parentLocator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemLocator)));
		elements = driver.findElements(By.xpath(allItemLocator));

		for (WebElement item : elements) {
			if (item.getText().equals(expectedItem)) {
				js.executeScript("arguments[0].scrollIntoView(true);", item);
				Thread.sleep(1000);
				item.click();
				Thread.sleep(2000);
				break;
			}
		}
	}
	
	public void selectItemInCustomDropdown(String parentLocator, String allItemLocator, String expectedItem)
			throws InterruptedException {
		element = driver.findElement(By.xpath(parentLocator));
		System.out.println(element);
		element.click();
		elements = driver.findElements(By.xpath(allItemLocator));
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemLocator)));
		for (WebElement item : elements) {
			if (item.getText().equals(expectedItem)) {
				item.click();
				break;
			}
		}
	}

	@BeforeClass
	public void beforeClass() {
		String rootfolder = System.getProperty("user.dir");
//		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
//		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
//		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, rootfolder + "\\firefoxlogs.txt");
//		driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		waitExplicit = new WebDriverWait(driver, 30);
		jsExecutor = (JavascriptExecutor) driver;
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
