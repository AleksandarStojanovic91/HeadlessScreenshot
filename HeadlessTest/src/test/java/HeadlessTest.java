import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class HeadlessTest extends Base{
    String URL = "https://www.saucedemo.com/";
    String password = "secret_sauce";

    @BeforeMethod
    public void setup(){
        init(URL);
    }

    @Test
    public void loginStandardUser(){
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.cssSelector("#login-button")).click();
        Assert.assertEquals(driver.getTitle(),"Swag Labs");
        Assert.assertTrue(driver.findElement(By.cssSelector(".peek")).isDisplayed());
    }

    @Test
    public void loginLockedOutUser(){
        driver.findElement(By.cssSelector("#user-name")).sendKeys("locked_out_user");
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.cssSelector("#login-button")).click();
        Assert.assertEquals(driver.getTitle(),"Swag Labs");
        Assert.assertTrue(driver.findElement(By.cssSelector(".peek")).isDisplayed());
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}