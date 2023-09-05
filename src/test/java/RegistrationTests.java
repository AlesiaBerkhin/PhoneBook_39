import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

//    WebDriver wd;
//
//    @BeforeMethod
//    public void init(){
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//    };

    @Test
    public void registrationPositiveTest(){

        // open login form
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();

        // fill login form
        int i = (int)(System.currentTimeMillis()/1000)%3600; //CASTING
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("katy_" + i + "@mail.ru");

        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("Kk12345!");

        // click on button registration
        wd.findElement(By.xpath("//button[2]")).click();

        // assert

        Assert.assertTrue(wd.findElements(By.tagName("button")).size() > 0);

    }

    @Test
    public void registrationNegativeTestWrongEmail(){

        wd.findElement(By.xpath("//*[.='LOGIN']")).click();

        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("katymail.ru");

        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("Kk12345!");

        wd.findElement(By.xpath("//button[2]")).click();

        Assert.assertTrue(isAlertPresent());
    }

//    public boolean isAlertPresent(){
//        Alert alert = new WebDriverWait(wd, 5)
//                .until(ExpectedConditions.alertIsPresent());   // do tex por poka
//        if(alert == null) return false;
//        wd.switchTo().alert(); // pereklychis na alert, chtob garantirovanno nazat na knopky
//        System.out.println(alert.getText());
//        alert.accept();
//        return true;
//    }
}
