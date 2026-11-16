package com.amigoscode._3_oop._4_polymorphism;

import com.amigoscode._3_oop._3_abstractclasses.Circle;
import com.amigoscode._3_oop._3_abstractclasses.Rectangle;
import com.amigoscode._3_oop._3_abstractclasses.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise: Polymorphism - Shape Calculator
 *
 * Use polymorphism to write methods that work with any Shape.
 * Because Circle and Rectangle both extend Shape, a single method
 * can handle both — and any future Shape subclass — without modification.
 *
 * Key concepts:
 * - Methods that accept a supertype parameter
 * - Polymorphic collections (List<Shape>)
 * - instanceof with pattern matching (Java 16+)
 * - Open/closed principle in practice
 *
 * Prerequisites: Complete Shape.java, Circle.java, and Rectangle.java first.
 */
public class ShapeCalculator {

    // TODO: 1 - Create a method: void printShapeArea(Shape shape)
    //   Print: "The <className> has an area of <area>"
    //   Use shape.getClass().getSimpleName() to get the class name.
    //   Use String.format("%.2f", shape.area()) for formatting.

    public void printShapeArea(Shape shape){
        System.out.println(String.format("The %s has an area of %.2f%n",shape.getClass().getSimpleName(), shape.area()));
    }


    // TODO: 2 - Create a method: double totalArea(List<Shape> shapes)
    //   Iterate over all shapes and return the sum of their areas.
    public static double totalArea(List<Shape> shapes){
        double sum =0.0;
        for(Shape s: shapes){
            sum += s.area();
        }
        return sum;
    }


    // TODO: 3 - Create a method: Shape largestShape(List<Shape> shapes)
    //   Return the shape with the largest area.
    //   If the list is empty, return null.

    public static Shape largestShape(List<Shape> shapes){
        if (shapes == null || shapes.isEmpty()) {
            return null;
        }

        Shape largest = shapes.get(0);
        for (Shape shape : shapes) {
            if (shape.area() > largest.area()) {
                largest = shape;
            }
        }
        return largest;
    }

    // TODO: 4 - Create a method: String describeShape(Shape shape)
    //   Use instanceof with pattern matching (Java 16+) to return
    //   specific descriptions:
    //   - If shape is a Circle c: return "Circle with radius info"
    //     (just return "Circle detected with area: " + c.area())
    //   - If shape is a Rectangle r: return "Rectangle detected with area: " + r.area()
    //   - Otherwise: return "Unknown shape with area: " + shape.area()
    public static String describeShape(Shape shape) {
        if (shape instanceof Circle c) {
            return "Circle detected with area: " + c.area();
        } else if (shape instanceof Rectangle r) {
            return "Rectangle detected with area: " + r.area();
        } else {
            return "Unknown shape with area: " + shape.area();
        }
    }




    // TODO: 5 - Create a method: String formatSummary(List<Shape> shapes)
    //   Return a formatted summary string like:
    //   "Summary: <N> shapes, total area: <totalArea>, largest area: <largestArea>"
    //   Use the totalArea() and largestShape() methods you already wrote.

    public static String formatSummary(List<Shape> shapes) {
        Shape largest = largestShape(shapes);

        return String.format(
                "Summary: %d shapes, total area: %.2f, largest area: %.2f",
                shapes.size(),
                totalArea(shapes)
        );
    }
    // TODO: 6 - In main, create a List<Shape> with at least two Circles
    //   and two Rectangles. Call all the methods above and print results.
    //   This demonstrates polymorphism: the same method handles
    //   different shape types seamlessly.

    public static void main(String[] args) {
        // Complete TODO 6 here.

        List<Shape> shapes = List.of(
                new Circle(3.0),
                new Circle(5.0),
                new Rectangle(4.0, 6.0),
                new Rectangle(2.5, 8.0)
        );

        // 1. Describe each shape using pattern matching
        for (Shape shape : shapes) {
            System.out.println(describeShape(shape));
        }

        // 2. Calculate and print total area
        System.out.println("Total area: " + totalArea(shapes));

        // 3. Find and print the largest shape
        Shape largest = largestShape(shapes);
        System.out.println("Largest shape: " + largest);

        // 4. Print the formatted summary
        System.out.println(formatSummary(shapes));

    }
}
