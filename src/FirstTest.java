import java.sql.Driver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.security.auth.x500.X500Principal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;;
public class FirstTest {
    WebDriver driver;
    //Store current project workspace location in a string variable ‘path’
   
    @BeforeTest
    public void SetDriver(){
    // //Mention the location of ChromeDriver in localsystem
    System.setProperty("webdriver.chrome.driver","F:\\JavaSeliniumLearning\\SeliniumLearning\\src\\drivers\\chromedriver.exe");
     driver = new ChromeDriver();// Object is created- Chrome browser is opened
     driver.manage().window().maximize();
    
     }
    
    @Test
    public void verifyTitle()
    {
  
    driver.get("https://www.amazon.com");
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
    driver.findElement(By.xpath("//input[contains(@class,'a-button-input')]")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Registry"))).click();
    driver.navigate().back();

    driver.navigate().forward();

    // String ActualTitle = driver.getTitle();
    // String ExpectedTitle = “Amazon.com: Online Shopping for Electronics, Apparel,
    //     Computers, Books, DVDs &amp; more”;
    // Assert.assertEquals(ActualTitle, ExpectedTitle);
    // System.out.println(“Assert passed”);
    }


    @Test
    public void switchBetweenWindows () {
        driver.get("https://the-internet.herokuapp.com/windows");
       String Current_window_handle =driver.getWindowHandle();
        
        driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();
       Set<String> handlenames =driver.getWindowHandles();
       Iterator<String> handlIterator = handlenames.iterator();
       while(handlIterator.hasNext())
       {
        String child_window = handlIterator.next();

        if(!Current_window_handle.equals(child_window))
        {
            driver.switchTo().window(child_window);
            driver.findElement(By.xpath("//h3[normalize-space()='New Window']"));
           
            
        }
       
    
    
    
    
    
    }

    driver.switchTo().window(Current_window_handle);
    driver.close();
    }

    @AfterTest
    public void closedriver(){
    //closes the browser instance
    driver.close();
driver.quit();
}

@Test
void InteractWithIframes()
{
    driver.get("https://the-internet.herokuapp.com/iframe");
    driver.switchTo().frame(0).findElement(By.tagName("p"));
}


    @Test(priority = 2)
    public void Test2(){
        int a=4;
        boolean is_student ;
    Assert.assertEquals(4, a);
    is_student=true;
    Assert.assertTrue(is_student);
        
    }



@Test(priority = 1)
public void Test3(){


}

void ReverseList()
{
    int [] array = {1,2,3};
    ArrayList<Integer> list=new ArrayList<Integer>();
    for (int i=array.length-1 ; i>=0;i--)
    {
        list.add(array[i]);
    
    } 

    System.out.println(list);

}
public static void main(String[] args) {
  FirstTest firstTest = new FirstTest();
  firstTest.ReverseList();
}
}

   