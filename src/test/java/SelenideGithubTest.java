import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideGithubTest {
    @BeforeAll
    static void beforeAll() {

        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";

    }

    @Test
    void wikiSelenideGithubTest(){
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $(".markdown-body").$$("ul li").get(7).shouldHave(text("Soft assertions"));
        $(".markdown-body a[href=\"/selenide/selenide/wiki/SoftAssertions\"]").click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
