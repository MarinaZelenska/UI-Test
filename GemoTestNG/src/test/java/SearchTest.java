import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class SearchTest extends BaseUITestFile {

    @Test
    public void positiveSearchGoogle() {
        driver.get("https://google.com/ncr");
        driver.findElement(By.name("q")).sendKeys("iphone kyiv buy" + Keys.ENTER);
        Boolean isPresent = driver.findElements(By.xpath("//cite[text()='stylus.ua']")).size() > 0;

        int n = 4;

        for (int i = 1; i <= n; i++) {
            if (isPresent) {
                System.out.println("STYLUS.UA found on " + i + " page");
                break;
            } else {
                driver.findElement(By.xpath("//span[text()='Next']")).click();

            }
            if(!isPresent && i==4){
               System.out.println("STYLUS.UA not found on first 5 pages");
           }
        }

        driver.quit();
    }
}


