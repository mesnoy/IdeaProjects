import java.util.Arrays;
import java.util.Objects;

public class Student {
    private String timestamp;
    private String group;
    private String note;
    private String sSurname;
    private String sName;
    private String sPatronymic;
    private String sBirthday;
    private String sAddress;
    private String school;
    private int grade;
    private String sEmail;
    private String sPhoneNumber;
    private String pSurname;
    private String pName;
    private String pPatronymic;
    private String pBirthday;
    private String pAddress;
    private String pEmail;
    private String pPhoneNumber;
    private String willTheStudentWork;
    private String consentToProcessing;

    public Student() {}

    public Student(String timestamp, String group, String note, String sSurname, String sName, String sPatronymic, String sBirthday, String sAddress,
                   String school, int grade, String sEmail, String sPhoneNumber, String pSurname, String pName, String pPatronymic, String pBirthday,
                   String pAddress, String pEmail, String pPhoneNumber, String willTheStudentWork, String consentToProcessing) {
        this.timestamp = timestamp;
        this.group = group;
        this.note = note;
        this.sSurname = sSurname;
        this.sName = sName;
        this.sPatronymic = sPatronymic;
        this.sBirthday = sBirthday;
        this.sAddress = sAddress;
        this.school = school;
        this.grade = grade;
        this.sEmail = sEmail;
        this.sPhoneNumber = sPhoneNumber;
        this.pSurname = pSurname;
        this.pName = pName;
        this.pPatronymic = pPatronymic;
        this.pBirthday = pBirthday;
        this.pAddress = pAddress;
        this.pEmail = pEmail;
        this.pPhoneNumber = pPhoneNumber;
        this.willTheStudentWork = willTheStudentWork;
        this.consentToProcessing = consentToProcessing;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getGroup() {
        return group;
    }

    public String getNote() {
        return note;
    }

    public String getsSurname() {
        return sSurname;
    }

    public String getsName() {
        return sName;
    }

    public String getsPatronymic() {
        return sPatronymic;
    }

    public String getsBirthday() {
        return sBirthday;
    }

    public String getsAddress() {
        return sAddress;
    }

    public String getSchool() {
        return school;
    }

    public int getGrade() {
        return grade;
    }

    public String getsEmail() {
        return sEmail;
    }

    public String getsPhoneNumber() {
        return sPhoneNumber;
    }

    public String getpSurname() {
        return pSurname;
    }

    public String getpName() {
        return pName;
    }

    public String getpPatronymic() {
        return pPatronymic;
    }

    public String getpBirthday() {
        return pBirthday;
    }

    public String getpAddress() {
        return pAddress;
    }

    public String getpEmail() {
        return pEmail;
    }

    public String getpPhoneNumber() {
        return pPhoneNumber;
    }

    public String isWillTheStudentWork() {
        return willTheStudentWork;
    }

    public String isConsentToProcessing() {
        return consentToProcessing;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setsSurname(String sSurname) {
        this.sSurname = sSurname;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public void setsPatronymic(String sPatronymic) {
        this.sPatronymic = sPatronymic;
    }

    public void setsBirthday(String sBirthday) {
        this.sBirthday = sBirthday;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public void setsPhoneNumber(String sPhoneNumber) {
        this.sPhoneNumber = sPhoneNumber;
    }

    public void setpSurname(String pSurname) {
        this.pSurname = pSurname;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public void setpPatronymic(String pPatronymic) {
        this.pPatronymic = pPatronymic;
    }

    public void setpBirthday(String pBirthday) {
        this.pBirthday = pBirthday;
    }

    public void setpAddress(String pAddress) {
        this.pAddress = pAddress;
    }

    public void setpEmail(String pEmail) {
        this.pEmail = pEmail;
    }

    public void setpPhoneNumber(String pPhoneNumber) {
        this.pPhoneNumber = pPhoneNumber;
    }

    public void setWillTheStudentWork(String willTheStudentWork) {
        this.willTheStudentWork = willTheStudentWork;
    }

    public void setConsentToProcessing(String consentToProcessing) {
        this.consentToProcessing = consentToProcessing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return grade == student.grade && Objects.equals(timestamp, student.timestamp) && Objects.equals(group, student.group) && Objects.equals(note, student.note) && Objects.equals(sSurname, student.sSurname) && Objects.equals(sName, student.sName) && Objects.equals(sPatronymic, student.sPatronymic) && Objects.equals(sBirthday, student.sBirthday) && Objects.equals(sAddress, student.sAddress) && Objects.equals(school, student.school) && Objects.equals(sEmail, student.sEmail) && Objects.equals(sPhoneNumber, student.sPhoneNumber) && Objects.equals(pSurname, student.pSurname) && Objects.equals(pName, student.pName) && Objects.equals(pPatronymic, student.pPatronymic) && Objects.equals(pBirthday, student.pBirthday) && Objects.equals(pAddress, student.pAddress) && Objects.equals(pEmail, student.pEmail) && Objects.equals(pPhoneNumber, student.pPhoneNumber) && Objects.equals(willTheStudentWork, student.willTheStudentWork) && Objects.equals(consentToProcessing, student.consentToProcessing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, group, note, sSurname, sName, sPatronymic, sBirthday, sAddress, school, grade, sEmail, sPhoneNumber, pSurname, pName, pPatronymic, pBirthday, pAddress, pEmail, pPhoneNumber, willTheStudentWork, consentToProcessing);
    }

    @Override
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
                ", Будет ли заниматься в этом году в группах по математике\n=" + willTheStudentWork +
                ", Согласие на обработку персональных данных\n=" + consentToProcessing +
                '}';
    }
}
