package BTH3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class lab3 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(
            driver, Duration.ofSeconds(15)
        );

        try {
            // 1. Mở trình duyệt và truy cập DemoQA
            driver.manage().window().maximize();
            driver.navigate().to("https://demoqa.com/");

            // 2. Chọn Elements
            wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//h5[normalize-space()='Elements']")
            )).click();

            // 3. Chọn Text Box
            wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Text Box']")
            )).click();

            // 4. Nhập Full Name
            WebElement fullName = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.id("userName")
                )
            );
            fullName.clear();
            fullName.sendKeys("Nguyen Van A");

            // 5. Nhập Email
            WebElement email = driver.findElement(By.id("userEmail"));
            email.clear();
            email.sendKeys("nguyenvana@example.com");

            // 6. Nhập Current Address
            WebElement currentAddress =
                driver.findElement(By.id("currentAddress"));
            currentAddress.clear();
            currentAddress.sendKeys("Quy Nhon, Gia Lai");

            // 7. Nhập Permanent Address
            WebElement permanentAddress =
                driver.findElement(By.id("permanentAddress"));
            permanentAddress.clear();
            permanentAddress.sendKeys("Viet Nam");

            // 8. Cuộn đến nút Submit và nhận
            WebElement submit = driver.findElement(By.id("submit"));

            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", submit
            );

            wait.until(ExpectedConditions.elementToBeClickable(
                By.id("submit")
            )).click();

            // 9. Chờ kết quả hiển thị
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("output")
            ));

            // 10. Lấy kết quả bằng XPath
            String resultName = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@id='output']//p[@id='name']")
                )
            ).getText();

            String resultEmail = driver.findElement(
                By.xpath("//div[@id='output']//p[@id='email']")
            ).getText();

            String resultCurrentAddress = driver.findElement(
                By.xpath("//div[@id='output']//p[@id='currentAddress']")
            ).getText();

            String resultPermanentAddress = driver.findElement(
                By.xpath("//div[@id='output']//p[@id='permanentAddress']")
            ).getText();

            // 11. In kết quả println(resultName);
            System.out.println(resultEmail);
            System.out.println("Current Address: "
                + resultCurrentAddress);
            System.out.println("Permanent Address: "
                + resultPermanentAddress);

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
