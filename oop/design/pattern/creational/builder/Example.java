package design.pattern.creational.builder;

import java.util.ArrayList;
import java.util.List;

public class Example {

}

class Director {
    private IBuilder builder;

    public void builder(IBuilder builder) {
        this.builder = builder;
    }

    public void buildProductA() {
        this.builder.buildPartA();
        this.builder.buildPartB();
    }
}

interface IBuilder {
    void buildPartA();
    void buildPartB();
    void buildPartC();
}

class BuilderA implements IBuilder {

    private Product product = new Product();
    @Override
    public void buildPartA() {
        product.addPart("Name");
    }

    @Override
    public void buildPartB() {
        product.addPart("Ram");
    }

    @Override
    public void buildPartC() {
        product.addPart("Screen");
    }
}

class Product {

    private List<String> parts = new ArrayList<>();
    // fixed code
    public void addPart(String part) {
        this.parts.add(part);
    }

    public String getParts() {
        return "Product: " + String.join(",", parts);
    }
}
