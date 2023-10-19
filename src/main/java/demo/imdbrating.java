package demo;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class imdbrating {
    ChromeDriver driver;
    public imdbrating(){
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

  public void testCase07(){

    driver.get("https://www.imdb.com/chart/top");
    String wb = driver.findElement(By.xpath("(//a[@class='ipc-title-link-wrapper'])[1]")).getText();
    System.out.println("highest rated movie"+ wb);
    List <WebElement> total = driver.findElements(By.xpath("//a[@class='ipc-title-link-wrapper']"));
    System.out.println("total movies : " + total.size());
    String wb1 = driver.findElement(By.xpath("(//h3[text()='250. Dances with Wolves'])[1]")).getText();
    System.out.println("oldest movie "  +wb1);
    String wb3 = driver.findElement(By.xpath("(//a[@class='ipc-title-link-wrapper'])[1]")).getText();
    System.out.println("Most recent movie"+ wb3);
    String wb4 = driver.findElement(By.xpath("(//a[@class='ipc-title-link-wrapper'])[1]")).getText();
    System.out.println("Most user rating"+ wb4);
  }  
}

