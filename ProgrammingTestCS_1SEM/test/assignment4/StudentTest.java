/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

import org.junit.jupiter.api.*;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author jeppjleemoritzled
 */
public class StudentTest {
    @Test
    public void testGetSetMethods() {
        Method[] methods = Student.class.getMethods();

        ArrayList<String> methodsMustBe = new ArrayList(
                Arrays.asList(
                        "getStudentId", "setStudentId",
                        "getName", "setName",
                        "getMultiplier", "setMultiplier"
                )
        );

        methodsMustBe.forEach((String mm) ->
        {
            boolean found = false;
            for (Method method : methods) {
                if (method.getName().equals(mm)) {
                    found = true;
                }
            }
            if (!found) {
                fail("Missing get/set method in Student: " + mm);
            }
        });

        for (Method m : Student.class.getMethods()) {
            Parameter[] params = m.getParameters();
            if (m.getName().startsWith("get")) {
                if (params.length != 0) {
                    fail("No parameters allowed in get method: " + m.getName());
                }
            }
        }

        for (Method m : Student.class.getMethods()) {
            Parameter[] params = m.getParameters();
            if (m.getName().startsWith("set")) {
                if (params.length == 0) {
                    fail("Parameters in set method missing: " + m.getName());
                }
            }
        }

    }

    /**
     * Test of get and setMultiplier method, of class Student.
     */
    @Test
    public void testGetSetMultiplier() {
        double badMultiplier = 0.06;
        Student instance = new Student(1, "Piotr Stegonovskij");
        assertFalse(instance.setMultiplier(badMultiplier), "Should return false if value is incorrect");
        assertNotEquals(badMultiplier, instance.getMultiplier(), 0.0, "Should not change value if incorrect");

        instance = new Student(2, "Jeppe Led");
        double multiplier = 1.06 * 1.08;
        assertTrue(instance.setMultiplier(multiplier), "Correct value not allowed?");
        assertEquals(multiplier, instance.getMultiplier(), "Value did not change although correct");
        multiplier = 1.06;
        assertTrue(instance.setMultiplier(multiplier), "Correct value not allowed?");
        assertEquals(multiplier, instance.getMultiplier(), "Value did not change although correct");
        multiplier = 1.08;
        assertTrue(instance.setMultiplier(multiplier), "Correct value not allowed?");
        assertEquals(multiplier, instance.getMultiplier(), "Value did not change although correct");
    }

    /**
     * Test of get and setGrade method, of class Student.
     */
    @Test
    public void testSetGrade() {
        double mult1 = 1.06;
        double mult2 = 1.08;

        double grade = 12;
        double result = grade * mult1 * mult2;
        Student instance = new Student(3, "Trine Thomsen");
        instance.setMultiplier(mult1 * mult2);
        assertTrue(instance.setGrade(grade), "Should return true when value is correct");
        assertNotEquals(result, instance.getGrade(), 0.0, "Should not change value if incorrect");

        instance = new Student(2, "Jeppe Led");
        instance.setMultiplier(mult1 * mult2);
        grade = -4;
        assertFalse(instance.setGrade(grade));

        instance = new Student(1, "Peter Stegger");
        instance.setMultiplier(mult1 * mult2);
        grade = -3.01 * mult1 * mult2; // just very little under
        assertFalse(instance.setGrade(grade));
    }

    /**
     * Test of get and setName method, of class Student.
     */
    @Test
    public void testSetName() {
        char[] invalidChars = ".\\/,()&%€#!$".toCharArray();
        Student instance = new Student(6, "Ole Eriksen");
        String name = "";
        assertFalse(instance.setName(name), "Should return false if value is incorrect");
        assertNotEquals(instance.getName(), name, "Should not change value if incorrect");

        assertFalse(instance.setName(null), "Should return false if value is incorrect");

        for (char invalidChar : invalidChars) {
            instance = new Student(7, "Stig Iversen");
            name = invalidChar + "";
            assertFalse(instance.setName(name), "Should return false if value is incorrect");
            assertNotEquals(instance.getName(), name, "Should not change value if incorrect");

            instance = new Student(8, "Anne-Mette Tonnesen");
            name = "" + invalidChar + " check";
            assertFalse(instance.setName(name), "Should return false if value is incorrect");
            assertNotEquals(instance.getName(), name, "Should not change value if incorrect");

            instance = new Student(9, "Lektor Blomme");
            name = "start " + invalidChar + " end";
            assertFalse(instance.setName(name), "Should return false if value is incorrect");
            assertNotEquals(instance.getName(), name, "Should not change value if incorrect");
        }

        instance = new Student(10, "Dumbledore Potter");
        name = "InvalidNameOnlyOneWord";
        assertFalse(instance.setName(name), "Should return false if value is incorrect");
        assertNotEquals(instance.getName(), name, "Should not change value if incorrect");

        instance = new Student(11, "Petronov Steginova");
        name = "Valid Name=";
        assertTrue(instance.setName(name), "Correct value not allowed?");
        assertEquals(instance.getName(), name, "Value has not changed, although it is correct?");
        name = "Valid Name Many Spaces No Problem Att all uncaps";
        assertTrue(instance.setName(name), "Correct value not allowed?");
        assertEquals(instance.getName(), name, "Value has not changed, although it is correct?");
        name = "a e";
        assertTrue(instance.setName(name), "Correct value not allowed?");
        assertEquals(instance.getName(), name, "Value has not changed, although it is correct?");
    }

    /**
     * Test of setStudentId method, of class Student.
     */
    @Test
    public void testSetStudentId() {
        int studentId = 0;
        Student instance = new Student(studentId, "Pete Farmman Steggano");
        assertFalse(instance.setStudentId(-1), "Student id must be >= 0");
        assertTrue(instance.setStudentId(0), "StudentId 0 is valid, but returns false");
        assertTrue(instance.setStudentId(65536), "StudentId 65536 is valid, but returns false");
    }

}
