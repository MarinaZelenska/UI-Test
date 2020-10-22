package Lesson22;

import DemoUI.BaseUITestFile;
import Factorypages.pages.CompareProductPageFactory;
import Factorypages.pages.DetailProductPageFactory;
import Factorypages.pages.HomePageRozetkaFactory;
import Factorypages.pages.ProductGridRozetkaFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CompareProductPage;
import pages.DetailProductPage;
import pages.HomePageRozetka;
import pages.ProductGridRozetka;

import static org.testng.Assert.assertEquals;

public class compressionFactoryMonitors extends BaseUITestFile {





    @Test
    public void positiveCompressionMonitorsTest() {
        driver.manage().window().maximize();
        driver.get(url);


        HomePageRozetkaFactory homePageRozetka = new HomePageRozetkaFactory(driver);
        homePageRozetka.waitSelectCategoryInMenu();
        homePageRozetka.hoverElement();
        homePageRozetka.waitProductInCategory();
        homePageRozetka.selectSubCategory();

        ProductGridRozetkaFactory productGridRozetka = new ProductGridRozetkaFactory(driver);
        productGridRozetka.waitProductImage();
        productGridRozetka.findSuitablePrice(3000);

        DetailProductPageFactory detailProductPage = new DetailProductPageFactory(driver);
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

        CompareProductPageFactory compareProductPage = new CompareProductPageFactory(driver);
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
