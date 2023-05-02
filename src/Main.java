import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/ariel/Downloads/chromedriver_mac_arm64/chromedriver");

        WebDriver driver = new ChromeDriver();
        // Navigate to the website and log in
        driver.get("https://my.randstad.com.au/dsm/#/open-shifts");
        // ... Perform login actions here ...

        // Navigate to the page you want to reload
        driver.get("https://my.randstad.com.au/dsm/#/open-shifts");

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.of(now.toLocalDate(), LocalTime.of(20, 15));

        while (now.isBefore(end)) {
            driver.navigate().refresh();
            try {
                TimeUnit.SECONDS.sleep(300); // Wait for 60 seconds before next refresh
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            now = LocalDateTime.now();
        }

        driver.quit();
    }
}

