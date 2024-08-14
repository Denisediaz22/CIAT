import java.util.Scanner;


abstract class Shape {
    public abstract double getArea();


    public String toString() {
        return "Area: " + getArea();
    }
}

// Circle class
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}

// Square class
class Square extends Shape {
    private double width;

    public Square(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }


    public double getArea() {
        return Math.pow(width, 2);
    }
}

// Rectangle class
class Rectangle extends Square {
    private double height;

    public Rectangle(double width, double height) {
        super(width);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    public double getArea() {
        return getWidth() * height;
    }
}


class Console {
    private Scanner scanner;

    public Console() {
        scanner = new Scanner(System.in);
    }

    public String readLine() {
        return scanner.nextLine();
    }

    public double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(readLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public boolean readBoolean() {
        while (true) {
            String input = readLine().trim().toLowerCase();
            if (input.equals("y")) {
                return true;
            } else if (input.equals("n")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter y or n.");
            }
        }
    }
}

public class AreaCalculator {
    public static void main(String[] args) {
        Console console = new Console();

        while (true) {
            System.out.println("Welcome to the Area Calculator");
            System.out.println("Calculate area of a circle, square, or rectangle? (c/s/r): ");
            String shapeType = console.readLine().trim().toLowerCase();

            Shape shape = null;

            if (shapeType.equals("c")) {
                System.out.println("CIRCLE:");
                System.out.println("Enter radius: ");
                double radius = console.readDouble();
                shape = new Circle(radius);
            } else if (shapeType.equals("s")) {
                System.out.println("SQUARE:");
                System.out.println("Enter width: ");
                double width = console.readDouble();
                shape = new Square(width);
            } else if (shapeType.equals("r")) {
                System.out.println("RECTANGLE:");
                System.out.println("Enter width: ");
                double width = console.readDouble();
                System.out.println("Enter height: ");
                double height = console.readDouble();
                shape = new Rectangle(width, height);
            }

            System.out.println(shape.toString());

            System.out.println("Continue? (y/n): ");
            if (!console.readBoolean()) {
                break;
            }
        }
    }
}