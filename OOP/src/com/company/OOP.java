package com.company;


import javax.swing.*;
import java.sql.SQLOutput;
import java.util.function.DoubleUnaryOperator;

/**
 * Объект -- это мыслимая или реальная сущность,
 * обладающая характерным поведением и отличительными характеристиками и являющаяся важной
 * в предметной области.
 */
public class OOP {

    public static void main(String[] args) {

        // standard methods of enumerates
        for (DayOfWeek day : DayOfWeek.values()){
            System.out.println(day.ordinal() + " " + day.name());
        }

        String[] test = {};

        Robot robot = new Robot(0,0, Direction.UP);
        moveRobot(robot, 1, 2);
        System.out.println(String.format("x = %d, y = %d", robot.getX(), robot.getY()));

        Triangle triangle = new Triangle(
                new Point(4, -4), new Point(5, 3), new Point(-2, 1), Color.GREEN);

        Circle circle = new Circle(new Point(0, 0), 1, Color.BLACK);

        Square square = new Square(new Point(5, 5), 2, Color.RED);

        Shape shape = triangle;
        shape.getColor();
        Object object = triangle;
        triangle = (Triangle) object;

        Shape[] shapes = {circle, triangle, square};
        printArrayElements(shapes);

        Shape maxShape = findShapeWithMaxArea(shapes);
        System.out.println("Shape with max area: " + maxShape);

        ComplexNumber cn1 = new ComplexNumber(2.3412,7.2434);
        ComplexNumber cn2 = new ComplexNumber(2.3412,7.2434);
        ComplexNumber cn3 = new ComplexNumber(3.23124,1435.23);
        System.out.println("equals cn1 & cn2 true // " + cn1.equals(cn2));
        System.out.println("equals cn2 & cn1 true // " + cn2.equals(cn1));
        System.out.println("equals cn2 & cn3 false // " + cn2.equals(cn3));
        System.out.println("equals cn3 & cn1 false // " + cn3.equals(cn1));
        System.out.println("hash cn1 & cn2 true // " + (cn1.hashCode() == cn2.hashCode()));
        System.out.println("hash cn2 & cn1 true // " + (cn2.hashCode() == cn1.hashCode()));
        System.out.println("hash cn3 & cn1 false // " + (cn3.hashCode() == cn1.hashCode()));
        System.out.println("hash cn3 & cn2 false // " + (cn3.hashCode() == cn2.hashCode()));

        System.out.println(integrate(x -> Math.log(x), 1, 10));
        System.out.println(integrate(x -> Math.sin(x) / x, 1, 5));
        System.out.println(integrate(x -> Math.exp(x), 1, 2.7));

        byte[] example = {65, 66, 67, 68, 69, 70};
        AsciiCharSequence answer = new AsciiCharSequence(example);
        System.out.println("Последовательность: " + answer.toString());
        System.out.println("Размер последовательности: " + answer.length());
        System.out.println("Первый элемент последовательности: " + answer.charAt(1));
        System.out.println("Подпоследовательность: " + answer.subSequence(0, 4));
        System.out.println(answer.toString()); // ABCDEF
        example[0] = 74;
        System.out.println(answer.toString()); // JBCDEF

        byte[] example_ = {72, 101, 108, 108, 111, 33};
        AsciiCharSequence answer2 = new AsciiCharSequence(example_);
        System.out.println("Последовательность - " + answer2.toString());//Hello!
        System.out.println("Размер её - " + answer2.length());//6
        System.out.println("Символ под № 1 - " + answer2.charAt(1));//e
        System.out.println("Подпоследовательность - " + answer2.subSequence(3, 5));//ello

        //проверка на нарушение инкапсуляции private поля
        System.out.println(answer2.toString());//Hello!
        example_[0] = 74;
        System.out.println(answer2.toString());//Jello!

        // ещё больше проверок (может быть лишних)
        System.out.println(answer2.subSequence(1, 2)); //e
        System.out.println(answer2.subSequence(5, 6)); //!
        System.out.println(answer2.subSequence(1, 3)); //el
        System.out.println("ello = " + answer2.subSequence(1, 5)); // Hello || Jello

        System.out.println(answer2.charAt(0)); // J
        System.out.println(answer2.charAt(1)); // e
        System.out.println(answer2.charAt(2)); // l
        System.out.println(answer2.charAt(3)); // l
        System.out.println(answer2.charAt(4)); // o
        System.out.println(answer2.charAt(5)); // !


        // Ключевые слова для класса SpamAnalyzer
        String[] spamKeywords = {"bad", "spam"};
        int commentMaxLength = 40;

        // инициализация классов внутри интерфейса TextAnalyzer
        TextAnalyzer[] textAnalyzers= {
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer()
        };


        // тестовые комментарии
        String[] tests = new String[5];

        tests[0] = "This is comment is good enough"; // OK
        tests[1] = "This is a spam comment"; // SPAM
        tests[2] = "This is a bad comment, so it is spam"; // SPAM
        tests[3] = "Do not be scary terry! :("; // NEGATIVE
        tests[4] = "Hello! I'm very long text. Nice to meet you. What do you love to do the most?"; //TOO_LONG

        for (String testText : tests) {
            System.out.println(checkLabel(textAnalyzers, testText));
        }

    }

    /**
     * КАК ЖЕ Я ЛЮБЛЮ БТС :) <3 <3, Вот они слева направо:
     * public, protected, __ static, private
     */
    public static class ModifiersDemo {
        public static void visibleEverywhere() {}
        protected static void inSubclasses() {}
        static void inPackage() {}
        private void inClass() {}
    }

    // ПЕРЕЧИСЛЕНИЯ || ENUMERATION
    public enum DayOfWeek {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    public static class Robot {
        int x = 0;
        int y = 0;
        Direction direction = Direction.UP;

        public Robot (int x, int y, Direction direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
        public Direction getDirection() {
            return direction;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void turnLeft(){
            switch (getDirection()) {
                case DOWN: direction = Direction.RIGHT;
                case UP: direction = Direction.LEFT;
                case LEFT: direction = Direction.DOWN;
                case RIGHT: direction = Direction.UP;
            }
        }

        public void turnRight() {
            switch (getDirection()) {
                case DOWN: direction = Direction.LEFT;
                    break;
                case UP: direction = Direction.RIGHT;
                    break;
                case LEFT: direction = Direction.UP;
                    break;
                case RIGHT: direction = Direction.DOWN;
                    break;
            }
        }

        public void stepForward() {
            switch (getDirection()) {
                case DOWN: y--;
                    break;
                case UP: y++;
                    break;
                case LEFT: x--;
                    break;
                case RIGHT: x++;
                    break;
            }
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }


    public static void moveRobot(Robot robot, int toX, int toY) {
        if (robot.getX() - toX > 0) {
            while (robot.getDirection() != Direction.LEFT)
                robot.turnLeft();
        } else {
            while (robot.getDirection() != Direction.RIGHT)
                robot.turnRight();
        }
        while (robot.getX() != toX)
            robot.stepForward();
        if (robot.getY() - toY > 0) {
            while (robot.getDirection() != Direction.DOWN)
                robot.turnLeft();
        } else {
            while (robot.getDirection() != Direction.UP) {
                robot.turnRight();
            }
        }
        while (robot.getY() != toY)
            robot.stepForward();
    }

    public static void printArrayElements(Object[] objects) {
        for (int i = 0; i < objects.length; i++)
            System.out.println(i + ": " + objects[i]);
    }

    public static Shape findShapeWithMaxArea(Shape[] shapes) {
        Shape maxShape = null;
        double max = -1;
        Double area;
        for (Shape shape: shapes){
            area = shape.getArea();
            if (area > max) {
                max = shape.getArea();
                maxShape = shape;
            }
        }

        return maxShape;
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double step = 1e-6;
        double area = 0;
        while (a < b) {
            area += step * f.applyAsDouble(a);
            a += step;
        }
        return area;
    }

    public static Label checkLabel(TextAnalyzer[] analyzers, String text) {
                Label checkLabel;
                for (TextAnalyzer analyzer : analyzers) {
                    checkLabel = analyzer.processText(text);
                    if (checkLabel != Label.OK)
                        return checkLabel;
                }
                return Label.OK;
    }
}
