package demo;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Linkedln {
    ChromeDriver driver;
    public Linkedln(){
       
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
    public void testCase04(){
        driver.get("https://in.linkedin.com/");

        WebElement email = driver.findElement(By.xpath("//input[@id='session_key']"));
        email.sendKeys("bhavanashiva8@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='session_password']"));
        password.sendKeys("twinkleshine@17");

        WebElement signin = driver.findElement(By.xpath("//button[@type='submit']"));
        signin.click();

        WebElement count =  driver.findElement(By.xpath("(//div[@class= 'feed-identity-widget-item__icon-stat t-12 t-black t-bold flex-1'])[1]"));  
        System.out.println("Number of people viewed:" + count.getText());
        
        WebElement countImp =  driver.findElement(By.xpath("(//div[@class= 'feed-identity-widget-item__icon-stat t-12 t-black t-bold flex-1'])[2]"));  
        System.out.println("Number of impression:" + countImp.getText());

        WebElement startPost = driver.findElement(By.xpath("//button[@class='artdeco-button artdeco-button--muted artdeco-button--4 artdeco-button--tertiary ember-view share-box-feed-entry__trigger']"));
        startPost.click();
        WebElement setting = driver.findElement(By.xpath("//div[@class='relative artdeco-entity-lockup artdeco-entity-lockup--size-4 ember-view']"));
        setting.click();

        // WebElement connectonly = driver.findElement(By.xpath("(//label[@class='sharing-shared-generic-list__radio-label'])[2]"));
        // connectonly.click();

        WebElement done1 = driver.findElement(By.xpath("//span[@text='Done']"));
        done1.click();
    }
}
      

