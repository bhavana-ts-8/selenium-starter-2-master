package demo;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.util.Arrays.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;

public class Alert {
    WebDriver driver;
    public Alert(){
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
    public void testCase09() throws InterruptedException{
        driver.get("https://web-locators-static-site-qa.vercel.app/Alerts");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//p[text()= 'Add Remarks']")).click();
        
        org.openqa.selenium.Alert alert =  driver.switchTo().alert();
        alert.sendKeys("Excellent");
        alert.accept();
    
}
}
