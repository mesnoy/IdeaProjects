import java.time.LocalDate;
import java.util.Objects;

public class Human {
    private String Surname;
    private String Name;
    private String Patronymic;
    private LocalDate Birthday;
    private String Address;
    private String Email;
    private String PhoneNumber;

    public Human(String surname, String name, String patronymic, LocalDate birthday, String address, String email, String phoneNumber) {
        Surname = surname;
        Name = name;
        Patronymic = patronymic;
        Birthday = birthday;
        Address = address;
        Email = email;
        PhoneNumber = phoneNumber;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPatronymic() {
        return Patronymic;
    }

    public void setPatronymic(String patronymic) {
        Patronymic = patronymic;
    }

    public LocalDate getBirthday() {
        return Birthday;
    }

    public void setBirthday(LocalDate birthday) {
        Birthday = birthday;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(Surname, human.Surname) && Objects.equals(Name, human.Name) && Objects.equals(Patronymic, human.Patronymic) && Objects.equals(Birthday, human.Birthday) && Objects.equals(Address, human.Address) && Objects.equals(Email, human.Email) && Objects.equals(PhoneNumber, human.PhoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Surname, Name, Patronymic, Birthday, Address, Email, PhoneNumber);
    }

    @Override
    public String toString() {
        return "Фамилия: '" + Surname + '\'' +
                ", Имя: '" + Name + '\'' +
                ", Отчество: '" + Patronymic + '\'' +
                ", День рождения: " + Birthday +
                ", Адрес: '" + Address + '\'' +
                ", Почта: '" + Email + '\'' +
                ", Телефон: '" + PhoneNumber + '\'';
    }
}
