package design.pattern.structural.decorator;

public class Example {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        coffee = new MilkDecorator(coffee);
        coffee = new WhipDecorator(coffee);
        System.out.println(coffee.getCost()); // Kết quả: 2.2
        System.out.println(coffee.getDescription()); // Kết quả: Cà phê đơn giản, Sữa, Kem
    }
}

interface Coffee {
    double getCost();

    String getDescription();
}

class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 1.0;
    }

    @Override
    public String getDescription() {
        return "Cà phê đơn giản";
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected final Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.5;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Sữa";
    }
}

class WhipDecorator extends CoffeeDecorator {
    public WhipDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.7;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Kem";
    }
}