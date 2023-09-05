import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    WebDriver wd;

    @BeforeMethod
    public void init(){
        wd = new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");
        //wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        pause(5000);
        wd.quit();
    }

    public void pause(int millis) {

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public boolean isAlertPresent(){
        Alert alert = new WebDriverWait(wd, 5)
                .until(ExpectedConditions.alertIsPresent());   // do tex por poka
        if(alert == null) return false;
        wd.switchTo().alert(); // pereklychis na alert, chtob garantirovanno nazat na knopky
        System.out.println(alert.getText());
        alert.accept();
        return true;
    }

    public void openLoginRegistrationForm(){
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
    }

    public void fillLoginRegistrationForm(String email, String password){
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);

        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys(password);
    }

    public void submitLogin(){
        wd.findElement(By.xpath("//button[1]")).click();
    }
    public boolean isElementPresent(By locator){
       return wd.findElements(locator).size() > 0;
    }
}