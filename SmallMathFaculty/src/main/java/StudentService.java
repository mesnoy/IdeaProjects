import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StudentService {
    public static String[] splitByStudents(Reader in) throws IOException {
        List<String> list = new ArrayList<>();
        try (BufferedReader stream = new BufferedReader(in)){
            list = stream.lines().toList();
        } catch (IOException e) {
            throw new IOException();
        } finally {
            if (in != null) {
                in.close();
            }
        }
        return (String[]) list.toArray(String[]::new);
    }

    public static Student stringToStudent(String str) {
        String[] fields = str.split(";");
        return new Student(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6], fields[7], fields[8],
                Integer.parseInt(fields[9]), fields[10], fields[11], fields[12], fields[13], fields[14], fields[15],
                fields[16], fields[17], fields[18], fields[19], fields[20]);
    }

    public static List<Student> createStudents(Reader in) throws IOException {
        List<Student> result = new ArrayList<>();
        String[] strings = splitByStudents(in);
        for (String string  :  strings) {
            result.add(stringToStudent(string));
        }
        return result;
    }

    //надо написать методы выборки по ДР и школе

    public static List<Student> studentsByGrade(List<Student> list, int grade) {
        List<Student> result = new ArrayList<>();
        for  (Student student : list) {
            if (student.getGrade() == grade) {
                result.add(student);
            }
        }
        return result;
    }

    public static List<Student> studentsByGroup(List<Student> list, String group) {
        List<Student> result = new ArrayList<>();
        for  (Student student : list) {
            if (Objects.equals(student.getGroup(), group)) {
                result.add(student);
            }
        }
        return result;
    }
}

