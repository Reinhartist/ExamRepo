import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmployeePage {
    @FindBy(id = "firstName")
    WebElement first_name;

    @FindBy(id = "middleName")
    WebElement middle_name;

    @FindBy(id = "lastName")
    WebElement last_name;

    @FindBy(id = "location_inputfileddiv")
    WebElement location_element;

    public void fillEmployeeDetails(String first, String middle, String last, String location) {
        first_name.sendKeys(first);
        middle_name.sendKeys(middle);
        last_name.sendKeys(last);
        location_element.sendKeys(location);
    }
}
