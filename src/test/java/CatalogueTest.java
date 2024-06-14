import org.testng.annotations.Test;
import pages.Catalogue;
import pages.MainPage;

public class CatalogueTest extends BaseTest {
    @Test
    public void closeAllFilters() {
        Catalogue catalogue = new Catalogue(driver);
        catalogue.openCataloguePage()
                .firstPartOfPage()
                .scroll()
                .secondPartOfPage();
    }

    @Test
    public void discountTest() {
        Catalogue catalogue = new Catalogue(driver);
        catalogue.openCataloguePage()
                .openSaleCategory()
                .checkTheDifferenceInPrice()
                .discountInfo();
    }

    @Test
    public void filterResultTest()throws InterruptedException {
        Catalogue catalogue = new Catalogue(driver);
        catalogue.openCataloguePage()
                .filter1()
                .filter2()
                .filter3()
                .filter4()
                .filterResult()
                .checkResults();
    }

}
