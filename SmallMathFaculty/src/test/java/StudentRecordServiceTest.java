import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StudentRecordServiceTest {
    @Test
    public void splitByStudentsTest() throws IOException {
        Reader reader = new FileReader("Novichki_inf.txt");
        String[] strings = StudentRecordService.splitByLines(reader);
        System.out.println(StudentRecordService.stringToStudentRecord(strings[5]));
        assertEquals("9.17.2021 11:06:08;воскресенье, 10:00;web-программирование, Санчак ЮС;Гиль ;Марина;Евгеньевна;" +
                "19.08.2008;644001, г. Омск, Лермонтова, 128, кв. 5;\"АНОО \"\"Школа \"\"Видергебурт\"\"\";7;;;Кунавина;" +
                "Альбина;Викторовна;08.09.1978;644001, г. Омск, Лермонтова, 128, кв. 5;al0809@yandex.ru;89658758675;Нет;Согласен",
                strings[0]);
        assertEquals("9.17.2021 12:43:34;воскресенье, 10:00;web-программирование, Санчак ЮС;Золкина;Ирина;Михайловна;" +
                "16.01.2008;160024 Омск , ул. Ленина 50-10;Гимназия 115;7;ira16.01.08@mail.ru;89131422150;Поддубная;Наталия;" +
                "Викторовна ;11.10.1977;160024 Омск , ул. Ленина 50-10;nnn11.10.77@mail.ru;89136409965;Да;Согласен", strings[5]);
    }

    @Test
    public void stringToStudentTest() {
        StudentRecord actual = StudentRecordService.stringToStudentRecord("5.5.2005 13:59:59; группа А ; web; а ;б;в;20.02.2002;" +
                "адрес;  ШКОЛА №96 ;7; почта ; номер ; аа ; бб;вв;18.09.1978; адрес ;почта;номер;Да;Согласен");
        StudentRecord expected = new StudentRecord("а", "б", "в", LocalDate.of(2002, 2, 20),
                "адрес", "почта", "номер", "96", 7,
                "аа", "бб", "вв", LocalDate.of(1978, 9, 18), "адрес",
                "почта", "номер",
                LocalDateTime.of(2005, 5, 5, 13, 59, 59), "web","группа А",
                true, true);
        assertEquals(expected, actual);
    }

    @Test
    public void studentsByGroupTest() throws IOException {
        Reader reader = new FileReader("Novichki_inf.txt");
        List<StudentRecord> studentRecords = StudentRecordService.createStudentRecords(reader);
        List<StudentRecord> actual = StudentRecordService.studentsByGroup(studentRecords,
                "воскресенье, 10:00");
        List<StudentRecord> expected = new ArrayList<>();
        expected.add(studentRecords.get(0));
        expected.add(studentRecords.get(1));
        expected.add(studentRecords.get(5));
        expected.add(studentRecords.get(10));
        expected.add(studentRecords.get(16));
        expected.add(studentRecords.get(18));
        expected.add(studentRecords.get(20));
        expected.add(studentRecords.get(25));
        expected.add(studentRecords.get(26));
        for (StudentRecord studentRecord : actual) {
            System.out.println(studentRecord.getStudent().toString());
        }
        assertEquals(expected, actual);
    }

    @Test
    public void studentsByYearOfBirthTest() throws IOException {
        Reader reader = new FileReader("Novichki_inf.txt");
        List<StudentRecord> studentRecords = StudentRecordService.createStudentRecords(reader);
        List<StudentRecord> actual = StudentRecordService.studentsByYearOfBirth(studentRecords,
                2006);
        List<StudentRecord> expected = new ArrayList<>();
        expected.add(studentRecords.get(29));
        for (StudentRecord studentRecord : actual) {
            System.out.println(studentRecord.getStudent().toString());
        }
        assertEquals(expected, actual);
    }

    @Test
    public void studentsBySchoolTest() throws IOException {
        Reader reader = new FileReader("Novichki_inf.txt");
        List<StudentRecord> studentRecords = StudentRecordService.createStudentRecords(reader);
        List<StudentRecord> actual = StudentRecordService.studentsBySchool(studentRecords,
                "117");
        List<StudentRecord> expected = new ArrayList<>();
        expected.add(studentRecords.get(14));
        expected.add(studentRecords.get(22));
        expected.add(studentRecords.get(32));
        for (StudentRecord studentRecord : actual) {
            System.out.println(studentRecord.getStudent().toString());
        }
        assertEquals(expected, actual);
    }

    @Test
    public void studentsByGradeTest() throws IOException {
        Reader reader = new FileReader("Novichki_inf.txt");
        List<StudentRecord> studentRecords = StudentRecordService.createStudentRecords(reader);
        List<StudentRecord> actual = StudentRecordService.studentsByGrade(studentRecords,
                6);
        List<StudentRecord> expected = new ArrayList<>();
        expected.add(studentRecords.get(37));
        for (StudentRecord studentRecord : actual) {
            System.out.println(studentRecord.getStudent().toString());
        }
        assertEquals(expected, actual);
    }



}
