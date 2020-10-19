package Lesson23;

import DemoUI.BaseUITestFile;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertTrue;

public class Task2 extends BaseUITestFile {

    String urlDemo = "http://demo.guru99.com/Agile_Project/Agi_V1/index.php";
    String userId = "1303";
    String password = "Guru99";

    @Test
    public void positiveCookieTest() {
        driver.get(urlDemo);
        driver.findElement(By.name("uid")).sendKeys(userId);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        Set<Cookie> cookies = driver.manage().getCookies();

        for (Cookie i : cookies) {
            System.out.println(i);
        }

        driver.manage().deleteAllCookies();

        driver.navigate().to(driver.getCurrentUrl());

        assertTrue(driver.findElement(By.xpath("//a[text()='Log out']")).isDisplayed());


    }
}
