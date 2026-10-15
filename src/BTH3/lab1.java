package BTH3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class lab1 {

	 public static void main(String[] args) throws InterruptedException {

		 	//1. Khởi tạo trình duyệt Chrome, thiết lập các thuộc tính,…
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        // 2. Navigate đến https://opensource-demo.orangehrmlive.com/
	        driver.navigate().to(
	            "https://opensource-demo.orangehrmlive.com/"
	        );

	        Thread.sleep(2000);

	        // 3. Lấy một số element thông qua: id, name, classname, Xpath,…

	        // Locator bằng name
	        WebElement username = driver.findElement(
	            By.name("username")
	        );

	        // Locator bằng name
	        WebElement password = driver.findElement(
	            By.name("password")
	        );

	        // Locator bằng XPath
	        WebElement loginButton = driver.findElement(
	            By.xpath("//button[@type='submit']")
	        );

	        // Locator bằng className
	        WebElement loginForm = driver.findElement(
	            By.className("orangehrm-login-form")
	        );

	        // 4. Thực hiện các thao tác tương ứng các element: click, clear, sendKeys, getText,…

	        // clear(): Xóa dữ liệu trong ô nhập
	        username.clear();
	        password.clear();

	        // sendKeys(): Nhập dữ liệu
	        username.sendKeys("Admin");
	        password.sendKeys("admin123");

	        // getText(): Lấy nội dung văn bản trong element
	        System.out.println(
	            "Login form: " + loginForm.getText()
	        );

	        // click(): Nhấn nút login
	        loginButton.click();

	        Thread.sleep(2000);

	        // Lấy tiêu đề
	        System.out.println(
	            "Title of the page is: " + driver.getTitle()
	        );
    }
}