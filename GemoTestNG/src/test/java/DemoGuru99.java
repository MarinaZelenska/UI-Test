import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DemoGuru99 extends BaseUITestFile {

    String loginUrl = "http://demo.guru99.com/Agile_Project/Agi_V1/index.php";
    String userId = "1303";
    String password = "Guru99";

    @BeforeMethod
    public void pageUrl(){
        driver.get(loginUrl);

    }



    @Test
    public void positiveLoginTest() {

        driver.findElement(By.name("uid")).sendKeys(userId);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();


        WebElement logoutButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Log out']")));
        logoutButton.click();

        assertEquals(driver.switchTo().alert().getText(), "You Have Succesfully Logged Out!!");
        driver.switchTo().alert().accept();


        assertEquals(driver.getCurrentUrl(), loginUrl);

    }


    @Test
    public void negativeWrongPasswordLoginTest() {

        driver.findElement(By.name("uid")).sendKeys(userId);
        driver.findElement(By.name("password")).sendKeys("qwerty");
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();

        assertEquals(driver.getCurrentUrl(), loginUrl);

    }


    @Test
    public void negativeWrongUserIDLoginTest() {

        driver.findElement(By.name("uid")).sendKeys("1234");
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();

        assertEquals(driver.getCurrentUrl(), loginUrl);

    }



    @Test
    public void negativePasswordWithSpacesLoginTest(){

        driver.findElement(By.name("uid")).sendKeys(userId);
        driver.findElement(By.name("password")).sendKeys("Gur   u99");

        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
        assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();

        assertEquals(driver.getCurrentUrl(), loginUrl);

    }




    @Test
    public void negativeEmptyFieldsLoginTest() {

        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
        assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();

        assertEquals(driver.getCurrentUrl(), loginUrl);

    }

    @Test
    public void negativeEmptyFieldUserIDLoginTest() {

        driver.findElement(By.name("uid")).sendKeys(" ");
        driver.findElement(By.name("password")).sendKeys(password);

        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
        assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();

        assertEquals(driver.getCurrentUrl(), loginUrl);

    }

    @Test
    public void negativeEmptyFieldPasswordLoginTest() {

        driver.findElement(By.name("uid")).sendKeys(userId);


        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
        assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();

        assertEquals(driver.getCurrentUrl(), loginUrl);

    }

}
