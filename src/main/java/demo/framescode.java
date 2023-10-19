package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class framescode {
    WebDriver driver;

    public framescode() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }

    public void testCase06() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        // Switch to left frame driver.switchTo().frame('frame-left')
        driver.switchTo().frame("frame-top");
        // String txt = driver.findElement(By.xpath("/html/body")).getText();

        // Get LEFT text element and print text Using Locator "XPath" /html/body |
        // getText()
        driver.switchTo().frame("frame-left");
        String txtlft = driver.findElement(By.xpath("/html/body")).getText();
        System.out.println("frame left" + txtlft);
        // Move back to parent frame /html/body | getText()
        driver.switchTo().parentFrame();

        // Switch to middle frame driver.switchTo().frame('frame-middle')
        driver.switchTo().frame("frame-middle");
        // Get MIDDLE text element and print text Using Locator "ID" id='content' |
        // getText()
        String txtmid = driver.findElement(By.id("content")).getText();
        System.out.println("frame middle" + txtmid);
        // Move back to parent frame driver.switchTo().parentFrame()
        driver.switchTo().parentFrame();
        // Switch to right frame driver.switchTo().frame('frame-right')
        driver.switchTo().frame("frame-right");
        // Get RIGHT text element and print text Using Locator "XPath" /html/body |
        // getText()
        String txtrgt = driver.findElement(By.xpath("/html/body")).getText();
        System.out.println("frame Right" + txtrgt);
        // Move back to parent frame driver.switchTo().parentFrame()

        driver.switchTo().defaultContent();

        // Switch to bottom frame driver.switchTo().frame('frame-bottom')
        driver.switchTo().frame("frame-bottom");
        // Get BOTTOM text element and print text /html/body | getText()
        String txtbttm = driver.findElement(By.xpath("/html/body")).getText();
        System.out.println("frame Right" + txtbttm);
        // Move back to parent frame driver.switchTo().parentFrame()
        driver.switchTo().defaultContent();

    }

}