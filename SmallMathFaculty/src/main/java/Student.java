import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class Student extends Human {

    private String school;
    private int grade;
    private String group;

    public Student(String surname, String name, String patronymic, LocalDate birthday, String address, String email, String phoneNumber,
                   String school, int grade, String group) {
        super(surname, name, patronymic, birthday, address, email, phoneNumber);
        this.school = schoolFilter(school);
        this.grade = grade;
        this.group = group;
    }


    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = schoolFilter(school);
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    // Метод принимает строку. Если в ней есть число, то возвращает его (номер школы), иначе возвращает начальную строку
    private String schoolFilter(String string) {
        if (string != null && string.length() != 0) {
            StringBuilder numberSchool = new StringBuilder("");
            for (char c : string.toCharArray()) {
                if (Character.isDigit(c)) {
                    numberSchool.append(c);
                }
            }
            if (numberSchool.length() != 0) {
                return numberSchool.toString();
            }
            return string;
        }
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return grade == student.grade && Objects.equals(school, student.school) && Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), school, grade, group);
    }

    @Override
    public String toString() {
        return "Студент{" + super.toString() +
                ", Школа: '" + school + '\'' +
                ", Класс: " + grade +
                ", Группа: '" + group + '\'' +
                '}';
    }

    /*@Override
    public String toString() {
        return "Ученик{" +
                "Отметка времени='" + timestamp + '\'' +
                ", Группа='" + group + '\'' +
                ", Примечание='" + note + '\'' +
                ", Фамилия ученика='" + sSurname + '\'' +
                ", Имя ученика='" + sName + '\'' +
                ", Отчество ученика='" + sPatronymic + '\'' +
                ", Дата рождения ученика='" + sBirthday + '\'' +
                ", Адрес ученика='" + sAddress + '\'' +
                ", Школа='" + school + '\'' +
                ", Класс=" + grade +
                ", Адрес почты ученика='" + sEmail + '\'' +
                ", Номер телефона ученика=" + sPhoneNumber +
                ", Фамилия родителя='" + pSurname + '\'' +
                ", Имя родителя='" + pName + '\'' +
                ", Отчество родителя='" + pPatronymic + '\'' +
                ", День рождения родителя='" + pBirthday + '\'' +
                ", Адрес родителя='" + pAddress + '\'' +
                ", Адрес почты родителя='" + pEmail + '\'' +
                ", Номер телефона родителя=" + pPhoneNumber +
                ", Будет ли заниматься в этом году в группах по математике=" + willTheStudentWork +
                ", Согласие на обработку персональных данных=" + consentToProcessing +
                '}';
    }*/


}
