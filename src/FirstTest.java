import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
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
    driver.findElement(By.linkText("Registry")).click();
    

    // String ActualTitle = driver.getTitle();
    // String ExpectedTitle = “Amazon.com: Online Shopping for Electronics, Apparel,
    //     Computers, Books, DVDs &amp; more”;
    // Assert.assertEquals(ActualTitle, ExpectedTitle);
    // System.out.println(“Assert passed”);
    }
    @AfterTest
    public void closedriver(){
    //closes the browser instance
    driver.close(); }



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

}

   