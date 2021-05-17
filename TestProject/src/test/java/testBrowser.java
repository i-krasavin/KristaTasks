import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class testBrowser {
    @BeforeClass
    public static void setup() {
        Configuration.baseUrl = "http://google.com/";
    }

    @Test
    public void test() {
        open("/");
        $(By.name("q")).val("ивт яргу").pressEnter();
        $$("span").get(96).shouldHave(text("ИВТ"));
    }
}