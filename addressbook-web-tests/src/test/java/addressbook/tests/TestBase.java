package addressbook.tests;

import addressbook.appmanager.ApplicationManager;
import addressbook.model.ContactData;
import addressbook.model.Contacts;
import addressbook.model.GroupData;
import addressbook.model.Groups;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class TestBase {

  Logger logger = LoggerFactory.getLogger(TestBase.class);
  // указываем, из какого браузера будут запускаться тесты
  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();

  }

  @AfterSuite (alwaysRun = true)
  public void tearDown() {
    app.stop();
  }


  @BeforeMethod
  public void logTestStart(Method m, Object[] p) {
    logger.info("Start test "+ m.getName()+ " with parameters "+ Arrays.asList(p));
  }

  @AfterMethod (alwaysRun = true)
  public void logTestStop(Method m) {
    logger.info("Stop test " + m.getName());
  }

  public void VerifyGroupListInUI() {
    if (Boolean.getBoolean("verifyUI")) {
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      assertThat(uiGroups, equalTo(dbGroups.stream()
              .map((g) -> new GroupData().withId(g.getId()).withName(g.getName()))
              .collect(Collectors.toSet())));
    }
  }

  public void VerifyContactListInUI() {
    if (Boolean.getBoolean("verifyUI")) {
      Contacts dbContacts = app.db().contacts();

      Contacts uiContacts = app.contact().all();
      assertThat(uiContacts, equalTo(dbContacts.stream()
              .map((c) -> new ContactData().withId(c.getId()).withFirstName(c.getFirstName()).withSecondName(c.getSecondName()).withAddress(c.getAddress())
                      .withAllEmales(Arrays.asList(c.getEmail(), c.getEmail2(), c.getEmail3()).stream().filter((s) -> !s.equals("")).collect(Collectors.joining("\n")))
                      .withAllPhones(Arrays.asList(c.getHomePhone().replaceAll("\\s", "")
                              .replaceAll("[-()]", ""),
                              c.getMobilePhone().replaceAll("\\s", "").replaceAll("[-()]", ""),
                              c.getWorkPhone().replaceAll("\\s", "").replaceAll("[-()]", ""))
                              .stream().filter((s) -> !s.equals("")).collect(Collectors.joining("\n"))))
              .collect(Collectors.toSet())));
    }
  }
}
