package addressbook.model;

public class ContactData {
  private final String firstName;
  private final String secondName;
  private final String nickName;
  private final String group;
  private final String address;
  private final String email;

  public ContactData(String firstName, String secondName, String nickName, String address, String email, String group) {
    this.firstName = firstName;
    this.secondName = secondName;
    this.nickName = nickName;
    this.address = address;
    this.email = email;
    this.group = group;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getSecondName() {
    return secondName;
  }

  public String getNickName() {
    return nickName;
  }

  public String getAddress() {
    return address;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }
}
