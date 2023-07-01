Để minh hoạ tính linh hoạt của design pattern Decorator, hãy xem xét ví dụ sau với Java code:

Giả sử chúng ta có một interface `Coffee` để đại diện cho một ly cà phê:

```java
public interface Coffee {
     double getCost();

     String getDescription();
}
```

Chúng ta cũng có một lớp cà phê cơ bản `SimpleCoffee` thực hiện interface `Coffee`:

```java
public class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 1.0;
    }

    @Override
    public String getDescription() {
        return "Cà phê đơn giản";
    }
}
```

Bây giờ, chúng ta muốn thêm một số chức năng cho cà phê, chẳng hạn như thêm sữa, đường, hoặc kem. Thay vì tạo ra một lớp
mới cho mỗi chức năng này, chúng ta có thể sử dụng Decorator để thêm chúng vào cà phê gốc.

Đầu tiên, chúng ta tạo ra một lớp abstract decorator `CoffeeDecorator` để thực hiện interface `Coffee` và giữ một tham
chiếu đến một đối tượng `Coffee` gốc:

```java
public abstract class CoffeeDecorator implements Coffee {
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
```

Sau đó, chúng ta có thể tạo ra các lớp decorator cụ thể để thêm các chức năng khác nhau vào cà phê gốc, ví dụ như
lớp `MilkDecorator` để thêm sữa vào cà phê:

```java
public class MilkDecorator extends CoffeeDecorator {
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
```

Với việc sử dụng Decorator, chúng ta có thể dễ dàng thêm các chức năng khác nhau vào cà phê gốc mà không cần thay đổi
cấu trúc của nó. Ví dụ, để thêm kem vào cà phê, chúng ta chỉ cần tạo một lớp decorator mới như sau:

```java
public class WhipDecorator extends CoffeeDecorator {
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
```

Sử dụng Decorator, chúng ta có thể linh hoạt thêm hoặc bỏ đi các chức năng của đối tượng một cách động lực và tại thời
điểm chạy. Ví dụ, chúng ta có thể tạo một ly cà phê với sữa và kem như sau:

```java
Coffee coffee = new SimpleCoffee();
coffee = new MilkDecorator(coffee);
coffee=new WhipDecorator(coffee);
System.out.println(coffee.getCost()); // Kết quả: 2.2
System.out.println(coffee.getDescription()); // Kết quả: Cà phê đơn giản, Sữa, Kem
```

Chúng ta có thể thêm hoặc bỏ đi các chức năng của đối tượng một cách linh hoạt, động lực và tại thời điểm chạy.