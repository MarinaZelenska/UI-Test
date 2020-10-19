package Lesson23;

import DemoUI.BaseUITestFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Task3 extends BaseUITestFile {

    String urlDemo = "http://demo.guru99.com/Agile_Project/Agi_V1/index.php";

    @Test
    public void positiveIframeTest() throws InterruptedException {
        driver.get(urlDemo);
        WebElement video = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='primisslate']/div/div/div")));
        video.click();


        Actions actions = new Actions(driver);
        actions.moveToElement(video).build().perform();


        WebElement display = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@style='width: 100%; bottom: 0px; left: 0px; position: absolute; opacity: 1; visibility: visible; user-select: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0); pointer-events: auto; display: block;']")));

        assertTrue(display.isDisplayed());

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.name("uid")));

        WebElement notDisplay = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@style='width: 100%; bottom: 0px; left: 0px; position: absolute; opacity: 0; visibility: visible; user-select: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0); pointer-events: auto; display: none;']")));

        assertFalse(display.isDisplayed());



    }


}
