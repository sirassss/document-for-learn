# Sự khác nhau giữa abstract `class` và `interface`

## Mục đích

* Abstract class thường được sử dụng để chứa các phương thức và thuộc tính chung của các lớp con. 

  > abstract class vẫn có thuộc tính và phương thức cụ thể 
  > => nó vẫn được coi là 1 thực thể, định nghĩa 1 đối tượng, không hoàn toàn khái quát các hành vi(method)

* Trong khi đó, interface thường được sử dụng để định nghĩa các hành vi (behavior) chung của các đối tượng.

## Lợi ích của interface:

* Giảm sự phụ thuộc giữa các thành phần
* Dễ thay đổi và mở rộng về sau

    
    Interface đại diện cho hình mẫu (pattern)
    Interface không được coi là 1 thực thể
    Interface chỉ là 1 bản khai báo, danh mục các hành vi cần thiết
    Hãy dùng interface nhiều nhất có thể, đừng nghĩ gì về abstract class

* Interface linh hoạt hơn

    `Một đối tượng có thể được coi là thuộc về nhiều loại đối tượng khác nhau nếu nó triển khai các interface tương ứng`

* Có thể sử dụng kỹ thuật định danh để xử lý đa kế thừa bị trùng method trong interface

  ````java
  interface A {
    void doSomething();
  }

  interface B {
  void doSomething();
  }

  class MyClass implements A, B {
   @Override
   public void doSomething() {
   A.super.doSomething(); // định danh phương thức của interface A
   B.super.doSomething(); // định danh phương thức của interface B
   }
  }
  ````

# 2 khía cạnh của abstraction

- `Abstract data` là quá trình xác định và phân tách các tính năng cần thiết của một đối tượng từ chi tiết về cách thức
  triển khai của nó. Điều này cho phép chúng ta làm việc với đối tượng ở mức độ trừu tượng hơn mà không cần phải quan
  tâm đến các chi tiết cụ thể về cách thức triển khai của nó.

- `Procedural abstraction` nhằm ẩn các chi tiết cụ thể của một hàm hoặc thủ tục nhằm làm cho nó dễ sử dụng và hiểu hơn.
  Điều này cho phép chúng ta làm việc với hàm hoặc thủ tục ở mức độ trừu tượng hơn mà không cần phải quan tâm đến các chi
  tiết cụ thể về cách thức hoạt động của nó.



