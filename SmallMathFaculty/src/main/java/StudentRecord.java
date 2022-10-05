import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class StudentRecord {
    private Student student;
    private Parent parent;

    private LocalDateTime timestamp;
    private String note;
    private Boolean willTheStudentWork;
    private Boolean consentToProcessing;

    public StudentRecord(Student student, Parent parent, LocalDateTime timestamp, String note,
                         Boolean willTheStudentWork, Boolean consentToProcessing) {
        this.student = student;
        this.parent = parent;
        this.timestamp = timestamp;
        this.note = note;
        this.willTheStudentWork = willTheStudentWork;
        this.consentToProcessing = consentToProcessing;
    }

    public StudentRecord(String surname, String name, String patronymic, LocalDate birthday, String address, String email,
                         String phoneNumber, String school, int grade, String pSurname, String pName, String pPatronymic,
                         LocalDate pBirthday, String pAddress, String pEmail, String pPhoneNumber, LocalDateTime timestamp,
                         String note, String group, Boolean willTheStudentWork, Boolean consentToProcessing) {
        this.student = new Student(surname, name, patronymic, birthday, address, email, phoneNumber, school, grade, group);
        this.parent = new Parent(pSurname, pName, pPatronymic, pBirthday, pAddress, pEmail, pPhoneNumber);
        this.timestamp = timestamp;
        this.note = note;
        this.willTheStudentWork = willTheStudentWork;
        this.consentToProcessing = consentToProcessing;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getWillTheStudentWork() {
        return willTheStudentWork;
    }

    public void setWillTheStudentWork(Boolean willTheStudentWork) {
        this.willTheStudentWork = willTheStudentWork;
    }

    public Boolean getConsentToProcessing() {
        return consentToProcessing;
    }

    public void setConsentToProcessing(Boolean consentToProcessing) {
        this.consentToProcessing = consentToProcessing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentRecord that = (StudentRecord) o;
        return Objects.equals(student, that.student) && Objects.equals(parent, that.parent) && Objects.equals(timestamp, that.timestamp) && Objects.equals(note, that.note) && Objects.equals(willTheStudentWork, that.willTheStudentWork) && Objects.equals(consentToProcessing, that.consentToProcessing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, parent, timestamp, note, willTheStudentWork, consentToProcessing);
    }

    @Override
    public String toString() {
        return "StudentRecord{" +
                student + "\n" +
                parent + "\n" +
                "Отметка времени: " + timestamp +
                ", Примечание: '" + note + '\'' +
                ", Будет ли заниматься: " + willTheStudentWork +
                ", Согласие на обработку данных: " + consentToProcessing +
                '}';
    }
}
