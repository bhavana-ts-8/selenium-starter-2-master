package demo;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.util.Arrays.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Links;
import com.google.common.collect.Iterators;

import io.github.bonigarcia.wdm.WebDriverManager;

public class bookmyshow {
    WebDriver driver;
    public bookmyshow(){
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
    public void testCase05() throws InterruptedException{
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        Thread.sleep(5000);

        List <WebElement> recommended = driver.findElements(By.xpath("//div[@class='style__VerticalCardContainer-sc-dv5ht7-0 crxcDb']/div"));

        java.util.Iterator<WebElement> itr = recommended.iterator();
         while(itr.hasNext()) {
              System.out.println(itr.next().getText());
}    
        List<WebElement> imgurls = driver.findElements(By.xpath("//a[@class='commonStyles__LinkWrapper-sc-133848s-11 style__CardContainer-sc-lnhrs7-5 kcFNYT']"));
      
        for(WebElement img: imgurls){
            System.out.println(img.getAttribute("href"));
        }

        WebElement premier = driver.findElement(By.xpath("(//div[@class='sc-7o7nez-0 zDfcI'])[2]"));
        System.out.println("Name of premier" + premier.getText());

        WebElement language = driver.findElement(By.xpath("(//div[@class='sc-7o7nez-0 veMGd'])[2]"));
        System.out.println("Name of language" + language.getText());

       
    }
}

