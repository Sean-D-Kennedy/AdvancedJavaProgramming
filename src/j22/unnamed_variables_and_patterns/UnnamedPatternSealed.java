package j22.unnamed_variables_and_patterns;

sealed interface Shape permits Circle, Rectangle {}

record Circle(double radius) implements Shape {}
record Rectangle(double width, double height) implements Shape {}

public class UnnamedPatternSealed {
    static void describeShape(Shape shape) {
        switch (shape) {
            case Circle(double radius) -> System.out.println("A circle with radius " + radius);
            case Rectangle(_, _) -> System.out.println("Its a rectangle (don't care about its width or height).");
        }
    }

    public static void main(String[] args) {
        Shape shape1 = new Circle(5.0);
        Shape shape2 = new Rectangle(10.0, 20.0);

        describeShape(shape1);
        describeShape(shape2);
    }
}