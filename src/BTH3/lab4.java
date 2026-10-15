package BTH3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class lab4 {
	 WebDriver driver;

	    // Khởi tạo trình duyệt trước khi test
	    @BeforeMethod
	    public void openBrowser() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.navigate().to(
	            "https://opensource-demo.orangehrmlive.com/"
	        );
	    }

	    // Kiểm thử tiêu đề website
	    @Test
	    public void testWebsiteTitle() {
	        String actualTitle = driver.getTitle();

	        System.out.println("Tieu de website: " + actualTitle);

	        String expectedTitle = "OrangeHRM";

	        Assert.assertEquals(
	            actualTitle,
	            expectedTitle,
	            "Tieu de website khong dung!"
	        );
	    }

	    // Đóng trình duyệt sau khi test
	    @AfterMethod
	    public void closeBrowser() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
