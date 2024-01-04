import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CalculatorTests {

    private AndroidDriver driver;

    @BeforeEach
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("appium:deviceName", "Redmi Note 11S");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.miui.calculator");
        capabilities.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        try {
            driver = new AndroidDriver(new URL("http://192.168.1.62:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void calculateAddTest() {

        driver.findElement(By.id("com.miui.calculator:id/btn_5_s")).click();
        driver.findElement(By.id("com.miui.calculator:id/btn_plus_s")).click();
        driver.findElement(By.id("com.miui.calculator:id/btn_3_s")).click();
        driver.findElement(By.id("com.miui.calculator:id/btn_equal_s")).click();
        Assertions.assertEquals(driver.findElement(By.id("com.miui.calculator:id/result")).getText(), "= 8");

    }

    @Test
    public void calculateDeductTest() {

        driver.findElement(By.id("com.miui.calculator:id/btn_5_s")).click();
        driver.findElement(By.id("com.miui.calculator:id/btn_minus_s")).click();
        driver.findElement(By.id("com.miui.calculator:id/btn_3_s")).click();
        driver.findElement(By.id("com.miui.calculator:id/btn_equal_s")).click();
        Assertions.assertEquals(driver.findElement(By.id("com.miui.calculator:id/result")).getText(), "= 2");

    }

    @Test
    public void calculateMultiplayTest() {

        driver.findElement(By.id("com.miui.calculator:id/btn_5_s")).click();
        driver.findElement(By.id("com.miui.calculator:id/btn_mul_s")).click();
        driver.findElement(By.id("com.miui.calculator:id/btn_3_s")).click();
        driver.findElement(By.id("com.miui.calculator:id/btn_equal_s")).click();
        Assertions.assertEquals(driver.findElement(By.id("com.miui.calculator:id/result")).getText(), "= 15");

    }

    @Test
    public void calculateDivideTest() {

        driver.findElement(By.id("com.miui.calculator:id/btn_9_s")).click();
        driver.findElement(By.id("com.miui.calculator:id/btn_div_s")).click();
        driver.findElement(By.id("com.miui.calculator:id/btn_3_s")).click();
        driver.findElement(By.id("com.miui.calculator:id/btn_equal_s")).click();
        Assertions.assertEquals(driver.findElement(By.id("com.miui.calculator:id/result")).getText(), "= 3");

    }

    @AfterEach
    public void tearDown() {
        driver.findElement(By.id("com.miui.calculator:id/btn_c_s")).click();
        driver.findElement(By.id("com.miui.calculator:id/btn_c_s")).click();
        driver.quit();
    }
}


