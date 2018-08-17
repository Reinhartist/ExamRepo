import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private AddEmployeePage addEmployeePage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Development\\web_driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("^the login page$")
    public void the_login_page() {
        driver.get(Constants.main_url + Constants.login_path);
    }

    @When("^I login$")
    public void i_login() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login(Constants.username, Constants.password);
    }

    @When("^I click the PIM tab$")
    public void i_click_the_PIM_tab() {
        dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        dashboardPage.click_pim();

    }

    @When("^then the Add Employee Tab$")
    public void then_the_Add_Employee_Tab() {
        dashboardPage.clickAddEmployee(wait);
    }

    @When("^I fill out the Add Employee Details correctly$")
    public void i_fill_out_the_Add_Employee_Details_correctly() {
        addEmployeePage = PageFactory.initElements(driver, AddEmployeePage.class);
        addEmployeePage.fillEmployeeDetails();
    }

    @When("^I choose to create Login Details by clicking the appropriate button$")
    public void i_choose_to_create_Login_Details_by_clicking_the_appropriate_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I fill out the Login Details correctly$")
    public void i_fill_out_the_Login_Details_correctly() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I click the Save button$")
    public void i_click_the_Save_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I can search for the Employee I have just created$")
    public void i_can_search_for_the_Employee_I_have_just_created() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^select them for inspection$")
    public void select_them_for_inspection() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
