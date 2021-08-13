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
        System.out.println("please write you userName");
        String userName = scanner.next();
        System.out.println("please write you password");
        String password = scanner.next();
        WebDriver driver = new ChromeDriver();
        driver.get(Data.SITE_URL);
        driver.manage().window().maximize();
        WebElement portal = driver.findElement(By.cssSelector(Data.PORTAL_URL));
        portal.click();
        WebElement user = driver.findElement(By.cssSelector(Data.USER_ID));
        user.sendKeys(userName);
        WebElement pass = driver.findElement(By.cssSelector(Data.PASSWORD));
        pass.sendKeys(password);
        WebElement submit = driver.findElement(By.cssSelector(Data.SUBMIT));
        submit.click();
        WebElement url = driver.findElement(By.cssSelector(Data.LOGIN));
        url.click();
        WebDriverWait driverWait = new WebDriverWait(driver, 10);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Data.COURSE_NAME)));
        List<WebElement> coursesNames = driver.findElements(By.cssSelector(Data.COURSE_NAME));
        for (int i = 0; i < coursesNames.size(); i++) {
            System.out.println(i + 1 + ") " + trimWords(coursesNames.get(i)));
        }
        System.out.println("which course do you want?");
        int choose = scanner.nextInt();
        WebElement course = coursesNames.get(choose - 1);
        course.click();
        WebElement menu = driver.findElement(By.cssSelector(Data.MENU));
        menu.click();
        WebElement logOut = driver.findElement(By.cssSelector(Data.LOGOUT));
        logOut.click();
        Thread.sleep(3000);
        WebElement moodleLogOUt = driver.findElement(By.cssSelector(Data.FINAL_LOGOUT));
        moodleLogOUt.click();
    }

    private static String trimWords(WebElement coursesName) {
        String words = coursesName.getText().trim();
        words = words.replace("שם הקורס", "").trim();
        return (words);
    }
}
