import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(id = "txtUsername")
    private WebElement username;

    @FindBy(id = "txtPassword")
    private WebElement password;

    public void login(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        username.submit();
    }
}
