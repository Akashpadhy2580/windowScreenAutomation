package videoPlayerWindow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser(SWD)
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site(SWD)
		driver.get("http://www.youtube.com");
		FluentWait<ChromeDriver> w=new FluentWait<ChromeDriver>(driver);
		w.withTimeout(Duration.ofSeconds(20));
		w.pollingEvery(Duration.ofMillis(500));
		//Search for a video(SWD)
		w.until(ExpectedConditions.visibilityOfElementLocated(
				By.name("search_query"))).sendKeys("abdul kalam sir speeches");
		Thread.sleep(2000);
		w.until(ExpectedConditions.elementToBeClickable(
				          By.xpath("(//button[@aria-label='Search'])[1]"))).click();
		//Start video(SWD)
		w.until(ExpectedConditions.elementToBeClickable(By.xpath(
		   "//a[@title='APJ Abdul Kalam Inspiring Speech on India at European Parliament']")))
		                                                                             .click();
		Thread.sleep(20000);
		//Automate video elements/controls/icons(SWD)
		//click on Skip add and skip adds
		
		WebElement volume=driver.findElement(By.xpath("//button[@class='ytp-mute-button ytp-button']"));
		WebElement bubble=driver.findElement(By.xpath("//div[@class='ytp-volume-slider-handle']"));
		Actions act=new Actions(driver);
		act.moveByOffset(200, 300).pause(1000).perform();
		
		act.moveToElement(volume).pause(1000).build().perform();
		act.moveToElement(bubble).moveByOffset(-30,0).click().build().perform();
		
	}
}
