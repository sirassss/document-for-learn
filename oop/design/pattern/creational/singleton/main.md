## Mục đích && ưu

1. Có thể chắc chắn rằng một lớp chỉ có một instance
2. Có khả năng truy cập đến instance từ mọi nơi (global access)
3. Đối tượng singleton chỉ được khởi tạo duy nhất một lần khi nó được yêu cầu lần đầu.
4. Thường được dùng cho các trường hợp giải quyết các bài toán cần truy cập vào các ứng dụng như: Shared resource,
   Logger, Configuration, Caching, Thread pool, …
5. Có thể chắc chắn rằng một lớp chỉ có một instance

## nhược

1. vi phạm single responsibility principle
2. các đối tượng biết quá nhiều về nhau -> không có tính đóng gói

## code

* no thread safe

````java
public class Singleton {
    private Singleton() {
    }

    private static Singleton1 instance = null;

    public static Singleton1 Instance() {
        get {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }
}
````

* thread safe

````java
public class Singleton2 {
    Singleton2() {
    }

    private static object lock = new object();
    private static Singleton2 instance = null;

    public static Singleton2 Instance() {
        get {
            synchronized (lock) {
                if (instance == null) {
                    instance = new Singleton2();
                }
                return instance;
            }
        }
    }
}
````
