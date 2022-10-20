import java.net.URL;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.sql.Driver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.security.auth.x500.X500Principal;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class BrokenLinksTest
{
    String WebsiteURL="https://the-internet.herokuapp.com";
    WebDriver driver;
    @BeforeTest
    public void SetDriver(){
    // //Mention the location of ChromeDriver in localsystem
    System.setProperty("webdriver.chrome.driver","F:\\JavaSeliniumLearning\\SeliniumLearning\\src\\drivers\\chromedriver.exe");
     driver = new ChromeDriver();// Object is created- Chrome browser is opened
     driver.manage().window().maximize();
    
     }

    
    @Test
    void TestBrokenLinks()
    {
        String url="";

        driver.get("https://dev.pgtech.games");
      List<WebElement> links=  driver.findElements(By.tagName("a"));
    
      Iterator<WebElement> link_iterator = links.iterator();
      while (link_iterator.hasNext())
      {
        url=link_iterator.next().getAttribute("href");
        if(url==null )
        {
System.out.println("URK us empty");
            continue;
        }

        try {
            URL urlobj= new URL(url);
            try {
                HttpURLConnection con =(HttpURLConnection) urlobj.openConnection();
                int responseCode= con.getResponseCode();
                
                if(responseCode>=400)
                {
                    System.out.println(url+"is a broken link");
                }
            else
            {
                System.out.println(url+"is non broken");
            }
            } catch (IOException e) {
            
                e.printStackTrace();
            }
        
        
        } catch (MalformedURLException e) {
           
            e.printStackTrace();
        }
      }

    }

    @AfterTest
    public void closedriver(){
    //closes the browser instance
    driver.close();
driver.quit();
}}