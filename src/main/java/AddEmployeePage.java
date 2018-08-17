import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployeePage {
    // For fill EmployeeDetails
    @FindBy(id = "firstName")
    private WebElement first_name;

    @FindBy(id = "middleName")
    private WebElement middle_name;

    @FindBy(id = "lastName")
    private WebElement last_name;

    @FindBy(id = "employeeId")
    private WebElement employee_id;

    @FindBy(id = "location_inputfileddiv")
    private WebElement location_element;

    // For clickCreateLoginDetails
    @FindBy(xpath = "//*[@id=\"pimAddEmployeeForm\"]/div[1]/div/materializecss-decorator[3]/div/sf-decorator/div/label")
    private WebElement create_login_details;

    // For fillLoginDetails
    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "confirmPassword")
    private WebElement confirm_password;

    @FindBy(id = "adminRoleId_inputfileddiv")
    private WebElement admin_role;

    // For clickSave
    @FindBy(id = "systemUserSaveBtn")
    private WebElement save_btn;

    @FindBy(id = "personal_details_tab")
    private WebElement personal_details_tab;

    public void fillEmployeeDetails(WebDriverWait wait, Actions action,
                                      String first, String middle, String last, String id) {
        wait.until(ExpectedConditions.visibilityOf(first_name));
        first_name.sendKeys(first);
        middle_name.sendKeys(middle);
        last_name.sendKeys(last);
        action.click(location_element).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(
                Keys.ENTER).perform();
        employee_id.sendKeys(id);
    }

    public void clickCreateLoginDetails() {
        create_login_details.click();
    }

    public void fillLoginDetails(Actions action, String user, String pass, String confirm_pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        confirm_password.sendKeys(confirm_pass);
        action.click(admin_role).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
    }

    public void clickSave(WebDriverWait wait) {
        //Not sure what to do with this, if the save button is clicked too fast it won't go through...
        try{
            Thread.sleep(3000);
        } catch (Exception e) {}
        save_btn.click();
        wait.until(ExpectedConditions.visibilityOf(personal_details_tab));
    }
}
