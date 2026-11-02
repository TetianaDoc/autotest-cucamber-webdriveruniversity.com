package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

public class DriverFactory {
    private DriverFactory() {
    }

    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static final Path CONFIG_PATH = Path.of(
            System.getProperty("user.dir"), "src", "main", "java", "properties", "config.properties"
    );

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            try {
                webDriver.set(createDriver());
            } catch (IOException e) {
                throw new WebDriverInitException(e);
            }
        }
        return webDriver.get();
    }

    private static WebDriver createDriver() throws IOException {
        Properties properties = loadProperties();
        String browserType = getBrowserType(properties);
        boolean headless = isHeadless(properties);

        WebDriver driver = switch (browserType) {
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                if (headless) {
                    firefoxOptions.addArguments("-headless", "-width=1920", "-height=1080");
                }
                yield new FirefoxDriver(firefoxOptions);
            }
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                if (headless) {
                    chromeOptions.addArguments(
                            "--headless=new",
                            "--no-sandbox",
                            "--disable-dev-shm-usage",
                            "--window-size=1920,1080"
                    );
                }
                yield new ChromeDriver(chromeOptions);
            }
            default -> throw new IllegalStateException("Unexpected browser type: " + browserType);
        };
        driver.manage().window().maximize();
        return driver;
    }

    private static Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        try (FileInputStream file = new FileInputStream(CONFIG_PATH.toFile())) {
            properties.load(file);
        }
        return properties;
    }

    private static String getBrowserType(Properties properties) {
        String browserTypeRemoteValue = System.getProperty("browserType");
        if (browserTypeRemoteValue == null || browserTypeRemoteValue.isBlank()) {
            return properties.getProperty("browser", "chrome").toLowerCase().trim();
        }
        return browserTypeRemoteValue.toLowerCase().trim();
    }

    private static boolean isHeadless(Properties properties) {
        String headlessRemoteValue = System.getProperty("headless");
        if (headlessRemoteValue == null || headlessRemoteValue.isBlank()) {
            return Boolean.parseBoolean(properties.getProperty("headless", "false").trim());
        }
        return Boolean.parseBoolean(headlessRemoteValue.trim());
    }

    public static void cleanupDriver() {
        WebDriver driver = webDriver.get();
        if (driver != null) {
            driver.quit();
            webDriver.remove();
        }
    }
}
