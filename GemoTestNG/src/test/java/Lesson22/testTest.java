package Lesson22;

import DemoUI.BaseUITestFile;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class testTest extends BaseUITestFile {

    @Test
    public void positiveSelectMakeTest() {
        driver.manage().window().maximize();
        driver.get(url);
        driver.findElement(By.name("search")).sendKeys("samsung" + Keys.ENTER);
        WebElement filterLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Мобильные телефоны']")));
        filterLink.click();



        WebElement goods = (WebElement) driver.findElements(By.xpath("//span[contains(text(),'Samsung')"));


        List<WebElement> allItems = driver.findElements(By.cssSelector("span[class='goods-tile__title']"));
        for (WebElement product : allItems) {
            assertTrue(allItems.contains(goods));


        }


    }
}
