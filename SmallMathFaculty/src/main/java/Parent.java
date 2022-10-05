import java.time.LocalDate;

public class Parent extends Human {
    public Parent(String surname, String name, String patronymic, LocalDate birthday, String address, String email, String phoneNumber) {
        super(surname, name, patronymic, birthday, address, email, phoneNumber);
    }

    @Override
    public String toString() {
        return "Родитель{" + super.toString() + '}';
    }
}
