import java.util.Objects;

public class Human {
    String lastname;
    String firstname;
    String middlename;
    int age;
    Sex sex;

    public Human(String lastname, String firstname, String middlename, int age, Sex sex) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.middlename = middlename;
        this.age = age;
        this.sex = sex;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human human)) return false;
        return age == human.age && Objects.equals(lastname, human.lastname) &&
                Objects.equals(firstname, human.firstname) && Objects.equals(middlename, human.middlename) &&
                sex == human.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastname, firstname, middlename, age, sex);
    }
}
