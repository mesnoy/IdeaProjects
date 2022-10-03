import java.util.Objects;

public class Student extends Human{
    private String university;
    private int course;


    public Student(String fullName, int age, String university, int course) {
        super(fullName, age);
        this.university = university;
        this.course = course;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return course == student.course && Objects.equals(university, student.university);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), university, course);
    }
}
