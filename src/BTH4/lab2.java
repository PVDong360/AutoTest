
package BTH4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class lab2 {

    public static void main(String[] args) {

        // 1. Khởi tạo Chrome
        WebDriver driver = new ChromeDriver();

        try {
            // 2. Truy cập website Guru99
            driver.manage().window().maximize();
            driver.navigate().to(
                "https://demo.guru99.com/test/ajax.html"
            );

            // 3. Tìm tất cả radio button có name="name"
            List<WebElement> elements =
                driver.findElements(By.name("name"));

            // 4. In số luợng radio button
            System.out.println(
                "Số lượng của element là: " + elements.size()
            );

            // 5. In giá trị của từng radio button
            for (int i = 0; i < elements.size(); i++) {
                System.out.println(
                    "giá trị của Radio button: "
                    + elements.get(i).getAttribute("value")
                );
            }

        } finally {
            // 6. Đóng trình duyệt
            driver.quit();
        }
    }
}
