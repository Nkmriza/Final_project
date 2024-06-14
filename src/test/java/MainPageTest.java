import org.testng.annotations.Test;
import pages.MainPage;

import static org.testng.Assert.assertEquals;

public class MainPageTest extends BaseTest {

    @Test
    public void TestSearchItem() {
        String itemName = "missha";
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage()
                .searchForItem(itemName)
                .clickOnSearchItemPopUp();
    }

    @Test
    public void SlideTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage()
                .clickOnLastSlide()
                .clickOnLastSlideImage()
                .getNameOfPageFromAdv();
    }

    @Test
    public void PartnershipFieldTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage()
                .clickOnPartnership();
        Thread.sleep(2000);
        mainPage.clickOnToMainPage();

    }

    @Test
    public void AdditionalSearchFieldTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        String request = "qwe";
        String request2 = "face";
        mainPage.openMainPage()
                .enterTextToSearchField1(request)
                .clickOnSearchBot1()
                .getResultText();
        Thread.sleep(2000);
        mainPage.enterTextToSearchField2(request2)
                .clickOnSearchBot2();
    }

    @Test
    public void CategoriesTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage()
                .moveToSelectFace()
                .clickOnSunCream()
                .moveToSelectFace()
                .moveToAnotherCategory();
        ;
    }
}