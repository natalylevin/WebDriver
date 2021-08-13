import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
        scanner = new Scanner(System.in);
        System.out.println("please write yu userName");
        String userName = scanner.next();
        System.out.println("please write yu password");
        String password = scanner.next();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.aac.ac.il/");
        driver.manage().window().maximize();
        WebElement a = driver.findElement(By.cssSelector("a[href='https://portal.aac.ac.il']"));
        a.click();
        WebElement user = driver.findElement(By.cssSelector("input[name='Ecom_User_ID']"));
        user.sendKeys(userName);
        WebElement pass = driver.findElement(By.cssSelector("input[name='Ecom_Password']"));
        pass.sendKeys(password);
        WebElement submit = driver.findElement(By.cssSelector("input[name='wp-submit']"));
        submit.click();
        WebElement url = driver.findElement(By.cssSelector("a[href='https://moodle.aac.ac.il/login/index.php']"));
        url.click();
        WebDriverWait driverWait = new WebDriverWait(driver, 10);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class = 'aalink coursename']")));
        List<WebElement> coursesNames = driver.findElements(By.cssSelector("a[class = 'aalink coursename']"));
        for (int i = 0; i < coursesNames.size(); i++) {
            System.out.println(i + 1 + ") " + trimWords(coursesNames.get(i)));
        }
        System.out.println("which course do you want?");
        int choose = scanner.nextInt();
        WebElement course = coursesNames.get(choose - 1);
        course.click();
        WebElement menu = driver.findElement(By.cssSelector("a[class='d-inline-block  dropdown-toggle icon-no-margin']"));
        menu.click();
        WebElement logOut = driver.findElement(By.cssSelector("a[data-title='logout,moodle']"));
        logOut.click();
        Thread.sleep(3000);
        WebElement moodleLogOUt = driver.findElement(By.cssSelector("a[href=\"https://portal.aac.ac.il/AGLogout\"]"));
        moodleLogOUt.click();
    }

    private static String trimWords(WebElement coursesName) {
        String words = coursesName.getText().trim();
        words = words.replace("שם הקורס", "").trim();
        return (words);
    }
}
