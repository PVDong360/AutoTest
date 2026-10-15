package BTH3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class lab2 {

	  public static void main(String[] args) {

	        // 1. Khởi tạo Chrome và thiết lập thuộc tính
	        WebDriver driver = new ChromeDriver();

	        WebDriverWait wait = new WebDriverWait(
	            driver, Duration.ofSeconds(15)
	        );

	        try {
	            driver.manage().window().maximize();

	            // 2. Mở Google
	            driver.navigate().to("https://www.google.com.vn/");

	            // 3. Navigate đến OrangeHRM
	            driver.navigate().to(
	                "https://opensource-demo.orangehrmlive.com/"
	            );

	            // 4. Đăng nhập OrangeHRM
	            wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.name("username")
	            )).sendKeys("Admin");

	            driver.findElement(By.name("password"))
	                  .sendKeys("admin123");

	            driver.findElement(
	                By.xpath("//button[@type='submit']")
	            ).click();

	            // 5. Chờ Dashboard
	            wait.until(ExpectedConditions.urlContains("/dashboard"));

	            // 6. Mở Maintenance
	            wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//span[text()='Maintenance']")
	            )).click();

	            // 7. Xác nhận tài khoản
	            wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.name("password")
	            )).sendKeys("admin123");

	            driver.findElement(
	                By.xpath("//button[@type='submit']")
	            ).click();

	            // 8. Chờ trang Maintenance
	            wait.until(ExpectedConditions.urlContains("/maintenance"));

	            // 9. Chuyển sang My Info
	            wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//span[text()='My Info']")
	            )).click();

	            // 10. Chờ trang Personal Details
	            wait.until(ExpectedConditions.urlContains(
	                "/viewPersonalDetails"
	            ));

	            wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.name("firstName")
	            ));

	            // 11. Lấy Employee Full Name
	            wait.until(d ->
	                !d.findElement(By.name("firstName"))
	                  .getAttribute("value").trim().isEmpty()
	            );

	            WebElement firstName = driver.findElement(
	                By.name("firstName")
	            );

	            WebElement middleName = driver.findElement(
	                By.name("middleName")
	            );

	            WebElement lastName = driver.findElement(
	                By.name("lastName")
	            );

	            String first = firstName.getAttribute("value");
	            String middle = middleName.getAttribute("value");
	            String last = lastName.getAttribute("value");

	            String fullName = (first + " " + middle + " " + last)
	                .trim().replaceAll("\\s+", " ");

	            // 12. Lấy Employee Id
	            WebElement employeeId = driver.findElement(
	                By.xpath(
	                    "//label[normalize-space()='Employee Id']" +
	                    "/ancestor::div[contains(@class,'oxd-input-group')]" +
	                    "//input"
	                )
	            );

	            String id = employeeId.getAttribute("value");

	            // 13. In kết quả ra Console
	            System.out.println(
	                "Title of the page: " + driver.getTitle()
	            );

	            System.out.println(
	                "Employee Full Name: " + fullName
	            );

	            System.out.println(
	                "Employee Id: " + id
	            );

	        } catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		} 
    }
}
