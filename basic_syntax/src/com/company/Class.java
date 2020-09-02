package com.company;
import java.math.*;
import java.security.spec.RSAOtherPrimeInfo;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Objects;

import static java.lang.Float.NaN;
import static java.lang.Float.POSITIVE_INFINITY;

/**
 * The Java basics of syntax.
 * Learned topics:
 * 1. primitive types
 * 2. perform operations with primitive type
 * 3. Arrays.
 * 4. Strings.
 * 5. Useful methods of arrays and strings (for finding elements or char and work with)
 * 6. if else for while case ternary operator

 */
public class Class {
    public static void main(String[] args) {
        System.out.println(doubleExpression(1, 2, 3));

        double exponential = -123.4e-2;
        double hex = 0x1.Fp11;

        float floatWithSuffix = 36.6f;
        double doubleWithSuffix = 4d;

        System.out.println(exponential);
        System.out.println(hex);
        System.out.println(floatWithSuffix);
        System.out.println(doubleWithSuffix);

        double nan = 0.0 / 0.0;
        System.out.println(nan != nan);

        System.out.println(0x0bp3);

        int a = 20;
        int b = 4;
        int arithmeticShiftRight = a >>> b;

        System.out.println(arithmeticShiftRight);

        int x = 13; // value
        int y = 2; // amount

        int z = (x >> y);
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(z));
        System.out.println(z);

        int intValue = 1024;
        byte byteValue = (byte) intValue;

        double pi = 3.14;
        int intFromDouble = (int) pi;

        float largeFloat = 1e5f;
        int intFromLargeFloat = (int) largeFloat;

        System.out.println(byteValue);
        System.out.println(intFromDouble);
        System.out.println(largeFloat);

        byte bi = -1;
        char ai = '/';
        System.out.println((char) ((int) ai));

        int primitive = 0;
        Integer reference = Integer.valueOf(primitive);
        int backToPrimitive = reference.intValue();

        System.out.println(reference);
        System.out.println(backToPrimitive);

        Integer ax = 1;
        System.out.println(ax);

        long fromString = Long.parseLong("12345");
        String fromLong = Long.toString(12345);
        String concatenation = "area" + 51;

        System.out.println(fromString);
        System.out.println(fromLong);
        System.out.println(concatenation);

        // useful methods
        short maxShortValue =  Short.MAX_VALUE;
        int bitCount = Integer.bitCount(199);
        boolean isLetter = Character.isLetter('a');
        float floatInfinity = Float.POSITIVE_INFINITY;
        double doubleNaN = Double.NaN;
        boolean isNan = Double.isNaN(doubleNaN);
        int maxIntValue = Integer.MAX_VALUE;

        System.out.println(isNan);
        System.out.println(doubleNaN != NaN);
        System.out.println(bitCount);
        /* Иерархия типов в Java
        1. Double
        2. Float
        3. long
        4. int
        5. short
        6. byte
        7. char
        ....

        Также не надо явно указывать соотвествующие классые - обёртки.
        Например, не надо писать:
        char c = Character '\\';
         */

        int intToNegative = -1;
        int negativeInt = ~32;
        System.out.println(-2 % 2);
        System.out.println(Integer.toBinaryString(intToNegative));
        System.out.println(Integer.toBinaryString(-1&0));

        // creature array
        // it is not required to explicitly in initialize the newly
        // created array with zeros

        int[] numbers = new int[100];
        String[] strings = new String[1];
        boolean[] bits = new boolean[0];

        // it is not required to specify the number of arrays elements
        int[] numbers_ = new int[]{1, 2, 3, 4, 5};
        boolean[] bits_ = new boolean[]{true, false};

        // useful methods to work with arrays
        int arrayLength  = numbers.length;

        // how to get value of an array element?
        int firstNumber = numbers[0];
        int lastNumber = numbers[arrayLength - 1];
        // int indexOutOfBounds = numbers[101];

        // multidimensional arrays "arrays of arrays"

        int[][] matrix1 = new int[2][2];
        int[][] matrix2 = {{1, 2}, {3, 4}};
        int[][] triangle = {{1, 2, 3, 4},
                            {1, 2, 3},
                            {1, 2},
                            {1}};
        // hot to get value of an multidimensional array element?

        int[] firstRow = matrix2[0];
        int someElement = matrix2[1][1];
        int secondRowLength = triangle[1].length;

        // compare arrays
        int[] a_array = {1, 2, 3};
        int[] b_array = {-3, -2, -1};

        System.out.println(Arrays.toString(mergeArrays(a_array, b_array)));

        // is it true that a_true and b_true reference to the same object?
        boolean equals1 = a == b;

        // just compare values
        boolean equals2 = Arrays.equals(a_array, b_array); // exactly Arrays (one-dimensional) objects with method equals, not a equal

        // there is hexadecimal representation
        System.out.println(a_array);

        // there is string representation
        System.out.println(Arrays.toString(a_array));

        // DEEEP!!!!! STRIING!!!
        // System.out.println(Arrays.deepToString(a_array)); -- not working --__--
        // Before to invent a cycle method that will be working with arrays check Array class methods
        // It's time to discuss about string. Oh yeah!

        String hello = "Hello";
        String specialChars = "\r\n\t\"\\";
        String empty = "";

        // String is not char arrays
        char[] charArray = {'a', 'b', 'c'};
        String string = new String(charArray);
        char[] charsFromString = string.toCharArray();

        // Java strings do not end with zeros,
        // string size information is stored in a 'separate field' (memory sell)

        String zeros = "\u0000\u0000";

        System.out.println(zeros);

        // String means immutable. The fundamental principle.
        String s = "stringIsImmutable";

        // useful methods
        int length = s.length();
        char firstChar = s.charAt(0);
        boolean endsWithTable = s.endsWith("table"); // the same as in Python.
        boolean containsIs = s.contains("Is");

        String substring = s.substring(0, 6); // KICK OUT THE CHAIR (char, substring)
        String afterReplace = s.replace("Imm", "M"); // KICK OUT THE "IMM"
        String allCapitals = s.toUpperCase(); // London is the capital of great Britain

        // Concatenation is the same as in Python.
        String hello_ = "Hello ";
        String world = "world";
        String helloWorld = hello + world;

        // OR STRINGBUILDER (LIKE A MUSCLE BUILDER)
        StringBuilder sb = new StringBuilder();
        sb.append(hello);
        sb.append(world);
        String helloWorld_ = sb.toString();

        // Ok. String is immutable, can be concatenating, have so many useful methods
        // But. HOW TO COMPARE???

        boolean referenceEquals = hello == world;
        boolean contentEquals = hello.equals(world);
        boolean contentEqualsIgnoreCase = hello.equalsIgnoreCase(world);

        System.out.println('\t' + '\u0004');

        int[] zero_array = {};

        System.out.println(isPalindrome("Madam, I'm Adam"));

        // conditional statements and cycles
        boolean weatherIsGood = true;
        if (weatherIsGood) {
            System.out.println("Weather is good");
        } else {
            System.out.println("Weather is bad");
        }

        // same affect, much shorter: ternary operator
        System.out.println("Weather is " + (weatherIsGood ? "good" : "bad"));

        // switch
        int digit = 0;
        String text;
        long switch_1 = 10_000_000;
        switch (digit) {
            case 0:
                text = "zero";
                break;
            case 1:
                text = "one";
                break;
            // ....

            default:
                text = "???????";
        }

        boolean freeTime = true;
        boolean accessToWifi = false;

        while (freeTime && accessToWifi){
            // goStudy();
        }

        // for as in C language
        // but we also have foreach (simplified v. for generics and collections)
        for (int a_ : a_array){
            System.out.println(a_);
        }

        // labels (only for break and continue). java is not for who loves spaghetti code. goto is not available
        boolean found = false;
        int[][] matrix = { {10, 20, 30}, {40, 50, 60}};

        // outer:
        for (int[] row : matrix) {
            for (int x_: row){
                if (x_ > 10){
                    found = true;
                    break;
                }
            }
        }
        System.out.println(factorial(6));

        // for test purposes (task with arrays)
        int[] test1 = {0, 1};
        int[] test2 = {1, 2, 3};

        int[] test3 = {1, 1, 1};
        int[] test4 = {1, 1, 1};

        int[] test5 = {-9, -8, -7};
        int[] test6 = {10, 20, 30};

        System.out.println(Arrays.toString(mergeArrays(test1, test2)));
        System.out.println(Arrays.toString(mergeArrays(test3, test4)));
        System.out.println(Arrays.toString(mergeArrays(test5, test6)));

        System.out.println(Arrays.toString(mergeArraysEffective(test1, test2)));
        System.out.println(Arrays.toString(mergeArraysEffective(test3, test4)));
        System.out.println(Arrays.toString(mergeArraysEffective(test5, test6)));

        // for test purposes (task with strings)
        String [] roles= {
                "Городничий","Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"};
        String [] textLines={"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};

        System.out.println(Arrays.toString(printTextPerRole(roles, textLines)));
        //printTextPerRole(roles, textLines);

        // see the difference between StringBuilder and string. StringBuilder is fast. String is slow
        // ** when we use loop, off course.
        // The problem is that to += append to a string reconstructs a new string.
        long now = System.currentTimeMillis();
        slow();
        System.out.println("slow elapsed " + (System.currentTimeMillis() - now) + " ms");

        now = System.currentTimeMillis();
        System.out.println("fast elapsed " +  (System.currentTimeMillis() - now) + " ms");
    }


    public static boolean doubleExpression(double a, double b, double c) {
        return true;
    }

    /*
        What does we have?
        1. StringBuilder() API
        2. .equalsIgnoreCase()
     */
    public static boolean isPalindrome(String text){

        text = text.replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(text);
        return new StringBuilder(text).reverse().toString().equalsIgnoreCase(text);
    }

    public static BigInteger factorial(int value) {
        System.out.println("are you running?");
        if (value == 0) {
            System.out.println("bottom is broken");
            return BigInteger.ONE;
        }
        else {
            System.out.println(value - 1);
            return BigInteger.valueOf(value).multiply(factorial(value - 1));
        }
    }

    public static int[] mergeArrays(int[] a1, int a2[]) {
        /**
         * 1. Nested cycles for. For every i and j check the value of both arrays.
         * if a1 < a2 then add a1
         * 2. Create new array a3[]
         * 3. check the last elements
         */
        int[] a3 = new int[a1.length + a2.length];
        System.out.println(String.format("Length of 3-d array = %d", a3.length));
        for (int a3Index = 0, i = 0, j = 0; a3Index < a3.length; a3Index++) {
            System.out.println(String.format("a3Index = %d, i = %d, j = %d", a3Index, i, j));
            if (a1.length == i) {
                a3[a3Index] = a2[j];
                j++;
            } else if (a2.length == j) {
                a3[a3Index] = a1[i];
                i++;
            }
            else if (a1[i] > a2[j]) {
                a3[a3Index] = a2[j];
                j++;
            } else if (a1[i] < a2[j]) {
                a3[a3Index] = a1[i];
                i++;
            } else {
                a3[a3Index] = a1[i];
                a3Index++;
                a3[a3Index] = a2[j];
                i++;
                j++;
            }
        }
        return a3;
    }

    public static int[] addElement(int[] arrayToBeIncrement, int value) {
        /**
         * 1. Arrays.CopyOf
         * 2. Add Element
         * 3. return array
         */
        arrayToBeIncrement = Arrays.copyOf(arrayToBeIncrement, arrayToBeIncrement.length + 1);
        arrayToBeIncrement[arrayToBeIncrement.length - 1] = value;

        return arrayToBeIncrement;
    }

    public static int[] mergeArraysEffective(int[] a1, int[] a2) {
        /**
         * Time to use while and ternary operator.
         * 1. Create result array.
         * 2. Create while with condition: (a1.length < i && a2.length < j).
         * It is needed for check error "array out of bounds"
         * 3. The body of while is ternary operator. res = a1[i] < a2[j] ? a1[i++] : a2[j++];
         * 4. Other two whiles that will finally fill result arrays
         */
        int[] result = new int[a1.length + a2.length];
        int i = 0;
        int j = 0;
        while (a1.length < i && a2.length < j) {
            result[i + j] = a1[i] < a2[j] ? a1[i++] : a2[j++];
        }
        while (a1.length - i > 0) {
            result[i + j] = a1[i++];
        }
        while (a2.length - j > 0){
            result[i + j] = a2[j++];
        }
        return result;
    }

    public static String[] printTextPerRole(String[] roles, String[] textLines) {
        String[] result = new String[roles.length];
        String toBeDeleted = "";
        for (int i = 0; i < roles.length; i++) {
            toBeDeleted = roles[i] + ":";
            result[i] = roles[i] + ":";
            for (int j = 0; j < textLines.length; j++){
                if (textLines[j].contains(roles[i])) {
                    textLines[j] = textLines[j].replace(toBeDeleted, "");
                    result[i] += String.format("\n%d)%s", j + 1, textLines[j]);
                    //System.out.println(String.format("i = %d, j = %d\n%s",i, j, result[i]));
                }
            }
            result[i] += "\n\n";
        }
        return result;
    }

    // see the difference between SB and string
    public static void fast() {
        StringBuilder string_ = new StringBuilder();
        for (int i = 0; i < 10000; i++)
            string_.append("*");
    }

    public static void slow() {
        String s = "";
        for (int i = 0;i < 10000; i++)
            s += "*";
    }
}
