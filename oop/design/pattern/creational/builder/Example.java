package design.pattern.creational.builder;

public class Example {
    public static void main(String[] args) {
        Pizza pizza = new Pizzeria().makePizza(new PepperoniPizzaBuilder());
        Pizza pizza2 = new Pizzeria().makePizza(new HawaiianPizzaBuilder());
        System.out.println(pizza.toString());
        System.out.println(pizza2.toString());
    }
}

class Pizza {
    private String dough;
    private String sauce;
    private String[] topping;

    public void setDough(String dough) {
        this.dough = dough;
    }
    public void setSauce(String sauce) {
        this.sauce = sauce;
    }
    public void setTopping(String[] topping){
        this.topping = topping;
    }

    public String getDough() {
        return dough;
    }

    public String getSauce() {
        return sauce;
    }

    public String[] getTopping() {
        return topping;
    }
}

/**
 * builder interface
 * */
abstract class PizzaBuilder {
    protected Pizza pizza;

    protected PizzaBuilder() {
        pizza = new Pizza();
    }

    public Pizza getPizza() {
        return pizza;
    }
    public abstract void createPizza();
}

/**
 * builder
 * */
class HawaiianPizzaBuilder extends PizzaBuilder {

    @Override
    public void createPizza() {
        pizza.setDough("cross");
        pizza.setSauce("mild");
        pizza.setTopping(new String[] {"ham", "pineapple"});
    }
}

class PepperoniPizzaBuilder extends PizzaBuilder {

    @Override
    public void createPizza() {
        pizza.setDough("pan baked");
        pizza.setSauce("tomato");
        pizza.setTopping(new String[] {"pepperoni", "cheese"});
    }
}

/**
 * Director
 * */
class Pizzeria {
    public Pizza makePizza(PizzaBuilder builder) {
        builder.createPizza();
        return builder.getPizza();
    }
}