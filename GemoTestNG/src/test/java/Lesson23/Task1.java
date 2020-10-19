package Lesson23;

import DemoUI.BaseUITestFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Task1 extends BaseUITestFile {

    String urlGmail = "https://www.google.com/intl/ru/gmail/about/";

    @Test
    public void positiveGmailTest() throws AWTException {
        driver.manage().window().maximize();

        driver.get(urlGmail);
        WebElement btnSignIn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='h-c-header__cta-list header__nav--ltr']//a[@ga-event-action='sign in']")));
        btnSignIn.click();

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));


        WebElement inputEmail = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='email']")));
        inputEmail.click();
        inputEmail.sendKeys("zelenskaamarinaa@gmail.com");
        driver.findElement(By.xpath("//div[@id='identifierNext']//button")).click();


        WebElement inputPassword = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='password']")));
        inputPassword.click();
        inputPassword.sendKeys("1s6b12z2q");
        driver.findElement(By.xpath("//div[@id='passwordNext']//button")).click();

        WebElement addNewLetter = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[gh='cm']")));
        addNewLetter.click();

        WebElement dialogWindow = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[role='dialog']")));

        driver.findElement(By.cssSelector("textarea[name='to']")).sendKeys("osychenkomarina@gmail.com");
        driver.findElement(By.cssSelector("input[name='subjectbox']")).sendKeys("Test Email");
        driver.findElement(By.cssSelector("div[aria-label='Тело письма']")).sendKeys("It's test letter");
        driver.findElement(By.cssSelector("div[command='Files']")).click();


        StringSelection ss = new StringSelection("C:/Users/User/TestProject/Test.docx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        driver.findElement(By.xpath("//div[@class='dC']//div[contains(text(), 'Отправить')]")).click();


        WebElement letterGrid = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Test')])")));
        Assert.assertTrue(letterGrid.isDisplayed());
        letterGrid.click();

        WebElement letterInside = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='amn']")));
        Assert.assertTrue(driver.findElement(By.xpath("h2[contains(text(), 'Test')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='aQH']/span")).isDisplayed());


    }
}
