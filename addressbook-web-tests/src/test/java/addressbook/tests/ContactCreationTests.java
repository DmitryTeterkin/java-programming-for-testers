package addressbook.tests;


import addressbook.model.ContactData;
import addressbook.model.Contacts;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {
    Contacts before = app.contact().all();
    app.goTo().editorPage(); // переход на страницу редактирования контакта
    ContactData contact = new ContactData().withFirstName("petro")
            .withSecondName("petrov").withNickName("NiKnAmE")
            .withAddress("testovii address").withEmail("test@test.com").withGroup("[none]");
    app.contact().create(contact, true);
    app.goTo().homePage();         // возврат на список контактов
    Contacts after = app.contact().all();

    assertThat(after.size(), equalTo(before.size() + 1)); // сравниваем количество контактов до и после
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));// сравнивание списков, преобразованных в неотсортированные множества

  }

}
