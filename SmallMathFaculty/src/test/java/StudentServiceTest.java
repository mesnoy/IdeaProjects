import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class StudentServiceTest {
    @Test
    public void splitByStudentsTest() throws IOException {
        Reader reader = new FileReader("Novichki_inf.txt");
        String[] strings = StudentService.splitByStudents(reader);
        //System.out.println("ASDasdSAD");
        System.out.println(StudentService.stringToStudent(strings[1]));
        assertTrue(true);
    }

}
