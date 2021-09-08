package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class TestStepsDefinition {

    WebDriver driver=new ChromeDriver();
    String url ="http://automationpractice.com/index.php";

    @Given("MyStore main page is loaded in foreground")
    public void my_store_main_page_is_loaded_in_foreground() {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(2500, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }
    @When("Sign in button is pressed")
    public void sign_in_button_is_pressed() {
        driver.findElement(By.linkText("Sign in")).click();
    }
    @When("A valid email address is entered in the Create an account section")
    public void a_valid_email_address_is_entered_in_the_create_an_account_section() {
        driver.findElement(By.xpath("//input[@name=\"email_create\"]")).sendKeys("example_email_123@gmail.com");
    }
    @When("Create an account button is pressed")
    public void create_an_account_button_is_pressed() {
        driver.findElement(By.cssSelector("[name='SubmitCreate']")).click();
    }
    @When("Personal Information, Address and Contact info fields are filled in with valid data")
    public void personal_information_address_and_contact_info_fields_are_filled_in_with_valid_data() {
        // Personal info data
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("ExampleFirstName");
        driver.findElement(By.id("customer_lastname")).sendKeys("ExampleLastName");
        driver.findElement(By.id("passwd")).sendKeys("ExamplePassword");

        // Address data
        driver.findElement(By.id("firstname")).sendKeys("ExampleFirstName");
        driver.findElement(By.id("lastname")).sendKeys("ExampleLastName");
        driver.findElement(By.id("company")).sendKeys("ExampleCompany");
        driver.findElement(By.id("address1")).sendKeys("ExampleAddress");
        driver.findElement(By.id("city")).sendKeys("ExampleCity");

        WebElement stateDropMenu=driver.findElement(By.name("id_state"));
        Select selectState=new Select(stateDropMenu);
        selectState.selectByValue("10");

        driver.findElement(By.id("postcode")).sendKeys("12345");

        WebElement countryDropMenu=driver.findElement(By.name("id_country"));
        Select selectCountry=new Select(countryDropMenu);
        selectCountry.selectByVisibleText("United States");

        // Contact info
        driver.findElement(By.id("phone_mobile")).sendKeys("123456789");
        driver.findElement(By.xpath("//input[@name=\"alias\"]")).clear();
        driver.findElement(By.xpath("//input[@name=\"alias\"]")).sendKeys("ExampleAddressAlias");
    }
    @When("Register button is pressed")
    public void register_button_is_pressed() {
        driver.findElement(By.name("submitAccount")).click();
    }
    @Then("A new account with previously entered data is created")
    public void a_new_account_with_previously_entered_data_is_created() {
        String userText=driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).getText();

        if(userText.contains("ExampleFirstName")) {
            System.out.println("=======================================================================");
            System.out.println("New account has been successfully created using previously entered data");
            System.out.println("=======================================================================");
        }
        else {
            System.out.println("==============================================================");
            System.out.println("New account could not be created using previously entered data");
            System.out.println("==============================================================");
        }
    }

}
