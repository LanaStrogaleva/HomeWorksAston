import org.openqa.selenium.WebDriver;

public class AboutServiceInfoPage {
    private final WebDriver webDriver;

    public AboutServiceInfoPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getAboutServiceInfoPage() {
        return webDriver.getCurrentUrl();
    }
}
