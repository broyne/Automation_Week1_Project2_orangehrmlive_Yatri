package orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowser {
    static String browser = "Firefox";
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        //1. Setup Multi browser.
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        }else {
            System.out.println("Wrong browser name");
        }
        //2. Open the URL into browser
        driver.get(baseUrl);

        //Maximise the browser window
        driver.manage().window().maximize();

        //We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //3. Print the title of the page
        System.out.println("Main Title of the page is: " +driver.getTitle());

        //4. Print the current url.
        System.out.println("Current URL is: " +driver.getCurrentUrl());

        //5. Print the page source.
        System.out.println("This the Page source: " +driver.getPageSource());

        //6. Click on ‘Forgot your password?’ link.
        driver.findElement(By.className("orangehrm-login-forgot-header")).click();

        //7. Print the current URL.
        System.out.println("Current URL is: "+driver.getCurrentUrl());

        //8. Navigate back to the login page.
        driver.navigate().back();

        //9. Refresh the page.
        driver.navigate().refresh();

        //10. Enter the email to email field.
        WebElement emailField = driver.findElement(By.name("username"));
        emailField.sendKeys("Admin");

        //11. Enter Password to the password field
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin123");

        //12. close the browser
        driver.quit();


    }
}
