import org.testng.annotations.Test;
import pages.Catalogue;
import pages.MainPage;

public class CatalogueTest extends BaseTest{
    @Test
    public void closeAllFilters() {
       Catalogue catalogue= new Catalogue(driver);
       catalogue.openCataloguePage()
               .firstPartOfPage()
               .scroll()
               .secondPartOfPage();
    }

    @Test
    public void discountTest (){
        Catalogue catalogue= new Catalogue(driver);
        catalogue.openCataloguePage()
                .openSaleCategory()
                .checkTheDifferenceInPrice()
                .discountInfo();
    }

}
