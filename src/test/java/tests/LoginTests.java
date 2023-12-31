package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

  //  WebDriver wd;

//    @BeforeMethod
//    public void init(){
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        //wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//    }

    @Test
    public void loginPositiveTest(){

        app.getHelperUser().openLoginRegistrationForm();


        // open login form
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
 //       openLoginRegistrationForm();

        // fill login form
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("katy@mail.ru");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Kk12345!");
        app.getHelperUser().fillLoginRegistrationForm("katy@mail.ru","Kk12345!");

        // click on button login
        //wd.findElement(By.xpath("//button[1]")).click();
        app.getHelperUser().submitLogin();

        // assert
        app.getHelperUser().pause(3000);
       // Assert.assertTrue(wd.findElements(By.tagName("button")).size() > 0);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));

    }

  //  @Test
//    public void loginNegativeTestWrongEmail(){
//
//        // open login form
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//
//        // fill login form
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("katymail.ru");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Kk12345!");
//
//        // click on button login
//        wd.findElement(By.xpath("//button[1]")).click();
//
//        // assert
//        pause(3000);
//    }
//
//    @Test
//    public void loginNegativeTestWrongPassword(){
//
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("katy@mail.ru");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Kk12345");
//
//        // click on button login
//        wd.findElement(By.xpath("//button[1]")).click();
//        Assert.assertTrue(isAlertPresent());
//
//    }

//    public void pause(int millis) {
//        try {
//            Thread.sleep(millis);
//        } catch (InterruptedException e) {
//           e.printStackTrace();
//        }
//    }

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
