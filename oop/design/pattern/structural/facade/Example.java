package design.pattern.structural.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Example {

    public static void main(String[] args) {
        /*=========== Facade =============*/
        OnlineStore onlineStore = OnlineStoreFacade.getFacade();

        onlineStore.addToCart("123", 2);
        onlineStore.addToCart("456", 1);
        onlineStore.checkout();

        /*=========== Addition facade =============*/

        AdditionFacade facade = new AdditionFacade();
        facade.operation();
        facade.additionalOperation();
    }
}

interface OnlineStore {
    void addToCart(String productId, int quantity);

    void checkout();
}

class Product {
    private String productId;
    private String name;
    private Integer quantity;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product, int quantity) {
        product.setQuantity(quantity);
        products.add(product);
    }

    public double getTotalAmount() {
        return products.stream().map(Product::getPrice).reduce(0D, Double::sum);
    }

    // getters and setters
}

class PaymentProcessor {
    public void processPayment(double amount) {
        // code to process payment
    }
}

class OnlineStoreFacade implements OnlineStore {

    private static OnlineStoreFacade _instance;
    private ShoppingCart shoppingCart;
    private PaymentProcessor paymentProcessor;

    private OnlineStoreFacade() {
        shoppingCart = new ShoppingCart();
        paymentProcessor = new PaymentProcessor();
    }

    static OnlineStore getFacade() {
        return Optional.ofNullable(_instance)
                .orElseGet(() -> {
                    _instance = new OnlineStoreFacade();
                    return _instance;
                });
    }

    public void addToCart(String productId, int quantity) {
        Product product = getProductById(productId);
        shoppingCart.addProduct(product, quantity);
    }

    public void checkout() {
        double amount = shoppingCart.getTotalAmount();
        paymentProcessor.processPayment(amount);
    }

    private Product getProductById(String productId) {
        return new Product(productId, "productName", 3000);
    }
}

/**
 * Example for Addition facade
 * */
// Subsystems
class SubsystemA {
    public void operationA() {
        System.out.println("SubsystemA operation");
    }
}

class SubsystemB {
    public void operationB() {
        System.out.println("SubsystemB operation");
    }
}

class SubsystemC {
    public void operationC() {
        System.out.println("SubsystemC operation");
    }
}

// Facade
class Facade {
    private SubsystemA subsystemA;
    private SubsystemB subsystemB;

    public Facade() {
        subsystemA = new SubsystemA();
        subsystemB = new SubsystemB();
    }

    public void operation() {
        subsystemA.operationA();
        subsystemB.operationB();
    }
}

// Addition Facade
class AdditionFacade extends Facade {
    private SubsystemC subsystemC;

    public AdditionFacade() {
        super();
        subsystemC = new SubsystemC();
    }

    public void additionalOperation() {
        subsystemC.operationC();
    }
}
