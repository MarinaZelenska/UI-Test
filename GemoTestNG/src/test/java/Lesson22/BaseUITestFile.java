package Lesson22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseUITestFile {
    public WebDriver driver;
    public WebDriverWait wait;
    public String url = "https://rozetka.com.ua/";

    @BeforeClass
    public void setupDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

    }

    @AfterClass
    public void closeDriver(){
        driver.quit();
    }
}
