import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TestE1 extends Base{

    @BeforeTest
    public void initialize() {
        driver = initializeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void textForm() throws InterruptedException {

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Luis");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Ferrari");

        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("luis.fem14@gmail.com");

        WebElement userGender = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label"));
        userGender.click();

        WebElement userNumber = driver.findElement(By.id("userNumber"));
        userNumber.sendKeys("9269394570");

        WebElement dateOfBirthInput = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirthInput.sendKeys(Keys.CONTROL + "a");
        dateOfBirthInput.sendKeys("14 May 1994");
        dateOfBirthInput.sendKeys(Keys.ENTER);

        WebElement subjects = driver.findElement(By.xpath("//*[@id=\"subjectsContainer\"]/div/div[1]/div[2]"));
        subjects.click();
        WebElement subjects1 = driver.findElement(By.id("subjectsInput"));
        subjects1.sendKeys("Physics");
        subjects1.sendKeys(Keys.ENTER);

        WebElement userHobbie = driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label"));
        userHobbie.click();

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", currentAddress);
        currentAddress.sendKeys("Lima - Perú");

        WebElement selectClick1 = driver.findElement(By.xpath("//*[@id=\"state\"]/div/div[1]"));
        selectClick1.click();
        WebElement selectState = driver.findElement(By.id("react-select-3-input"));
        selectState.sendKeys("NCR");
        selectState.sendKeys(Keys.ENTER);

        WebElement selectClick2 = driver.findElement(By.xpath("//*[@id=\"city\"]/div/div[1]"));
        selectClick2.click();
        WebElement inputCity = driver.findElement(By.id("react-select-4-input"));
        inputCity.sendKeys("Noida");
        inputCity.sendKeys(Keys.ENTER);

        WebElement btnSubmit = driver.findElement(By.id("submit"));
        btnSubmit.click();
        Thread.sleep(5000);

        String titleSubmit = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();
        WebElement btnclose = driver.findElement(By.id("closeLargeModal"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", btnclose);

        String FinalTitle = "Thanks for submitting the form";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(FinalTitle, titleSubmit);
        softAssert.assertAll();

    }

    @AfterTest
    public void closeDriver(){

        driver.close();
    }
}
