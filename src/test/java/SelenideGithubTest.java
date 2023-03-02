import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideGithubTest {
    @BeforeAll
    static void beforeAll() {

        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";

    }

    @Test
    void wikiSelenideGithubTest() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $(byXpath("//button[contains(@class,'f6 Link')]")).click();
        $("#wiki-pages-box").shouldBe(text("SoftAssertions"));
        $(byXpath("//a[@href='/selenide/selenide/wiki/SoftAssertions'][@data-view-component='true']")).click();
        $(byXpath("//div[@class='markdown-body']//h4[3]")).shouldHave(text("Using JUnit5 extend test class:"));
        $(byXpath("//div[@class='markdown-body']//h4[3]/following-sibling::div/pre")).shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();"));

    }
}
