package demo;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Links;

import io.github.bonigarcia.wdm.WebDriverManager;

public class framescode {
    WebDriver driver;
    public framescode(){
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
    public void testCase06() throws InterruptedException{
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-bottom");
        Thread.sleep(5000);
        WebElement top = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
        top.getText();
        // driver.switchTo().frame("frame-top");
        // WebElement top1 =driver.findElement(By.xpath("//frame[@name='frame-top']"));
        // top1.getText();

    }
}
