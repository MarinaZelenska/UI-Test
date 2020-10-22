package Lesson22;

import DemoUI.BaseUITestFile;
import Factorypages.pages.HomePageRozetkaFactory;
import Factorypages.pages.ProductGridRozetkaFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePageRozetka;
import pages.ProductGridRozetka;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class filtersTestFactory extends BaseUITestFile {


    @Test
    public void positiveSelectMakeTest() {
        driver.manage().window().maximize();
        driver.get(url);

        HomePageRozetkaFactory homePageRozetka = new HomePageRozetkaFactory(driver);
        homePageRozetka.searchQuery("samsung");


        ProductGridRozetkaFactory productGridRozetka = new ProductGridRozetkaFactory(driver);
        productGridRozetka.waitCheckboxCategoryforFilter();
        productGridRozetka.clickCheckboxCategoryforFilter();
        productGridRozetka.waitAppleElement();
        productGridRozetka.clickAppleElement();
        productGridRozetka.waitDownloadImage();
        productGridRozetka.waitHuaweiElement();
        productGridRozetka.clickHuaweiElement();

        assertEquals(productGridRozetka.getSelectedGoods().size(), productGridRozetka.getAllItems().size());


    }


    @Test
    public void positiveSelectPriceTest() {
        driver.manage().window().maximize();
        driver.get(url);
        HomePageRozetkaFactory homePageRozetka = new HomePageRozetkaFactory(driver);
        homePageRozetka.searchQuery("samsung");

        ProductGridRozetkaFactory productGridRozetka = new ProductGridRozetkaFactory(driver);
        productGridRozetka.waitCheckboxCategoryforFilter();
        productGridRozetka.clickCheckboxCategoryforFilter();
        productGridRozetka.waitDownloadImage();
        productGridRozetka.waitMinPrice();
        productGridRozetka.clearMinPrice();
        productGridRozetka.addValueMinPrice("5000");
        productGridRozetka.waitMaxPrice();
        productGridRozetka.clearMaxPrice();
        productGridRozetka.addValueMaxPrice("15000");
        productGridRozetka.buttonOk();
        productGridRozetka.downloadPictureAfterSelectedLimit();


        List<WebElement> itemsContainsFilter = productGridRozetka.getAllPricesAfterSelectedLimitPrice();
        int count;

        for (count = 1; count <= itemsContainsFilter.size(); count++) {
            String price = driver.findElement(By.xpath("//ul[@class='catalog-grid']//li[" + count + "]//span[@class='goods-tile__price-value']")).getText().replaceAll("\\s", "");
            int priceFiltered = Integer.parseInt(price);
            assertTrue(priceFiltered > 5000);
            assertTrue(priceFiltered < 15000);
        }


    }


    @Test
    public void positiveSelectSeriesTest() {
        driver.manage().window().maximize();
        driver.get(url);
        HomePageRozetkaFactory homePageRozetka = new HomePageRozetkaFactory(driver);
        homePageRozetka.searchQuery("samsung");

        ProductGridRozetkaFactory productGridRozetka = new ProductGridRozetkaFactory(driver);
        productGridRozetka.waitCheckboxCategoryforFilter();
        productGridRozetka.clickCheckboxCategoryforFilter();
        productGridRozetka.waitDownloadImage();

        productGridRozetka.waitReadyForDelivery();
        productGridRozetka.clickReadyForDelivery();
        productGridRozetka.downloadPictureAfterSelectedLimit();


        assertEquals(productGridRozetka.selectedSeriesGoods().size(), productGridRozetka.getAllItems().size());


    }


}
