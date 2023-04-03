import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;

public class MyClassTest {

    private MyClass myClass;

    @Nested
    class SimpleTests{
        @BeforeEach
        public void setUp() {
            ArrayList<Long> numbers = new ArrayList<>();
            numbers.add(1L);
            numbers.add(2L);
            ArrayList<String> strings = new ArrayList<>();
            strings.add("a");
            strings.add("b");
            myClass = new MyClass(LocalDateTime.now(), "test", numbers, strings);
        }

        @Test
        public void testGetTime() {
            LocalDateTime expected = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
            LocalDateTime actual = myClass.getTime().truncatedTo(ChronoUnit.MINUTES);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testGetName() {
            String expected = "test";
            String actual = myClass.getName();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testGetNumbers() {
            ArrayList<Long> expected = new ArrayList<>();
            expected.add(1L);
            expected.add(2L);
            ArrayList<Long> actual = myClass.getNumbers();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testGetStrings() {
            ArrayList<String> expected = new ArrayList<>();
            expected.add("a");
            expected.add("b");
            ArrayList<String> actual = myClass.getStrings();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testRemoveString() {
            myClass.removeString("a");
            ArrayList<String> expected = new ArrayList<>();
            expected.add("b");
            ArrayList<String> actual = myClass.getStrings();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testContainsNumber() {
            boolean expected = true;
            boolean actual = myClass.containsNumber(2L);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testIsHistoric() {
            boolean expected = false;
            boolean actual = myClass.isHistoric();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testToString() {
            String expected = "test 1 2";
            String actual = myClass.toString();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testEquals() {
            MyClass expected = new MyClass(LocalDateTime.now(), "test", new ArrayList<>(), new ArrayList<>());
            MyClass actual = myClass;
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    class nullTests{
        @BeforeEach
        public void setUp() {
            myClass = new MyClass(null, null, null, null);
        }

        @Test
        public void testGetTime() {
            LocalDateTime expected = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
            LocalDateTime actual = myClass.getTime().truncatedTo(ChronoUnit.MINUTES);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testGetName() {
            String expected = "";
            String actual = myClass.getName();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testGetNumbers() {
            ArrayList<Long> expected = new ArrayList<>();
            ArrayList<Long> actual = myClass.getNumbers();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testGetStrings() {
            ArrayList<String> expected = new ArrayList<>();
            ArrayList<String> actual = myClass.getStrings();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testRemoveString() {
            myClass.removeString(null);
            ArrayList<String> expected = new ArrayList<>();
            ArrayList<String> actual = myClass.getStrings();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testRemoveStringNothingToRemove() {
            myClass.removeString("a");
            ArrayList<String> expected = new ArrayList<>();
            ArrayList<String> actual = myClass.getStrings();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testContainsNumber() {
            boolean expected = false;
            boolean actual = myClass.containsNumber(0);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testIsHistoric() {
            boolean expected = false;
            boolean actual = myClass.isHistoric();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testToString() {
            String expected = "";
            String actual = myClass.toString();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testToStringNoName() {
            String expected = "hello";
            myClass.setName("hello");
            String actual = myClass.toString();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testToStringNoNumbers() {
            ArrayList<Long> numbers = new ArrayList<>();
            numbers.add(1L);
            numbers.add(2L);
            numbers.add(3L);
            String expected = " 1 2 3";
            myClass.setNumbers(numbers);
            String actual = myClass.toString();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testEquals() {
            MyClass expected = new MyClass(null, null, null, null);
            MyClass actual = myClass;
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testEmptyEquals() {
            MyClass expected = new MyClass(null, "", null, null);
            MyClass actual = myClass;
            Assertions.assertEquals(expected, actual);
        }

    }

    @Nested
    class edgeTests{
        @BeforeEach
        public void setUp() {
            ArrayList<Long> numbers = new ArrayList<>();
            numbers.add(1L);
            numbers.add(2L);
            numbers.add(2L);
            numbers.add(1L);
            numbers.add(5L);
            ArrayList<String> strings = new ArrayList<>();
            strings.add("a");
            strings.add("b");
            strings.add("b");
            strings.add("a");
            strings.add("f");
            strings.add("a");
            myClass = new MyClass(LocalDateTime.now(), "test", numbers, strings);
        }

        @Test
        public void testGetTime() {
            LocalDateTime expected = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
            LocalDateTime actual = myClass.getTime().truncatedTo(ChronoUnit.MINUTES);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testGetName() {
            String expected = "test";
            String actual = myClass.getName();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testGetNumbers() {
            ArrayList<Long> expected = new ArrayList<>();
            expected.add(1L);
            expected.add(2L);
            expected.add(2L);
            expected.add(1L);
            expected.add(5L);
            ArrayList<Long> actual = myClass.getNumbers();
            Assertions.assertEquals(expected, actual);
            Assertions.assertEquals(expected.size(), actual.size());
            Assertions.assertEquals(actual.size(), 5);
        }

        @Test
        public void testGetStrings() {
            ArrayList<String> expected = new ArrayList<>();
            expected.add("a");
            expected.add("b");
            expected.add("b");
            expected.add("a");
            expected.add("f");
            expected.add("a");
            ArrayList<String> actual = myClass.getStrings();
            Assertions.assertEquals(expected, actual);
            Assertions.assertEquals(expected.size(), actual.size());
            Assertions.assertEquals(actual.size(), 6);
        }

        @Test
        public void testRemoveString() {
            myClass.removeString("a");
            ArrayList<String> expected = new ArrayList<>();
            expected.add("b");
            expected.add("b");
            expected.add("f");
            ArrayList<String> actual = myClass.getStrings();
            Assertions.assertEquals(expected, actual);
            Assertions.assertEquals(actual.size(), 3);

        }

        @Test
        public void testRemoveStringNotInArray() {
            myClass.removeString("a");
            myClass.removeString("h");
            ArrayList<String> expected = new ArrayList<>();
            expected.add("b");
            expected.add("b");
            expected.add("f");
            ArrayList<String> actual = myClass.getStrings();
            Assertions.assertEquals(expected, actual);
            Assertions.assertEquals(actual.size(), 3);
        }

        @Test
        public void testRemoveStringNull() {
            myClass.removeString("null");
            myClass.removeString("a");
            ArrayList<String> expected = new ArrayList<>();
            expected.add("b");
            expected.add("b");
            expected.add("f");
            ArrayList<String> actual = myClass.getStrings();
            Assertions.assertEquals(expected, actual);
            Assertions.assertEquals(actual.size(), 3);

        }

        @Test
        public void testContainsNumber() {
            boolean expected = true;
            boolean actual = myClass.containsNumber(2L);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testNotContainsNumber() {
            boolean expected = false;
            boolean actual = myClass.containsNumber(8L);
            Assertions.assertEquals(expected, actual);
        }


        @Test
        public void testIsHistoricTrue() {
            boolean expected = true;
            myClass.setTime(LocalDateTime.of(1998, 5, 12, 0, 0, 0));
            boolean actual = myClass.isHistoric();
            Assertions.assertEquals(expected, actual);
        }


        @Test
        public void testToString() {
            String expected = "test 1 2 2 1 5";
            String actual = myClass.toString();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testEquals() {
            MyClass expected = new MyClass(LocalDateTime.now(), "test", new ArrayList<>(), new ArrayList<>());
            MyClass actual = myClass;
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testNotEquals() {
            MyClass expected = new MyClass(LocalDateTime.now(), "test1", new ArrayList<>(), new ArrayList<>());
            MyClass actual = myClass;
            Assertions.assertNotEquals(expected, actual);
        }
    }
}
