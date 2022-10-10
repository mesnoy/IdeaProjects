import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class StudentRecordService {
    // Метод получает на вход строку - путь к xlsx файлу с таблицей по студентам(типа: программисты) и возвращает список записей
    public static List<StudentRecord> createStudentRecordList(String filePath, String sheetName) {
        List<StudentRecord> result = new ArrayList<>();
        FileInputStream fileInputStream = null;
        XSSFSheet sheet;
        try {
            fileInputStream = new FileInputStream(filePath);
            XSSFWorkbook sheets = new XSSFWorkbook(fileInputStream);
            sheet = sheets.getSheet(sheetName);
            // Проверка файла - математик или программист
            String str = filePath.substring(21);
            if (str.matches("\\d{1,2}_klass\\S*")) {
                String[] strings = str.split("_");
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    result.add(rowToStudentRecord(sheet.getRow(i), Integer.parseInt(strings[0]), strings[3].concat(" " + strings[4]).concat(":" + strings[5])));
                }
            }

            for (int i = 1; i < sheet.getLastRowNum(); i++) {
                result.add(rowToStudentRecord(sheet.getRow(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // Метод получает на вход строку xlsx файла и возвращает объект StudentRecord по ней
    // Для Математиков
    public static StudentRecord rowToStudentRecord(XSSFRow row) {
        return new StudentRecord(
                new Student(getStr(row, 4), getStr(row, 5), getStr(row, 6), row.getCell(7).getLocalDateTimeCellValue().toLocalDate(),
                        getStr(row, 8), getStr(row, 11), getStr(row, 12), getStr(row, 9),
                        Integer.parseInt(getStr(row, 10).replace(".0", "")), getStr(row, 2)),
                new Parent(getStr(row, 13), getStr(row, 14), getStr(row, 15), row.getCell(16).getLocalDateTimeCellValue().toLocalDate(),
                        getStr(row, 17), getStr(row, 18), getStr(row, 19)), row.getCell(0).getLocalDateTimeCellValue(), getStr(row, 3),
                studentWorkToBoolean(getStr(row, 20)), consentToBoolean(getStr(row, 21)));
    }
    // Для Информатиков
    public static StudentRecord rowToStudentRecord(XSSFRow row, int grade, String group) {
        return new StudentRecord(
                new Student(getStr(row, 1), getStr(row, 2), getStr(row, 3), row.getCell(4).getLocalDateTimeCellValue().toLocalDate(),
                        getStr(row, 5), getStr(row, 7), getStr(row, 8), getStr(row, 6),
                        grade, group),
                new Parent(getStr(row, 9), getStr(row, 10), getStr(row, 11), row.getCell(12).getLocalDateTimeCellValue().toLocalDate(),
                        getStr(row, 13), getStr(row, 14), getStr(row, 15)), row.getCell(0).getLocalDateTimeCellValue(), getStr(row, 18),
                studentWorkToBoolean(getStr(row, 16)), consentToBoolean(getStr(row, 17)));
    }

    // Метод получает на вход строку xlsx файла и индекс столбца. Возвращает ячейку по индексу в формате String
    // Пофиксить. Дополнительный ноль в эксель таблицах после числового значения для этого метода(например: 46 -> 460)
    private static String getStr(XSSFRow row, int col) {
        if (row.getCell(col) != null) {
            return row.getCell(col).toString();
        }
        return "";
    }

    // Вспомогательные методы перевода String в boolean
    private static boolean studentWorkToBoolean(String string) {
        return string.equals("Да");
    }

    private static boolean consentToBoolean(String string) {
        return string.equals("Согласен");
    }

    // Методы фильтров студентов по группе, году рождения, школе и классу
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




    /*
    // Метод делит поток ввода на строки и возвращает их в виде массива
    public static String[] splitByLines(Reader in) throws IOException {
        List<String> list;
        try (BufferedReader stream = new BufferedReader(in)){
            list = stream.lines().toList();
        } catch (IOException e) {
            throw new IOException();
        } finally {
            if (in != null) {
                stream.close();
            }
        }
        return list.toArray(String[]::new);
    }

    // Метод делит строку по разделителю, обрабатывает получившиеся поля, создает запись по ним и возвращает ее
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

    // Метод создает список записей из потока ввода с помощью предыдущих методов
    public static List<StudentRecord> createStudentRecords(Reader in) throws IOException {
        List<StudentRecord> result = new ArrayList<>();
        for (String string : splitByLines(in)) {
            result.add(stringToStudentRecord(string));
        }
        return result;
    }

    // Вспомогательные методы перевода String в нужный тип, методы перевода в тип LocalDate зависят от формата даты потока ввода
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
    }*/

}

