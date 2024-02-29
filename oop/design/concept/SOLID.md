
# Nguyên tắc thiết kế  S-O-L-I-D

***

## Nguyên tắc đơn trách nhiệm (Single Responsibility Principle - SRP): 

> Đơn trách nhiệm
* Một lớp(class) nên chỉ có một trách nhiệm duy nhất, và nó phải hoàn thành trách nhiệm đó một cách độc lập. 
* Nguyên tắc này giúp cho mã nguồn trở nên dễ đọc, dễ hiểu và dễ bảo trì hơn.

-----------

## Nguyên tắc đóng mở (Open/Closed Principle - OCP): 

> Dễ dàng đóng/mở
* Một lớp nên `mở để mở rộng` nhưng `đóng để sửa đổi`. 
  * Điều này có nghĩa là bạn nên có thể mở rộng chức năng của lớp một cách dễ dàng mà không cần phải thay đổi mã nguồn của lớp đó.

        Tức là ta sẽ mở rộng theo hướng tách class, không thay đổi tính chất của 1 class vốn có
        VD:
          Giả sử bạn có một class Shape và muốn thêm 1 class Circle,
          và bạn có 1 class ShapeCalulate, bạn có thể sửa đổi class này bằng cách sửa phương thức Area() để tính diện tích hình tam giác. 
          Tuy nhiên, điều này làm vi phạm nguyên tắc OCP, vì bạn đã phải sửa đổi mã nguồn đã có.
          Cách giải quyết là tạo 1 abstract method Area() cho class Shape và các class kế thừa nó buộc phải tính Area()
          => không cần phải sửa các class đã có

* Khi ta muốn thêm chức năng,.. cho chương trình, chúng ta nên viết class mới mở rộng class cũ 
  ( bằng cách kế thừa hoặc sở hữu class cũ ) không nên sửa đổi class cũ.

* Mở khi cho phép thêm các tính năng mới thông qua các lớp con nhưng vẫn có thể thực hiện thay đổi này trong khi vẫn giữ
  nguyên các lớp này đóng(Clean code - trang 234,235,236)

      mở là mở rộng các chức năng bằng cách thêm các lớp con, đóng là không sửa source đã viết, các lớp con khác


-----------

## Nguyên tắc thay thế (Liskov Substitution Principle - LSP): 

> Không thay đổi tính chất vốn có của đối tượng
* Đối tượng của một lớp con nên có thể thay thế được đối tượng của lớp cha mà không làm thay đổi tính đúng đắn của chương trình. 
  * Nguyên tắc này đảm bảo tính đúng đắn và linh hoạt của hệ thống.

        Tức là class con sẽ thực hiện đúng các chức năng của class cha, không nên thay đổi tính chất ban đầu của class cha 
        VD 1: class con quăng exception khi gọi hàm
          Giả sử bạn có một lớp Bird để biểu diễn các loài chim, và bạn có một lớp con là Penguin để biểu diễn chim cánh cụt. 
          Nếu lớp Penguin không thể thay thế cho lớp Bird trong một số trường hợp, 
          ví dụ như khi bạn gọi phương thức fly() của lớp Bird cho một đối tượng thuộc lớp Penguin nó quăng ra exception => vi phạm LSP. 
        VD 2: class con thay đổi hành vi của class cha 
          Giả sử ta có class Rectangle và có class Square kế thừa Rectangle vì hình vuông là hình chữ nhật,
          nhưng khi ta set độ rộng cho hình vuông thì độ dài của nó cũng phải được set lại bằng độ rộng,
          nhưng áp dụng điều đó cho class Rectangle thì sẽ bị sai => vi phạm LSP

        Trong đời sống, A là B (hình vuông là hình chữ nhật, chim cánh cụt là chim) không có nghĩa là class A nên kế thừa class B.
        Chỉ cho class A kế thừa class B khi class A thay thế được cho class B. 
        -> không thay thế được thì sẽ vi phạm LSP

* Trong thực tế, A là B (hình vuông là hình chữ nhật) không có nghĩa là class A nên kế thừa class B. Chỉ cho class A kế thừa class B khi class A thay thế được cho class B.
* File hệ thống cũng là file nhưng không thay thế được cho file, do đó ví dụ này vi phạm LSP.

-----------

## Nguyên tắc phân tách interface (Interface Segregation Principle - ISP): 

> Chia chức năng để giảm thiểu trách nhiệm 
* Nên tách các giao diện thành những giao diện nhỏ hơn, chuyên biệt hơn để tránh việc triển khai những phương thức không cần thiết.
* Nguyên tắc này giúp cho mã nguồn trở nên linh hoạt hơn và dễ dàng sử dụng hơn.

-----------

## Nguyên tắc thay đổi phụ thuộc (Dependency Inversion Principle - DIP): 

* Các module cấp cao không nên phụ thuộc vào các modules cấp thấp. Cả 2 nên phụ thuộc vào abstraction(Interface).

* Interface (abstraction) không nên phụ thuộc vào chi tiết, mà ngược lại. ( Các class giao tiếp với nhau thông qua interface, không phải thông qua implementation.)

> VD: thay vì một lớp trừu tượng phụ thuộc vào một lớp cụ thể như MySqlDatabase, nó nên phụ thuộc vào một interface như DatabaseInterface

* `Inversion of Control`: là 1 design pattern được tạo để tuân thủ `Dependency Inversion`, các service sẽ được đưa đến nơi độc lập thông qua 1 bên thứ 3
  - Không tạo ra các instance mà `container` sẽ tạo ra và sẽ chuyển đến người dùng khi cần, hay còn nói là đảo ngược quyền kiểm soát sang cho bên thứ 3
* `Dependency Injection`: là 1 cách hiện thực `IoC`
  - Nguyên tắc cơ bản của `DI` là làm cho module cấp cao phụ thuộc vào module cấp thấp thông qua `injector`(constructor, setter)
  - Cung cấp cho `Container` các thể hiện thông qua constructor để cho `Container` quản lý   
* `Dependency`: là các module cấp thấp, hay đơn giản là các service từ bên ngoài
* `DI container`: là nơi chứa các module để inject vào các module cấp cao

> - Có sự tách rời việc thực hiện một nhiệm vụ nhất định khỏi quá trình thực thi
> - Giúp việc chuyển đổi giữa các implementations trở nên dễ dàng hơn
