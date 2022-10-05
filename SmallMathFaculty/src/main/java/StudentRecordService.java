import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class StudentRecordService {

    // ����� ����� ����� ����� �� ������ � ���������� �� � ���� �������
    public static String[] splitByLines(Reader in) throws IOException {
        List<String> list;
        try (BufferedReader stream = new BufferedReader(in)){
            list = stream.lines().toList();
        } catch (IOException e) {
            throw new IOException();
        } finally {
            if (in != null) {
                in.close();
            }
        }
        return list.toArray(String[]::new);
    }

    // ����� ����� ������ �� �����������, ������������ ������������ ����, ������� ������ �� ��� � ���������� ��
    public static StudentRecord stringToStudentRecord(String str) {
        String[] fields = str.split(";");
        for (int i = 0; i < fields.length; i++) {
            String temp;
            temp = fields[i].trim();
            fields[i] = temp;
        }
        return new StudentRecord(fields[3], fields[4], fields[5], stringToLocalDate(fields[6]), fields[7], fields[10], fields[11],
                fields[8], Integer.parseInt(fields[9]), fields[12], fields[13], fields[14], stringToLocalDate(fields[15]), fields[16],
                fields[17], fields[18], stringToLocalDateTime(fields[0]), fields[2], fields[1],
                studentWorkToBoolean(fields[19]), consentToBoolean(fields[20]));
    }

    // ����� ������� ������ ������� �� ������ ����� � ������� ���������� �������
    public static List<StudentRecord> createStudentRecords(Reader in) throws IOException {
        List<StudentRecord> result = new ArrayList<>();
        for (String string : splitByLines(in)) {
            result.add(stringToStudentRecord(string));
        }
        return result;
    }

    // ��������������� ������ �������� String � ������ ���, ������ �������� � ��� LocalDate ������� �� ������� ���� ������ �����
    private static LocalDate stringToLocalDate(String string) {
        String[] temp = string.split("\\.");
        return LocalDate.of(Integer.parseInt(temp[2]), Integer.parseInt(temp[1]), Integer.parseInt(temp[0]));
    }

    private static LocalDateTime stringToLocalDateTime(String string) {
        String[] temp = string.split(" ");
        String[] date = temp[0].split("\\.");
        String[] time = temp[1].split(":");
        return LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[0]), Integer.parseInt(date[1])).
                atTime(Integer.parseInt(time[0]), Integer.parseInt(time[1]), Integer.parseInt(time[2]));
    }

    private static boolean studentWorkToBoolean(String string) {
        return string.equals("��");
    }

    private static boolean consentToBoolean(String string) {
        return string.equals("��������");
    }

    // ������ �������� ��������� �� ������, ���� ��������, ����� � ������
    public static List<StudentRecord> studentsByGroup(List<StudentRecord> list, String group) {
        List<StudentRecord> result = new ArrayList<>();
        for  (StudentRecord studentRecord : list) {
            if (studentRecord.getStudent().getGroup().equals(group)) {
                result.add(studentRecord);
            }
        }
        return result;
    }

    public static List<StudentRecord> studentsByYearOfBirth(List<StudentRecord> list, int year) {
        List<StudentRecord> result = new ArrayList<>();
        for  (StudentRecord studentRecord : list) {
            if (studentRecord.getStudent().getBirthday().getYear() == year) {
                result.add(studentRecord);
            }
        }
        return result;
    }

    public static List<StudentRecord> studentsBySchool(List<StudentRecord> list, String school) {
        List<StudentRecord> result = new ArrayList<>();
        for  (StudentRecord studentRecord : list) {
            if (studentRecord.getStudent().getSchool().equals(school)) {
                result.add(studentRecord);
            }
        }
        return result;
    }

    public static List<StudentRecord> studentsByGrade(List<StudentRecord> list, int grade) {
        List<StudentRecord> result = new ArrayList<>();
        for  (StudentRecord studentRecord : list) {
            if (studentRecord.getStudent().getGrade() == grade) {
                result.add(studentRecord);
            }
        }
        return result;
    }

}

