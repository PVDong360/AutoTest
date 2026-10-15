
package BTH2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserInit {
    public static void main(String[] args) throws InterruptedException {

        // Khởi tạo Chrome, Selenium Manager tự xử lý driver
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to(
            "https://demoqa.com/"
        );

        Thread.sleep(1000);

        System.out.println(
            "Title of the page is: " + driver.getTitle()
        );

    }
}
