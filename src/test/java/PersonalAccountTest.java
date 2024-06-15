import pages.BasePage;
import org.testng.annotations.Test;
import pages.PersonalAccount;

public class PersonalAccountTest extends BaseTest {


    @Test
    public void createAccountTest() {
        PersonalAccount personalAccount = new PersonalAccount(driver);
        personalAccount.logInPage()
                .createAccount()
                .nameField("name")
                .surnameField("surname")
                .emailField("mail@mail.com")
                .createPassword("123456")
                .confirmPassword("654321")
                .save()
                .checkIfThereAnyError();
    }
}