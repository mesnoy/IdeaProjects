import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Optional;

public class LambdaJavaTest {
    @Test
    public void lengthStringTest() {
        Assert.assertEquals(Optional.of(5), Optional.of(LambdaRunner.biFunction(LambdaDemo.length, "12345")));
    }

    @Test
    public void firstCharTest() {
        Assert.assertEquals(Optional.of('c'), Optional.of(LambdaRunner.biFunction(LambdaDemo.firstChar, "const")));
        Assert.assertNull(LambdaRunner.biFunction(LambdaDemo.firstChar, ""));
        Assert.assertNull(LambdaRunner.biFunction(LambdaDemo.firstChar, null));
    }

    @Test
    public void isSpaceTest() {
        Assert.assertFalse(LambdaRunner.biFunction(LambdaDemo.isNotSpace, "a a"));
    }

    @Test
    public void countWordsTest() {
        Assert.assertEquals(Optional.of(3), Optional.of(LambdaRunner.biFunction(LambdaDemo.countWords, "a,a,c")));
        Assert.assertEquals(Optional.of(3), Optional.of(LambdaRunner.biFunction(LambdaDemo.countWords, "a,,,,a,,,,,c")));
    }

    @Test
    public void countWordsTest1() {
        //Assert.assertEquals(Optional.of(3), Optional.of(LambdaRunner.biFunction(LambdaDemo.countWords, "a,a,c")));
        Assert.assertEquals(Optional.of(3), Optional.of(LambdaRunner.biFunction(LambdaDemo.countWords, ",,a,,,,a,,,,,c")));
    }

    @Test
    public void countWordsTest2() {
        //Assert.assertEquals(Optional.of(3), Optional.of(LambdaRunner.biFunction(LambdaDemo.countWords, "a,a,c")));
        Assert.assertEquals(Optional.of(3), Optional.of(LambdaRunner.biFunction(LambdaDemo.countWords, "a,,,,a,,,,,c,")));
    }

    @Test
    public void getAgeTest() {
        Assert.assertEquals(Optional.of(5), Optional.of(
                LambdaRunner.biFunction(LambdaDemo.getAge, new Human("a", "a", "a", 5, Sex.MALE))));
    }

    @Test
    public void isEqualLastNameTest() {
        Assert.assertTrue(LambdaRunner.tripleFunction(LambdaDemo.isEqualLastName, new Human("a", "a", "a", 5, Sex.MALE),
                        new Human("a", "a", "a", 6, Sex.FEMALE)
                )
        );
    }

    @Test
    public void getFullNameTest() {
        Assert.assertEquals("a a a",
                LambdaRunner.biFunction(LambdaDemo.getFullName, new Human("a", "a", "a", 7, Sex.MALE))
        );
    }

    @Test
    public void addYearToHumanTest() {
        Assert.assertEquals(new Human("a", "a", "a", 8, Sex.MALE),
                LambdaRunner.biFunction(LambdaDemo.addYearToHuman, new Human("a", "a", "a", 7, Sex.MALE))
        );
    }

    @Test
    public void isAgesLowerMaxAgesTest() {
        Assert.assertTrue(LambdaRunner.iOperation(LambdaDemo.isAgesLowerMaxAges, new Human("a", "a", "a", 5, Sex.MALE),
                new Human("b", "b", "b", 6, Sex.FEMALE),
                new Human("c", "c", "c", 4, Sex.FEMALE)
                , 10
        ));
    }

}
