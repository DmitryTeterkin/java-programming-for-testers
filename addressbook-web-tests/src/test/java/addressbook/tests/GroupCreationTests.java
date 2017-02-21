package addressbook.tests;

import addressbook.model.GroupData;
import addressbook.model.Groups;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException { // итератор массивов объектов
    ArrayList<Object[]> list = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")));
    String xml ="";
    String line = reader.readLine();
    while (line != null){
       xml += line;

      line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(GroupData.class);
    List<GroupData> groups = (List<GroupData>) xstream.fromXML(xml);
    groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    return list.iterator(); // вроде тут падает
  }

  // создание группы
  @Test (dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) { // положительный тест, группа должна создаться.
    app.goTo().groupPage(); // преход на страницу групп
    Groups before = app.group().all(); // построение списка групп до добавления новой группы
    app.group().create(group);

    assertThat(app.group().count(), equalTo(before.size() + 1)); // сравнение количества групп до и после добавления новой группы
    Groups after = app.group().all(); // построение списка групп после добавления новой группы
    assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt())))); // сравнение списков групп
  }

  @Test (enabled = false)
  public void testBadGroupCreation() {       // отрицательный тест, группа с одинарным апострофом в названии не должна создаться.
    app.goTo().groupPage(); // преход на страницу групп
    Groups before = app.group().all(); // построение списка групп до добавления новой группы
    GroupData group = new GroupData().withName("test1 576 ' ").withFooter("test4").withHeader("test5"); // перенос атрибутов новой группы в переменную
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size())); // сравнение количества групп до и после добавления новой группы
    Groups after = app.group().all(); // построение списка групп после добавления новой группы
    assertThat(after, equalTo(before));
  }
}
