package design.pattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String[] args) {
// Tạo các đối tượng hình dạng
        Shape circle = new Circle();
        Shape square = new Square();
        CompositeShape composite = new CompositeShape();

        // Thêm hình dạng vào composite
        composite.addShape(circle);
        composite.addShape(square);
        composite.draw();

        // Tạo một composite lớn chứa cả hình tròn và hình vuông
        CompositeShape rootComposite = new CompositeShape();
        rootComposite.addShape(circle);
        rootComposite.addShape(square);
        rootComposite.addShape(composite);

        // Vẽ toàn bộ cây đối tượng
        rootComposite.draw();
    }
}

interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a square");
    }
}


class CompositeShape implements Shape {
    private List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a composite shape");
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
