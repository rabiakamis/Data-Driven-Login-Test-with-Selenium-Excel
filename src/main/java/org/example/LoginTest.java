package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class LoginTest {
    public static void main(String[] args) {
        String filePath = "src/main/resources/testdata/credentials.xlsx";
        List<String[]> credentialsList = ExcelReader.readCredentials(filePath);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        for (String[] creds : credentialsList) {
            String username = creds[0];
            String password = creds[1];

            driver.get("https://the-internet.herokuapp.com/login");

            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.cssSelector("button.radius")).click();

            boolean loginSuccess = driver.getPageSource().contains("You logged into a secure area!");

            if (loginSuccess) {
                System.out.println("✅ Başarılı giriş: " + username);
                driver.findElement(By.cssSelector("a.button.secondary.radius")).click(); // logout
            } else {
                System.out.println("❌ Hatalı giriş: " + username);
            }
        }

        driver.quit();
    }
}
