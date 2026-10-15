package BTH4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class lab3 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(
            driver, Duration.ofSeconds(15)
        );

        try {
            // 1. Mở website đăng ký New Tours
            driver.manage().window().maximize();
            driver.navigate().to(
                "https://demo.guru99.com/test/newtours/register.php"
            );

            // 2. Chờ form đăng ký hiển thị
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("firstName")
            ));

            // 3. Nhập thông tin cá nhân
            driver.findElement(By.name("firstName"))
                  .sendKeys("Nguyen");

            driver.findElement(By.name("lastName"))
                  .sendKeys("Van A");

            driver.findElement(By.name("phone"))
                  .sendKeys("0901234567");

            driver.findElement(By.id("userName"))
                  .sendKeys("nguyenvana@example.com");

            // 4. Nhập địa chỉ đang nhập
            driver.findElement(By.name("address1"))
                  .sendKeys("123 Nguyen Hue");

            driver.findElement(By.name("city"))
                  .sendKeys("Quy Nhon");

            driver.findElement(By.name("state"))
                  .sendKeys("Binh Dinh");

            driver.findElement(By.name("postalCode"))
                  .sendKeys("590000");

            // 5. Thao tác DropDown quốc gia
            WebElement countryElement =
                driver.findElement(By.name("country"));

            Select country = new Select(countryElement);
            country.selectByVisibleText("UNITED STATES");

            // 6. In thông tin dropdown
            System.out.println(
                "Quoc gia da chon: "
                + country.getFirstSelectedOption().getText()
            );

            // 7. In các option của dropdown
            List<WebElement> options = country.getOptions();

            System.out.println(
                "So luong quoc gia: " + options.size()
            );

            // 8. Thao tác các trường username va password
            driver.findElement(By.id("email"))
                  .sendKeys("nguyenvana");

            driver.findElement(By.name("password"))
                  .sendKeys("Test123456");

            driver.findElement(By.name("confirmPassword"))
                  .sendKeys("Test123456");

            System.out.println(
                "Da hoan thanh thao tac voi form dang ky."
            );

        } finally {
            driver.quit();
        }
    }
}
