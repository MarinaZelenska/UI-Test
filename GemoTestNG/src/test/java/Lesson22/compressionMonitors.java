package Lesson22;

import DemoUI.BaseUITestFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.CompareProductPage;
import pages.DetailProductPage;
import pages.HomePageRozetka;
import pages.ProductGridRozetka;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class compressionMonitors extends BaseUITestFile {





    @Test
    public void positiveCompressionMonitorsTest() {
        driver.manage().window().maximize();
        driver.get(url);


        HomePageRozetka homePageRozetka = new HomePageRozetka(driver);
        homePageRozetka.waitSelectCategoryInMenu();
        homePageRozetka.hoverElement();
        homePageRozetka.waitProductInCategory();
        homePageRozetka.selectSubCategory();

        ProductGridRozetka productGridRozetka = new ProductGridRozetka(driver);
        productGridRozetka.waitProductImage();
        productGridRozetka.findSuitablePrice(3000);

        DetailProductPage detailProductPage = new DetailProductPage(driver);
        detailProductPage.waitTabOnDetailPage();
        detailProductPage.waitCompareIcon();
        detailProductPage.clickCompareIcon();
        detailProductPage.waitImageDetailPage();


        String firstElementPrice = productGridRozetka.selectFirstElementPrice();
        int firstPriceFiltered = Integer.parseInt(firstElementPrice);
        String name1 = productGridRozetka.selectFirstName();

        detailProductPage.checkProductWasAddedOnCompare();
        driver.navigate().back();

        productGridRozetka.waitProductImage();
        productGridRozetka.findSuitablePrice(firstPriceFiltered);
        detailProductPage.waitCompareIcon();
        detailProductPage.clickCompareIcon();


        String secondElementPrice = productGridRozetka.selectSecondElementPrice();
        int secondElementFiltered = Integer.parseInt(secondElementPrice);
        String name2 = productGridRozetka.selectSecondName();

        detailProductPage.checkSecondProductWasAddedOnCompare();
        detailProductPage.checkMenuCompareIconIsClickable();
        detailProductPage.checkCountMonitorsInCompareMenu();
        detailProductPage.clickLinkForRedirectOnDetailComparePage();

        CompareProductPage compareProductPage = new CompareProductPage(driver);
        compareProductPage.waitImageComparePage();



        String priceInCompareMenufirst = productGridRozetka.selectPriceCompareMenuFirst();
        String first1 = priceInCompareMenufirst.substring(5, 9);
        int first = Integer.parseInt(first1);


        String nameComparePage1 = productGridRozetka.selectPageCompareFirstName();


        String priceInCompareMenusecond = productGridRozetka.selectPriceInCompareMenuSecond();
        String second1 = priceInCompareMenusecond.substring(5, 9);
        int second = Integer.parseInt(second1);

        String nameComparePage2 = productGridRozetka.selectPageCompareSecondName();

        assertEquals(name1, nameComparePage1);
        assertEquals(name2, nameComparePage2);


        assertEquals(firstPriceFiltered, first);
        assertEquals(secondElementFiltered, second);


    }

}
