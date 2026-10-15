package BTH4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class lab1 {

    public static void main(String[] args) throws InterruptedException {

        // 1. Khởi tạo Chrome
        WebDriver driver = new ChromeDriver();

        try {
            // 2. Mở website Guru99
            driver.manage().window().maximize();
            driver.navigate().to(
                "https://demo.guru99.com/test/ajax.html"
            );

            Thread.sleep(1000);

            // 3. Chọn radio button Yes
            driver.findElement(By.id("yes")).click();

            // 4. Nhấn nút Check
            driver.findElement(By.id("buttoncheck")).click();

            Thread.sleep(1000);

            // 5. In thông báo kết quả
            System.out.println(
                "Đã chọn yes và nhấn nút check."
            );

        } finally {
            // 6. Đóng trình duyệt
            driver.quit();
        }
    }
}
