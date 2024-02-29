package design.pattern.structural.bridge;

public class Example {

    public static void main(String[] args) {
        var chair = new Chair(new Plastic());
        var table = new Table(new Wood());
        chair.create();
        table.create();
    }
}


abstract class Product {

    protected Material material;
    protected Product(Material material) {
        this.material = material;
    }

    abstract void create();
}
class Chair extends Product {
    protected Chair(Material material) {
        super(material);
    }

    public void create() {
        System.out.println("Created chair with " + super.material.getMaterial());
    }
}

class Table extends Product {
    protected Table(Material material) {
        super(material);
    }

    public void create() {
        System.out.println("Created table with" + super.material.getMaterial());
    }
}

interface Material {
    String getMaterial();
}

class Wood implements Material {

    @Override
    public String getMaterial() {
        return "Wood";
    }
}

class Plastic implements Material {

    @Override
    public String getMaterial() {
        return "Plastic";
    }
}