package mk.finki.ukim.mk.lab1.selenium;

import mk.finki.ukim.mk.lab1.model.Manufacture;
import mk.finki.ukim.mk.lab1.model.ShoppingCard;
import mk.finki.ukim.mk.lab1.model.User;
import mk.finki.ukim.mk.lab1.model.UserFullname;
import mk.finki.ukim.mk.lab1.repository.ShoppingCardRepository;
import mk.finki.ukim.mk.lab1.service.interfaces.BalloonService;
import mk.finki.ukim.mk.lab1.service.interfaces.ManufacturerService;
import mk.finki.ukim.mk.lab1.service.interfaces.ShoppingCardService;
import mk.finki.ukim.mk.lab1.service.interfaces.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.ArrayList;


@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SeleniumScenarioTest {
    private static final String user = "user";
    private static final String admin = "admin";
    private static Manufacture m1;
    private static User adminUser;
    private static User regularUser;
    private static boolean dataInitialized = false;
    @Autowired
    UserService userService;
    @Autowired
    BalloonService balloonService;
    @Autowired
    ManufacturerService manufacturerService;
    @Autowired
    ShoppingCardRepository shoppingCartRepository;
    @Autowired
    ShoppingCardService shoppingCartService;

    private WebDriver driver;

    @BeforeEach
    private void setup() {
        this.driver = new HtmlUnitDriver(false);
//        System.setProperty("webdriver.chrome.driver", "D:\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
//        driver = new ChromeDriver();
        initData();
    }
    @AfterEach
    public void destroy() {
            if (this.driver != null) {
                this.driver.close();
            }

            if (!balloonService.listAll().isEmpty()) {
                if (!shoppingCartRepository.findAll().isEmpty()) {
                    ShoppingCard shoppingCart = shoppingCartService.getAllShoppingCardFromWithUserId(regularUser.getId()).get(0);
                    shoppingCartRepository.delete(shoppingCart);
                }

                balloonService.deleteById(balloonService.listAll().get(0).getId());
            }
        }

        private void initData() {
            if (!dataInitialized) {
                m1 = manufacturerService.save("Name1", "Country1", "Address1");

                regularUser = userService.register(new User(user, user, new UserFullname(user,user), user, LocalDateTime.now(),null));
                adminUser = userService.register(new User(admin, admin, new UserFullname(admin,admin), admin, LocalDateTime.now(),null));

                dataInitialized = true;
            }
        }
        @Test
        public void testScenarioBalloonsPageNoUser() {
        BalloonsPage balloonsPage = BalloonsPage.to(this.driver);
        balloonsPage.assertElements(0, 0, 0, 0);
    }
    @Test
    public void testScenarioBalloonsPageAdminUser() {
        LoginPage loginPage = LoginPage.openLoginPage(this.driver);

        BalloonsPage balloonsPage = LoginPage.login(this.driver, loginPage, adminUser.getUsername(), admin);
        balloonsPage.assertElements(0, 0, 0, 0);

        balloonsPage = AddBalloonPage.addBalloon(this.driver, "test", "test");
        balloonsPage.assertElements(1, 1, 1, 1);
    }

}
