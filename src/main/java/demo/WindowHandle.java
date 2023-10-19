package demo;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {
    ChromeDriver driver;
    public WindowHandle(){
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

  }
  public void endTest()
  {
      System.out.println("End Test: TestCases");
      driver.close();
      driver.quit();
  }

  public void testCase08() throws InterruptedException {

    driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
    driver.switchTo().frame("iframeResult");
    
    WebElement tryit = driver.findElement(By.xpath("//button[@onclick='myFunction()']"));
    tryit.click();
    driver.switchTo().parentFrame();
    String firstwindow = driver.getWindowHandle();
    
    Set<String> windows  = driver.getWindowHandles();
    Iterator<String> itr = windows.iterator();
    while(itr.hasNext())
    {
        String window = itr.next();
        driver.switchTo().window(window);

        String url = driver.getCurrentUrl();
        System.out.println("Url of website : " +url);
        String sb= driver.getTitle();
        System.out.println("Get title of page : " +sb);
        
        File srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcScreenshot, new File(".//Screenshot/screenshot2.png"));
        }
            catch (IOException e) {
                e.printStackTrace();
        }
            if (sb.equals("W3Schools Online Web Tutorials"))
            { 
                driver.close();
            }     
    }
    driver.switchTo().window(firstwindow);  
    driver.close();
  }

}

