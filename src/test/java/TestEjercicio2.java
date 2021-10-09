import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestEjercicio2 extends Base{

    @BeforeTest
    public void initialize() {
        driver = initializeDriver();
        driver.get("https://demoqa.com/buttons");

    }

    @Test
    public void VerifyClickBtn() {

        Actions act = new Actions(driver);


        WebElement DobleClick = driver.findElement(By.xpath("//*[@id=\"doubleClickBtn\"]"));
        act.doubleClick(DobleClick).perform();

        WebElement RightClick = driver.findElement(By.xpath("//*[@id=\"rightClickBtn\"]"));
        act.contextClick(RightClick).perform();

        WebElement OneClick = driver.findElement(By.xpath("//div[@class='mt-4']//following::button"));
        act.click(OneClick).perform();

        String DoubleClickText = driver.findElement(By.id("doubleClickMessage")).getText();
        String RightClickText = driver.findElement(By.id("rightClickMessage")).getText();
        String ClickMeText = driver.findElement(By.id("dynamicClickMessage")).getText();

        String Text1 = "You have done a double click";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(Text1, DoubleClickText);
        softAssert.assertAll();

        String Text2 = "You have done a right click";
        SoftAssert softAssert2 = new SoftAssert();
        softAssert2.assertEquals(Text2, RightClickText);
        softAssert2.assertAll();

        String Text3 = "You have done a dynamic click";
        SoftAssert softAssert3 = new SoftAssert();
        softAssert3.assertEquals(Text3, ClickMeText);
        softAssert3.assertAll();
    }

    @AfterTest
    public void closeDriver(){

        driver.close();
    }
}
